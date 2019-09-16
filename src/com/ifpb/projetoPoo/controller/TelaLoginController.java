package com.ifpb.projetoPoo.controller;

import com.ifpb.projetoPoo.dao.LoginDaoArquivo;
import com.ifpb.projetoPoo.model.Login;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController implements Initializable {
    
    @FXML private TextField campoEmail;
    @FXML private PasswordField campoSenha;
    @FXML private Button buttonCadastrar;
    @FXML private Button buttonEntrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

          buttonEntrar.setOnAction((ActionEvent event) -> {
                   String email = campoEmail.getText();
                   String senha = campoSenha.getText();
                   
                   Login l = new Login();
                   l.setEmail(email);
                   l.setSenha(senha);
                   
                   try {
                        LoginDaoArquivo dao = new LoginDaoArquivo();
                        Login acessar = dao.entrar(email, senha);
                        if(acessar != null){
                          mudarTela();
                          buttonEntrar.getScene().getWindow().hide();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText("Email ou senha incorreto!");
                            alert.show();
                            
                        }
                   } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                   }
              
          });
          
          buttonCadastrar.setOnAction((ActionEvent event) -> {
                  Stage stage = new Stage();
                  Parent root = null;
                  
                  try{
                      root = FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/CadastroLogin.fxml"));
                  } catch(IOException ex){
                      Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  Scene scene = new Scene(root);
                  
                  stage.setScene(scene);
                  stage.show();
                  stage.setTitle("Cadastro de Usuário");
                  
                  buttonEntrar.getScene().getWindow().hide();
                 
          });
    } 
  
    private void mudarTela() {
        Stage stage = new Stage();
                  Parent root = null;
                  
                  try{
                      root = FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/TelaPrincipal.fxml"));
                  } catch(IOException ex){
                      Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  Scene scene = new Scene(root);
                  
                  stage.setScene(scene);
                  stage.show();
                  stage.setTitle("Sistema de Supermercado");
    }
}
