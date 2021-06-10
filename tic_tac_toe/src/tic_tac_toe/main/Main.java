package tic_tac_toe.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage; 
	private final String ROOT_XML_PATH = "/tic_tac_toe/view/BoardGUI.fxml"; 
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage; 
		this.primaryStage.setTitle("Game Board Mockup"); 
		loadXML(); 
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void loadXML() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(ROOT_XML_PATH));
			primaryStage.setScene(new Scene(root));
			primaryStage.show(); 
		} catch (IOException e) {
			System.out.println(e.toString()); 
		} 
		
	}
}
