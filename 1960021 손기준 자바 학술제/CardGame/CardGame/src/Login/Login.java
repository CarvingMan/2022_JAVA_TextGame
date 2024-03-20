package Login;
import java.sql.Connection; // db와 연동하기위해
import java.sql.DriverManager;
import java.sql.PreparedStatement; //쿼리를 처리한다.
import java.sql.ResultSet;  // 쿼리 값을 저장해 준다.
import java.sql.SQLException;  // sql 연동 오류처리

//import java.sql.SQLException;
import java.util.concurrent.TimeUnit;  // 시간차 출력을 위한 클래스
import InGame.InGame_Print;  // Clean 메소드 사용하기 위해
import java.util.Scanner;

public class Login {
	public static Scanner log = new Scanner(System.in);
	
	
	
	
	public static void login() throws SQLException {
		while(true) {
		String id; // id를 입력받을 문자열
		String pw; //password를 입력받을 문자열
		boolean SuccessLogin = false;
		
		
		InGame_Print.Clean();
		System.out.println("\t로그인");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("\t아이디	:	");
		id = log.next(); // 아이디 입력
		System.out.println();
		System.out.print("\t패스워드	:	");
		pw = log.next(); //비밀번호 입력
		
		try {
			//1. JDBC 드라이버의 이름 지정
			String driverName = "com.mysql.cj.jdbc.Driver";  //mysql 버전상 가운데 cj를 포함 해야 오류 안난다.
			
			//2. JDBC 드라이버 로드
			Class.forName(driverName);
		}catch (ClassNotFoundException e) { // 드라이버 로드에 실패시
			e.printStackTrace();
		}
		
		//3. 접속할 정보인 URL 지정
		String dbURL = "jdbc:mysql://localhost:3306/gamehit?severTimezone=UTC";
		
		Connection con = null;
		try {
			//4.데이터베이스에 연결
			con = DriverManager.getConnection(dbURL,"root", "password");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		PreparedStatement pstmt; //조회문(select, show 등)을 실행할 목적으로 사용한다.
		
		
		pstmt = con.prepareStatement("select * from login"); // login table조회

		ResultSet rs;
		rs = pstmt.executeQuery();  //실행란 쿼리의 결과 값을 저장해준다
	
		// 무한 반복으로 테이블 행을 내려가며 입력 값과  db의 id,pw값을 비교 해 준다.
		while(rs.next()) { //rs.next()는 다음 행으로 이동 해 준다. 0 부터 시작해 값을 참조 하려면 처음에 넘기고 시작해야 함
			// 자동 으로 마지막에 false가 되어 break 없이 사용 가능하다.
			
			if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw")) ){ // 해당 튜플의 아이디와 비번이 입력한 아이디 비번과 같다면 
				SuccessLogin = true;
				break;
			}
			
			
		}
		
		if(SuccessLogin == true) {
			try {
				InGame_Print.Clean();
				System.out.println("\t\t\t로그인 성공\n\n\n\n\n");
				TimeUnit.SECONDS.sleep(1);
				}catch(Exception e) {
		            System.out.println(e.getMessage());		
				}
			break;
		}
		else if(SuccessLogin == false) {
			try {
				InGame_Print.Clean();
				System.out.print("\t\t\t잘못 입력 하셨거나 계정이 없습니다.\n\n\n\n\n");
				TimeUnit.SECONDS.sleep(1);
				}catch(Exception e) {
		            System.out.println(e.getMessage());
								}
				continue;
		}
		rs.close();
		pstmt.close();
		con.close();
		}
		
	}
	
	
	
	
	
