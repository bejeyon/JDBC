package com.myapp;//myapp 패키지

import java.sql.Connection;//JDBC API 사용을 위한 인터페이스. createStatement()/preparedStatement()/collableStatement() 메소드 사용하여 Statement/preparedStatement 개체 참조 위함.
import java.sql.PreparedStatement;//SQL문을 실행하고 결과를 반환하기 위해 제공되는 Statement 인터페이스의 하위 인터페이스로, 미리 컴파일된 SQL문에 인수를 전달하도록 허용하는 역할을 함.
import java.sql.ResultSet;//Statement에서 executeQuery()메소드나 반환된
import java.sql.SQLException;/*드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우*/

public class AccountDAO implements AccountDAOInterface {//DAOInterface를 상속받아 구체적으로 구현

	private Connection conn = DBConnection.getConnection();//DBConnection의 static getConnection() 메소드로부터 Connection conn을 반환받아 Connection conn에 대입.
	
	//insert
	public void accountInsert(AccountVO newAccount) {/*AccountVO 클래스의 객체를 newAccount 매개변수로 받아서 AccountVO 객체의 필드값 3개를 getter로 받아 
	query의 insert문 ? 3곳에 계좌번호,계좌주,계좌잔고값을 넣어서 insert query 실행하는 멤버 메소드*/
		String sql = "insert into hr.accounts( ano,owner,balance) values(?, ?, ?) ";//PreparedStatemen에 인수로 넣을 query를 문자열로 저장.

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setString(1, newAccount.getAno());/*매개변수로 받은 AccountVO 객체 newAccount의 getAno() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌번호를 preparedStatement의 1번째 ?에 대입*/
			preparedStatement.setString(2, newAccount.getOwner());/*매개변수로 받은 AccountVO 객체 newAccount의 getOwner() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌주를 preparedStatement의 2번째 ?에 대입*/
			preparedStatement.setDouble(3, newAccount.getBalance());/*매개변수로 받은 AccountVO 객체 newAccount의 getBalance() 메소드 실행하여 
			입력받은 객체의 필드값인 계좌잔고를 preparedStatement의 3번째 ?에 대입*/
			preparedStatement.executeUpdate();//preparedStatement의 insert query문 최종 실행.
			System.out.println("hr.accounts 입력 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try
	}//end accountInsert

	//select all
	public void accountList() {//은행에 있는 모든 계좌번호, 계좌주, 계좌잔고 정보를 출력하는 select query문 실행하는 멤버 메소드.
		String sql = "select * from hr.accounts";//select query문 String sql에 저장
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			ResultSet resultSet =  preparedStatement.executeQuery();//preparedStatement의 select query문 최종 실행하여 반환되는 테이블을 ResultSet resultSet에 대입하여 저장.
			while (resultSet.next()) {//resultSet으로부터 next() 메소드로 한 행씩 읽어들어와 한 행을 읽어들일 때마다 true를 반환하며 다 읽어들여서 더 이상 읽을 ResultSet이 없으면 false를 반환.
			/*boolean next()
  					throws SQLException
  			Moves the cursor forward one row from its current position.
  			A ResultSet cursor is initially positioned before the first row;
  			the first call to the method next makes the first row the current row;
  			the second call makes the second row the current row, and so on.*/
				System.out.print(resultSet.getString(1) + "   ");/*resultSet에서 커서가 위치한 행의 1번째 열의 문자열값을 반환받아 출력
				String getString(int columnIndex)
          				throws SQLException
          		Retrieves the value of the designated column in the current row of this ResultSet object as a String in the Java programming language.*/
				System.out.print(resultSet.getString(2) + "   ");//resultSet에서 커서가 위치한 행의 2번째 열의 문자열값을 반환받아 출력
				System.out.println(resultSet.getDouble(3));/*resultSet에서 커서가 위치한 행의 3번째 열의 실수값을 반환받아 출력
				double getDouble(int columnIndex)
          				throws SQLException
				Retrieves the value of the designated column in the current row of this ResultSet object as a double in the Java programming language.*/
			}//end while
			System.out.println();
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생. 
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			System.out.println("에러 발생!");
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());//SQL에 뜬 예외 메세지와 JAVA에 뜬 예외 메세지 문자열로 출력
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}//end try
	}//end accountList

	//입금 deposit
	public void accountPlusUpdate(AccountVO account) {/*AccountVO 클래스의 객체를 account 매개변수로 받아서 AccountVO 객체의 필드값 2개를 getter로 받아
	query의 update문 ? 2곳에 계좌번호,계좌잔고값을 넣어서 update query 실행하는 멤버 메소드*/
		String  sql= "UPDATE hr.accounts set balance = (balance+?) where ano=?";//PreparedStatemen에 인수로 넣을 query를 문자열로 저장.
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setDouble(1, account.getBalance());/*매개변수로 받은 AccountVO 객체 account의 getBalance() 메소드 실행하여
			입력받은 객체의 필드값인 추가할 계좌잔고를 preparedStatement의 1번째 ?에 대입하여 계좌잔고 +연산으로 계좌잔고 늘림*/
			preparedStatement.setString(2, account.getAno());/*매개변수로 받은 AccountVO 객체 account의 getAno() 메소드 실행하여
			입력받은 객체의 필드값인 계좌번호를 preparedStatement의 2번째 ?에 대입*/
			preparedStatement.executeUpdate();//preparedStatement의 update query문 최종 실행.
			System.out.println("입금 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생.
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}
	}//end accountPlusUpdate

	//출금 withdraw
	public void accountMinusUpdate(AccountVO account) {/*AccountVO 클래스의 객체를 account 매개변수로 받아서 AccountVO 객체의 필드값 2개를 getter로 받아
	query의 update문 ? 2곳에 계좌번호,계좌잔고값을 넣어서 update query 실행하는 멤버 메소드*/
		String  sql= "UPDATE hr.accounts set balance = (balance - ?) where ano=?";//PreparedStatemen에 인수로 넣을 query를 문자열로 저장.
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);/*query를 String sql로 받아 Connection 객체 conn의 prepareStatement() 메소드의 매개변수로 넣어
			PreparedStatement type 객체인 preparedStatement로 반환 대입*/
			preparedStatement.setDouble(1, account.getBalance());/*매개변수로 받은 AccountVO 객체 account의 getBalance() 메소드 실행하여
			입력받은 객체의 필드값인 추가할 계좌잔고를 preparedStatement의 1번째 ?에 대입하여 계좌잔고 -연산으로 계좌잔고 줄임*/
			preparedStatement.setString(2, account.getAno());/*매개변수로 받은 AccountVO 객체 account의 getAno() 메소드 실행하여
			입력받은 객체의 필드값인 계좌번호를 preparedStatement의 2번째 ?에 대입*/
			preparedStatement.executeUpdate();//preparedStatement의 update query문 최종 실행.
			System.out.println("출금 성공");//예외 발생 없이 성공할 시 성공했다는 메세지 출력.
		} catch (SQLException e) {/*PreparedStatement 클래스 객체의 setString() 메소드, setDouble() 메소드, executeUpdate() 메소드 실행시 필수 예외.
			드라이버 메소드, 데이터베이스에 액세스하는 메소드 또는 데이터베이스 연결을 가져오려는 시도 중 하나에 발생하는 오류에서 발생.
			사용자 이름이나 암호 정보가 잘못되어 데이터 베이스에 연결할 수 없거나 데이터베이스가 오프라인일 경우, SQL 쿼리에 포함되지 않은 열 이름에 액세스를 시도할 경우 catch로 예외 처리*/
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} catch (Exception e) {//SQLException 외의 예외 상황 발생 대비.
			e.printStackTrace();//예외가 발생한 내역 추척하여 출력.
		} finally {
		}
	}//end accountMinusUpdate
	

	//계좌 확인
	public boolean accountFindOne(String ano) {
		boolean isExist = false;
		String sql = "select count(*)  from hr.accounts where ano = ? ";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ano);
			ResultSet resultSet =preparedStatement.executeQuery();
			resultSet.next();
			
			int result = resultSet.getInt(1);
			if (result ==1 ) {
				isExist = true;
			} else {
				isExist = false;
			}//end if
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}//end try		
		return isExist;
	}//end accountFindOne

}//end class