package com.ifpb.projetoPoo.controller;

import com.ifpb.projetoPoo.dao.CartaoDaoArquivo;
import com.ifpb.projetoPoo.model.Cartao;
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
import javafx.scene.layout.Pane;

public class PagamentoCartaoController implements Initializable {

    @FXML private Button buttonSalvarCliente;
    @FXML private Button buttonExcluirCliente;
    @FXML private TextField campoTitularCartao;
    @FXML private TextField campoNumeroCartao;
    @FXML private Pane painel;
    @FXML private TextField campoTotal;
    @FXML private TextField campoCpfCliente;
    @FXML private ComboBox<String> comBoxTipoCartao;
    @FXML private Button buttonAtualizarCliente;
 
    private CartaoDaoArquivo dao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
                  dao = new  CartaoDaoArquivo();
             } catch (IOException ex) {
                 Logger.getLogger(PagamentoCartaoController.class.getName()).log(Level.SEVERE, null, ex);
             }
           
            comBoxTipoCartao = new ComboBox<>();
            comBoxTipoCartao.getItems().addAll(
                        "VISA", "MASTERCARD", "ELO", "HIPERCARD"
            );
            
            String tipoCargo = (String) comBoxTipoCartao.getValue();
            
            Cartao c = new Cartao(campoCpfCliente.getText(),campoTitularCartao.getText(),
                    campoNumeroCartao.getText(), tipoCargo);
            
            buttonSalvarCliente.setOnAction((ActionEvent event) -> {
            
                       try {
                           if(dao.salvar(c)){
                               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Dados do cliente foi salvo");
                               alert.show();
                           }else{
                               Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Não foi possível salvar os dados do cliente");
                               alert.show();
                           }
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
               });
            
            buttonExcluirCliente.setOnAction((ActionEvent event) -> {
            
                       try {
                           if(dao.excluir(c)){
                               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Dados do cliente foi excluido");
                               alert.show();
                           }else{
                               Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Não foi possível excluir os dados do cliente");
                               alert.show();
                           }
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
               });
            buttonAtualizarCliente.setOnAction((ActionEvent event) -> {
            
                       try {
                           if(dao.atualizar(c)){
                               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                               alert.setHeaderText("Dados do cliente foi atualizado");
                               alert.show();
                           }else{
                               Alert alert = new Alert(Alert.AlertType.ERROR);
                               alert.setHeaderText("Não foi possível atualizar os dados do cliente");
                               alert.show();
                           }
                       } catch (IOException | ClassNotFoundException ex) {
                           Logger.getLogger(CadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                       }
               });
    }    
    
}
