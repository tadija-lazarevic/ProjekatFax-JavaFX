package basketball;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import base.CoachBase;
import base.PlayerBase;
import base.TeamBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tadija
 * @author lazarevic.tadija@gmail.com
 */
public class CoreAppFXMLController implements Initializable {

    // Input za igrace
    @FXML
    private TextField playerNameFld;
    @FXML
    private TextField playerLNFld;
    @FXML
    private TextField playerNumberFld;
    @FXML
    private TextField playerPointsFld;
    @FXML
    private TextField playerAssistsFld;
    @FXML
    private TextField playerReboundsFld;
    // Input za trenera
    @FXML
    private TextField coachesNameFld;
    @FXML
    private TextField coachesLNFld;
    @FXML
    private TextField coachesAgeFld;
    // Input za tim
    @FXML
    private TextField teamNameFld;
    @FXML
    private TextField teamFromFld;
    @FXML
    private TextField teamPointsFld;

    // Kolone za igrace
    @FXML
    private TableColumn<Player, String> playerNameCol;
    @FXML
    private TableColumn<Player, String> playerLNCol;
    @FXML
    private TableColumn<Player, Integer> playerNumberCol;
    @FXML
    private TableColumn<Player, Integer> playerPointsCol;
    @FXML
    private TableColumn<Player, Integer> playerAssitsCol;
    @FXML
    private TableColumn<Player, Integer> playerReboundsCol;
    // Kolone za trenera
    @FXML
    private TableColumn<Coaches, String> coachesNameCol;
    @FXML
    private TableColumn<Coaches, String> coachesLNCol;
    @FXML
    private TableColumn<Coaches, Integer> coachesAgeCol;
    // Kolone za tim
    @FXML
    private TableColumn<Teams, String> teamsNameCol;
    @FXML
    private TableColumn<Teams, String> teamsFromCol;
    @FXML
    private TableColumn<Teams, String> teamsPointsCol;

    // Tabele za igrace
    @FXML
    private TableView<Player> playerTable;
    // Tabela za trenera
    @FXML
    private TableView<Coaches> coachesTable;
    // Tabela za tim
    @FXML
    private TableView<Teams> teamsTable;

    // Liste za igrace trenere i timove
    private ObservableList<Player> playerData;

    private ObservableList<Coaches> coachesData;

    private ObservableList<Teams> teamsData;

    // Validacione slike za igraca
    @FXML
    private ImageView playerNameImg, playerLNImg, playerNumberImg,
            playerPointsImg, playerAssistsImg, playerReboundsImg;
    @FXML
    // Validacione slike za trenera
    private ImageView coachNameImg, coachLastnameImg, coachAgeImg;

    // Validacione slike za tim
    @FXML
    private ImageView teamNameImg, teamFromImg, teamPointsImg;

    @FXML
    private final Image okImg = new Image(getClass().getResourceAsStream(
            "/images/okImg.png"));
    @FXML
    private final Image errorImg = new Image(getClass().getResourceAsStream(
            "/images/errorImg.png"));

    // Igraci na terenu
    @FXML
    private javafx.scene.control.Button playerOneBtn;
    @FXML
    private javafx.scene.control.Button playerTwoBtn;
    @FXML
    private javafx.scene.control.Button playerThreeBtn;
    @FXML
    private javafx.scene.control.Button playerFourBtn;
    @FXML
    private javafx.scene.control.Button playerFiveBtn;
    // Izbor trenera i tima
    @FXML
    public javafx.scene.control.Button teamBtn;
    @FXML
    public javafx.scene.control.Button coachBtn;

    // Klasa igrac
    public static class Player {

        private SimpleIntegerProperty id = new SimpleIntegerProperty();
        private SimpleStringProperty name = new SimpleStringProperty();
        private SimpleStringProperty lastName = new SimpleStringProperty();
        private SimpleIntegerProperty number = new SimpleIntegerProperty();
        private SimpleIntegerProperty points = new SimpleIntegerProperty();
        private SimpleIntegerProperty assists = new SimpleIntegerProperty();
        private SimpleIntegerProperty rebounds = new SimpleIntegerProperty();

