/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.controller;

import co.com.poli.appcreditos.business.implementation.CreditoBusinessImpl;
import co.com.poli.appcreditos.jpacontroller.Credito_1JpaController;
import co.com.poli.appcreditos.jpacontroller.TipocreditoJpaController;
import co.com.poli.appcreditos.jpacontroller.TipotrabajadorJpaController;
import co.com.poli.appcreditos.model.Credito;
import co.com.poli.appcreditos.model.Credito_1;
import co.com.poli.appcreditos.model.Tipocredito;
import co.com.poli.appcreditos.model.Tipotrabajador;
import co.com.poli.appcreditos.util.JPAFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author wilmar.duque
 */
public class CreditoServlet extends HttpServlet {

    private String NroDocumento;
    private String Nombres;
    private String Apellidos;
    private Double Monto;
    private int TipoTrabajador;
    private int TipoCredito;
    private Boolean TrabajaCompania;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        //CreditoBusinessImpl cBusinessImpl = new CreditoBusinessImpl();
        Credito_1JpaController jpaCreditoController = new Credito_1JpaController(JPAFactory.getEMFACTORY());
        TipotrabajadorJpaController jpaTipoTrabajadorController = new TipotrabajadorJpaController(JPAFactory.getEMFACTORY());
        TipocreditoJpaController jpaTipoCreditoController = new TipocreditoJpaController(JPAFactory.getEMFACTORY());
        List<Credito_1> creditoList;

        String action = request.getParameter("action");

        limpiarMensajes(session);
        String resp = "";
        if (action.equals("Create")) {
            NroDocumento = request.getParameter("txtNroDocumento");
            Nombres = request.getParameter("txtNombres");
            Apellidos = request.getParameter("txtApellidos");
            Monto = Double.valueOf(request.getParameter("txtMonto"));
            TipoTrabajador = Integer.parseInt(request.getParameter("txtTipoTrabajador")); //1-Independiente; 2-Dependiente
            TipoCredito = Integer.parseInt(request.getParameter("txtTipoCredito")); //1-Vivienda, 2-Estudio, 3-LibreInversion
            TrabajaCompania = Boolean.parseBoolean(request.getParameter("txtTrabajaCompania"));
        }
        switch (action) {
            case "Create":

                limpiarMensajes(session);

                Credito_1 jpaCredito = new Credito_1(jpaCreditoController.getCredito_1Count() + 1);
                jpaCredito.setDocumentopersona(NroDocumento);
                jpaCredito.setNombrepersona(Nombres);
                jpaCredito.setApellidopersona(Apellidos);
                jpaCredito.setMontocredito(Monto);
                jpaCredito.setTipotrabajador(jpaTipoTrabajadorController.findTipotrabajador(TipoTrabajador));
                jpaCredito.setTipocredito(jpaTipoCreditoController.findTipocredito(TipoCredito));
                jpaCredito.setTrabajacompania(TrabajaCompania);

//                <Credito> cred = cBusinessImpl.ObtenerCreditos();
//                int position = cred.size() - 1;
//                Credito Credit = cred.get(position);
//                int NroCredito = Integer.parseInt(Credit.getNroCredito()) + 1;
                Boolean crear = true;
                creditoList = jpaCreditoController.findCredito_1Entities();

                List<Credito_1> listCredAux = new ArrayList<>();
                for (Credito_1 cre : creditoList) {
                    if (cre.getDocumentopersona().equals(NroDocumento)) {
                        listCredAux.add(cre);
                    }
                }

                if (listCredAux.size() > 0) {
                    for (Credito_1 crd : listCredAux) {
                        if (crd.getTipocredito().getId() == TipoCredito) {
                            crear = false;
                        }
                    }
                }

                if (crear) {

                    try {
                        jpaCreditoController.create(jpaCredito);
//                    Credito credito = new Credito(String.valueOf(NroCredito), NroDocumento, Nombres, Apellidos, Monto, TipoTrabajador, TipoCredito, TrabajaCompañia);
//                    String mensaje = cBusinessImpl.CrearCredito(credito);
//                    session.setAttribute("creditoCreated", mensaje);
//                    List<Credito> creditoList = cBusinessImpl.ObtenerCreditos();
                        creditoList = jpaCreditoController.findCredito_1Entities();
                        session.setAttribute("CreditoCreado", "Crédito creado correctamente.");
                    } catch (Exception ex) {
                        Logger.getLogger(CreditoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    session.setAttribute("ExceptionCreated", "El usuario ya tiene actualmente un credito del mismo tipo");
                }
                rd = request.getRequestDispatcher("views/creditos.jsp");

                break;
            case "CredMasUtilizado":
                limpiarMensajes(session);
                resp = jpaCreditoController.ObtenerCreditoMasutilizado();//cBusinessImpl.ObtenerCreditoMasutilizado();
                session.setAttribute("creditoMasUtilizado", resp);
                rd = request.getRequestDispatcher("views/Menu.jsp");
                break;
            case "CredMasAcum":
                limpiarMensajes(session);
                resp = jpaCreditoController.ObtenerPrestamoMayorAcumulado();//cBusinessImpl.ObtenerCreditoMasutilizado();
                session.setAttribute("creditoMayAcum", resp);
                rd = request.getRequestDispatcher("views/Menu.jsp");
                break;
            case "MayorPrestamista":
                limpiarMensajes(session);
                resp = jpaCreditoController.ObtenerMayorPrestamista();
                session.setAttribute("MayorPrestamista", resp);
                rd = request.getRequestDispatcher("views/Menu.jsp");
                break;

            case "Listar":
                limpiarMensajes(session);
                creditoList = jpaCreditoController.findCredito_1Entities();
                session.setAttribute("creditosList", creditoList);
                rd = request.getRequestDispatcher("views/creditosList.jsp");
                break;
            default:
                break;
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void limpiarMensajes(HttpSession session) {
        String nulle = "null";
        session.setAttribute("creditoMasUtilizado", nulle);
        session.setAttribute("ExceptionCreated", nulle);
        session.setAttribute("CreditoCreado", nulle);
        session.setAttribute("creditoMayAcum", nulle);
        session.setAttribute("MayorPrestamista", nulle);
    }

}
