package DATA_MODEL;

import java.sql.Connection;//JDBC API 사용을 위한 인터페이스. createStatement()/preparedStatement()/collableStatement() 메소드 사용하여 Statement/preparedStatement 개체 참조 위함.
import java.sql.PreparedStatement;//SQL문을 실행하고 결과를 반환하기 위해 제공되는 Statement 인터페이스의 하위 인터페이스로, 미리 컴파일된 SQL문에 인수를 전달하도록 허용하는 역할을 함.
import java.sql.ResultSet;//Statement에서 executeQuery()메소드나 반환된
import java.sql.SQLException;/*드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우*/
import UTIL.DBConnection;

public class KioskDAO implements KioskDAOInterface {
	
	private Connection conn = DBConnection.getConnection();

	public void orderInsert(KioskDTO newKioskOrderDTO) {
		String sql = "insert into T4.order_list(order_id, menu_id, menu_name, unit_price, num_of_sales) values(TO_CHAR(SYSDATE, 'YYYYDDMM')||order_id_seq.NEXTVAL||?, ?, ?, ?, ?) ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setString(1, newKioskOrderDTO.getMenu_id());
			preparedStatement.setString(2, newKioskOrderDTO.getMenu_id());/*매개변수로 받은 AccountVO 객체 newAccount의 getAno() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌번호를 preparedStatement의 1번째 ?에 대입*/
			preparedStatement.setString(3, newKioskOrderDTO.getMenu_name());/*매개변수로 받은 AccountVO 객체 newAccount의 getOwner() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌주를 preparedStatement의 2번째 ?에 대입*/
			preparedStatement.setInt(4, newKioskOrderDTO.getUnit_price());/*매개변수로 받은 AccountVO 객체 newAccount의 getBalance() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌잔고를 preparedStatement의 3번째 ?에 대입*/
			preparedStatement.setInt(5, newKioskOrderDTO.getNum_of_sales());
			preparedStatement.executeUpdate();//preparedStatement의 insert query문 최종 실행.
			System.out.println("T4.ORDER_LIST 입력 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try	
	}
	public void getMenu(String menu_id, String menu_name, int unit_cost, int unit_price) {
		
	}
	public void setStock(int consumption_stock, int ingredient_id) {
		String sql = "update T4.stock set available_stock = (available_stock - ?) where ingredient_id = ? ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setInt(1, consumption_stock);/*매개변수로 받은 AccountVO 객체 newAccount의 getAno() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌번호를 preparedStatement의 1번째 ?에 대입*/
			preparedStatement.setInt(2, ingredient_id);/*매개변수로 받은 AccountVO 객체 newAccount의 getOwner() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌주를 preparedStatement의 2번째 ?에 대입*/
			preparedStatement.executeUpdate();//preparedStatement의 insert query문 최종 실행.
			System.out.println("T4.STOCK 입력 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try	
	}
	public void setSettlement(KioskDTO setSettlementDTO) {
		String sql = "insert into T4.settlement(menu_id, menu_name, num_of_sales, unit_cost, unit_price, profit_margin) values(?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setString(1, setSettlementDTO.getMenu_id());
			preparedStatement.setString(2, setSettlementDTO.getMenu_name());/*매개변수로 받은 AccountVO 객체 newAccount의 getAno() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌번호를 preparedStatement의 1번째 ?에 대입*/
			preparedStatement.setInt(3, setSettlementDTO.getNum_of_sales());/*매개변수로 받은 AccountVO 객체 newAccount의 getOwner() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌주를 preparedStatement의 2번째 ?에 대입*/
			preparedStatement.setInt(4, setSettlementDTO.getUnit_cost());/*매개변수로 받은 AccountVO 객체 newAccount의 getBalance() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌잔고를 preparedStatement의 3번째 ?에 대입*/
			preparedStatement.setInt(5, setSettlementDTO.getUnit_price());
			preparedStatement.setInt(6, setSettlementDTO.getProfit_margin());
			preparedStatement.executeUpdate();//preparedStatement의 insert query문 최종 실행.
			System.out.println("T4.SETTLEMENT 입력 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try
	}
	public void memberInsert(String guest_name, String guest_phone) {
		
	}
	public void setMember(KioskDTO setMemberDTO) {
		String sql = "insert into T4.member(guest_name, guest_phone) values(?, ?) ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setString(1, setMemberDTO.getGuest_name());
			preparedStatement.setString(2, setMemberDTO.getGuest_phone());
			preparedStatement.executeUpdate();//preparedStatement의 insert query문 최종 실행.
			System.out.println("T4.ORDER_LIST 입력 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try
	}
	public boolean memberFindOne(String guest_phone) {
		boolean isExist = false;//계좌번호일치 여부를 저장할 변수 isExist. 기본값 false.
		String sql = "select count(*) from hr.member where guest_phone = ? ";//where절에 계좌번호값이 사용자가 입력한 값과 일치하는 조건을 걸고 count(*) 함수 실행하는 select문 query
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setString(1, guest_phone);//매개변수로 받은 사용자가 입력한 값인 String 객체 ano를 preparedStatement의 1번째 ?에 대입하여 select query 실행
			ResultSet resultSet =preparedStatement.executeQuery();//preparedStatement의 select query문 최종 실행하여 결과값으로 반환된 ResultSet을 resultSet에 대입
			resultSet.next();//resultSet의 첫번째 행 맨 앞에 커서를 갖다놓고 읽어들일 준비함.
			
			int result = resultSet.getInt(1);//select문으로부터 1열의 count(*) 함수 결과값을 받아 int result에 대입하여 저장.
			if (result ==1 ) {//result값이 1이면 count(*) 함수 결과값이 1이므로 일치하는 계좌번호가 단 1개 있다는 결과가 나온 것.
				isExist = true;//따라서 isExist는 true값으로 변경.
			} else {//result값이 1이 아니면 count(*) 함수 결과값이 1이 아니므로 일치하는 계좌번호가 존재하지 않다는 결과가 나온 것.
				isExist = false;//따라서 isExist는 그대로 false값 유지.
			}//end if
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, ResultSet 클래스 객체의 next() 메소드, getInt() 메소드 실행 시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생.
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());/*java.lang 패키지의 System 클래스의 필드인 PrintStream 클래스형의 err를
			PrintStream 클래스의 format() 메소드로 실행. format() 메소드의 매개변수는 format(String format, Object... args)로 Format String Syntax를 따름.
			formatted string인 "SQL State: %s\n%s"의 %s 2곳에 e.getSQLState()와 e.getMessage() 문자열을 받아 출력.
			내용은 인수로 받은 SQLException 클래스의 객체 e의 메소드인 getSQLState() public String getSQLState() Retrieves the SQLState for this SQLException object.와
			SQLException 클래스가 java.lang 패키지의 Throwable로부터 상속받은 메소드인 getMessage() public String getMessage() Returns the detail message string of this throwable.
			두 String을 %s 형식으로 출력함.*/
			System.out.println();
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try		
		return isExist;//최종적으로 일치하는 계좌가 있으면 1->true 반환, 없으면 0->false 반환.
	}

}
