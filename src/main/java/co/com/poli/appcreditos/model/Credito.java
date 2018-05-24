/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.model;

import java.util.Objects;

/**
 *
 * @author wilmar.duque - luisa tangarife
 */
public class Credito {
    
    private String NroCredito;
    private String NroDocumento;
    private String Nombres;
    private String Apellidos;
    private double Monto;
    private int TipoTrabajador; //1-Independiente; 2-Dependiente
    private int TipoCredito; //1-Vivienda, 2-Estudio, 3-LibreInversion
    private boolean TrabajaCompañia;

    public Credito(String NroCredito, String NroDocumento, String Nombres, String Apellidos, double Monto, int TipoTrabajador, int TipoCredito, boolean TrabajaCompañia) {
        this.NroCredito = NroCredito;
        this.NroDocumento = NroDocumento;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Monto = Monto;
        this.TipoTrabajador = TipoTrabajador;
        this.TipoCredito = TipoCredito;
        this.TrabajaCompañia = TrabajaCompañia;
    }

    public String getNroCredito() {
        return NroCredito;
    }

    public void setNroCredito(String NroCredito) {
        this.NroCredito = NroCredito;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public int getTipoTrabajador() {
        return TipoTrabajador;
    }

    public void setTipoTrabajador(int TipoTrabajador) {
        this.TipoTrabajador = TipoTrabajador;
    }

    public int getTipoCredito() {
        return TipoCredito;
    }

    public void setTipoCredito(int TipoCredito) {
        this.TipoCredito = TipoCredito;
    }

    public boolean isTrabajaCompañia() {
        return TrabajaCompañia;
    }

    public void setTrabajaCompañia(boolean TrabajaCompañia) {
        this.TrabajaCompañia = TrabajaCompañia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.NroCredito);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Credito other = (Credito) obj;
        if (!Objects.equals(this.NroCredito, other.NroCredito)) {
            return false;
        }
        return true;
    }
    
    
    
}
