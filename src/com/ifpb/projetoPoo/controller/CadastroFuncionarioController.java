package com.ifpb.projetoPoo.controller;

import com.ifpb.projetoPoo.dao.FuncionarioDaoArquivo;
import com.ifpb.projetoPoo.model.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CadastroFuncionarioController implements Initializable {
    
    @FXML private TextField campoNome;
    @FXML private TextField campoCpf;
    @FXML private TextField campoRg;
    @FXML private TextField campoTelefone;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoBairro;
    @FXML private TextField campoCidade;
    @FXML private TextField campoCargo;
    @FXML private ComboBox<String> cbCargo;
    @FXML private TextField campoSalario;
    @FXML private Button btBuscar;
    @FXML private Button btCadastrar;
    @FXML private Button btAtualizar;
    @FXML private Button btExcluir;
    @FXML private Button btSair;
    
    private FuncionarioDaoArquivo dao;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
                  dao = new  FuncionarioDaoArquivo();
             } catch (IOException ex) {
                 Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
             }
           
            cbCargo = new ComboBox<>();
            cbCargo.getItems().addAll(
                        "Vendedor", "Gerente"
            );
            
            String tipoCargo = (String) cbCargo.getValue();
            
            String valorSalario = campoSalario.getText();
            float salario = Float.parseFloat(valorSalario);
           
            Funcionario f = new Funcionario(campoNome.getText(), campoCpf.getText(), campoRg.getText(), 
                     campoTelefone.getText(), campoEndereco.getText(), campoBairro.getText(), campoCidade.getText(), 
                    tipoCargo, salario);
            
             btCadastrar.setOnAction((ActionEvent event) -> {
            
                       try {
                           if(dao.cadastrar(f)){
                               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Usuário cadastrado");
                               alert.show();
                           }else{
                               Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Usuário não cadastrado");
                               alert.show();
                           }
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
               });
    
            btBuscar.setOnAction((ActionEvent event) -> {
                       Funcionario funcionario = null;
            
                       try {
                            funcionario = dao.buscar(campoCpf.getText());
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       if (funcionario == null){
                           Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Funcionário não encontrado");
                               alert.show();
                       }else{
                           campoNome.setText(f.getNome());
                           campoRg.setText(f.getRg());
                           campoTelefone.setText(f.getTelefone());
                           campoEndereco.setText(f.getEndereco());
                           campoBairro.setText(f.getBairro());
                           campoCidade.setText(f.getCidade());
                          }
                       
             });
            
            btAtualizar.setOnAction((ActionEvent event) -> {
                         try {
                            if(dao.atualizar(f)){
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Funcionário atualizado!");
                               alert.show();
                            }else{
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Falha ao atualizar arquivo!");
                               alert.show();
                            }
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
             });
            
            btExcluir.setOnAction((ActionEvent event) -> {
                         try {
                            if(dao.deletar(f)){
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                               alert.setHeaderText("Funcionário excluido!");
                               alert.show();
                            }else{
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Falha ao excluir funcionário!");
                               alert.show();
                            }
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
             });
            
            
           
       
    } 
    
   
   
}