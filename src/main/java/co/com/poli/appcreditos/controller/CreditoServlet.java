/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.controller;

import co.com.poli.appcreditos.business.implementation.CreditoBusinessImpl;
import co.com.poli.appcreditos.model.Credito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wilmar.duque
 */
public class CreditoServlet extends HttpServlet {

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
        CreditoBusinessImpl cBusinessImpl = new CreditoBusinessImpl();
        String action = request.getParameter("action");
        switch (action) {
            case "Create":

                String NroCredito = request.getParameter("txtNroCredito");
                String NroDocumento = request.getParameter("txtNroDocumento");
                String Nombres = request.getParameter("txtNombres");
                String Apellidos = request.getParameter("txtApellidos");
                double Monto = Double.valueOf(request.getParameter("txtMonto"));
                int TipoTrabajador = Integer.parseInt(request.getParameter("txtTipoTrabajador")); //1-Independiente; 2-Dependiente
                int TipoCredito = Integer.parseInt(request.getParameter("txtTipoCredito")); //1-Vivienda, 2-Estudio, 3-LibreInversion
                boolean TrabajaCompañia = Boolean.parseBoolean(request.getParameter("txtTrabajaCompañia"));

                Credito credito = new Credito(NroCredito, NroDocumento, Nombres, Apellidos, Monto, TipoTrabajador, TipoCredito, TrabajaCompañia);
                String mensaje = cBusinessImpl.CrearCredito(credito);
                session.setAttribute("creditoCreated", mensaje);
                List<Credito> creditoList = cBusinessImpl.ObtenerCreditos();
                session.setAttribute("creditoList", creditoList);
                rd = request.getRequestDispatcher("view/creditoList.jsp");
                break;
            case "CredMasUtilizado":

                break;
            case "CredMasAcum":

                break;
            case "MayorPrestamista":

                break;

            case "Listar":
                List<Credito> creditosList = cBusinessImpl.ObtenerCreditos();
                session.setAttribute("creditosList", creditosList);
                rd = request.getRequestDispatcher("view/creditosList.jsp");
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

}
