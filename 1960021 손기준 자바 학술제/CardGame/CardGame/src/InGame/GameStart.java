package InGame;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class GameStart {
	
	
	public static Scanner input = new Scanner(System.in);
	
	public static int Select_W; // �Է¹��� ���� ����
	
	
	
	
	public static void TotalStart() { // �� ���� ����
		
	   while(true) { 				// ���� �ݺ������� �߸��Է½� �ٽ� �Է��Ѵ�.
		   InGame_Print.Clean();
		   InGame_Print.SelectWarrior();
		   Select_W = input.nextInt();	
	   if(Select_W == 1) {  // 1�� ���ý�
		   Police_Start.P_Start(); // �÷��̾ ������ ���� ����
		   break; // ���� ���� ������ �ݺ��� Ż��
	   }
	   else  if(Select_W == 2) {  // 2�� ���ý�
		   Mafia_Start.M_Start();  // ���Ǿ� ���� ����
		   break; 
	   }
	   else  if(Select_W == 3) {  // 3�� ���ý�
		   R_Soldier_Start.R_Start(); // �𿪱��� ���ӽ���
		   break; 
	   }
	   else  if(Select_W == 4) {  // 4�� ���ý�
		   Killer_Start.K_Start();  // ų�� ���� ����
		   
		   break; 
	   }
	   else {
		   InGame_Print.Clean();
			System.out.println("\t\t\t �߸� �Է� �Ͽ����ϴ�. �ٽ� �Է��ϼ���");
			System.out.println("\n\n\n\n\n\n\n\n");
			try {
			TimeUnit.SECONDS.sleep(1);
			}catch(Exception e) {
	            System.out.println(e.getMessage());
							}
		   continue;  // �߸� �Է����� �� ���Է�
	   }
	   }
		
		
	}
        
        
        
	       
	public static void main(String[] args) throws Exception{
	
	
			GameStart.TotalStart(); // �׽�Ʈ ����
   
    }
}
