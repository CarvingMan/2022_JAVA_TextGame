/*
   스레드를 상속받아 메세지를 보내는 클라이언트 송신 클래스 
 */
package Client;

import java.io.BufferedReader; // 버퍼에 입력받아 String으로 고정 - System.in을 사용하기 편하도록 만들기 위해 import
import java.io.IOException;  // 입출력 예외 처리를 하기위해 import
import java.io.InputStreamReader;  // char 형태로 입력할수 있다. 
import java.io.PrintWriter; // OutputStream 값을 사용하기 편하게 하기위해 import
//File(String), OutputStream, Writer 등의 객체를 인수로 받아 더 간편하게 스트림을 연결할 수 있다.

import java.net.Socket; // 소켓사용





public class C_Send_Massage extends Thread {
	
	private Socket Main_Socket;  // 메인에서 Socket를 받기 위함
	
// run  메소드 재정의
	public void run() {
		
		super.run();
		
		try {
			BufferedReader C_Buffered_Massage = new BufferedReader(new InputStreamReader(System.in)); 
			// System.in을 사용하기 편하게 하기위해 BufferedReader 클래스로 변경
			// System.in 에서 데이터를 readLine()으로 받아 문자열로 버퍼에 저장 후 
			PrintWriter C_Send_Writer = new PrintWriter(Main_Socket.getOutputStream());
			//OutputStream 객체를 인수로 받아 더 간편하게 스트림을 연결
			// Main_Socket.getOutputStream()		->		소켓의 출력스트림을 반환
			String C_Send_Massage; // 스트링의 메세지
			while(true) { // 무한 루프로 언제든지 전송가능
				
				C_Send_Massage = C_Buffered_Massage.readLine(); // BufferedReaderd 에서 입력받은 문자열 저장
															 // readLine() : BufferedReader의 메소드 한줄을 읽어 String으로 반환
				
				if(C_Send_Massage.equals("종료")) {// equals = 문자열 비교 메소드 (==)와 달리 내용자체를 비교한다. 주소값X
					break;
				}
				
				C_Send_Writer.println(C_Send_Massage); //  버퍼에 저장된 입력 받은 값 출력
				C_Send_Writer.flush(); // 버퍼 flush
			}
			C_Buffered_Massage.close();  // 반복문 접속시 데이터 입출력 멈추고 소켓종료
	 		C_Send_Writer.close();
	 		Main_Socket.close();
		
	 		
		}catch(IOException e) {
			e.printStackTrace(); 
			
		}
		
	}
	public void setMain_Socket(Socket Socket) {
		Main_Socket = Socket;  // 메인으로 부터 소켓을 받기위한 Setta
	}

}
