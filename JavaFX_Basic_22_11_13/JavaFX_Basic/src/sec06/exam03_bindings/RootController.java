package sec06.exam03_bindings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RootController implements Initializable {
	@FXML private AnchorPane root;
	@FXML private Circle circle;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//circle 중심 centerX 속성 
		circle.centerXProperty().bind(
				//루트 컨테이너의 속성에 바인딩 나누기 2
				Bindings.divide(root.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));	
	}//end initialize
}//end class
