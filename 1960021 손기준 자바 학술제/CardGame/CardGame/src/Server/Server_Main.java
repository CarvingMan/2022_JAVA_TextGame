/*
   서버의 메인메소드 클래스
 */

package Server;

import java.io.IOException; // 입출력 예외 처리를 위해 import
import java.net.ServerSocket; //서버 소켓사용
import java.net.Socket; // 클라이언트용 소켓 사용
public class Server_Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket S_Socket = null;
		Socket C_Socket = null;
		try {
			S_Socket = new ServerSocket(8889); // 서버 소켓 객체생성
						//(new ServerSocket(서버 port)) 클라이언트의 접속을 받기 위해 기다린다.
			
			 C_Socket = S_Socket.accept();
				//서버는 클라이언트로부터 접속 요청을 받으면 accept()메소드에서 접속된 클라이언트와
	          	//통신하도록 전용 클라이언트 소켓을 따로 생성한다.
	          
			Get_Massage G_Massage = new Get_Massage(); // Get_Massage 스레드 생성
			G_Massage.setMainSocket(C_Socket); // Get_Massage의 MainSocket에 C_Socket Set
			
			Send_Massage S_Massage = new Send_Massage(); //Send_Massage 스레드 생성
			S_Massage.setMain_Socket(C_Socket); // Send_Massge의 MainSocket에 C_Socket Set
			
			
			
			G_Massage.start();  // 송 수신 스레드 실행
			S_Massage.start();
				
		}catch(IOException e) {
			e.printStackTrace(); // 예외 발생시 Trace
		}
		finally {
	         try {
	        		S_Socket.close(); // 소켓종료
	         }catch(Exception ignored) {
	            
	         }
	      }
		
	}

}
