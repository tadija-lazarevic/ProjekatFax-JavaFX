/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketball;

import base.CoachBase;
import base.TeamBase;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author tadija
 */
public class SetCoachController implements Initializable {
    
    //Kolone i tabela za prikazivanje trenera
    @FXML
    private TableColumn<Coaches, String> coachesNameCol;
    @FXML
    private TableColumn<Coaches, String> coachesLNCol;
    @FXML
    private TableView coachTable;
    @FXML
    private Button chooseBtn;
    @FXML
    private Button cancelBtn;
    
    private ObservableList<Coaches> coachesData;
    

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        coachesNameCol
                .setCellValueFactory(new PropertyValueFactory<Coaches, String>(
                                "name"));
        coachesLNCol
                .setCellValueFactory(new PropertyValueFactory<Coaches, String>(
                                "lastName"));
        
        coachesData = FXCollections.observableArrayList();
        coachTable.setItems(coachesData);
        coachTable.setEditable(false);
        CoachBase.get();
        loadCoachesData();
    }
    //sql upit
    public void loadCoachesData() {
        try {
            ResultSet rs = CoachBase.query("SELECT * FROM CoachTable");
            coachesData.clear();
            while (rs.next()) {
                coachesData.add(new Coaches(rs.getString("Name"), rs.getString("Lastname")));
            }
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
    }

    public void chooseAction(ActionEvent event) {        
        
    }

    public void cancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
