/*
 �� ���� �޼ҵ�

 �α���
 Ʃ�丮��, ���ӽ���, ä�� �� ��� Ŭ������ �޼ҵ���� �����Ѵ�
 ä�� ���ý� Ŭ���̾�Ʈ ���ϰ� ������ ������ �����Ѵ�.
 */
package MainStart;

import Client.*; // Ŭ���̾�Ʈ ��Ű���� ��������� ���� ����ϱ� ���� import

import java.net.Socket; // ���� ���
import java.net.SocketException;
import InGame.GameStart;  // ���ӽ���
import InGame.InGame_Print;
import Login.Login; // �α���
import Tutorial.Rule; // Ʃ�丮�� 

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mainStart {
	public static Scanner main_select = new Scanner (System.in);
	public static int Title;
	
	public static void PrintMain() {
		InGame_Print.Clean();
		System.out.println("\t\t\t\tHIT ����ȭ��!!!");
		System.out.println();
		System.out.println();
		System.out.println("\t���Ͻô� ����� ��ȣ�� �Է� �� �ּ���...");
		System.out.println();
		System.out.println();
		System.out.println("\t1. ���Ӽ���\t\t\t2. ĳ���ͼ���");
		System.out.println();
		System.out.println("\t3. ���ӽ���\t\t\t4. �����ڿ� ä��");
		System.out.println();
		System.out.println();
		System.out.print("\t\t\t�Է� :\t");
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Login.Start();
		
		
		while(true) { // ���� �ݺ����� ���Ḧ ������ ������ ���� Ÿ��Ʋ�� ���ư���.
		PrintMain();
		 Title =main_select.nextInt();  
		if(Title == 1) {
			Rule.Print_Rule(); // �� ���
			continue;   // �ش� Ŭ���� �ƹ�Ű�� �Է��� ���� Ÿ��Ʋ�� ���ư�
		}
		else if(Title == 2) {
			Rule.Print_Info(); // ĳ���� ���� ��� 
			continue;
		}
		else if(Title == 3) {
			GameStart.TotalStart(); // ī�� ���� ����
			continue;
		}
		else if(Title == 4) {
			
			InGame_Print.Clean();
			break;
		}
		else {
			try {
				InGame_Print.Clean();
				System.out.println("\t\t �߸� �Է��ϼ̽��ϴ�.");
				System.out.println("\n\n\n\n\n\n\n\n");
				TimeUnit.SECONDS.sleep(2);
				}catch(Exception e) {
		            System.out.println(e.getMessage());
								}
			continue;  // �߸� �Է½� �ݺ�
		}
		
	}

		try {
			Socket C_Socket = new Socket("localhost", 8889);
			 // ���� ���α׷��� �ִ� IP �ּҾ� ������ ���� ���� ��Ʈ ��ȣ�� ���� ��ü�� ����
			// ���� ��ü ������ ���ÿ� �����ʿ� ������ ��û�ϰ� ��
		
			C_Get_Massage C_G_Massage = new C_Get_Massage();	// C_Get_Massage ������ ����
			C_G_Massage.setMainSocket(C_Socket);  // C_Get_Massage�� MainSocket�� C_Socket Set
			
			C_Send_Massage C_S_Massage = new C_Send_Massage();	// C_Send_Massage ������ ����
			C_S_Massage.setMain_Socket(C_Socket);	 // C_Send_Massage�� MainSocket�� C_Socket Set
			
			
			
			C_S_Massage.start();
			C_G_Massage.start();  // �� ���� ������ ����
			
			
		}catch(SocketException e) {
			e.printStackTrace(); // ���� �߻��� Trace
		
		}
		
		
		
	}
}
