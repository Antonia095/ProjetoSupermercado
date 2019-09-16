package com.ifpb.projetoPoo.controller;

import com.ifpb.projetoPoo.dao.FornecedorDaoArquivo;
import com.ifpb.projetoPoo.model.Fornecedor;
import java.io.IOException;
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

public class TelaFornecedorController implements Initializable {
    @FXML private Button ButtonExcluirFornecedor;
    @FXML private TextField campoEndereco;
    @FXML private Button ButtonAtualizarFornecedor;
    @FXML private Button ButtonCadastrarFornecedor;
    @FXML private TextField campoNomeFornecedor;
    @FXML private ComboBox<String> comboBoxTipo;
    @FXML private TextField campoTelefone;
    @FXML private TextField campoBairro;
    @FXML private TextField campoEmail;
    @FXML private TextField campoCnpj;
    @FXML private TextField campoCidade;
    @FXML private Button ButtonBuscarFornecedor;
    @FXML private TextField campoEstado;

    private FornecedorDaoArquivo dao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
             dao = new FornecedorDaoArquivo();
         } catch (IOException ex) {
             Logger.getLogger(TelaFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         comboBoxTipo = new ComboBox<>();
         comboBoxTipo.getItems().addAll(
                        "Alimento", "Bebidas", "Limpeza", "Ortifruti"
         );
         
         String tipo = (String) comboBoxTipo.getValue();
         String tel = campoTelefone.getText();
         int telefone = Integer.parseInt(tel);
         
         Fornecedor f = new Fornecedor(campoCnpj.getText(),campoNomeFornecedor.getText(),campoEmail.getText(),
                                       telefone,campoEndereco.getText(),campoBairro.getText(),
                                        campoCidade.getText(),campoEstado.getText(),tipo);
         
         ButtonCadastrarFornecedor.setOnAction((ActionEvent event) -> {
             try{
                 if(dao.salvar(f)){
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Fornecedor cadastrado");
                               alert.show();
                 }else{
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Fornecedor não cadastrado");
                               alert.show();
                 }
             }catch(IOException | ClassNotFoundException ex) {
                           Logger.getLogger(TelaFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                       }
         });
         
         ButtonExcluirFornecedor.setOnAction((ActionEvent event) -> {
             try{
                 if(dao.deletar(f)){
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Fornecedor excluido");
                               alert.show();
                 }else{
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Fornecedor não excluido");
                               alert.show();
                 }
             }catch(IOException | ClassNotFoundException ex) {
                           Logger.getLogger(TelaFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                       }
         });
         
         ButtonAtualizarFornecedor.setOnAction((ActionEvent event) -> {
             try{
                 if(dao.atualizarDadosFornecedor(f)){
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Fornecedor atualizado");
                               alert.show();
                 }else{
                     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Fornecedor não atualizado");
                               alert.show();
                 }
             }catch(IOException | ClassNotFoundException ex) {
                           Logger.getLogger(TelaFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                       }
         });

         ButtonBuscarFornecedor.setOnAction((ActionEvent event) -> {
             Fornecedor fornecedor = null;
             try{
                 fornecedor = dao.buscar(campoCnpj.getText());                   
                 
             }catch(IOException | ClassNotFoundException ex) {
                           Logger.getLogger(TelaFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                       }
         });
        
    }    
    
}
