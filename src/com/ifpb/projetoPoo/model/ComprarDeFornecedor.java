package com.ifpb.projetoPoo.model;

import java.time.LocalDate;
import java.util.Objects;


public class ComprarDeFornecedor {
        private String codCompra;
        private LocalDate data;
        private Produto[] produtos;
        private int quantidade;

    public ComprarDeFornecedor(String codCompra, LocalDate data, Produto[] produtos, int quantidade) {
        this.codCompra = codCompra;
        this.data = data;
        this.produtos = produtos;
        this.quantidade = quantidade;
    }

    public String getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(String codCompra) {
        this.codCompra = codCompra;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codCompra);
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
        final ComprarDeFornecedor other = (ComprarDeFornecedor) obj;
        if (!Objects.equals(this.codCompra, other.codCompra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComprarDeFornecedor{" + "codCompra=" + codCompra 
                + ", data=" + data 
                + ", produtos=" + produtos 
                + ", quantidade=" + quantidade 
                + '}';
    }
        
    

}
