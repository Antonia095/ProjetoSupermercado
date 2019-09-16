package com.ifpb.projetoPoo.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable {
    
     @FXML private MenuItem itemVenda;
     @FXML private AnchorPane anchorPane;
     @FXML private MenuItem itemFuncionario;
     @FXML private MenuItem itemFornecedor;
     @FXML private MenuItem itemProduto;
     @FXML private Button btSair;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btSair.setOnAction((ActionEvent event) -> {
                   
                  Stage stage = new Stage();
                  Parent root = null;
                  
                  try{
                      root = FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/TelaLogin.fxml"));
                  } catch(IOException ex){
                      Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  Scene scene = new Scene(root);
                  
                  stage.setScene(scene);
                  stage.show();
                  stage.setTitle("Tela de Login");
                  
                  btSair.getScene().getWindow().hide();
                   
             });
    } 
    
    @FXML
     public void actionItemFuncionario() throws IOException{
         AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/CadastroFuncionario.fxml"));
         anchorPane.getChildren().setAll(a);
     }
     @FXML
     public void actionItemFornecedor() throws IOException{
         AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/TelaFornecedor.fxml"));
         anchorPane.getChildren().setAll(a);
     }
     @FXML
     public void actionItemProduto() throws IOException{
         AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/TelaProduto.fxml"));
         anchorPane.getChildren().setAll(a);
     }
    @FXML
     public void actionItemVenda() throws IOException{
         AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/TelaVenda.fxml"));
         anchorPane.getChildren().setAll(a);
     }
    
}
