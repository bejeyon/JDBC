package main;

import java.net.URL;
import java.util.ResourceBundle;

import data_model.KioskDAO;
import data_model.KioskDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MemberController implements Initializable {
	
	@FXML private Label memberlist;
	@FXML private TextField name;
	@FXML private TextField phonenumber;
	@FXML private Button savepoint;
	@FXML private Button viewpoint;
	
	public void handleSavepointAction(ActionEvent event) {
		String guest_name = name.getText();
		String guest_phone = phonenumber.getText();
		
		KioskDAO kioskDAO = new KioskDAO();
		KioskDTO setMemberDTO = new KioskDTO(guest_name, guest_phone);
		
		if(!(kioskDAO.memberFindOne(guest_phone))) {
			kioskDAO.setMember(setMemberDTO);
		}
	}
	
	public void handleViewpointAction(ActionEvent event) {
		String guest_name = name.getText();
		String guest_phone = phonenumber.getText();
		
		KioskDAO kioskDAO = new KioskDAO();
		KioskDTO viewMemberDTO = new KioskDTO(guest_name, guest_phone);
		
		String point = kioskDAO.viewPoint(viewMemberDTO);
		
		memberlist.setText(point);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
