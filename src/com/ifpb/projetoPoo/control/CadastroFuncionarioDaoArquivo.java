package com.ifpb.projetoPoo.control;

import com.ifpb.projetoPoo.model.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class CadastroFuncionarioDaoArquivo implements CadastroFuncionarioDao{
    
    private File arquivo;
    
    public CadastroFuncionarioDaoArquivo() throws IOException {
        arquivo = new File("Funcionario.txt");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        
    }

    @Override
    public Set<Funcionario> getFuncionario() throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionario;
        if(arquivo.length() > 0){
            ObjectInputStream f = new ObjectInputStream (new FileInputStream(arquivo));
            funcionario = (Set<Funcionario>) f.readObject();
            f.close();
        }else{
            funcionario = new HashSet<>();
        }
        return funcionario;
    }

    @Override
    public boolean cadastrar(Funcionario f) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionario = getFuncionario();
        
        funcionario.add(f);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(funcionario);
        out.close();
        return true;
    }

    @Override
    public Funcionario login(String cpf, String senha) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionario = getFuncionario();
        
        for (Funcionario f : funcionario){
            if(f.getCpf().equals(cpf) && f.getSenha().equals(senha)){
                return f;
            }
            }
        return null;
    }
        
}