        public Player(Integer id, String name, String lastName, Integer number,
                Integer points, Integer assists, Integer rebounds, Integer position) {
            this.name.setValue(name);
            this.lastName.setValue(lastName);
            this.number.setValue(number);
            this.points.setValue(points);
            this.assists.setValue(assists);
            this.rebounds.setValue(rebounds);

        }

        public Player(Integer id, String name, String lastname, Integer number) {
            this.name.setValue(name);
            this.lastName.setValue(lastname);
            this.number.setValue(number);
        }

        public Player(Integer id, String name, String lastname) {
            this.name.setValue(name);
            this.lastName.setValue(lastname);
        }

        public Integer getId() {
            if (id == null) {
                return 0;
            }
            return id.getValue();
        }

        public String getName() {
            if (name != null) {
                return "";
            }
            return name.getValueSafe();
        }

        public String getlastName() {
            if (lastName != null) {
                return "";
            }
            return lastName.getValueSafe();
        }

        public Integer getNumber() {
            if (number == null) {
                return 0;
            }
            return number.getValue();
        }

        public Integer getPoints() {
            if (points == null) {
                return 0;
            }
            return points.getValue();
        }

        public Integer getAssists() {
            if (assists == null) {
                return 0;
            }
            return assists.getValue();
        }

        public Integer getRebounds() {
            if (rebounds == null) {
                return 0;
            }
            return rebounds.getValue();
        }

        public SimpleIntegerProperty IdProperty() {
            return id;
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public SimpleStringProperty lastNameProperty() {
            return lastName;
        }

        public SimpleIntegerProperty numberProperty() {
            return number;
        }

        public SimpleIntegerProperty pointsProperty() {
            return points;
        }

        public SimpleIntegerProperty assitsProperty() {
            return assists;
        }

        public SimpleIntegerProperty reboundsProperty() {
            return rebounds;
        }

    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

        playerNameCol
                .setCellValueFactory(new PropertyValueFactory<Player, String>(
                                "name"));
        playerLNCol
                .setCellValueFactory(new PropertyValueFactory<Player, String>(
                                "lastName"));
        playerNumberCol
                .setCellValueFactory(new PropertyValueFactory<Player, Integer>(
                                "number"));
        playerPointsCol
                .setCellValueFactory(new PropertyValueFactory<Player, Integer>(
                                "points"));
        playerAssitsCol
                .setCellValueFactory(new PropertyValueFactory<Player, Integer>(
                                "assists"));
        playerReboundsCol
                .setCellValueFactory(new PropertyValueFactory<Player, Integer>(
                                "rebounds"));
        coachesNameCol
                .setCellValueFactory(new PropertyValueFactory<Coaches, String>(
                                "name"));
        coachesLNCol
                .setCellValueFactory(new PropertyValueFactory<Coaches, String>(
                                "lastName"));
        coachesAgeCol
                .setCellValueFactory(new PropertyValueFactory<Coaches, Integer>(
                                "age"));
        teamsNameCol
                .setCellValueFactory(new PropertyValueFactory<Teams, String>(
                                "name"));
        teamsFromCol
                .setCellValueFactory(new PropertyValueFactory<Teams, String>(
                                "from"));
        teamsPointsCol
                .setCellValueFactory(new PropertyValueFactory<Teams, String>(
                                "points"));
        //Igrac
        playerData = FXCollections.observableArrayList();
        playerTable.setItems(playerData);
        playerTable.setEditable(false);
        PlayerBase.get();
        loadPlayerData();
        //Trener
        coachesData = FXCollections.observableArrayList();
        coachesTable.setItems(coachesData);
        coachesTable.setEditable(false);
        CoachBase.get();
        loadCoachData();
        //Tim
        teamsData = FXCollections.observableArrayList();
        teamsTable.setItems(teamsData);
        teamsTable.setEditable(false);
        TeamBase.get();
        loadTeamData();

    }

