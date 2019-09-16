package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Fornecedor;
import java.io.IOException;
import java.util.Set;

/**
 * Interface Dao da classe Fornecedor.
 * @author antonia
 */

public interface FornecedorDao {
    Set<Fornecedor> getFornecedor() throws IOException, ClassNotFoundException;
        boolean salvar(Fornecedor fornecedor) throws IOException, ClassNotFoundException;
        boolean deletar(Fornecedor fornecedor) throws IOException, ClassNotFoundException;
        Fornecedor buscar(String cnpj) throws IOException, ClassNotFoundException;
        boolean atualizarDadosFornecedor(Fornecedor fornecedor) throws IOException, ClassNotFoundException;
}
