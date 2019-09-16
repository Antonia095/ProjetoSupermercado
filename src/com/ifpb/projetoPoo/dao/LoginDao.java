package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Login;
import java.io.IOException;
import java.util.Set;

/**
 * Interface Dao da classe Login.
 * @author antonia
 */

public interface LoginDao {

     Set<Login> getLogin() throws IOException, ClassNotFoundException;
        boolean cadastrar(Login login) throws IOException, ClassNotFoundException;
        Login entrar(String login, String senha) throws IOException, ClassNotFoundException;
        
}
