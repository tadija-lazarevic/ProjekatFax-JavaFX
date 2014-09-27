/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketball;

import base.CoachBase;
import base.PlayerBase;
import basketball.CoreAppFXMLController.Player;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author tadija
 */
public class SetPositionController implements Initializable {

    @FXML
    private TableView positionTable;
    @FXML
    private TableColumn<Player, Integer> playerNumberCol;
    @FXML
    private TableColumn<Player, String> playerNameCol;
    @FXML
    private TableColumn<Player, String> playerLNCol;
    @FXML
    private Button chooseBtn;
    @FXML
    private Button cancelBtn;

    private ObservableList<Player> playerData;
    private Connection conn = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        playerNumberCol
                .setCellValueFactory(new PropertyValueFactory<Player, Integer>(
                                "number"));

        playerNameCol
                .setCellValueFactory(new PropertyValueFactory<Player, String>(
                                "name"));
        playerLNCol
                .setCellValueFactory(new PropertyValueFactory<Player, String>(
                                "lastName"));

        playerData = FXCollections.observableArrayList();
        positionTable.setItems(playerData);
        positionTable.setEditable(false);
        PlayerBase.get();
        loadPlayerData();

    }

    public void loadPlayerData() {
        try {
            ResultSet rs = PlayerBase.query("SELECT * FROM PlayerTable");
            playerData.clear();
            while (rs.next()) {
                playerData.add(new CoreAppFXMLController.Player(rs.getInt("id"), rs.getString("Name"), rs.getString("Lastname"), rs.getInt("Number")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chooseAction(ActionEvent event) throws SQLException {
        String sql = ("INSERT INTO `PlayerTable`(`Name`, `Lastname`, `Number`, `Points`, `Assists`, `Rebounds`) VALUES (?,?,?,?,?,?)");
        PreparedStatement ps = PlayerBase.get().prepareStatement(sql);

    }

    public void cancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
