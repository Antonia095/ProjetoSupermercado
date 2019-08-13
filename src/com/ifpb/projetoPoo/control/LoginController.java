package com.ifpb.projetoPoo.control;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    
    @FXML
    private Menu menuItemEntrar;
    @FXML
    private Menu menuItemCadastrar;
    @FXML
    private Button buttonEntrar;
    @FXML
    private Button buttonCadastrar;
    
    @FXML
    private AnchorPane anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    @FXML
    
     public void btActionCadastrar() throws IOException {
        AnchorPane cadastro = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/ifpb/projetoPoo/view/CadastroFuncionario.fxml"));
        
        anchorPane.getChildren().setAll(cadastro);
    } 
}
