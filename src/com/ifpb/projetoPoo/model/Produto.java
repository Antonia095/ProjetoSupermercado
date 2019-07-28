package com.ifpb.projetoPoo.model;

import com.ifpb.enumeration.TipoDeProduto;
import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable{
    private String codBarra;
    private String nome;
    private Fornecedor fornecedor;
    private double valorUnitario;
    private TipoDeProduto tipo;
    private int quantidade;

    public Produto(String codBarra, String nome, Fornecedor fornecedor, double valorUnitario, TipoDeProduto tipo, int quantidade) {
        this.codBarra = codBarra;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public TipoDeProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeProduto tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.codBarra);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.codBarra, other.codBarra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codBarra=" + codBarra 
                + ", nome=" + nome 
                + ", fornecedor=" + fornecedor 
                + ", valorUnitario=" + valorUnitario 
                + ", tipo=" + tipo 
                + ", quantidade=" + quantidade 
                + '}';
    }
    
    
}