    // Akcije za igraca
    int playerRound = 0;

    public void addPlayersAction(ActionEvent event) throws IOException,
            SQLException {
        //Validacija inputa
        boolean uspesno = true;
        //boolean validacija za svako polje

        //ovde ne moze playerRound = 0;
        //Query za upisivanje u Player bazu
        String sql = ("INSERT INTO `PlayerTable`(`Name`, `Lastname`, `Number`, `Points`, `Assists`, `Rebounds`) VALUES (?,?,?,?,?,?)");
        PreparedStatement ps = PlayerBase.get().prepareStatement(sql);

        String name = playerNameFld.getText();
        if ((name == null) || (name.trim().equals(""))) { //greska
            playerNameImg.setImage(errorImg);
            uspesno = false;
        } else { //prolaz
            if (playerRound > 0) {
                playerNameImg.setImage(okImg);
            }
            ps.setString(1, name);
        }

        String lastName = playerLNFld.getText();
        if ((lastName == null) || (lastName.trim().equals(""))) {
            playerLNImg.setImage(errorImg);
            uspesno = false;
        } else {
            if (playerRound > 0) {
                playerLNImg.setImage(okImg);
            }
            ps.setString(2, lastName);
        }

        Integer playerNumber = null;
        try {
            playerNumber = Integer.parseInt(playerNumberFld.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (playerNumber == null) {
            uspesno = false;
            playerNumberImg.setImage(errorImg);
        } else {
            if (playerRound > 0) {
                playerNumberImg.setImage(okImg);
            }
            ps.setInt(3, playerNumber);
        }

        Integer points = null;
        try {
            points = Integer.parseInt(playerPointsFld.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (points == null) {
            uspesno = false;
            playerPointsImg.setImage(errorImg);
        } else {
            if (playerRound > 0) {
                playerPointsImg.setImage(okImg);
            }
            ps.setInt(4, points);
        }

        Integer assists = null;

        try {
            assists = Integer.parseInt(playerAssistsFld.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (assists == null) {
            uspesno = false;
            playerAssistsImg.setImage(errorImg);
        } else {
            if (playerRound > 0) {
                playerAssistsImg.setImage(okImg);
            }
            ps.setInt(5, assists);
        }

        Integer playerRebounds = null;
        try {
            playerRebounds = Integer.parseInt(playerReboundsFld.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (playerRebounds == null) {
            uspesno = false;
            playerReboundsImg.setImage(errorImg);
        } else {
            if (playerRound > 0) {
                playerReboundsImg.setImage(okImg);
            }
            ps.setInt(6, playerRebounds);
        }
        if (uspesno) {
            playerData.add(new Player(null, playerNameFld.getText(),
                    playerLNFld.getText(),
                    Integer.parseInt(playerNumberFld.getText()),
                    Integer.parseInt(playerPointsFld.getText()),
                    Integer.parseInt(playerAssistsFld.getText()),
                    Integer.parseInt(playerReboundsFld.getText()), null));
            ps.execute();
            playerNameFld.clear();
            playerLNFld.clear();
            playerNumberFld.clear();
            playerPointsFld.clear();
            playerAssistsFld.clear();
            playerReboundsFld.clear();
            playerRound++;
            //tred za brisanje validacionih slika
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {

                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            playerNameImg.setImage(null);
                            playerLNImg.setImage(null);
                            playerNumberImg.setImage(null);
                            playerPointsImg.setImage(null);
                            playerAssistsImg.setImage(null);
                            playerReboundsImg.setImage(null);
                        }
                    });

                }
            });
            t.start();

        } else {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "AddErrorFXML.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Error");
            stage.show();
        }

    }

    public void deletePlayersAction(ActionEvent event) throws IOException {
        int selectedIndex = playerTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            playerData.remove(selectedIndex);
            //String sql = ("INSERT INTO `PlayerTable`(`Name`, `Lastname`, `Number`, `Points`, `Assists`, `Rebounds`) VALUES (?,?,?,?,?,?)");
            //PreparedStatement ps = PlayerBase.get().prepareStatement(sql);

        } else {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "DeleteItemFXML.fxml"));
            Stage itemError = new Stage();
            itemError.setScene(new Scene(root));
            itemError.setTitle("Error");
            itemError.show();
            itemError.centerOnScreen();
        }

    }

