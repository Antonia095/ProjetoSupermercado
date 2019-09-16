package com.ifpb.projetoPoo.controller;

import com.ifpb.projetoPoo.dao.ProdutoDaoArquivo;
import com.ifpb.projetoPoo.model.Produto;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaProdutoController implements Initializable {
     @FXML private TextField campoValorUnitarioDeProduto;
     @FXML private Button ButtonBuscarProduto;
     @FXML private TextField campoCodigoProduto;
     @FXML private Button ButtonAtualizarProduto;
     @FXML private Button ButtonExcluirProduto;
     @FXML private TextField campoNomeProduto;
     @FXML private ComboBox<String> comboBoxTipoDeProduto;
     @FXML private Button ButtonCadastrarProduto;
     @FXML private TextField campoQuantidadeDeProduto;
     @FXML private TextField campoNomeFornecedor;
     
     private ProdutoDaoArquivo dao;
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
             dao = new ProdutoDaoArquivo();
         } catch (IOException ex) {
             Logger.getLogger(TelaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         comboBoxTipoDeProduto = new ComboBox<>();
         comboBoxTipoDeProduto.getItems().addAll(
                        "Alimento", "Bebidas", "Limpeza", "Ortifruti"
         );
         
        String valor = campoValorUnitarioDeProduto.getText();
        double valorUnitario = Double.parseDouble(valor);
        String quant = campoQuantidadeDeProduto.getText();
        int quantProduto = Integer.parseInt(quant);
        String tipoProduto = (String) comboBoxTipoDeProduto.getValue();
             
        Produto p = new Produto(campoCodigoProduto.getText(),campoNomeProduto.getText(),
                                campoNomeFornecedor.getText(), valorUnitario, tipoProduto, quantProduto);
        
        
       ButtonCadastrarProduto.setOnAction((ActionEvent event) -> {
             try{
                 if(dao.salvar(p)){
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Produto cadastrado");
                               alert.show();
                 }else{
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Produto não cadastrado");
                               alert.show();
                 }
             }catch(IOException | ClassNotFoundException ex) {
                           Logger.getLogger(TelaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                       }
         
         
         });
         
         
       
    } 
    
        
    
    
}
