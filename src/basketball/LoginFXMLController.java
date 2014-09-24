package basketball;

import base.UserBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.PreparedStatement;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tadija
 * @author lazarevic.tadija@gmail.com
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private Button okBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Label infoPassword;
    @FXML
    private TextField nameFld;
    @FXML
    private PasswordField passwordFld;
    

    private Connection conn = null;
    private ResultSet rs = null;
    private java.sql.PreparedStatement ps = null;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        conn = UserBase.get();
       
    }

    // Akcija za ok dugme u login formi
    public void okBtnAction(ActionEvent event) throws SQLException, IOException {
        String userName = nameFld.getText().trim();
        String password = passwordFld.getText().trim();

        String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Parent root = FXMLLoader.load(getClass().getResource(
                        "CoreAppFXML.fxml"));
                Stage core = new Stage();
                core.setScene(new Scene(root));
                core.setTitle("Core");
                core.show();

                Stage login = (Stage) exitBtn.getScene().getWindow();
                login.close();
            } else {
                wrongInputFXML();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void wrongInputFXML() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(
                "WrongUsernameFXML.fxml"));
        Stage errorStage = new Stage();
        errorStage.setScene(new Scene(root));
        errorStage.setTitle("Error");
        errorStage.centerOnScreen();
        errorStage.show();
    }

    // Akcija za exit dugme u login formi
    public void exitBtnAction(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
    

}
