package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Funcionario;
import java.io.IOException;
import java.util.Set;

/**
 * Interface Dao da classe Funcionario
 * @author antonia
 */

public interface FuncionarioDao {
    Set<Funcionario> getFuncionario() throws IOException, ClassNotFoundException;
    boolean cadastrar(Funcionario funcionario) throws IOException, ClassNotFoundException;
    boolean atualizar(Funcionario funcionario) throws IOException, ClassNotFoundException;
    boolean deletar(Funcionario funcionario) throws IOException, ClassNotFoundException;
    Funcionario buscar(String cpf) throws IOException, ClassNotFoundException;
}
