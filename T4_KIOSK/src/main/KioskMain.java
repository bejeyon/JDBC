package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KioskMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("T4 cafe Kiosk");
		primaryStage.setScene(scene);
		primaryStage.show();	// 윈도우 보여주기
		
	}
	
	public static void main(String[] args) {

		launch(args);	// KioskMain 객체 생성 및 메인 윈도우 생성

	}

}
