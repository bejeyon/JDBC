package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class SampleMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public static void main(String args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SW Test Academy - Sample JavaFX App");
		initRootLayout();    // Initialize RootLayout
		showEmployeeView();  // Display the EmployeeOperations View
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showEmployeeView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/EmployeeView.fxml"));
			AnchorPane employeeOperationsView = (AnchorPane) loader.load();
			rootLayout.setCenter(employeeOperationsView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}










