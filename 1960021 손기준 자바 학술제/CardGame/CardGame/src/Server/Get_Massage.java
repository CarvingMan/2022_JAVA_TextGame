/*
   스레드를 상속받아 메세지를 보내는 송신 클래스 
 */
package Server;

import java.io.BufferedReader; // 버퍼에 입력받아 String으로 고정 - System.in을 사용하기 편하도록 만들기 위해 import
import java.io.IOException;  // 입출력 예외 처리를 하기위해 import
import java.io.InputStreamReader;  // char 형태로 입력할수 있다. 
import java.net.Socket; // 소켓사용


public class Get_Massage extends Thread{  //스레드 상속
private Socket Main_Socket; // 메인에서 Socket를 받기 위함

// 스레드 run메소드 오버라이딩
public void run() {
	super.run();
	
	try {
		BufferedReader Buffered_Massage = new BufferedReader(new InputStreamReader(Main_Socket.getInputStream()));
		//MainSocket의 InputStream값을 편하게 사용하기위해 Buffered Reader 로 변경
		
		String Get_Massage; // 수신 메세지
		
		while(true) { // 무한 반복으로 클라이언트가 종료를 원할시까지 반복
			Get_Massage = Buffered_Massage.readLine(); // 소켓에 입력된 데이터를 문자열 한줄을 반환
			
			if(Get_Massage == null) { // 받은 데이터가 null 일시 소켓연결이 끊어진 것 이기에 무한반복문 탈출
				System.out.println("\t클라이언트와 연결이 끊겼습니다.");
				break;
			}
			else
			{
				System.out.println("클라이언트	:	"+Get_Massage);
			}
		}
		
		Buffered_Massage.close();  // 연결 종료
	}catch(IOException e) {
			e.printStackTrace(); // 오류 발생시 Trace해준다.
		
	}
	
	
}

public void setMainSocket(Socket Socket) {	// 메인으로 부터 소켓을 받기위한 Setta
	Main_Socket = Socket;	
}


}