package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Cartao;
import java.io.IOException;
import java.util.Set;

/**
 * Interface Dao da classe Cartão.
 * @author antonia
 */

public interface CartaoDao {
    Set<Cartao> getCartao()throws IOException, ClassNotFoundException;
    boolean salvar(Cartao cartao) throws IOException, ClassNotFoundException;
    boolean atualizar(Cartao cartao) throws IOException, ClassNotFoundException;
    boolean excluir(Cartao cartao) throws IOException, ClassNotFoundException;
}
