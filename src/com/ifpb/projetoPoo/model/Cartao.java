package com.ifpb.projetoPoo.model;

import com.ifpb.projetoPoo.enumeration.BandeiraCartao;
import java.io.Serializable;
import java.util.Objects;

public class Cartao implements Serializable{
    private String cpfCliente;
    private String titular;
    private int numero;
    private BandeiraCartao bandeira;

    public Cartao(String cpfCliente, String titular, int numero, BandeiraCartao bandeira) {
        this.cpfCliente = cpfCliente;
        this.titular = titular;
        this.numero = numero;
        this.bandeira = bandeira;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cpfCliente);
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
        final Cartao other = (Cartao) obj;
        if (!Objects.equals(this.cpfCliente, other.cpfCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cartao{" + "cpfCliente=" + cpfCliente 
                + ", titular=" + titular 
                + ", numero=" + numero 
                + ", bandeira=" + bandeira 
                + '}';
    }
    
    
}
