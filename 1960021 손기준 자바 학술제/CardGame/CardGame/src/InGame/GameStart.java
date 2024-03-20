package InGame;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class GameStart {
	
	
	public static Scanner input = new Scanner(System.in);
	
	public static int Select_W; // 입력받을 전사 선택
	
	
	
	
	public static void TotalStart() { // 총 게임 시작
		
	   while(true) { 				// 무한 반복문으로 잘못입력시 다시 입력한다.
		   InGame_Print.Clean();
		   InGame_Print.SelectWarrior();
		   Select_W = input.nextInt();	
	   if(Select_W == 1) {  // 1번 선택시
		   Police_Start.P_Start(); // 플레이어가 경찰인 게임 시작
		   break; // 경찰 게임 끝나고 반복문 탈출
	   }
	   else  if(Select_W == 2) {  // 2번 선택시
		   Mafia_Start.M_Start();  // 마피아 게임 시작
		   break; 
	   }
	   else  if(Select_W == 3) {  // 3번 선택시
		   R_Soldier_Start.R_Start(); // 퇴역군인 게임시자
		   break; 
	   }
	   else  if(Select_W == 4) {  // 4번 선택시
		   Killer_Start.K_Start();  // 킬러 게임 시작
		   
		   break; 
	   }
	   else {
		   InGame_Print.Clean();
			System.out.println("\t\t\t 잘못 입력 하였습니다. 다시 입력하세요");
			System.out.println("\n\n\n\n\n\n\n\n");
			try {
			TimeUnit.SECONDS.sleep(1);
			}catch(Exception e) {
	            System.out.println(e.getMessage());
							}
		   continue;  // 잘못 입력했을 시 재입력
	   }
	   }
		
		
	}
        
        
        
	       
	public static void main(String[] args) throws Exception{
	
	
			GameStart.TotalStart(); // 테스트 실행
   
    }
}
