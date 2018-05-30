/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.business.implementation;

import co.com.poli.appcreditos.model.Credito;
import java.util.List;
import co.com.poli.appcreditos.business.ICreditoBusiness;
import co.com.poli.appcreditos.dao.implementation.CreditoDaoImpl;
import co.com.poli.appcreditos.data.DatosCredito;

/**
 *
 * @author wilmar.duque
 */
public class CreditoBusinessImpl implements ICreditoBusiness{
    
    private CreditoDaoImpl creditoDaoImpl = new CreditoDaoImpl();

    @Override
    public List<Credito> ObtenerCreditos() {
        
        return creditoDaoImpl.ObtenerCreditos();
        
    }

    @Override
    public String ObtenerCreditoMasutilizado() {
        return creditoDaoImpl.ObtenerCreditoMasutilizado();
    }

    @Override
    public String CrearCredito(Credito credito) {
        String response = "Credit already exist";
        if(credito.getNroCredito().equals(creditoDaoImpl.ObtenerCredito(credito.getNroCredito()))){
            response = "Credit already exist";
        }else{
            creditoDaoImpl.CrearCredito(credito);
            response = "Credit created successfully";
        }
        return response;        
    }

    @Override
    public String ObtenerPrestamoMayorAcumulado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ObtenerPrestamistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Credito ObtenerCredito(String NroCredito) {
        return creditoDaoImpl.ObtenerCredito(NroCredito);
    }
    
}
