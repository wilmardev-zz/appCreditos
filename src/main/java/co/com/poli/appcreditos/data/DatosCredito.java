/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.data;

import co.com.poli.appcreditos.model.Credito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmar.duque
 */
public class DatosCredito {
    
    private static List<Credito> listCredit;
    
    static{
        listCredit = new ArrayList<Credito>(){
            {
                add(new Credito("123","12234","Luisa","Tangarife", 1000.00, 1, 1, Boolean.FALSE));
                add(new Credito("12","123","Luisa","Tangarife", 1000.00, 1, 2, Boolean.FALSE));
                add(new Credito("54","547","Luisa","Tangarife", 1000.00, 1, 2, Boolean.FALSE));
                add(new Credito("324","76865","Luisa","Tangarife", 1000.00, 1, 2, Boolean.FALSE));
            }
        };
    }

    public static List<Credito> getListCredit() {
        return listCredit;
    }

    public static void setListCredit(List<Credito> listCredit) {
        DatosCredito.listCredit = listCredit;
    }
    
    
    
}
