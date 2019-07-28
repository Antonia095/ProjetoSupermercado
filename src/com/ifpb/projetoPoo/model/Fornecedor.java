package com.ifpb.projetoPoo.model;

import com.ifpb.enumeration.TipoDeProduto;
import java.util.Objects;

public class Fornecedor {
    private String cnpj;
    private String nome;
    private String email;
    private int telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private TipoDeProduto produtoFornecido;

    public Fornecedor(String cnpj, String nome, String email, int telefone, String endereco, String bairro, String cidade, String estado, TipoDeProduto produtoFornecido) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.produtoFornecido = produtoFornecido;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoDeProduto getProdutoFornecido() {
        return produtoFornecido;
    }

    public void setProdutoFornecido(TipoDeProduto produtoFornecido) {
        this.produtoFornecido = produtoFornecido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.cnpj);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "cnpj=" + cnpj 
                + ", nome=" + nome 
                + ", email=" + email 
                + ", telefone=" + telefone 
                + ", endereco=" + endereco 
                + ", bairro=" + bairro 
                + ", cidade=" + cidade 
                + ", estado=" + estado 
                + ", produtoFornecido=" + produtoFornecido 
                + '}';
    }
    
    
}
