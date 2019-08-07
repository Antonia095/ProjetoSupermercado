package com.ifpb.projetoPoo.model;

import com.ifpb.projetoPoo.enumeration.TipoDeCargo;

public class AtualizarFuncionario  extends Funcionario{
    
    private float salario;

    public AtualizarFuncionario(String nome, String cpf, String rg, int telefone,
            String endereco, String bairro, String cidade, TipoDeCargo cargo, String senha, float salario) {
        super(nome, cpf, rg, telefone, endereco, bairro, cidade, cargo, senha);
        this.salario = salario;
       
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "AtualizarFuncionario{" + "salario=" + salario 
                + '}';
    }

}
