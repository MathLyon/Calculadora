/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtusu;
    @FXML
    private JFXPasswordField txtsenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrarL(ActionEvent event) throws IOException {
  FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getResource("cadastro.fxml"));
    Scene scene = new Scene(fxmlLoader.load(),500,500);
    Stage stage = new Stage();
    stage.setTitle("Cadastro");
    stage.setScene(scene);
    stage.show();
    }
    

    @FXML
    private void entrar(ActionEvent event)throws IOException  {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
      EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT f FROM Login as f WHERE f.usuario = :user ");
        query.setParameter("user", txtusu.getText());
        if(query.getResultList().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("o usuario nao existe BROW");
            alert.showAndWait();
        }else{
            Login f =(Login) query.getSingleResult();
            if (!f.getSenha().equals(txtsenha.getText())){
              Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("A senha nao existe BROW");
            alert.showAndWait();
            }
            else{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MenuPrincipal.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),500,500);
                Stage stage = new Stage();
                stage.setTitle("Menu Principal");
                stage.setScene(scene);
                stage.show();
        }
                 
                

    }
   
    }
}

      