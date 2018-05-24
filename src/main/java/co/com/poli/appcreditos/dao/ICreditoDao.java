/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.dao;

import co.com.poli.appcreditos.model.Credito;
import java.util.List;

/**
 *
 * @author wilmar.duque
 */
public interface ICreditoDao {
    
    List<Credito> ObtenerCreditos();
    String ObtenerCreditoMasutilizado();
    String CrearCredito(Credito credito);
    String ObtenerPrestamoMayorAcumulado();
    String ObtenerPrestamistas();
    
}
