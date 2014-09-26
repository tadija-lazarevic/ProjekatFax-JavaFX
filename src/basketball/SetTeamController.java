/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketball;

import base.TeamBase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author tadija
 */
public class SetTeamController implements Initializable {

    @FXML
    private TableView teamsTable;
    @FXML
    private Button chooseBtn;
    @FXML
    private Button cancelBtn;
    private ObservableList<Teams> teamsData;
    private Connection conn = null;
    @FXML
    private AnchorPane TeamPane;
    // Kolone za tim
    @FXML
    private TableColumn<Teams, String> teamsNameCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        teamsNameCol
                .setCellValueFactory(new PropertyValueFactory<Teams, String>(
                                "name"));

        teamsData = FXCollections.observableArrayList();
        teamsTable.setItems(teamsData);
        teamsTable.setEditable(false);
        TeamBase.get();
        loadTeamData();
    }

    public void loadTeamData() {
        try {
            ResultSet rs = TeamBase.query("SELECT * FROM TeamTable");
            teamsData.clear();
            while (rs.next()) {
                teamsData.add(new Teams(null, rs.getString("Name"), rs.getString("From"), rs.getInt("Points")));
            }
        } catch (Exception e) {
        }
    }

    public void chooseAction(ActionEvent event) {
        String name = null;

    }

    public void cancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
