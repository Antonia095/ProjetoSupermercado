/*package com.ifpb.projetoPoo.view;

import com.ifpb.projetoPoo.control.CadastroFuncionarioDaoArquivo;
import com.ifpb.projetoPoo.enumeration.TipoDeCargo;
import com.ifpb.projetoPoo.model.Funcionario;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
       
        Funcionario f1 = new Funcionario("Ana","111.111.111-01","200134-02",888582439,"Rua Jonas Azevedo",
        "Jardim Oasis","Cajazeiras",TipoDeCargo.GERENTE,"12345");
        Funcionario f2 = new Funcionario("Pedro","222.222.222-02","132345-01",88546548,"Rua 03 de abril",
        "Vila NOva","Cajazeiras",TipoDeCargo.VENDEDOR,"987456");
        
        CadastroFuncionarioDaoArquivo dao = new CadastroFuncionarioDaoArquivo();
          
        dao.cadastrar(f1);
        dao.cadastrar(f2);
        
        System.out.println(f1);
        System.out.println(f2);
        
        
        Scanner login = new Scanner(System.in);
        System.out.println("Informe seu CPF:");
        String cpf = login.nextLine();
        System.out.println("Informe sua senha:");
        String senha = login.nextLine();
        
        Funcionario validando = dao.login(cpf, senha);
            
        if (validando == null){
            System.out.println("Cpf ou senha incorreto!");
            }else{
                System.out.println("Bem vindo(a) "+f1.getNome());
            }
        }
    
}
*/