	/// 회원 가입
	public static void join() throws SQLException{
		String id; // id를 입력받을 문자열
		String pw; //password를 입력받을 문자열
		
		
		while(true){
			boolean already = false;
			while(true) {
				InGame_Print.Clean();
				System.out.println("\t회원가입");
				System.out.println();
				System.out.println("\t10자리 이하로 생성해 주세요...");
				System.out.println();
				System.out.println();
				System.out.print("\t생성할 아이디	:	");
				id = log.next(); // 아이디 입력
				System.out.println();
				System.out.print("\t생성할 패스워드	:	");
				pw = log.next(); //비밀번호 입력
				
				if(id.length() > 10 || pw.length() >10) {
					try {
						InGame_Print.Clean();
						System.out.print("\t10자리 이하로 다시 입력 해 주세요...\n\n\n\n\n");
						TimeUnit.SECONDS.sleep(1);
						}catch(Exception e) {
				            System.out.println(e.getMessage());
										}
						continue;
				}
				else if(id.length() <=10 && pw.length()<=10) {
					InGame_Print.Clean();
					break;
				}
			}
		try {
			//1. JDBC 드라이버의 이름 지정
			String driverName = "com.mysql.cj.jdbc.Driver";
			
			//2. JDBC 드라이버 로드
			Class.forName(driverName);
		}catch (ClassNotFoundException e) { // 드라이버 로드에 실패시
			e.printStackTrace();
		}
		
		//3. 접속할 정보인 URL 지정
		String dbURL = "jdbc:mysql://localhost:3306/gamehit?severTimezone=UTC";
		
		Connection con = null;
		try {
			//4.데이터베이스에 연결
			con = DriverManager.getConnection(dbURL,"root", "password");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
		PreparedStatement pstmt; //쿼리 준비
		
		
		pstmt = con.prepareStatement("select * from login"); // login table조회

		ResultSet rs;
		rs = pstmt.executeQuery();  //실행란 쿼리의 결과 값을 저장해준다
		//조회문(select, show 등)을 실행할 목적으로 사용한다
		
		// 무한 반복으로 테이블 행을 내려가며 입력 값과  db의 id,pw값을 비교 해 준다.
		while(rs.next()) { //next()는 다음 행으로 이동 해 준다. 0 부터 시작해 값을 참조 하려면 처음에 넘기고 시작해야 함
				// 자동 으로 마지막에 false가 되어 break 없이 사용 가능하다.
			
			if(id.equals(rs.getString("id"))  ){ // 해당 튜플의 아이디와 비번이 입력한 아이디 비번과 같다면 
				already = true; // 생성할 아이디와 비번이 이미 존재 키값이라 중복 되어선 안된다. 비번은 중복 가능
				break;
			}
			
		}
		
		rs.close();
		pstmt.close();
		if(already == true) { // already 가 참이면 이미 아이디 가 존재 한다. 아이디는 pk이기 때문에 중복 불가하다.
			
			try {
				InGame_Print.Clean();
				System.out.println("\t\t이미 존재하는 계정 입니다.");
				System.out.println("\n\n\n\n");
				TimeUnit.SECONDS.sleep(1);
				}catch(Exception e) {
		            System.out.println(e.getMessage());
								}
			continue;
		}
		else if(already == false) {
			
			PreparedStatement In_pstmt = con.prepareStatement("INSERT INTO login VALUES(?,?)"); // INSERT명령
			In_pstmt.setString(1, id);
			In_pstmt.setString(2, pw);
			int In_rs;
			In_rs = In_pstmt.executeUpdate();  //실행란 쿼리의 결과 값을 저장해준다 // 인서트 명령
			if(In_rs > 0) {
				
				try {
					InGame_Print.Clean();
					System.out.println("\t\t\t가입 성공\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(1);
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}
				break;
				} else {
					try {
						InGame_Print.Clean();  // 화면 넘기기
						System.out.println("\t\t\t가입 실패\n\n\n\n\n");
						TimeUnit.SECONDS.sleep(1);
						}catch(Exception e) {
				            System.out.println(e.getMessage());
										}
					
				continue;
				}
			
		}
		
		con.close();
		
		}
	}
	
	
	public static void Start() throws SQLException {
		
			int Select;
			while(true) {
			InGame_Print.Clean();
			System.out.println("\t\t\tH    H       I       TTTTT");
			System.out.println("\t\t\tHHHH       I           T   ");
			System.out.println("\t\t\tH   H       I           T");
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t턴제 전략 카드게임!!!");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t1. 로그인");
			System.out.println("\t2. 회원가입");
			System.out.println("");
			System.out.println("\t원하시는 번호를 입력하세요.. ");
			System.out.println("");
			System.out.print("\t\t\t\t입력 :\t");
			Select = log.nextInt(); // 입력
			
			if(Select == 1) { // 번호1일 시 
				
				break ; // 반복 종료
			}
			else if(Select == 2) { // 번호2일 시 
				join();  // 회원가입 메소드 시작
				continue; // 회원가입 후 다시 로그인 하게 무한 반복문 유지
			}
			else {
				try {
					InGame_Print.Clean();
					System.out.println("\t\t 잘못 입력하셨습니다.");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}
				continue;  // 잘못 입력시 반복
			}
				
			
			}
			login();  // 로그인 메소드 시작
			
		}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Start();
		//Login.join();
		//Login.login();
		
	}

}
