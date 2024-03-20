/*
  클라이언트 스레드를 실행시키는 클래스
 */
package Client;
import java.io.IOException;  //입출력 예외 처리를 위해 import
import java.net.Socket; // 소켓 사용
import java.net.SocketException;

public class Client_Start {


	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		try {
			Socket C_Socket = new Socket("localhost", 8889);
			 // 서버 프로그램이 있는 IP 주소아 서버가 열어 놓은 포트 번호로 소켓 객체를 생성
			// 소켓 객체 생성과 동시에 서버쪽에 접속을 요청하게 됨
		
			C_Get_Massage C_G_Massage = new C_Get_Massage();	// C_Get_Massage 스레드 생성
			C_G_Massage.setMainSocket(C_Socket);  // C_Get_Massage의 MainSocket에 C_Socket Set
			
			C_Send_Massage C_S_Massage = new C_Send_Massage();	// C_Send_Massage 스레드 생성
			C_S_Massage.setMain_Socket(C_Socket);	 // C_Send_Massage의 MainSocket에 C_Socket Set
			
			
			
			C_S_Massage.start();
			C_G_Massage.start();  // 송 수신 스레드 시작
			
			
		}catch(SocketException e) {
			e.printStackTrace(); // 예외 발생시 Trace
			
		}
		
		
		
		
		
		
	
		
	}

}
