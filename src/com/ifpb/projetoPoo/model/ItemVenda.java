package com.ifpb.projetoPoo.model;

import java.util.Arrays;

public class ItemVenda {
        private int quantidade;
        private Produto[] produtoVendido;

        public ItemVenda(int quantidade, Produto[] produtoVendido) {
            this.quantidade = quantidade;
            this.produtoVendido = produtoVendido;
        }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto[] getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(Produto[] produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.quantidade;
        hash = 97 * hash + Arrays.deepHashCode(this.produtoVendido);
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Arrays.deepEquals(this.produtoVendido, other.produtoVendido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "quantidade=" + quantidade 
                + ", produtoVendido=" + produtoVendido 
                + '}';
    }
}
