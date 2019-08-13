package com.ifpb.projetoPoo.control;

import com.ifpb.projetoPoo.enumeration.TipoDeCargo;
import com.ifpb.projetoPoo.model.Funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastroFuncionarioController implements Initializable {

    @FXML
    private AnchorPane HyperlinkSair;
    @FXML
    private TextField  CampoNome;
    @FXML
    private TextField  CampoCpf;
    @FXML
    private TextField  CampoRg;
    @FXML
    private TextField  CampoTelefone;
    @FXML
    private TextField  CampoEndereco;
    @FXML
    private TextField  CampoBairro;
    @FXML
    private TextField  CampoCidade;
    
    @FXML
    private ComboBox<TipoDeCargo> CamboBoxTipoCargo;
    
    @FXML
    private PasswordField CampoSenha;
    @FXML
    private Button ButtonCadastrarFuncionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
