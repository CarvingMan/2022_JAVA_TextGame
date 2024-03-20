package InGame;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Character.*;
/*
 플레이어가 마피아를 선택했을시 게임 메소드를 담고 있는 클래스 
 */
public class Mafia_Start {
	public static int P_Life; // 플레이어 체력
	public static int C_Life; // 컴퓨터 체력
	
	public static Scanner input = new Scanner(System.in);
	public static int turn = 10; // 게임 턴 수
	public static int computer = 0; // 컴퓨터
	
	public static int Select_W; // 입력받을 전사 선택
	public static int P_Select_Card; // 선택할 카드  
	public static int C_Select_Card ;// 컴퓨터 선택 카드 
	
	// 플레이어
		public static int P_Rest_G = 0;      // 남은 주 무기 카드
		public static int P_Rest_P = 0;      // 남은 보조 무기 카드 
		public static int P_Rest_C = 0;     //  남은 엄폐 카드 
		public static int P_Rest_U = 1;    //   남은 유니크 카드 - 공통으로 1장이다.
		
		//컴퓨터
		public static int C_Rest_G = 0;      // 남은 주 무기 카드
		public static int C_Rest_P = 0;      // 남은 보조 무기 카드 
		public static int C_Rest_C = 0;     //  남은 엄폐 카드 
		public static int C_Rest_U = 1;    //   남은 유니크 카드 - 공통으로 1장이다.
		
		
		
