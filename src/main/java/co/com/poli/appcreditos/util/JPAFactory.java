/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wilmar.duque
 */
public class JPAFactory {
    
    private static final String UP = "UP_APPCREDITOS";
    private static final EntityManagerFactory EMFACTORY;
    
    static {
        EMFACTORY = Persistence.createEntityManagerFactory(UP);
    }

    public static EntityManagerFactory getEMFACTORY() {
        return EMFACTORY;
    }
 
    
    
    
}
