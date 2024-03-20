package InGame;



import java.util.concurrent.TimeUnit;  // 시간차 출력을 위한 클래스

public class InGame_Print  {

public static void Clean() {  // 콘솔창을 깔끔하게 넘겨 준다.
	for (int i = 0; i < 80; i++) {
	      System.out.println("");
	      }
		
}


public static void SelectWarrior() {
		
		System.out.println("\t게임을 시작합니다.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t원하는 전사의 번호를 입력 하세요");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t1. 경찰\t\t2. 마피아\n\t3. 퇴역군인 \t4. 킬러");
		System.out.println();
		System.out.println();
		System.out.print("\t\t\t\t입력	:	");
		
}

public static void Selected_P(){ // 경찰을 선택하였을시 
	InGame_Print.Clean();
	
	System.out.print("\t\t당신은 경찰입니다. \n\n\t\t상대는 ");
	if(Police_Start.computer == 1) {
		System.out.print("경찰입니다.");
	}
	else if(Police_Start.computer == 2) {
		System.out.print("마피아입니다.");
	}
	else if(Police_Start.computer == 3) {
		System.out.print("퇴역군인입니다.");
	}
	else {
		System.out.print("킬러 입니다.");
	}
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
try {
		TimeUnit.SECONDS.sleep(3);
		InGame_Print.Clean();
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}
	InGame_Print.CountDown();
}


public static void Selected_M(){ // 마피아를 선택하였을시 
	InGame_Print.Clean();
	
	System.out.print("\t\t당신은 마피아입니다. \n\n\t\t상대는 ");
	if(Mafia_Start.computer == 1) {
		System.out.print("경찰입니다.");
	}
	else if(Mafia_Start.computer == 2) {
		System.out.print("마피아입니다.");
	}
	else if(Mafia_Start.computer == 3) {
		System.out.print("퇴역군인입니다.");
	}
	else {
		System.out.print("킬러 입니다.");
	}
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
try {
		TimeUnit.SECONDS.sleep(3);
		InGame_Print.Clean();
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}
	InGame_Print.CountDown();
}



public static void Selected_R(){ // 퇴역군인을 선택하였을시 
	InGame_Print.Clean();
	
	System.out.print("\t\t당신은 퇴역군인 입니다. \n\n\t\t상대는 ");
	if(R_Soldier_Start.computer == 1) {
		System.out.print("경찰입니다.");
	}
	else if(R_Soldier_Start.computer == 2) {
		System.out.print("마피아입니다.");
	}
	else if(R_Soldier_Start.computer == 3) {
		System.out.print("퇴역군인입니다.");
	}
	else {
		System.out.print("킬러 입니다.");
	}
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
try {
		TimeUnit.SECONDS.sleep(3);
		InGame_Print.Clean();
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}
	InGame_Print.CountDown();
}

public static void Selected_K(){ // 킬러를 선택하였을시 
	InGame_Print.Clean();
	
	System.out.print("\t\t당신은 킬러입니다. \n\n\t\t상대는 ");
	if(Killer_Start.computer == 1) {
		System.out.print("경찰입니다.");
	}
	else if(Killer_Start.computer == 2) {
		System.out.print("마피아입니다.");
	}
	else if(Killer_Start.computer == 3) {
		System.out.print("퇴역군인입니다.");
	}
	else {
		System.out.print("킬러 입니다.");
	}
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
try {
		TimeUnit.SECONDS.sleep(3);
		InGame_Print.Clean();
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}
	InGame_Print.CountDown();
}



public static void CountDown() {  // 게임이 시작시 카운트 다운 한다.
	
	for(int i = 3; i >= 1 ; i--) {
		InGame_Print.Clean();
		try {
			
		
		System.out.println("\t\t게임이 시작합니다. 준비하세요\n");
		System.out.println("\t\t\t\t"+i+"\n\n\n\n\n\n\n");
		TimeUnit.SECONDS.sleep(1);
		
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}		
	}
}


// 카드 선택후 메세지
public static void Print_C_Select() {
	InGame_Print.Clean();
	try {
		
	
	System.out.println("\t\t카드 선택이 완료 되었습니다.\n");
	System.out.println("\n\n\n\n\n\n\n");
	TimeUnit.SECONDS.sleep(1);
	InGame_Print.Clean();
	System.out.println("\t\t\t\t\tFight !!!!!!\n");
	System.out.println("\n\n\n\n\n\n\n");
	TimeUnit.SECONDS.sleep(2);
	
	}catch(Exception e) {
        System.out.println(e.getMessage());
					}		
}

// 다음 턴 출력 함수
public static void Next_Turn_Print() {
	for(int i = 3; i >= 1 ; i--) {
		InGame_Print.Clean();
		try {
			
		
		System.out.println("\t\t다음 턴이 시작 됩니다.\n");
		System.out.println("\t\t\t\t"+i+"\n\n\n\n\n\n\n");
		TimeUnit.SECONDS.sleep(1);
		
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}		
	}
}




}
