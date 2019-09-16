package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.model.Fornecedor;
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
 * Classe de implementação de Fornecedor dao.
 * @author antonia
 */
public class FornecedorDaoArquivo implements FornecedorDao{
    private File arquivoFornecedor;
    
    /**
     * Método de persistência
     * @throws IOException 
     */
    public FornecedorDaoArquivo() throws IOException{
        arquivoFornecedor = new File("Fornecedor");
        
        if(!arquivoFornecedor.exists()){
            arquivoFornecedor.createNewFile();
        }
    }

    /**
     * Método usado para armazenar as informações da classe
     * fornecedor usando a tabela Hast.
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    
    @Override
    public Set<Fornecedor> getFornecedor() throws IOException, ClassNotFoundException {
        Set<Fornecedor> fornecedor;
       if(arquivoFornecedor.length()>0){
           ObjectInputStream f = new ObjectInputStream( new FileInputStream(arquivoFornecedor));
           fornecedor = (Set<Fornecedor>) f.readObject();
           f.close();
        }else{
         fornecedor = new HashSet<>();
       }
       return fornecedor;
    }

    /**
     * Método utilizado para salvar as informações do Fornecedor.
     * @param fornecedor
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    
    @Override
    public boolean salvar(Fornecedor fornecedor) throws IOException, ClassNotFoundException {
        Set<Fornecedor> f = getFornecedor();
        f.add(fornecedor);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoFornecedor));
        out.writeObject(f);
        out.close();
        return true;
    }
/**
 *  Método utilizado para deletar os dados do Fornecedor.
 * @param fornecedor
 * @return
 * @throws IOException
 * @throws ClassNotFoundException 
 */
    
    @Override
    public boolean deletar(Fornecedor fornecedor) throws IOException, ClassNotFoundException {
        Set<Fornecedor> f = getFornecedor();
        f.remove(fornecedor);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoFornecedor));
        out.writeObject(f);
        out.close();
        return true;
    }
    /**
     * Método utilizado para buscar os dados do Fornecedor cadastrado
     * @param cnpj
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */

    @Override
    public Fornecedor buscar(String cnpj) throws IOException, ClassNotFoundException {
        Set<Fornecedor> fornecedor = getFornecedor();
        
        for(Fornecedor f : fornecedor){
            if(f.getCnpj() == cnpj){
                return f;
            }
        }
        return null;
    }

    /**
     * Método utilizado para atualizar os dados do Fornecedor.
     * @param fornecedor
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean atualizarDadosFornecedor(Fornecedor fornecedor) throws IOException, ClassNotFoundException {
        Set<Fornecedor> f = getFornecedor();
        
        for(Fornecedor fornecedores : f){
            if(fornecedores.getCnpj() == fornecedor.getCnpj()){
                f.remove(fornecedores);
                f.add(fornecedor);
                atualizarFornecedor(f);
                return true;
            }
        }
        return false;
    }
    /**
     * Método utilizado para atualizar os dados do Fornecedor.
     * @param f
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void atualizarFornecedor(Set<Fornecedor> f) throws FileNotFoundException, IOException {
         ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoFornecedor));
         
         out.writeObject(f);
         out.close();
    }
    
}
