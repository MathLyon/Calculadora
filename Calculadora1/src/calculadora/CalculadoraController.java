/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CalculadoraController implements Initializable {

    double valor1 = 0, valor2 = 0, resultado = 0;
    String op = "";
    @FXML
    private TextField TELA;
    @FXML
    private Button SETEBTN;
    @FXML
    private Button QUATROBTN;
    @FXML
    private Button UMBTN;
    @FXML
    private Button ZEROBTN;
    @FXML
    private Button DOISBTN;
    @FXML
    private Button CINCOBTN;
    @FXML
    private Button OITOBTN;
    @FXML
    private Button TRESBTN;
    @FXML
    private Button SEISBTN;
    @FXML
    private Button NOVEBTN;
    @FXML
    private Button IGUALBTN;
    @FXML
    private Button SOMABTN;
    @FXML
    private Button MENOSBTN;
    @FXML
    private Button BARRABTN;
    @FXML
    private Button VEZESBTN;
    @FXML
    private Button CLEAR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        UMBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "1");
            }
        }
        );

        DOISBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "2");
            }
        }
        );
        TRESBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "3");
            }
        }
        );
        QUATROBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "4");
            }
        }
        );
        CINCOBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "5");
            }
        }
        );
        SEISBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "6");
            }
        }
        );
        SETEBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "7");
            }
        }
        );
        OITOBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "8");
            }
        }
        );
        NOVEBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "9");
            }
        }
        );
        ZEROBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TELA.setText(TELA.getText() + "0");
            }
        }
        );
        VEZESBTN.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(TELA.getText());
                TELA.setText("");
                op = "*";
            }
        }
        );
        SOMABTN.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(TELA.getText());
                TELA.setText("");
                op = "+";
            }
        }
        );
        MENOSBTN.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(TELA.getText());
                TELA.setText("");
                op = "-";
            }
        }
        );
        BARRABTN.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(TELA.getText());
                TELA.setText("");
                op = "/";
            }
        }
        );
        CLEAR.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                TELA.setText("");
                valor1 = 0;
                valor2 = 0;
                op = "";
            }
        }
        );
        IGUALBTN.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valor2 = Double.parseDouble(TELA.getText());

                switch (op) {
                    case "+":
                        resultado = valor1 + valor2;
                        TELA.setText(String.valueOf(resultado));
                    break;
                    case"-":
                        resultado = valor1 - valor2;
                        TELA.setText(String.valueOf(resultado));
                    break;
                    case"/":
                        resultado = valor1/valor2;
                        TELA.setText(String.valueOf(resultado));
                    break;
                    case"*":
                        resultado = valor1*valor2;
                        TELA.setText(String.valueOf(resultado));
                    break;
                }
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
                EntityManager em = emf.createEntityManager();

                Calcles a = new Calcles();
                a.setFirstN(valor1);
                a.setSecondN(valor2);
                a.setOperator(op);
                a.setResult(resultado);
                em.getTransaction().begin();

                em.persist(a);

                em.getTransaction().commit();
                valor1 = 0;
                valor2 = 0;
                op = "";
                
              
       
    }
            
        }
        );
    }

}
