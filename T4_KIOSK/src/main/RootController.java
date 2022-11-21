package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import data_model.KioskDAO;
import data_model.KioskDTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@FXML private TextField americano;
	@FXML private TextField cafelatte;
	@FXML private TextField espresso;
	@FXML private TextField milk;
	@FXML private TextField bread;
	@FXML private TextField cake;
	@FXML private TextField cookie;
	@FXML private TextField macaroon;
	@FXML private TextField icetea;
	@FXML private TextField chocolatelatte;
	@FXML private Label orderlist;
	@FXML private Button order;
	@FXML private Button exit;
	@FXML private TextField name;
	@FXML private TextField phonenumber;
	@FXML private Button savepoint;
	@FXML private Button viewpoint;
	static int total = 0;
	
	public void handleOrderAction(ActionEvent event) {
		int americanoCnt = Integer.parseInt(americano.getText());
		System.out.println("아메리카노 주문 개수 : " + americanoCnt);
		int cafelatteCnt = Integer.parseInt(cafelatte.getText());
		System.out.println("카페라떼 주문 개수 : " + cafelatteCnt);
		int espressoCnt = Integer.parseInt(espresso.getText());
		System.out.println("에스프레소 주문 개수 : " + espressoCnt);
		int milkCnt = Integer.parseInt(milk.getText());
		System.out.println("우유 주문 개수 : " + milkCnt);
		int breadCnt = Integer.parseInt(bread.getText());
		System.out.println("모닝빵 주문 개수 : " + breadCnt);
		int cakeCnt = Integer.parseInt(cake.getText());
		System.out.println("조각케잌 주문 개수 : " + cakeCnt);
		int cookieCnt = Integer.parseInt(cookie.getText());
		System.out.println("쿠키 주문 개수 : " + cookieCnt);
		int macaroonCnt = Integer.parseInt(macaroon.getText());
		System.out.println("마카롱 주문 개수 : " + macaroonCnt);
		int iceteaCnt = Integer.parseInt(icetea.getText());
		System.out.println("아이스티 주문 개수 : " + iceteaCnt);
		int chocolatelatteCnt = Integer.parseInt(chocolatelatte.getText());
		System.out.println("아메리카노 주문 개수 : " + chocolatelatteCnt);
		total = (int) (0.01*(4000*americanoCnt + 5000*cafelatteCnt + 6000*espressoCnt + 3000*milkCnt + 2000*breadCnt + 6000*cakeCnt + 4000*cookieCnt + 2500*macaroonCnt + 6000*iceteaCnt + 6000*chocolatelatteCnt));
		
		KioskDAO kioskDAO = new KioskDAO();
		
		ArrayList<KioskDTO> kioskArrayList = new ArrayList<KioskDTO>();
		ArrayList<KioskDTO> stockArrayList = new ArrayList<KioskDTO>();
		
		if (americanoCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("101", "101", "아메리카노", 4000, americanoCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(2*americanoCnt, 201);
			stockArrayList.add(newStockDTO);
		}
		if (cafelatteCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("102", "102", "카페라떼", 5000, cafelatteCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO01 = new KioskDTO(1*cafelatteCnt, 201);
			KioskDTO newStockDTO02 = new KioskDTO(1*cafelatteCnt, 202);
			stockArrayList.add(newStockDTO01);
			stockArrayList.add(newStockDTO02);
		}
		if (espressoCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("103", "103", "에스프레소", 6000, espressoCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*espressoCnt, 201);
			stockArrayList.add(newStockDTO);
		}
		if (milkCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("104", "104", "우유", 3000, milkCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*milkCnt, 202);
			stockArrayList.add(newStockDTO);
		}
		if (breadCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("105", "105", "모닝빵", 2000, breadCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*breadCnt, 203);
			stockArrayList.add(newStockDTO);
		}
		if (cakeCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("106", "106", "조각케잌", 6000, cakeCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*cakeCnt, 204);
			stockArrayList.add(newStockDTO);
		}
		if (cookieCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("107", "107", "쿠키", 4000, cookieCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*cookieCnt, 205);
			stockArrayList.add(newStockDTO);
		}
		if (macaroonCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("108", "108", "마카롱", 2500, macaroonCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*macaroonCnt, 206);
			stockArrayList.add(newStockDTO);
		}
		if (iceteaCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("109", "109", "아이스티", 6000, iceteaCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO = new KioskDTO(1*iceteaCnt, 208);
			stockArrayList.add(newStockDTO);
		}
		if (chocolatelatteCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("110", "110", "초코라떼", 6000, chocolatelatteCnt);
			kioskArrayList.add(newOrderDTO);
			KioskDTO newStockDTO01 = new KioskDTO(1*chocolatelatteCnt, 202);
			KioskDTO newStockDTO02 = new KioskDTO(1*chocolatelatteCnt, 207);
			stockArrayList.add(newStockDTO01);
			stockArrayList.add(newStockDTO02);
		}
		
		for(int i = 0; i < kioskArrayList.size(); i++) {
			kioskDAO.orderInsert(kioskArrayList.get(i));
			kioskDAO.setSettlement(kioskArrayList.get(i));
		}
		for(int i = 0; i < stockArrayList.size(); i++) {
			kioskDAO.setStock(stockArrayList.get(i));
		}
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				orderlist.setText("아메리카노\t4,000원 X " + americanoCnt + "개 = " + 4000*americanoCnt + "원\n"
						+ "카페라떼\t5,000원 X " + cafelatteCnt + "개 = " + 5000*cafelatteCnt + "원\n"
						+ "에스프레소\t6,000원 X " + espressoCnt + "개 = " + 6000*espressoCnt + "원\n"
						+ "우유\t\t3,000원 X " + milkCnt + "개 = " + 3000*milkCnt + "원\n"
						+ "모닝빵\t2,000원 X " + breadCnt + "개 = " + 2000*breadCnt + "원\n"
						+ "조각케잌\t6,000원 X " + cakeCnt + "개 = " + 6000*cakeCnt + "원\n"
						+ "쿠키\t\t4,000원 X " + cookieCnt + "개 = " + 4000*cookieCnt + "원\n"
						+ "마카롱\t2,500원 X " + macaroonCnt + "개 = " + 2500*macaroonCnt + "원\n"
						+ "아이스티\t6,000원 X " + iceteaCnt + "개 = " + 6000*iceteaCnt + "원\n"
						+ "초코라떼\t6,000원 X " + chocolatelatteCnt + "개 = " + 6000*chocolatelatteCnt + "원\n"
						+ "총계 = " + (4000*americanoCnt + 5000*cafelatteCnt + 6000*espressoCnt + 3000*milkCnt + 2000*breadCnt + 6000*cakeCnt + 4000*cookieCnt + 2500*macaroonCnt + 6000*iceteaCnt + 6000*chocolatelatteCnt) + "원\n");
			}
			
		});
	}
	
	public void handleExitAction(ActionEvent event) {
		Platform.exit();
	}
	
	public void handleSavepointAction(ActionEvent event) {
		String guest_name = name.getText();
		String guest_phone = phonenumber.getText();
		
		KioskDAO kioskDAO = new KioskDAO();
		KioskDTO setMemberDTO = new KioskDTO(guest_name, guest_phone);
		
		if(!(kioskDAO.memberFindOne(guest_phone))) {
			kioskDAO.setMember(setMemberDTO);
		}

		int point = total;
		KioskDTO savePointDTO = new KioskDTO(guest_phone, point);
		kioskDAO.savePoint(savePointDTO);
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if(point > 0) {
					orderlist.setText(guest_name + "님,\n멤버십 포인트 " + point + "원 적립되었습니다.");
					total = 0;
				}
				else {
					orderlist.setText("주문을 먼저 해주세요.");
					total = 0;
				}
			}
		});
	}

	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void handleViewpointAction(ActionEvent event) throws Exception {

		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("멤버십 포인트");
		
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane)FXMLLoader.load(getClass().getResource("Membership.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(anchorPane);
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
