package basketball;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WrongUsernameFXMLController implements Initializable {

	@FXML
	private Button okBtn;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void okBtnAction(ActionEvent event) {
		Stage stage = (Stage) okBtn.getScene().getWindow();
		stage.close();
	}

}
