/*
 총 메인 메소드

 로그인
 튜토리얼, 게임시작, 채팅 등 모든 클레스의 메소드들을 실행한다
 채팅 선택시 클라이언트 소켓과 스래드 동작이 시작한다.
 */
package MainStart;

import Client.*; // 클라이언트 패키지의 스레드들을 전부 사용하기 위해 import

import java.net.Socket; // 소켓 사용
import java.net.SocketException;
import InGame.GameStart;  // 게임시작
import InGame.InGame_Print;
import Login.Login; // 로그인
import Tutorial.Rule; // 튜토리얼 

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mainStart {
	public static Scanner main_select = new Scanner (System.in);
	public static int Title;
	
	public static void PrintMain() {
		InGame_Print.Clean();
		System.out.println("\t\t\t\tHIT 메인화면!!!");
		System.out.println();
		System.out.println();
		System.out.println("\t원하시는 기능의 번호를 입력 해 주세요...");
		System.out.println();
		System.out.println();
		System.out.println("\t1. 게임설명\t\t\t2. 캐릭터설명");
		System.out.println();
		System.out.println("\t3. 게임시작\t\t\t4. 개발자와 채팅");
		System.out.println();
		System.out.println();
		System.out.print("\t\t\t입력 :\t");
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Login.Start();
		
		
		while(true) { // 무한 반복으로 종료를 원하지 않을시 메인 타이틀로 돌아간다.
		PrintMain();
		 Title =main_select.nextInt();  
		if(Title == 1) {
			Rule.Print_Rule(); // 룰 출력
			continue;   // 해당 클래스 아무키나 입력후 메인 타이틀로 돌아감
		}
		else if(Title == 2) {
			Rule.Print_Info(); // 캐릭터 정보 출력 
			continue;
		}
		else if(Title == 3) {
			GameStart.TotalStart(); // 카드 게임 시작
			continue;
		}
		else if(Title == 4) {
			
			InGame_Print.Clean();
			break;
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
