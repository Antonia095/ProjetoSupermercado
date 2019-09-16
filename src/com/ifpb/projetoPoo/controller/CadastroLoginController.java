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

public class CadastroLoginController implements Initializable {
    
    @FXML private Button btCadastrarUsuario;
    @FXML private TextField campoEmail;
    @FXML private PasswordField campoSenha;
    @FXML private PasswordField campoConfSenha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btCadastrarUsuario.setOnAction((ActionEvent event) -> {
                   
                   String email = campoEmail.getText();
                   String senha = campoSenha.getText();
                   String confSenha = campoConfSenha.getText();
        
                   if(senha.equals(confSenha)){
                       Login l = new Login();
                       l.setEmail(email);
                       l.setSenha(senha);
                       
                       try {
                           LoginDaoArquivo dao = new LoginDaoArquivo();
                           if(dao.cadastrar(l)){
                               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Usuário cadastrado");
                               mudarTela();
                               alert.show();
                           }else{
                               Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Usuário não cadastrado");
                               alert.show();
                           }
                           
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroLoginController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       
                        btCadastrarUsuario.getScene().getWindow().hide();
                  
                   }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("As senhas não coincidem");
                        alert.show();
                    }
        });
}
    
    private void mudarTela(){
                  Stage stage = new Stage();
                  Parent root = null;
                  
                  try{
                      root = FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/TelaLogin.fxml"));
                  } catch(IOException ex){
                      Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  Scene scene = new Scene(root);
                  
                  stage.setScene(scene);
                  stage.show();
                  stage.setTitle("Tela de Login");
    }
    
}
