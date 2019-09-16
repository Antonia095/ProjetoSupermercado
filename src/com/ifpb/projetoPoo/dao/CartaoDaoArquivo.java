package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Cartao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
/**
 *  Classe de implementação de Cartao dao 
 * @author antonia
 */
public class CartaoDaoArquivo implements CartaoDao {
    private File arquivoCartao;
    /**
     * Método de persistência
     * @throws IOException 
     */
    public CartaoDaoArquivo() throws IOException{
        arquivoCartao = new File("Cartao");
        
        if(!arquivoCartao.exists()){
            arquivoCartao.createNewFile();
        }
    }
    /**
     * Método usado para armazenar as informações da classe
     * cartão usando a tabela Hast.
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public Set<Cartao> getCartao() throws IOException, ClassNotFoundException {
        Set<Cartao> cartao;
        
        if(arquivoCartao.length()>0){
            ObjectInputStream c = new ObjectInputStream (new FileInputStream(arquivoCartao));
            cartao = (Set<Cartao>) c.readObject();
            c.close();
        }else{
            cartao = new HashSet<>();
        }
        return cartao;
    }
    /**
     * Método utilizado para salvar as informações do cartão.
     * @param cartao
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean salvar(Cartao cartao) throws IOException, ClassNotFoundException {
        Set<Cartao> c = getCartao();
        c.add(cartao);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoCartao));
        out.writeObject(c);
        out.close();
        return true;
    }
    /**
     * Método utilizado para atualizar os dados do cartão.
     * @param cartao
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean atualizar(Cartao cartao) throws IOException, ClassNotFoundException {
        Set<Cartao> c = getCartao();
        
        for(Cartao cartoes : c){
            if(cartoes.getCpfCliente().equals(cartao.getCpfCliente())){
                c.remove(cartoes);
                c.add(cartao);
                atualizarCartao(c);
                return true;
            }
        }
        return false;
    }
    /**
     * Método utilizado para excluir os dados do cartão.
     * @param cartao
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean excluir(Cartao cartao) throws IOException, ClassNotFoundException {
        Set<Cartao> c = getCartao();
        c.remove(cartao);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoCartao));
        out.writeObject(c);
        out.close();
        return true;
    }
    
    /**
     * Método utilizado para atualizar os dados do cartão.
     * @param c
     * @throws FileNotFoundException
     * @throws IOException 
     */

    private void atualizarCartao(Set<Cartao> c) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoCartao));
        
        out.writeObject(c);
        out.close();
    }
    
}
