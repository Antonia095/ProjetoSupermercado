package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Produto;
import java.io.IOException;
import java.util.Set;

/**
 * Interface Dao da classe Produto.
 * @author antonia
 */

public interface ProdutoDao {
    Set<Produto> getProduto() throws IOException, ClassNotFoundException;
        boolean salvar(Produto produto) throws IOException, ClassNotFoundException;
        boolean excluir(Produto produto) throws IOException, ClassNotFoundException;
        Produto buscar(String codBarra) throws IOException, ClassNotFoundException;
        boolean atualizar(Produto produto) throws IOException, ClassNotFoundException;
}
