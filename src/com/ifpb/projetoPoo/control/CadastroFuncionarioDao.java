package com.ifpb.projetoPoo.control;

import com.ifpb.projetoPoo.model.Funcionario;
import java.io.IOException;
import java.util.Set;


public interface CadastroFuncionarioDao {
        Set<Funcionario> getFuncionario() throws IOException, ClassNotFoundException;
        boolean cadastrar(Funcionario funcionario) throws IOException, ClassNotFoundException;
        Funcionario login (String cpf, String senha) throws IOException, ClassNotFoundException;
}
