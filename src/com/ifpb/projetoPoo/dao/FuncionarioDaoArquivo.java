package com.ifpb.projetoPoo.dao;

import com.ifpb.projetoPoo.enumeration.TipoDeCargo;
import com.ifpb.projetoPoo.model.Funcionario;
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
 * Classe de implementação de Funcionario dao.
 * @author antonia
 */

public class FuncionarioDaoArquivo implements FuncionarioDao{
    
    private File arquivoFuncionario;
    
    /**
     * Método de persistência.
     * @throws IOException 
     */
    
    public FuncionarioDaoArquivo() throws IOException{
        arquivoFuncionario = new File("Funcionario");
        
        if(arquivoFuncionario.exists()){
            arquivoFuncionario.createNewFile();
        }
    }
     /**
      * Método usado para armazenar as informações da classe
     * funcionario usando a tabela Hast.
      * @return
      * @throws IOException
      * @throws ClassNotFoundException 
      */
    @Override
    public Set<Funcionario> getFuncionario() throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionario;
        
        if(arquivoFuncionario.length() > 0){
            ObjectInputStream f = new ObjectInputStream (new FileInputStream(arquivoFuncionario));
            funcionario = (Set<Funcionario>) f.readObject();
            f.close();
        }else{
            funcionario = new HashSet<>();
        }
        return funcionario;
    }
    /**
     * Método utilizado para cadastrar funcionário.
     * @param funcionario
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean cadastrar(Funcionario funcionario) throws IOException, ClassNotFoundException {
        Set<Funcionario> f = getFuncionario();
        f.add(funcionario);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoFuncionario));
        out.writeObject(f);
        out.close();
        return true;
    }
    /**
     * Método utilizado para atualizar os dados do funcionário.
     * @param funcionario
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean atualizar(Funcionario funcionario) throws IOException, ClassNotFoundException {
        Set<Funcionario> f = getFuncionario();
        
        for(Funcionario funcionarios : f){
            if(funcionarios.getCpf() == funcionario.getCpf()){
                f.remove(funcionarios);
                f.add(funcionario);
                atualizarArquivo(f);
                return true;
                
            }
        }
        return false;
    }
    /**
     * Método utilizado para atualizar os dados do funcionário.
     * @param f
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void atualizarArquivo(Set<Funcionario> f) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoFuncionario));
        
        out.writeObject(f);
        out.close();
    }
    
    /**
     * Método utilizado para deletar os dados do funcionário
     * @param funcionario
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean deletar(Funcionario funcionario) throws IOException, ClassNotFoundException {
        Set<Funcionario> f = getFuncionario();
        f.remove(funcionario);
        
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(arquivoFuncionario));
        out.writeObject(f);
        out.close();
        return true;
    }
    
    /**
     * Método utilizado para buscar os dados do funcionário
     * @param cpf
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public Funcionario buscar(String cpf) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionario = getFuncionario();
       
       for(Funcionario f : funcionario){
           if(f.getCpf() == cpf){
               return f;
           }
       }
       return null;
    }
    
}
