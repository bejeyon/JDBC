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
	@FXML private Label americanostock;
	@FXML private TextField americano;
	@FXML private Label cafelattestock;
	@FXML private TextField cafelatte;
	@FXML private Label espressostock;
	@FXML private TextField espresso;
	@FXML private Label milkstock;
	@FXML private TextField milk;
	@FXML private Label breadstock;
	@FXML private TextField bread;
	@FXML private Label cakestock;
	@FXML private TextField cake;
	@FXML private Label cookiestock;
	@FXML private TextField cookie;
	@FXML private Label macaroonstock;
	@FXML private TextField macaroon;
	@FXML private Label iceteastock;
	@FXML private TextField icetea;
	@FXML private Label chocolatelattestock;
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
		// 아메리카노 주문 수량 입력
		int cafelatteCnt = Integer.parseInt(cafelatte.getText());
		System.out.println("카페라떼 주문 개수 : " + cafelatteCnt);
		// 카페라떼 주문 수량 입력
		int espressoCnt = Integer.parseInt(espresso.getText());
		System.out.println("에스프레소 주문 개수 : " + espressoCnt);
		// 에스프레소 주문 수량 입력
		int milkCnt = Integer.parseInt(milk.getText());
		System.out.println("우유 주문 개수 : " + milkCnt);
		// 우유 주문 수량 입력
		int breadCnt = Integer.parseInt(bread.getText());
		System.out.println("모닝빵 주문 개수 : " + breadCnt);
		// 모닝빵 주문 수량 입력
		int cakeCnt = Integer.parseInt(cake.getText());
		System.out.println("조각케잌 주문 개수 : " + cakeCnt);
		// 조각케잌 주문 수량 입력
		int cookieCnt = Integer.parseInt(cookie.getText());
		System.out.println("쿠키 주문 개수 : " + cookieCnt);
		// 쿠키 주문 수량 입력
		int macaroonCnt = Integer.parseInt(macaroon.getText());
		System.out.println("마카롱 주문 개수 : " + macaroonCnt);
		// 마카롱 주문 수량 입력
		int iceteaCnt = Integer.parseInt(icetea.getText());
		System.out.println("아이스티 주문 개수 : " + iceteaCnt);
		// 아이스티 주문 수량 입력
		int chocolatelatteCnt = Integer.parseInt(chocolatelatte.getText());
		System.out.println("초코라떼 주문 개수 : " + chocolatelatteCnt);
		// 초코라떼 주문 수량 입력
		
		total = (int) (0.01*(4000*americanoCnt + 5000*cafelatteCnt + 6000*espressoCnt + 3000*milkCnt + 2000*breadCnt + 6000*cakeCnt + 4000*cookieCnt + 2500*macaroonCnt + 6000*iceteaCnt + 6000*chocolatelatteCnt));
		// 멤버십 포인트 적립 계산(1%)
		
		KioskDAO kioskDAO = new KioskDAO();
		// 새로운 객체 생성
		
		ArrayList<KioskDTO> kioskArrayList = new ArrayList<KioskDTO>();
		ArrayList<KioskDTO> stockArrayList = new ArrayList<KioskDTO>();
		
		KioskDTO checkAmericanoStockDTO = new KioskDTO(201);
		int americanoAvailable = kioskDAO.checkStock(checkAmericanoStockDTO)/2;
		
		if(americanoCnt > americanoAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("아메리카노 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkCafelatteStockDTO01 = new KioskDTO(201);
		KioskDTO checkCafelatteStockDTO02 = new KioskDTO(202);

		int cafelatteAvailable01 = kioskDAO.checkStock(checkCafelatteStockDTO01)-americanoCnt/2;
		int cafelatteAvailable02 = kioskDAO.checkStock(checkCafelatteStockDTO02);
		int cafelatteAvailable = cafelatteAvailable01 < cafelatteAvailable02 ? cafelatteAvailable01 : cafelatteAvailable02;

		if(cafelatteCnt > cafelatteAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("카페라떼 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkEspressoStockDTO = new KioskDTO(201);
		int espressoAvailable = kioskDAO.checkStock(checkEspressoStockDTO);
		
		if(espressoCnt > espressoAvailable-americanoCnt/2-cafelatteCnt) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("에스프레소 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkMilkStockDTO = new KioskDTO(202);
		int milkAvailable = kioskDAO.checkStock(checkMilkStockDTO);
		
		if(milkCnt > milkAvailable-cafelatteCnt) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("우유 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkBreadStockDTO = new KioskDTO(203);
		int breadAvailable = kioskDAO.checkStock(checkBreadStockDTO);
		
		if(breadCnt > breadAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("모닝빵 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkCakeStockDTO = new KioskDTO(204);
		int cakeAvailable = kioskDAO.checkStock(checkCakeStockDTO);
		
		if(cakeCnt > cakeAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("조각케잌 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkCookieStockDTO = new KioskDTO(205);
		int cookieAvailable = kioskDAO.checkStock(checkCookieStockDTO);
		
		if(cookieCnt > cookieAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("쿠키 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkMacaroonStockDTO = new KioskDTO(206);
		int macaroonAvailable = kioskDAO.checkStock(checkMacaroonStockDTO);
		
		if(macaroonCnt > macaroonAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("마카롱 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkIceteaStockDTO = new KioskDTO(206);
		int iceteaAvailable = kioskDAO.checkStock(checkIceteaStockDTO);
		
		if(iceteaCnt > iceteaAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("아이스티 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		KioskDTO checkChocolatelatteStockDTO01 = new KioskDTO(202);
		KioskDTO checkChocolatelatteStockDTO02 = new KioskDTO(207);

		int chocolatelatteAvailable01 = kioskDAO.checkStock(checkChocolatelatteStockDTO01)-cafelatteCnt-milkCnt;
		int chocolatelatteAvailable02 = kioskDAO.checkStock(checkChocolatelatteStockDTO02);
		int chocolatelatteAvailable = chocolatelatteAvailable01 < chocolatelatteAvailable02 ? chocolatelatteAvailable01 : chocolatelatteAvailable02;

		if(chocolatelatteCnt > chocolatelatteAvailable) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					orderlist.setText("초코라떼 원료 재고가 부족합니다.");
				}
				
			});
			return;
		}
		
		if (americanoCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("101", "101", "아메리카노", 4000, americanoCnt);
			kioskArrayList.add(newOrderDTO);
			// 아메리카노 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(2*americanoCnt, 201);
			stockArrayList.add(newStockDTO);
			// 아메리카노 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (cafelatteCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("102", "102", "카페라떼", 5000, cafelatteCnt);
			kioskArrayList.add(newOrderDTO);
			// 카페라떼 주문 내역 입력
			KioskDTO newStockDTO01 = new KioskDTO(1*cafelatteCnt, 201);
			KioskDTO newStockDTO02 = new KioskDTO(1*cafelatteCnt, 202);
			stockArrayList.add(newStockDTO01);
			stockArrayList.add(newStockDTO02);
			// 카페라떼 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (espressoCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("103", "103", "에스프레소", 6000, espressoCnt);
			kioskArrayList.add(newOrderDTO);
			// 에스프레소 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*espressoCnt, 201);
			stockArrayList.add(newStockDTO);
			// 에스프레소 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (milkCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("104", "104", "우유", 3000, milkCnt);
			kioskArrayList.add(newOrderDTO);
			// 우유 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*milkCnt, 202);
			stockArrayList.add(newStockDTO);
			// 우유 재고 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (breadCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("105", "105", "모닝빵", 2000, breadCnt);
			kioskArrayList.add(newOrderDTO);
			// 모닝빵 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*breadCnt, 203);
			stockArrayList.add(newStockDTO);
			// 모닝빵 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (cakeCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("106", "106", "조각케잌", 6000, cakeCnt);
			kioskArrayList.add(newOrderDTO);
			// 조각케잌 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*cakeCnt, 204);
			stockArrayList.add(newStockDTO);
			// 조각케잌 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (cookieCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("107", "107", "쿠키", 4000, cookieCnt);
			kioskArrayList.add(newOrderDTO);
			// 쿠키 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*cookieCnt, 205);
			stockArrayList.add(newStockDTO);
			// 쿠키 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (macaroonCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("108", "108", "마카롱", 2500, macaroonCnt);
			kioskArrayList.add(newOrderDTO);
			// 마카롱 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*macaroonCnt, 206);
			stockArrayList.add(newStockDTO);
			// 마카롱 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (iceteaCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("109", "109", "아이스티", 6000, iceteaCnt);
			kioskArrayList.add(newOrderDTO);
			// 아이스티 주문 내역 입력
			KioskDTO newStockDTO = new KioskDTO(1*iceteaCnt, 208);
			stockArrayList.add(newStockDTO);
			// 아이스티 재고 수량 수정 (사용량 만큼 재고에서 차감)
		}
		if (chocolatelatteCnt > 0) {
			KioskDTO newOrderDTO = new KioskDTO("110", "110", "초코라떼", 6000, chocolatelatteCnt);
			kioskArrayList.add(newOrderDTO);
			// 초코라떼 주문 내역 입력
			KioskDTO newStockDTO01 = new KioskDTO(1*chocolatelatteCnt, 202);
			KioskDTO newStockDTO02 = new KioskDTO(1*chocolatelatteCnt, 207);
			stockArrayList.add(newStockDTO01);
			stockArrayList.add(newStockDTO02);
			// 초코라떼 재고 수량 수정 (사용량 만큼 재고에서 차감)
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
				orderlist.setText("아메리카노\t 4,000원 X " + americanoCnt + "개 = " + 4000*americanoCnt + "원\n"
						+ "카페라떼\t 5,000원 X " + cafelatteCnt + "개 = " + 5000*cafelatteCnt + "원\n"
						+ "에스프레소\t 6,000원 X " + espressoCnt + "개 = " + 6000*espressoCnt + "원\n"
						+ "우유\t\t 3,000원 X " + milkCnt + "개 = " + 3000*milkCnt + "원\n"
						+ "모닝빵\t 2,000원 X " + breadCnt + "개 = " + 2000*breadCnt + "원\n"
						+ "조각케잌\t 6,000원 X " + cakeCnt + "개 = " + 6000*cakeCnt + "원\n"
						+ "쿠키\t\t 4,000원 X " + cookieCnt + "개 = " + 4000*cookieCnt + "원\n"
						+ "마카롱\t 2,500원 X " + macaroonCnt + "개 = " + 2500*macaroonCnt + "원\n"
						+ "아이스티\t 6,000원 X " + iceteaCnt + "개 = " + 6000*iceteaCnt + "원\n"
						+ "초코라떼\t 6,000원 X " + chocolatelatteCnt + "개 = " + 6000*chocolatelatteCnt + "원\n"
						+ "총계 = " + (4000*americanoCnt + 5000*cafelatteCnt + 6000*espressoCnt + 3000*milkCnt + 2000*breadCnt + 6000*cakeCnt + 4000*cookieCnt + 2500*macaroonCnt + 6000*iceteaCnt + 6000*chocolatelatteCnt) + "원\n");
			}
			
		});
	}
	
	public void handleExitAction(ActionEvent event) {
		Platform.exit();
	}
	
	public void handleSavepointAction(ActionEvent event) {
		
		if(name.getText().trim().isEmpty()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {		
					orderlist.setText("공백은 입력이 되지 않습니다.\n제대로된 값을 입력하세요.");
				}
			});
		}
		else if(phonenumber.getText().trim().isEmpty()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {		
					orderlist.setText("공백은 입력이 되지 않습니다.\n제대로된 값을 입력하세요.");
				}
			});
		}
		else {
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
		
	}

}
