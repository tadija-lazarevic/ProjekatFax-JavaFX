package basketball;

import base.PlayerBase;
import basketball.CoreAppFXMLController.Player;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowStatisticsController implements Initializable {

    //tabela za poene i kolone za ime i prezime
    @FXML
    private TableView pointsTable;
    @FXML
    private TableColumn<Player, String> pointsNameCol;
    @FXML
    private TableColumn<Player, String> pointsLNCol;

    private ObservableList<Player> pointsData;

    //tabela za asistencije i kolona za ime i prezime
    @FXML
    private TableView assistsTable;
    @FXML
    private TableColumn<Player, String> assistsNameCol;
    @FXML
    private TableColumn<Player, String> assistsLNCol;
    private ObservableList<Player> assistsData;

    //tabela za skokove i kolone za ime i prezime
    @FXML
    private TableView reboundsTable;
    @FXML
    private TableColumn<Player, String> reboundsNameCol;
    @FXML
    private TableColumn<Player, String> reboundsLNCol;
    private ObservableList<Player> reboundsData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PlayerBase.get();
        showPoints();
        showAssists();
        showRebounds();

    }

    //tabela za poene
    public void showPoints() {
        pointsNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        pointsLNCol.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));

        pointsData = FXCollections.observableArrayList();
        pointsTable.setItems(pointsData);
        pointsTable.setEditable(false);

        try {
            ResultSet rs = PlayerBase.query("SELECT * FROM  PlayerTable ORDER BY Points DESC");
            pointsData.clear();
            while (rs.next()) {
                pointsData.add(new Player(null, rs.getString("Name"), rs.getString("Lastname")));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    //tabela za asistencije
    public void showAssists() {
        assistsNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        assistsLNCol.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));

        assistsData = FXCollections.observableArrayList();
        assistsTable.setItems(assistsData);
        assistsTable.setEditable(false);

        try {
            ResultSet rs = PlayerBase.query("SELECT * FROM PlayerTable ORDER BY Assists DESC");
            assistsData.clear();
            while (rs.next()) {
                assistsData.add(new Player(null, rs.getString("Name"), rs.getString("Lastname")));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    //tabela za skokove
    public void showRebounds() {
        reboundsNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        reboundsLNCol.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));

        reboundsData = FXCollections.observableArrayList();
        reboundsTable.setItems(pointsData);
        reboundsTable.setEditable(false);

        try {
            ResultSet rs = PlayerBase.query("SELECT * FROM PlayerTable ORDER BY Rebounds DESC");
            reboundsData.clear();
            while (rs.next()) {
                reboundsData.add(new Player(null, rs.getString("Name"), rs.getString("Lastname")));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }

}
