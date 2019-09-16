package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Produto;
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
 * Classe de implementação de Produto dao
 * @author antonia
 */

public class ProdutoDaoArquivo implements ProdutoDao {
    
    private File arquivoProduto;
    
    /**
     * Método de persistência 
     * 
     * @throws IOException 
     */
    
    
    public ProdutoDaoArquivo() throws IOException {
        arquivoProduto = new File("Produto");
        
        if (!arquivoProduto.exists()){
            arquivoProduto.createNewFile();
        }
    }
    /**
     * Método usado para armazenar as informações da class
     * produto usando a tabela Hast
     * 
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */

    @Override
    public Set<Produto> getProduto() throws IOException, ClassNotFoundException {
        Set<Produto> produto;
        if(arquivoProduto.length() > 0){
            ObjectInputStream p = new ObjectInputStream (new FileInputStream(arquivoProduto));
            produto = (Set<Produto>) p.readObject();
            p.close();
        }else{
            produto = new HashSet<>();
        }
        return produto;
    }
    /**
     * Método utilizado para salvar as informações de um produto
     * @param produto
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */

    @Override
    public boolean salvar(Produto produto) throws IOException, ClassNotFoundException {
        Set<Produto> p = getProduto();
        p.add(produto);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoProduto));
        out.writeObject(p);
        out.close();
        return true;
    }
    
    /**
     * Método utilizado para excluir as informações do produto
     * @param produto
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */

    @Override
    public boolean excluir(Produto produto) throws IOException, ClassNotFoundException {
        Set<Produto> p = getProduto();
        p.remove(produto);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoProduto));
        out.writeObject(p);
        out.close();
        return true;
    }
    /**
     * Método utilizado para buscar as informações do produto pelo código de barra
     * @param codBarra
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public Produto buscar(String codBarra) throws IOException, ClassNotFoundException {
        Set<Produto> produto = getProduto();
        
        for (Produto p : produto){
            if(p.getCodBarra().equals(codBarra)){
                return p;
            }
        }
        return null;
    }
    /**
     * Método utilizado para atualizar os dados do produto
     * @param produto
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */

    @Override
    public boolean atualizar(Produto produto) throws IOException, ClassNotFoundException {
        Set<Produto> p = getProduto();
        
        for (Produto produtos : p){
            if(produtos.getCodBarra().equals(produto.getCodBarra())){
                p.remove(produtos);
                p.add(produto);
                atualizarArquivos(p);
                return true;
            }
        }
        return false;
    }
    /**
     *  Método para atualizar os dados do produto
     * @param p
     * @throws FileNotFoundException
     * @throws IOException 
     */

    private void atualizarArquivos(Set<Produto> p) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoProduto));
        
        out.writeObject(p);
        out.close();
    }
    
}