    // Akcije za trenera
    int coachRound = 0;

    public void addCoachesAction(ActionEvent event) throws IOException, SQLException {

        //Validacija unosa
        boolean uspesno = true;
        //Query za upisivanje u Coach bazu
        String sql = "INSERT INTO `CoachTable`(`Name`, `Lastname`, `Age`) VALUES (?,?,?)";
        PreparedStatement ps = CoachBase.get().prepareStatement(sql);

        //provera name
        String name = coachesNameFld.getText();
        if ((name == null) || (name.equals(""))) {
            coachNameImg.setImage(errorImg);
            uspesno = false;
        } else {
            if (coachRound > 0) {
                coachNameImg.setImage(okImg);
            }
            ps.setString(1, name);
        }

        //provera lastname
        String lastName = coachesLNFld.getText();
        if ((lastName == null) || (lastName.equals(""))) {
            coachLastnameImg.setImage(errorImg);
            uspesno = false;
        } else {
            if (coachRound > 0) {
                coachLastnameImg.setImage(okImg);
            }
            ps.setString(2, lastName);
        }
        //Proverava godine trenera
        try {
            int age = Integer.parseInt(coachesAgeFld.getText());
            if ((age < 20) || (age > 70)) {
                uspesno = false;
            } else {
                if (coachRound > 0) {
                    coachAgeImg.setImage(okImg);
                }
                ps.setString(3, coachesAgeFld.getText());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            coachAgeImg.setImage(errorImg);
        }

        //Ako je validacija uspesna
        if (uspesno) {
            coachesData.add(new Coaches(null, coachesNameFld.getText(), coachesLNFld
                    .getText(), Integer.parseInt(coachesAgeFld.getText())));
            coachesNameFld.clear();
            coachesLNFld.clear();
            coachesAgeFld.clear();
            ps.execute();

            //tred za brisanje validacionih slika
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {

                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            coachNameImg.setImage(null);
                            coachLastnameImg.setImage(null);
                            coachAgeImg.setImage(null);
                        }
                    });

                }
            });
            t.start();
            //Ako nije
        } else {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "AddErrorFXML.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Error");
            stage.show();
        }

    }

    public void deleteCoachesAction(ActionEvent event) throws IOException, SQLException {
        int selectedIndex = coachesTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            coachesData.remove(selectedIndex);
        } else {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "DeleteItemFXML.fxml"));
            Stage itemError = new Stage();
            itemError.setScene(new Scene(root));
            itemError.setTitle("Error");
            itemError.show();
            itemError.centerOnScreen();
        }
    }

    // Akcije za tim
    int teamRound = 0;

    public void addTeamsAction(ActionEvent event) throws IOException, SQLException {

        //Validacija inputa
        boolean uspesno = true;
        //Query za upisivanje u Team bazu
        String sql = "INSERT INTO `TeamTable`(`Name`, `From`, `Points`) VALUES (?,?,?)";
        PreparedStatement ps = TeamBase.get().prepareStatement(sql);

        //Proverava ime trenera
        String name = teamNameFld.getText();
        if ((name == null) || (name.equals(""))) {
            uspesno = false;
            teamNameImg.setImage(errorImg);
        } else {
            if (teamRound > 0) {
                teamNameImg.setImage(okImg);
            }
            ps.setString(1, name);
        }

        //Proverava grad tima
        String from = teamFromFld.getText();
        if ((from == null) || (from.equals(""))) {
            uspesno = false;
            teamFromImg.setImage(errorImg);
        } else {
            if (teamRound > 0) {
                teamFromImg.setImage(okImg);
            }
            ps.setString(2, from);
        }

        //Proverava poene tima
        try {
            Integer points = Integer.parseInt(teamPointsFld.getText());
            if ((points < 0) || (points > 150)) {
                uspesno = false;
            } else {
                if (teamRound > 0) {
                    teamPointsImg.setImage(okImg);
                }
                ps.setString(3, teamPointsFld.getText());
            }
        } catch (NumberFormatException e) {
            teamPointsImg.setImage(errorImg);

        }

        if (uspesno) {
            teamsData.add(new Teams(null, teamNameFld.getText(), teamFromFld
                    .getText(), Integer.parseInt(teamPointsFld.getText())));

            teamNameFld.clear();
            teamFromFld.clear();
            teamPointsFld.clear();
            ps.execute();
            teamRound++;

            //tred za brisanje validacionih slika
            //brise posle 2 sekunde
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {

                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            teamNameImg.setImage(null);
                            teamFromImg.setImage(null);
                            teamPointsImg.setImage(null);
                        }
                    });

                }
            });
            t.start();

        } else {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "AddErrorFXML.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Error");
            stage.show();
        }

    }

    public void deleteTeamsAction(ActionEvent event) throws IOException, SQLException {
        int selectedIndex = teamsTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            teamsData.remove(selectedIndex);
        } else {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "DeleteItemFXML.fxml"));
            Stage itemError = new Stage();
            itemError.setScene(new Scene(root));
            itemError.setTitle("Error");
            itemError.show();
            itemError.centerOnScreen();
        }
    }

    public void showStatisticsAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(
                "StatisticsFXML.fxml"));
        Stage statistics = new Stage();
        statistics.setScene(new Scene(root));
        statistics.setTitle("Statistics ");
        statistics.show();
        statistics.centerOnScreen();
        statistics.setWidth(800);
        statistics.setHeight(600);
        statistics.setResizable(false);
    }

    public void show1stTeamAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Set1stFive.fxml"));
        Stage five = new Stage();
        five.setScene(new Scene(root));
        five.setTitle("1st Five");
        five.centerOnScreen();
        five.setWidth(600);
        five.setHeight(400);
        five.setResizable(false);
        five.show();
    }

    public void setPosition(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource("SetPosition.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Set position");

    }

    public void setCoachAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(
                "SetCoachFXML.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Set coach");
        stage.show();
        stage.setResizable(false);

    }

    public void setTeamAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SetTeamFXML.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Set team");
        stage.show();
        stage.setResizable(false);

    }

    public void aboutAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AboutFXML.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("About");
        stage.show();
    }

    public void loadPlayerData() {
        try {
            ResultSet rs = PlayerBase.query("SELECT * FROM PlayerTable");
            playerData.clear();
            while (rs.next()) {
                playerData.add(new Player(rs.getInt("id"), rs.getString("Name"), rs.getString("Lastname"),
                        rs.getInt("Number"), rs.getInt("Points"), rs.getInt("Assists"), rs.getInt("Rebounds"), null));

            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void loadCoachData() {
        try {
            ResultSet rs = CoachBase.query("SELECT * FROM CoachTable");
            coachesData.clear();
            while (rs.next()) {
                coachesData.add(new Coaches(rs.getInt("Id"), rs.getString("Name"), rs.getString("Lastname"), rs.getInt("Age")));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void loadTeamData() {
        try {
            ResultSet rs = TeamBase.query("SELECT * FROM TeamTable");
            teamsData.clear();
            while (rs.next()) {
                teamsData.add(new Teams(rs.getInt("id"), rs.getString("Name"), rs.getString("From"), rs.getInt("Points")));
            }
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
}
