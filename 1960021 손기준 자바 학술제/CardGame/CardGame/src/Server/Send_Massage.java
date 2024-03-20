/*
   스레드를 상속받아 메세지를 보내는 송신 클래스 
 */
package Server;

import java.io.BufferedReader; // 버퍼에 입력받아 String으로 고정 - System.in을 사용하기 편하도록 만들기 위해 import
import java.io.IOException;  // 입출력 예외 처리를 하기위해 import
import java.io.InputStreamReader;  // char 형태로 입력할수 있다. 
import java.io.PrintWriter; // OutputStream 값을 사용하기 편하게 하기위해 import
//File(String), OutputStream, Writer 등의 객체를 인수로 받아 더 간편하게 스트림을 연결할 수 있다.

import java.net.Socket; // 소켓사용


public class Send_Massage extends Thread {
	
	private Socket Main_Socket;  // 메인에서 Socket를 받기 위함
	
// run  메소드 재정의
	public void run() {
		
		super.run();
		try {
			BufferedReader Buffered_Massage = new BufferedReader(new InputStreamReader(System.in)); 
			// System.in을 사용하기 편하게 하기위해 BufferedReader 클래스로 변경
			// System.in 에서 데이터를 readLine()으로 받아 문자열로 버퍼에 저장 후 
			PrintWriter Send_Writer = new PrintWriter(Main_Socket.getOutputStream());
			//OutputStream 객체를 인수로 받아 더 간편하게 스트림을 연결
			// Main_Socket.getOutputStream()		->		소켓의 출력스트림을 반환
			String Send_Massage; // 스트링의 메세지
			
			while(true) { // 무한 루프로 언제든지 전송가능
			
				Send_Massage = Buffered_Massage.readLine(); // BufferedReaderd 에서 입력받은 문자열 저장
															 // readLine() : BufferedReader의 메소드 한줄을 읽어 String으로 반환
				
				Send_Writer.println(Send_Massage); //  버퍼에 저장된 입력 받은 값 출력
				Send_Writer.flush(); // 버퍼 flush
			}
			
		
		}catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	public void setMain_Socket(Socket Socket) {
		Main_Socket = Socket;  // 메인으로 부터 소켓을 받기위한 Setta
	}

}
