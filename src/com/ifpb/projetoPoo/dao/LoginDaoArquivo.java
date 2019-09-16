package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Login;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe de implementação de Login dao.
 * @author antonia
 */

public class LoginDaoArquivo implements LoginDao {
    
    private File arquivo;
    
    /**
     * Método de persistência
     * @throws IOException 
     */
    public LoginDaoArquivo() throws IOException{
        arquivo = new File("Login");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }
    
    /**
     * Método usado para armazenar as informações da classe
     * login usando a tabela Hast.
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */

    @Override
    public Set<Login> getLogin() throws IOException, ClassNotFoundException {
        Set<Login> login;
        if(arquivo.length() > 0){
           ObjectInputStream l = new ObjectInputStream( new FileInputStream(arquivo));
           login = (Set<Login>) l.readObject();
           l.close();
        }else{
            login = new HashSet<>();
        }
        return login;
    }
    
    /**
     * Método utilizado para cadastrar o login.
     * @param login
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean cadastrar(Login login) throws IOException, ClassNotFoundException {
        Set<Login> l = getLogin();
        
        l.add(login);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(l);
        out.close();
        return true;
    }
    /**
     * Método utilizado para acessar o sistema através do login.
     * @param login
     * @param senha
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public Login entrar(String login, String senha) throws IOException, ClassNotFoundException {
        Set<Login> l = getLogin();
        
        for (Login log : l){
            if(log.getEmail().equals(login) && log.getSenha().equals(senha)){
                return log;
            }
        }
        return null;
    }
}