		// 시작 메소드
		public static void M_Start() { // 마피아를 선택 할 시 시작
			Mafia Player = new Mafia(); //플레이어 객체 생성
			P_Life = Player.getLife();  // 퇴역 군인 체력 저장
			
			P_Rest_G = Player.getG_Card();  // 남은 카드 초기값을 getta 함수로 저장
			P_Rest_P = Player.getP_Card();
			P_Rest_C = Player.getC_Card();
			
			
			Random random = new Random();
			computer = random.nextInt(4)+1; // 1~4 확률로 컴퓨터가 전사를 선택
			if(computer == 1) {
				Police Com = new Police(); // 컴퓨터 
				C_Life = Com.getLife();  // 컴퓨터 체력 저장
				
				C_Rest_G = Com.getG_Card();  // 남은 카드 초기값을 getta 함수로 저장
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // 화면 전환
				InGame_Print.Selected_M(); // 선택된 화면 출력 함수
				for(int i = 1; i <= turn; i++) {
					if((C_Life <=0 )|| (P_Life <= 0)) {   // 체력이 0보다 작거나 같을 시 바로 게임종료
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"번째 턴\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t이번 턴에 내실 카드의 번호를 입력 하세요");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t데미지 : "+Player.getG_Damage()
																	+"\t명중률"+Player.getG_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t데미지 : "+Player.getP_Damage()
																	+"\t명중률"+Player.getP_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  엄폐 \t\t\t확률 : "+Player.getCover_P()+"0%\t남은 장 수 : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t남은 장 수 : "+P_Rest_U);
							System.out.println();
							System.out.println("\t상대 체력 :\t" +C_Life);
							System.out.println("\t당신 체력 :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t입력 : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_G--;
										Player.Shot_Gun();
										break;
										}
								}
								else if(P_Select_Card == 2) {  
									if(P_Rest_P == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_P--;
										Player.Shot_Pistol();
										break;
										}
								}
								else if(P_Select_Card == 3) {  
									if(P_Rest_C == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_C--;
											Player.Cover();
											break;
										}
								}
								else if(P_Select_Card == 4) {  
									if(P_Rest_U == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_U--;
											Player.Selected_Unique = true;
											break;
										}
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
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // 컴퓨터도 카드 선택	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Gun();
									break;
								}
							}
							else if(C_Select_Card == 2)
							{
								if(C_Rest_P == 0) {
									continue;
								}
								else {
									C_Rest_P --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Pistol();
									break;
								}
							}
							else if(C_Select_Card == 3)
							{
								if(C_Rest_C == 0) {
									continue;
								}
								else {
									C_Rest_C --;  // 컴퓨터 카드 한장 소모
									Com.Cover();
									break;
								}
							}
							else if(C_Select_Card == 4)
							{
								if(C_Rest_U == 0) {
									continue;
								}
								else{
									C_Rest_U --;  // 컴퓨터 카드 한장 소모
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // 컴퓨터 카드 선택 완료
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// 서로 선택한 카드에 따라 결과 연산
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // 유니트 성공시 유니크 데미지 만큼 상대 체력 감소
								}
								// 둘다 유니크를 냈는데 성공하는 경우는 킬러 밖에 없다.
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									P_Life -= Com.getU_Damage(); 
									}
							}
							else if(Player.Selected_Unique == true && Com.Selected_Unique == false) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   
								}	
								else {
										if(Com.Hit_Gun == true) {
											P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
							else if(Player.Selected_Unique == false && Com.Selected_Unique == true) {
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									P_Life -= Com.getU_Damage(); 
									}
								else {
									if(Player.Hit_Gun == true) {
										C_Life -= Player.getG_Damage(); // 플레이어 체력 감소
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // 아무도 특수 카드를 안 냈을시
							  if(Com.Success_Cover ==false) {  // 상대가 엄폐를 실패하거나 안 냈을 시
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // 플레이어가 엄폐에 실패하거나 안 냈을시 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
									}
							  }
						  
						  }
							
						///플레이어 턴 결과
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t 당신의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t데미지 "+Player.getG_Damage() 
										+",\t명중률"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("명중 !! 상대에게 "+Player.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "데미지 "+Player.getP_Damage()
										+",\t명중률"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("명중 !! 상대에게 "+Player.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 상대의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("성공! 상대에게 "+Player.getU_Damage()+"데미지를 입혔습니다.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("실패하였습니다.");
								}
							}
							
							//// 컴퓨터 턴 결과
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t 상대의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t데미지 "+Com.getG_Damage() 
										+",\t명중률"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "데미지 "+Com.getP_Damage()
										+",\t명중률"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 당신의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("성공! 당신에게 "+Com.getU_Damage()+"데미지를 입혔습니다.");
								}
								else {
									System.out.println("실패하였습니다.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("상대의 체력 : "+C_Life);
							System.out.println("당신의 체력 : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// 턴종료		
							Player.Refresh(); // 성공 초기값 초기화
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // 체력이 0 이하일 시 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//게임결과
				InGame_Print.Clean();
				try {
					System.out.println("\t\t결투를 완료 했습니다.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t결과\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t이 결투는 무승부로 끝이 났습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t당신(마피아)은 이 결투에서 승리했습니다!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t당신(마피아)은 이 결투에서 패배 했습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
				
			}
			else if(computer == 2) {
				Mafia Com = new Mafia(); // 컴퓨터 
				C_Life = Com.getLife();  // 컴퓨터 체력 저장
				
				C_Rest_G = Com.getG_Card();  // 남은 카드 초기값을 getta 함수로 저장
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // 화면 전환
				InGame_Print.Selected_M(); // 선택된 화면 출력 함수
				for(int i = 1; i <= turn; i++) {
					if((C_Life <=0 )|| (P_Life <= 0)) {   // 체력이 0보다 작거나 같을 시 바로 게임종료
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"번째 턴\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t이번 턴에 내실 카드의 번호를 입력 하세요");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t데미지 : "+Player.getG_Damage()
																	+"\t명중률"+Player.getG_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t데미지 : "+Player.getP_Damage()
																	+"\t명중률"+Player.getP_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  엄폐 \t\t\t확률 : "+Player.getCover_P()+"0%\t남은 장 수 : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t남은 장 수 : "+P_Rest_U);
							System.out.println();
							System.out.println("\t상대 체력 :\t" +C_Life);
							System.out.println("\t당신 체력 :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t입력 : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_G--;
										Player.Shot_Gun();
										break;
										}
								}
								else if(P_Select_Card == 2) {  
									if(P_Rest_P == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_P--;
										Player.Shot_Pistol();
										break;
										}
								}
								else if(P_Select_Card == 3) {  
									if(P_Rest_C == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_C--;
											Player.Cover();
											break;
										}
								}
								else if(P_Select_Card == 4) {  
									if(P_Rest_U == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_U--;
											Player.Selected_Unique = true;
											break;
										}
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
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // 컴퓨터도 카드 선택	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Gun();
									break;
								}
							}
							else if(C_Select_Card == 2)
							{
								if(C_Rest_P == 0) {
									continue;
								}
								else {
									C_Rest_P --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Pistol();
									break;
								}
							}
							else if(C_Select_Card == 3)
							{
								if(C_Rest_C == 0) {
									continue;
								}
								else {
									C_Rest_C --;  // 컴퓨터 카드 한장 소모
									Com.Cover();
									break;
								}
							}
							else if(C_Select_Card == 4)
							{
								if(C_Rest_U == 0) {
									continue;
								}
								else{
									C_Rest_U --;  // 컴퓨터 카드 한장 소모
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // 컴퓨터 카드 선택 완료
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// 서로 선택한 카드에 따라 결과 연산
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // 유니트 성공시 유니크 데미지 만큼 상대 체력 감소
								}
								// 둘다 유니크를 냈는데 성공하는 경우는 킬러 밖에 없다.
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									P_Life -= Com.getU_Damage(); 
									}
							}
							else if(Player.Selected_Unique == true && Com.Selected_Unique == false) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   
								}	
								else {
										if(Com.Hit_Gun == true) {
											P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
							else if(Player.Selected_Unique == false && Com.Selected_Unique == true) {
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									P_Life -= Com.getU_Damage(); 
									}
								else {
									if(Player.Hit_Gun == true) {
										C_Life -= Player.getG_Damage(); // 플레이어 체력 감소
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // 아무도 특수 카드를 안 냈을시
							  if(Com.Success_Cover ==false) {  // 상대가 엄폐를 실패하거나 안 냈을 시
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // 플레이어가 엄폐에 실패하거나 안 냈을시 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
									}
							  }
						  
						  }
							
						///플레이어 턴 결과
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t 당신의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t데미지 "+Player.getG_Damage() 
										+",\t명중률"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("명중 !! 상대에게 "+Player.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "데미지 "+Player.getP_Damage()
										+",\t명중률"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("명중 !! 상대에게 "+Player.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 상대의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("성공! 상대에게 "+Player.getU_Damage()+"데미지를 입혔습니다.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("실패하였습니다.");
								}
							}
							
							//// 컴퓨터 턴 결과
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t 상대의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t데미지 "+Com.getG_Damage() 
										+",\t명중률"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "데미지 "+Com.getP_Damage()
										+",\t명중률"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 당신의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("성공! 당신에게 "+Com.getU_Damage()+"데미지를 입혔습니다.");
								}
								else {
									System.out.println("실패하였습니다.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("상대의 체력 : "+C_Life);
							System.out.println("당신의 체력 : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// 턴종료		
							Player.Refresh(); // 성공 초기값 초기화
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // 체력이 0 이하일 시 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//게임결과
				InGame_Print.Clean();
				try {
					System.out.println("\t\t결투를 완료 했습니다.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t결과\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t이 결투는 무승부로 끝이 났습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t당신(마피아)은 이 결투에서 승리했습니다!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t당신(마피아)은 이 결투에서 패배 했습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
			}
			else if(computer == 3) {  // 컴퓨터가 퇴역 군인일때
				Retired_Soldier Com = new Retired_Soldier(); // 컴퓨터 
				C_Life = Com.getLife();  // 컴퓨터 체력 저장
				
				C_Rest_G = Com.getG_Card();  // 남은 카드 초기값을 getta 함수로 저장
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // 화면 전환
				InGame_Print.Selected_M(); // 선택된 화면 출력 함수
				for(int i = 1; i <= turn; i++) {
					if((C_Life <= 0 )|| (P_Life <= 0)) {   // 체력이 0보다 작거나 같을 시 바로 게임종료
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"번째 턴\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t이번 턴에 내실 카드의 번호를 입력 하세요");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t데미지 : "+Player.getG_Damage()
																	+"\t명중률"+Player.getG_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t데미지 : "+Player.getP_Damage()
																	+"\t명중률"+Player.getP_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  엄폐 \t\t\t확률 : "+Player.getCover_P()+"0%\t남은 장 수 : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t남은 장 수 : "+P_Rest_U);
							System.out.println();
							System.out.println("\t상대 체력 :\t" +C_Life);
							System.out.println("\t당신 체력 :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t입력 : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_G--;
										Player.Shot_Gun();
										break;
										}
								}
								else if(P_Select_Card == 2) {  
									if(P_Rest_P == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_P--;
										Player.Shot_Pistol();
										break;
										}
								}
								else if(P_Select_Card == 3) {  
									if(P_Rest_C == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_C--;
											Player.Cover();
											break;
										}
								}
								else if(P_Select_Card == 4) {  
									if(P_Rest_U == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_U--;
											Player.Selected_Unique = true;
											break;
										}
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
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // 컴퓨터도 카드 선택	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Gun();
									break;
								}
							}
							else if(C_Select_Card == 2)
							{
								if(C_Rest_P == 0) {
									continue;
								}
								else {
									C_Rest_P --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Pistol();
									break;
								}
							}
							else if(C_Select_Card == 3)
							{
								if(C_Rest_C == 0) {
									continue;
								}
								else {
									C_Rest_C --;  // 컴퓨터 카드 한장 소모
									Com.Cover();
									break;
								}
							}
							else if(C_Select_Card == 4)
							{
								if(C_Rest_U == 0) {
									continue;
								}
								else{
									C_Rest_U --;  // 컴퓨터 카드 한장 소모
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // 컴퓨터 카드 선택 완료
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// 서로 선택한 카드에 따라 결과 연산
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // 유니트 성공시 유니크 데미지 만큼 상대 체력 감소
								}
								// 둘다 유니크를 냈는데 성공하는 경우는 킬러 밖에 없다.
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									C_Life ++; 
									}
							}
							else if(Player.Selected_Unique == true && Com.Selected_Unique == false) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   
								}	
								else {
										if(Com.Hit_Gun == true) {
											P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
							else if(Player.Selected_Unique == false && Com.Selected_Unique == true) {
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									C_Life ++; 
									}
								else {
									if(Player.Hit_Gun == true) {
										C_Life -= Player.getG_Damage(); // 플레이어 체력 감소
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // 아무도 특수 카드를 안 냈을시
							  if(Com.Success_Cover ==false) {  // 상대가 엄폐를 실패하거나 안 냈을 시
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // 플레이어가 엄폐에 실패하거나 안 냈을시 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
									}
							  }
						  
						  }
							
						///플레이어 턴 결과
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t 당신의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t데미지 "+Player.getG_Damage() 
										+",\t명중률"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("명중 !! 상대에게 "+Player.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "데미지 "+Player.getP_Damage()
										+",\t명중률"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("명중 !! 상대에게 "+Player.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 상대의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("성공! 상대에게 "+Player.getU_Damage()+"데미지를 입혔습니다.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("실패하였습니다.");
								}
							}
							
							//// 컴퓨터 턴 결과
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t 상대의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t데미지 "+Com.getG_Damage() 
										+",\t명중률"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "데미지 "+Com.getP_Damage()
										+",\t명중률"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 당신의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("성공!  체력을 1 회복 합니다.");
								}
								else {
									System.out.println("실패하였습니다.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("상대의 체력 : "+C_Life);
							System.out.println("당신의 체력 : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// 턴종료		
							Player.Refresh(); // 성공 초기값 초기화
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // 체력이 0 이하일 시 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//게임결과
				InGame_Print.Clean();
				try {
					System.out.println("\t\t결투를 완료 했습니다.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t결과\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t이 결투는 무승부로 끝이 났습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t당신(마피아)은 이 결투에서 승리했습니다!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t당신(마피아)은 이 결투에서 패배 했습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
			}
			else if(computer == 4) {
				Killer Com = new Killer(); // 컴퓨터 
				C_Life = Com.getLife();  // 컴퓨터 체력 저장
				
				C_Rest_G = Com.getG_Card();  // 남은 카드 초기값을 getta 함수로 저장
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // 화면 전환
				InGame_Print.Selected_M(); // 선택된 화면 출력 함수
				for(int i = 1; i <= turn; i++) {
					if((C_Life <=0 )|| (P_Life <= 0)) {   // 체력이 0보다 작거나 같을 시 바로 게임종료
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"번째 턴\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t이번 턴에 내실 카드의 번호를 입력 하세요");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t데미지 : "+Player.getG_Damage()
																	+"\t명중률"+Player.getG_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t데미지 : "+Player.getP_Damage()
																	+"\t명중률"+Player.getP_Hit_P()+"0%"+"\t남은 장 수 : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  엄폐 \t\t\t확률 : "+Player.getCover_P()+"0%\t남은 장 수 : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t남은 장 수 : "+P_Rest_U);
							System.out.println();
							System.out.println("\t상대 체력 :\t" +C_Life);
							System.out.println("\t당신 체력 :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t입력 : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_G--;
										Player.Shot_Gun();
										break;
										}
								}
								else if(P_Select_Card == 2) {  
									if(P_Rest_P == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(2);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
										P_Rest_P--;
										Player.Shot_Pistol();
										break;
										}
								}
								else if(P_Select_Card == 3) {  
									if(P_Rest_C == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_C--;
											Player.Cover();
											break;
										}
								}
								else if(P_Select_Card == 4) {  
									if(P_Rest_U == 0) {  // 남은 카드가 없을시
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t 남은 카드가 없습니다. 다시 입력하세요");
											System.out.println("\n\n\n\n\n\n\n\n");
											TimeUnit.SECONDS.sleep(1);
											}catch(Exception e) {
									            System.out.println(e.getMessage());
															}
										
											continue;
										}
										else {
											P_Rest_U--;
											Player.Selected_Unique = true;
											break;
										}
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
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // 컴퓨터도 카드 선택	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Gun();
									break;
								}
							}
							else if(C_Select_Card == 2)
							{
								if(C_Rest_P == 0) {
									continue;
								}
								else {
									C_Rest_P --;  // 컴퓨터 카드 한장 소모
									Com.Shot_Pistol();
									break;
								}
							}
							else if(C_Select_Card == 3)
							{
								if(C_Rest_C == 0) {
									continue;
								}
								else {
									C_Rest_C --;  // 컴퓨터 카드 한장 소모
									Com.Cover();
									break;
								}
							}
							else if(C_Select_Card == 4)
							{
								if(C_Rest_U == 0) {
									continue;
								}
								else{
									C_Rest_U --;  // 컴퓨터 카드 한장 소모
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // 컴퓨터 카드 선택 완료
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// 서로 선택한 카드에 따라 결과 연산
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // 유니트 성공시 유니크 데미지 만큼 상대 체력 감소
								}
								// 둘다 유니크를 냈는데 성공하는 경우는 킬러 밖에 없다.
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									P_Life -= Com.getU_Damage(); 
									}
							}
							else if(Player.Selected_Unique == true && Com.Selected_Unique == false) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   
								}	
								else {
										if(Com.Hit_Gun == true) {
											P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
							else if(Player.Selected_Unique == false && Com.Selected_Unique == true) {
								Com.Uniqe_Card(Player.Hit_Gun, Player.Hit_Pistol, Player.Success_Cover, Player.Selected_Unique);
								if(Com.Success_Unique == true) {
									P_Life -= Com.getU_Damage(); 
									}
								else {
									if(Player.Hit_Gun == true) {
										C_Life -= Player.getG_Damage(); // 플레이어 체력 감소
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // 플레이어 체력 감소
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // 아무도 특수 카드를 안 냈을시
							  if(Com.Success_Cover ==false) {  // 상대가 엄폐를 실패하거나 안 냈을 시
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // 플레이어가 엄폐에 실패하거나 안 냈을시 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // 플레이어 체력 감소
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // 플레이어 체력 감소
									}
							  }
						  
						  }
							
						///플레이어 턴 결과
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t 당신의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t데미지 "+Player.getG_Damage() 
										+",\t명중률"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("명중 !! 상대에게 "+Player.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "데미지 "+Player.getP_Damage()
										+",\t명중률"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("명중했으나 상대의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("명중 !! 상대에게 "+Player.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 상대의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("성공! 상대에게 "+Player.getU_Damage()+"데미지를 입혔습니다.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("실패하였습니다.");
								}
							}
							
							//// 컴퓨터 턴 결과
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t 상대의 카드 : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t데미지 "+Com.getG_Damage() 
										+",\t명중률"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getG_Damage()+"데미지를 입혔습니다.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "데미지 "+Com.getP_Damage()
										+",\t명중률"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("명중했으나 당신의 카드로 효과가 무효처리 됐습니다.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("명중 !! 당신에게 "+Com.getP_Damage()+"데미지를 입혔습니다.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("공격이 빗나갔습니다.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("엄폐" +",\t성공률 : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("엄폐에 성공하였지만 당신의 특수 카드에 효과가 무력화 됩니다.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("엄폐에 성공 했습니다.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("엄폐에 실패 했습니다.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("특수카드 : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t결과 : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("성공! 당신에게 "+Com.getU_Damage()+"데미지를 입혔습니다.");
								}
								else {
									System.out.println("실패하였습니다.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("상대의 체력 : "+C_Life);
							System.out.println("당신의 체력 : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// 턴종료		
							Player.Refresh(); // 성공 초기값 초기화
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // 체력이 0 이하일 시 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//게임결과
				InGame_Print.Clean();
				try {
					System.out.println("\t\t결투를 완료 했습니다.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t결과\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t이 결투는 무승부로 끝이 났습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t당신(마피아)은 이 결투에서 승리했습니다!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t당신(마피아)은 이 결투에서 패배 했습니다!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
			}
		}
}

