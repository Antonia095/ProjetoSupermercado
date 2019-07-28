package com.ifpb.projetoPoo.model;

import com.ifpb.enumeration.TipoDeCargo;
import java.io.Serializable;
import java.util.Objects;

public class Funcionario implements Serializable {
    
    private String nome;
    private String cpf;
    private String rg;
    private int telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private TipoDeCargo cargo;
    private String senha;
    

    public Funcionario(String nome, String cpf, String rg, int telefone, String endereco, String bairro, String cidade, TipoDeCargo cargo, String senha) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cargo = cargo;
        this.senha = senha;
        
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public TipoDeCargo getCargo() {
        return cargo;
    }

    public void setCargo(TipoDeCargo cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.cpf);
        hash = 47 * hash + Objects.hashCode(this.rg);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome 
                + ", cpf=" + cpf 
                + ", rg=" + rg 
                + ", telefone=" + telefone 
                + ", endereco=" + endereco 
                + ", bairro=" + bairro 
                + ", cidade=" + cidade 
                + ", cargo=" + cargo 
                + ", senha=" + senha 
                + '}';
    }
    
    
}
