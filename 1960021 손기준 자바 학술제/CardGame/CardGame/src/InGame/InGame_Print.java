package InGame;



import java.util.concurrent.TimeUnit;  // �ð��� ����� ���� Ŭ����

public class InGame_Print  {

public static void Clean() {  // �ܼ�â�� ����ϰ� �Ѱ� �ش�.
	for (int i = 0; i < 80; i++) {
	      System.out.println("");
	      }
		
}


public static void SelectWarrior() {
		
		System.out.println("\t������ �����մϴ�.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t���ϴ� ������ ��ȣ�� �Է� �ϼ���");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t1. ����\t\t2. ���Ǿ�\n\t3. �𿪱��� \t4. ų��");
		System.out.println();
		System.out.println();
		System.out.print("\t\t\t\t�Է�	:	");
		
}

public static void Selected_P(){ // ������ �����Ͽ����� 
	InGame_Print.Clean();
	
	System.out.print("\t\t����� �����Դϴ�. \n\n\t\t���� ");
	if(Police_Start.computer == 1) {
		System.out.print("�����Դϴ�.");
	}
	else if(Police_Start.computer == 2) {
		System.out.print("���Ǿ��Դϴ�.");
	}
	else if(Police_Start.computer == 3) {
		System.out.print("�𿪱����Դϴ�.");
	}
	else {
		System.out.print("ų�� �Դϴ�.");
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


public static void Selected_M(){ // ���ǾƸ� �����Ͽ����� 
	InGame_Print.Clean();
	
	System.out.print("\t\t����� ���Ǿ��Դϴ�. \n\n\t\t���� ");
	if(Mafia_Start.computer == 1) {
		System.out.print("�����Դϴ�.");
	}
	else if(Mafia_Start.computer == 2) {
		System.out.print("���Ǿ��Դϴ�.");
	}
	else if(Mafia_Start.computer == 3) {
		System.out.print("�𿪱����Դϴ�.");
	}
	else {
		System.out.print("ų�� �Դϴ�.");
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



public static void Selected_R(){ // �𿪱����� �����Ͽ����� 
	InGame_Print.Clean();
	
	System.out.print("\t\t����� �𿪱��� �Դϴ�. \n\n\t\t���� ");
	if(R_Soldier_Start.computer == 1) {
		System.out.print("�����Դϴ�.");
	}
	else if(R_Soldier_Start.computer == 2) {
		System.out.print("���Ǿ��Դϴ�.");
	}
	else if(R_Soldier_Start.computer == 3) {
		System.out.print("�𿪱����Դϴ�.");
	}
	else {
		System.out.print("ų�� �Դϴ�.");
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

public static void Selected_K(){ // ų���� �����Ͽ����� 
	InGame_Print.Clean();
	
	System.out.print("\t\t����� ų���Դϴ�. \n\n\t\t���� ");
	if(Killer_Start.computer == 1) {
		System.out.print("�����Դϴ�.");
	}
	else if(Killer_Start.computer == 2) {
		System.out.print("���Ǿ��Դϴ�.");
	}
	else if(Killer_Start.computer == 3) {
		System.out.print("�𿪱����Դϴ�.");
	}
	else {
		System.out.print("ų�� �Դϴ�.");
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



public static void CountDown() {  // ������ ���۽� ī��Ʈ �ٿ� �Ѵ�.
	
	for(int i = 3; i >= 1 ; i--) {
		InGame_Print.Clean();
		try {
			
		
		System.out.println("\t\t������ �����մϴ�. �غ��ϼ���\n");
		System.out.println("\t\t\t\t"+i+"\n\n\n\n\n\n\n");
		TimeUnit.SECONDS.sleep(1);
		
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}		
	}
}


// ī�� ������ �޼���
public static void Print_C_Select() {
	InGame_Print.Clean();
	try {
		
	
	System.out.println("\t\tī�� ������ �Ϸ� �Ǿ����ϴ�.\n");
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

// ���� �� ��� �Լ�
public static void Next_Turn_Print() {
	for(int i = 3; i >= 1 ; i--) {
		InGame_Print.Clean();
		try {
			
		
		System.out.println("\t\t���� ���� ���� �˴ϴ�.\n");
		System.out.println("\t\t\t\t"+i+"\n\n\n\n\n\n\n");
		TimeUnit.SECONDS.sleep(1);
		
		}catch(Exception e) {
            System.out.println(e.getMessage());
						}		
	}
}




}
