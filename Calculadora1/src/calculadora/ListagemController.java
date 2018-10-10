/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ListagemController implements Initializable {

    @FXML
    private TableView<?> tabela;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
        EntityManager em = emf.createEntityManager();

        // Busca utilizando HQL
        Query query = em.createQuery("SELECT a FROM Calcles as a");
        List<Calcles> alunos = query.getResultList();

        // Converte lista para observable list
        ObservableList ob = FXCollections.observableArrayList(alunos);
        // Adiciona resultado a Tabela
        tabela.setItems(ob);
        // Adiciona resultado ao Combobox
               

        em.close();
        emf.close();
    }

    
}
