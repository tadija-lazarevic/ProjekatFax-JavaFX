/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketball;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author tadija
 */
public class PositionController implements Initializable {

    @FXML
    private Button positionOne;
    @FXML
    private Button positionTwo;
    @FXML
    private Button positionThree;
    @FXML
    private Button positionFour;
    @FXML
    private Button positionFive;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void chooseAction(ActionEvent event) {

    }

}
