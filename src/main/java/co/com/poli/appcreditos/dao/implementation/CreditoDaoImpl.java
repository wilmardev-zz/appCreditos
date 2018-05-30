/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.dao.implementation;

import co.com.poli.appcreditos.dao.ICreditoDao;
import co.com.poli.appcreditos.data.DatosCredito;
import co.com.poli.appcreditos.model.Credito;
import java.util.List;

/**
 *
 * @author wilmar.duque
 */
public class CreditoDaoImpl implements ICreditoDao{
    

    @Override
    public List<Credito> ObtenerCreditos() {
        return DatosCredito.getListCredit();
    }

    @Override
    public String ObtenerCreditoMasutilizado() {
        List<Credito> listaCred = DatosCredito.getListCredit();
        int contVivienda = 0;
        int contEstudio = 0;
        int contInversion = 0;
        String mayor = "";
        for(Credito cred : listaCred){
            switch(cred.getTipoCredito()){
                case 1:
                    contVivienda++;
                    break;
                case 2:
                    contEstudio++;
                    break;
                case 3:
                    contInversion++;
                    break;
            }
        }
        
        if(contVivienda > contEstudio){
            if(contVivienda > contInversion){
                mayor = "Vivienda";
            }
        }else{
            if(contEstudio > contInversion){
                mayor = "Estudio";
            }
            else{
                if(contInversion > contVivienda)
                    mayor = "Inversion";
            }
        }
        return mayor;
    }

    @Override
    public String CrearCredito(Credito credito) {
        List<Credito> listaCred = DatosCredito.getListCredit();
        listaCred.add(credito);
        DatosCredito.setListCredit(listaCred);
        return "Credito Creado";
    }

    @Override
    public String ObtenerPrestamoMayorAcumulado() {
        List<Credito> listaCred = DatosCredito.getListCredit();
        double acumVivienda = 0;
        double acumtEstudio = 0;
        double acumtInversion = 0;
        String mayor = "";
        for(Credito cred : listaCred){
            switch(cred.getTipoCredito()){
                case 1:
                    acumVivienda += cred.getMonto();
                    break;
                case 2:
                    acumtEstudio += cred.getMonto();
                    break;
                case 3:
                    acumtInversion += cred.getMonto();
                    break;
            }
        }
        
        if(acumVivienda > acumtEstudio){
            if(acumVivienda > acumtInversion){
                mayor = "Vivienda,"+acumVivienda;
            }
        }else{
            if(acumtEstudio > acumtInversion){
                mayor = "Estudio,"+acumtEstudio;
            }
            else{
                if(acumtInversion > acumVivienda)
                    mayor = "Inversion,"+acumtInversion;
            }
        }
        return mayor;
    }

    @Override
    public String ObtenerPrestamistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Credito ObtenerCredito(String NroCredito) {
        Credito credit = null;
        for(Credito item : DatosCredito.getListCredit()){
            if(item.getNroCredito().equals(NroCredito)){
                credit = item;
                break;
            }
        }
        return credit;
    }
    
    
    
}
