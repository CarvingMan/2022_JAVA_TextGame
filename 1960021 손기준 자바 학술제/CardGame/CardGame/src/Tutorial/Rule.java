package Tutorial;

import java.util.concurrent.TimeUnit;  // 시간차 출력을 위한 클래스

import InGame.InGame_Print;  // 화면 넘기기 메소드(Clean)를 사용하기위해 ㅑㅡㅔㅐㄳ
import java.util.Scanner;
;
public class Rule {
	
	public static Scanner Back = new Scanner(System.in); // 아무키나 입력받아 메인 타이틀로 가기위한 스캐너
	public static String goTitle;
	public static String goInfo;
	public static void Print_Rule() { //게임 룰을 설명하기 위한 메소드
	InGame_Print.Clean();
	System.out.println("\t\t\t게임 규칙!!!");
	System.out.println();
	System.out.println("\t경찰, 마피아, 퇴역군인, 킬러 중 한 명을 선택한다. 선택한 캐릭터와 상대가 카드를 내며 전투한다.");
	System.out.println();
	System.out.println("\t카드를 한 장 씩(공격, 엄폐, 특수능력) 내어 체력이 많거나 모두 닳게 하면 게임에서 승리한다.");
	System.out.println();
	System.out.println("\t게임은 10 턴으로 구성되어 있고 그 전에 체력이 0이 될시 게임은 바로 끝난다.");
	System.out.println();
	System.out.println("\t카드는 (주, 보조)무기, 엄폐, 특수카드 총 4 종류로 구성되어 있다.");
	System.out.println();
	System.out.println("\t주, 보조무기는 각 케릭터 마다 데미지 및 명중률이 다르다.(빗나가거나 상대가 엄폐나 특수공격할 수 있다.)");
	System.out.println();
	System.out.println("\t엄폐카드는 케릭터마다 성공 확률이 존재하며 특수카드에 무력화 될 수 있다.");
	System.out.println();
	System.out.println("\t특수카드는 모든 케릭터가 1장씩 만을 가지며 각 효과와 발동조건은 케릭터 마다 다르다.");
	System.out.println();
	System.out.print("\t아무 키나 입력하시면 메인 화면으로 되돌아 갑니다.");
	goTitle = Back.next(); // 입력시 메인화면으로 이동
} 


	public static void P_Info_Print(){ // 경찰 정보를 출력하는 메소드
		InGame_Print.Clean();
		System.out.println();
		System.out.println("\t1. 경찰");
		System.out.println();
		System.out.println();
		System.out.println("\t체력 : 8+2(방탄조끼)");
		System.out.println();
		System.out.println("\t무기 : 레밍턴870(주무기) 2장 - 데미지 3, 명중률 : 60%");
		System.out.println("\t\t글록17(보조무기) 6장 - 데미지 1, 명중률 :70%");
		System.out.println();
		System.out.println("\t엄폐 : 3장\t성공확률 : 70%");
		System.out.println();
		System.out.println("\t특수 카드 진압 : 진압방패와 함께 전진한다. 데미지 1 피해를 준다.");
		System.out.println(" \t\t\t조건 - 상대가 엄폐카드를 사용하여 엄폐에 성공했을시 발동\r\n"
				+ "         엄폐에 실패하거나 다른 카드 사용시 발동하지 않는다.");
		System.out.println();
		System.out.println("\t한줄평 : 경찰은 많은 체력과 높은 데미지의 주무기로 안정적인 플레이가 가능하다.");
		System.out.println();
		
		System.out.print("\t아무 키나 입력하시면 이전 화면으로 되돌아 갑니다.");
		goInfo = Back.next(); // 입력시 이전화면으로 이동
	}
	
	public static void M_Info_Print() {  // 마피아 정보를 출력
		InGame_Print.Clean();
		System.out.println("\t2. 마피아");
		System.out.println();
		System.out.println();
		System.out.println("\t체력 : 8");
		System.out.println();
		System.out.println("\t무기 : 토미건(주무기) 4장 - 데미지 2, 명중률 : 60%");
		System.out.println("\t\tM36리볼버(보조무기)4장 - 데미지 1, 명중률 :60%");
		System.out.println();
		System.out.println("\t엄폐 : 3장\t성공확률 : 70%");
		System.out.println();
		System.out.println("\t 특수 카드 전면돌파 : 전면 돌파하여 상대의 사격에 맞대응한다. 데미지 2 피해를 준다..");
		System.out.println(" \t\t\t조건 - 상대가 주무기 카드를 사용하여  명중 했을 시 발동\r\n"
				+ "		  명중에 실패하거나 다른 카드 사용시 발동하지 않는다.");
		System.out.println();
		System.out.println("\t한줄평 : 마피아는 공격수단이 많다는 장점이 있지만 확률이 높지않다.");
		
		System.out.println();
		System.out.print("\t아무 키나 입력하시면 이전 화면으로 되돌아 갑니다.");
		goInfo = Back.next(); // 입력시 이전화면으로 이동
	}
	
