/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basketball;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author tadija
 * @author lazarevic.tadija@gmail.com
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root;
		root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
		Scene scene = new Scene(root, 450, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
