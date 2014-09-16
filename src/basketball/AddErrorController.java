package basketball;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddErrorController implements Initializable {

	@FXML
	private Button okBtn;


	public void okBtnAction(ActionEvent event) {
		Stage errorStage = (Stage) okBtn.getScene().getWindow();
		errorStage.close();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
