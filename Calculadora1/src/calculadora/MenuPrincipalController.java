/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class MenuPrincipalController implements Initializable {


  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrircalculadora(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("calculadora.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),500,500);
            Stage stage = new Stage();
            stage.setTitle("Calculadora");
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){

        }
    }

    @FXML
    private void fecharprojeto(ActionEvent event) {
    System.exit(0);
    }

    @FXML
    private void abrirListagem(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Listagem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),500,500);
        Stage stage = new Stage();
        stage.setTitle("Listagem");
        stage.setScene(scene);
        stage.show();
    }

    
}