	public static void R_Info_Print() { // 퇴역 군인 정보를 출력		
		InGame_Print.Clean();
		System.out.println("\t3. 퇴역군인");
		System.out.println();
		System.out.println();
		System.out.println("\t체력 : 8");
		System.out.println();
		System.out.println("\t무기 : AR15(주무기) 3장 - 데미지 2, 명중률 : 70%");
		System.out.println("\t\t베레타92(보조무기)5장 - 데미지 1, 명중률 :70%");
		System.out.println();
		System.out.println("\t엄폐 : 3장\t성공확률 : 70%");
		System.out.println();
		System.out.println("\t특수 카드 각성제: 숨겨놨던 군용 각성제를 복용 한다. 체력+1.");
		System.out.println(" \t\t\t조건 - 상대의 공격에 명중만 안할 시 발동\r\n"
				+ "		                                     상대의 공격이 명중 할 시 발동하지 않는다.");
		System.out.println();
		System.out.println("\t한줄평 : 퇴역군인은 오래쌓인 실전 경험으로 명중률이 높고 위기상황에 응급치료가 가능하다.");
		
		
		System.out.println();
		System.out.print("\t아무 키나 입력하시면 이전 화면으로 되돌아 갑니다.");
		goInfo = Back.next(); // 입력시 이전화면으로 이동
	}
	
	public static void K_Info_Print() { // 킬러 정보를 출력
		InGame_Print.Clean();
		System.out.println("\t4. 킬러");
		System.out.println();
		System.out.println();
		System.out.println("\t체력 : 6");
		System.out.println();
		System.out.println("\t무기 : m24(주무기) 1장 - 데미지 5, 명중률 : 80%");
		System.out.println("\t\t데저트 이글(보조무기)5장 - 데미지 2, 명중률 :50%");
		System.out.println();
		System.out.println("\t엄폐 : 3장\t성공확률 : 80%");
		System.out.println();
		System.out.println("\t특수 카드 카운터 : 날카로운 눈으로 상대의 특수카드에 반격한다. 데미지 3 피해를 준다.");
		System.out.println(" \t\t\t조건 - 상대가 특수 카드를 선택 했을 시 발동\r\n"
				+ "		                                    다만 상대의 특수카드의 조건이 맞을시 상대의 특수카드 또한 발동한다.");
		System.out.println();
		System.out.println("\t한줄평 :킬러는 주무기의 데미지와 명중률이 가장 높지만 체력이6이라는 불이익을 가지고 있다.");
		System.out.println();
		System.out.print("\t아무 키나 입력하시면 이전 화면으로 되돌아 갑니다.");
		goInfo = Back.next(); // 입력시 이전화면으로 이동
	}
	
	
	public static void Print_Info() {
	
			int Select;
			while(true) {
				InGame_Print.Clean();
				System.out.println("\t캐릭터 설명");
				System.out.println();
				System.out.println();
				System.out.println("\t정보를 보고싶은 캐릭터의 번호를 입력하세요 ");
				System.out.println();
				System.out.println();
				System.out.println("\t1.경찰\t\t\t2.마피아");
				System.out.println();
				System.out.println("\t3.퇴역군인\t\t4.킬러");
				System.out.println();
				System.out.println("\t5.이전 화면");
				System.out.println();
				System.out.println();
				System.out.print("\t\t\t입력 :\t");
				Select = Back.nextInt();
				
				if(Select == 1) {
					P_Info_Print(); // 경찰 정보 출력 메소드
					continue; // 아무키나 입력시 이전 화면때문에 반복
				}
				else if(Select == 2) {
					M_Info_Print(); // 마피아 정보 출력 메소드
					continue; // 아무키나 입력시 이전 화면때문에 반복
				}
				else if(Select == 3) {
					R_Info_Print(); //  정보 출력 메소드
					continue; // 아무키나 입력시 이전 화면때문에 반복
				}
				else if(Select == 4) {
					K_Info_Print(); // 킬러 정보 출력 메소드
					continue; // 아무키나 입력시 이전 화면때문에 반복
				}
				else if(Select == 5) {
					try{
					InGame_Print.Clean();
					System.out.println("\t\t 메인 화면으로 돌아갑니다.");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}
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
					continue;
				}
				
			}
			
		}
		
	}
	


