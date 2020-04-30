package calc;
/*
 * Projekt kalkulator przy u¿yciu JDK 11 i JavaFX 11
 * @autor: Jakub Kie¿un / kiezunjakub@gmail.com
 * @version 1.0
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calc extends Application {

	/*
	 * Method that prepares the whole GUI
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/calc/FXMLScene.fxml"));
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add("/calc/stylesheet.css");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setTitle("Calculator");
		stage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}