package Login;
import java.sql.Connection; // db�� �����ϱ�����
import java.sql.DriverManager;
import java.sql.PreparedStatement; //������ ó���Ѵ�.
import java.sql.ResultSet;  // ���� ���� ������ �ش�.
import java.sql.SQLException;  // sql ���� ����ó��

//import java.sql.SQLException;
import java.util.concurrent.TimeUnit;  // �ð��� ����� ���� Ŭ����
import InGame.InGame_Print;  // Clean �޼ҵ� ����ϱ� ����
import java.util.Scanner;

public class Login {
	public static Scanner log = new Scanner(System.in);
	
	
	
	
	public static void login() throws SQLException {
		while(true) {
		String id; // id�� �Է¹��� ���ڿ�
		String pw; //password�� �Է¹��� ���ڿ�
		boolean SuccessLogin = false;
		
		
		InGame_Print.Clean();
		System.out.println("\t�α���");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("\t���̵�	:	");
		id = log.next(); // ���̵� �Է�
		System.out.println();
		System.out.print("\t�н�����	:	");
		pw = log.next(); //��й�ȣ �Է�
		
		try {
			//1. JDBC ����̹��� �̸� ����
			String driverName = "com.mysql.cj.jdbc.Driver";  //mysql ������ ��� cj�� ���� �ؾ� ���� �ȳ���.
			
			//2. JDBC ����̹� �ε�
			Class.forName(driverName);
		}catch (ClassNotFoundException e) { // ����̹� �ε忡 ���н�
			e.printStackTrace();
		}
		
		//3. ������ ������ URL ����
		String dbURL = "jdbc:mysql://localhost:3306/gamehit?severTimezone=UTC";
		
		Connection con = null;
		try {
			//4.�����ͺ��̽��� ����
			con = DriverManager.getConnection(dbURL,"root", "password");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		PreparedStatement pstmt; //��ȸ��(select, show ��)�� ������ �������� ����Ѵ�.
		
		
		pstmt = con.prepareStatement("select * from login"); // login table��ȸ

		ResultSet rs;
		rs = pstmt.executeQuery();  //����� ������ ��� ���� �������ش�
	
		// ���� �ݺ����� ���̺� ���� �������� �Է� ����  db�� id,pw���� �� �� �ش�.
		while(rs.next()) { //rs.next()�� ���� ������ �̵� �� �ش�. 0 ���� ������ ���� ���� �Ϸ��� ó���� �ѱ�� �����ؾ� ��
			// �ڵ� ���� �������� false�� �Ǿ� break ���� ��� �����ϴ�.
			
			if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw")) ){ // �ش� Ʃ���� ���̵�� ����� �Է��� ���̵� ����� ���ٸ� 
				SuccessLogin = true;
				break;
			}
			
			
		}
		
		if(SuccessLogin == true) {
			try {
				InGame_Print.Clean();
				System.out.println("\t\t\t�α��� ����\n\n\n\n\n");
				TimeUnit.SECONDS.sleep(1);
				}catch(Exception e) {
		            System.out.println(e.getMessage());		
				}
			break;
		}
		else if(SuccessLogin == false) {
			try {
				InGame_Print.Clean();
				System.out.print("\t\t\t�߸� �Է� �ϼ̰ų� ������ �����ϴ�.\n\n\n\n\n");
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
	
	
	
	
	
	/// ȸ�� ����
	public static void join() throws SQLException{
		String id; // id�� �Է¹��� ���ڿ�
		String pw; //password�� �Է¹��� ���ڿ�
		
		
		while(true){
			boolean already = false;
			while(true) {
				InGame_Print.Clean();
				System.out.println("\tȸ������");
				System.out.println();
				System.out.println("\t10�ڸ� ���Ϸ� ������ �ּ���...");
				System.out.println();
				System.out.println();
				System.out.print("\t������ ���̵�	:	");
				id = log.next(); // ���̵� �Է�
				System.out.println();
				System.out.print("\t������ �н�����	:	");
				pw = log.next(); //��й�ȣ �Է�
				
				if(id.length() > 10 || pw.length() >10) {
					try {
						InGame_Print.Clean();
						System.out.print("\t10�ڸ� ���Ϸ� �ٽ� �Է� �� �ּ���...\n\n\n\n\n");
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
			//1. JDBC ����̹��� �̸� ����
			String driverName = "com.mysql.cj.jdbc.Driver";
			
			//2. JDBC ����̹� �ε�
			Class.forName(driverName);
		}catch (ClassNotFoundException e) { // ����̹� �ε忡 ���н�
			e.printStackTrace();
		}
		
		//3. ������ ������ URL ����
		String dbURL = "jdbc:mysql://localhost:3306/gamehit?severTimezone=UTC";
		
		Connection con = null;
		try {
			//4.�����ͺ��̽��� ����
			con = DriverManager.getConnection(dbURL,"root", "password");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
		PreparedStatement pstmt; //���� �غ�
		
		
		pstmt = con.prepareStatement("select * from login"); // login table��ȸ

		ResultSet rs;
		rs = pstmt.executeQuery();  //����� ������ ��� ���� �������ش�
		//��ȸ��(select, show ��)�� ������ �������� ����Ѵ�
		
		// ���� �ݺ����� ���̺� ���� �������� �Է� ����  db�� id,pw���� �� �� �ش�.
		while(rs.next()) { //next()�� ���� ������ �̵� �� �ش�. 0 ���� ������ ���� ���� �Ϸ��� ó���� �ѱ�� �����ؾ� ��
				// �ڵ� ���� �������� false�� �Ǿ� break ���� ��� �����ϴ�.
			
			if(id.equals(rs.getString("id"))  ){ // �ش� Ʃ���� ���̵�� ����� �Է��� ���̵� ����� ���ٸ� 
				already = true; // ������ ���̵�� ����� �̹� ���� Ű���̶� �ߺ� �Ǿ �ȵȴ�. ����� �ߺ� ����
				break;
			}
			
		}
		
		rs.close();
		pstmt.close();
		if(already == true) { // already �� ���̸� �̹� ���̵� �� ���� �Ѵ�. ���̵�� pk�̱� ������ �ߺ� �Ұ��ϴ�.
			
			try {
				InGame_Print.Clean();
				System.out.println("\t\t�̹� �����ϴ� ���� �Դϴ�.");
				System.out.println("\n\n\n\n");
				TimeUnit.SECONDS.sleep(1);
				}catch(Exception e) {
		            System.out.println(e.getMessage());
								}
			continue;
		}
		else if(already == false) {
			
			PreparedStatement In_pstmt = con.prepareStatement("INSERT INTO login VALUES(?,?)"); // INSERT���
			In_pstmt.setString(1, id);
			In_pstmt.setString(2, pw);
			int In_rs;
			In_rs = In_pstmt.executeUpdate();  //����� ������ ��� ���� �������ش� // �μ�Ʈ ���
			if(In_rs > 0) {
				
				try {
					InGame_Print.Clean();
					System.out.println("\t\t\t���� ����\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(1);
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}
				break;
				} else {
					try {
						InGame_Print.Clean();  // ȭ�� �ѱ��
						System.out.println("\t\t\t���� ����\n\n\n\n\n");
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
			System.out.println("\t\t\t���� ���� ī�����!!!");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t1. �α���");
			System.out.println("\t2. ȸ������");
			System.out.println("");
			System.out.println("\t���Ͻô� ��ȣ�� �Է��ϼ���.. ");
			System.out.println("");
			System.out.print("\t\t\t\t�Է� :\t");
			Select = log.nextInt(); // �Է�
			
			if(Select == 1) { // ��ȣ1�� �� 
				
				break ; // �ݺ� ����
			}
			else if(Select == 2) { // ��ȣ2�� �� 
				join();  // ȸ������ �޼ҵ� ����
				continue; // ȸ������ �� �ٽ� �α��� �ϰ� ���� �ݺ��� ����
			}
			else {
				try {
					InGame_Print.Clean();
					System.out.println("\t\t �߸� �Է��ϼ̽��ϴ�.");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}
				continue;  // �߸� �Է½� �ݺ�
			}
				
			
			}
			login();  // �α��� �޼ҵ� ����
			
		}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Start();
		//Login.join();
		//Login.login();
		
	}

}
