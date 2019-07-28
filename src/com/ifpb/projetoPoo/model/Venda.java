package com.ifpb.projetoPoo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Venda {
     private String codVenda;
      private LocalDate dataVenda;
      private ItemVenda[] vendido;
      private Funcionario vendidoPor;
      private double total;

    public Venda(String codVenda, LocalDate dataVenda, ItemVenda[] vendido, Funcionario vendidoPor, double total) {
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.vendido = vendido;
        this.vendidoPor = vendidoPor;
        this.total = total;
    }

    public String getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(String codVenda) {
        this.codVenda = codVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ItemVenda[] getVendido() {
        return vendido;
    }

    public void setVendido(ItemVenda[] vendido) {
        this.vendido = vendido;
    }

    public Funcionario getVendidoPor() {
        return vendidoPor;
    }

    public void setVendidoPor(Funcionario vendidoPor) {
        this.vendidoPor = vendidoPor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.codVenda);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.codVenda, other.codVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda 
                + ", dataVenda=" + dataVenda 
                + ", vendido=" + vendido 
                + ", vendidoPor=" + vendidoPor 
                + ", total=" + total 
                + '}';
    }
      
      
}
