package Tutorial;

import java.util.concurrent.TimeUnit;  // �ð��� ����� ���� Ŭ����

import InGame.InGame_Print;  // ȭ�� �ѱ�� �޼ҵ�(Clean)�� ����ϱ����� ���ѤĤ���
import java.util.Scanner;
;
public class Rule {
	
	public static Scanner Back = new Scanner(System.in); // �ƹ�Ű�� �Է¹޾� ���� Ÿ��Ʋ�� �������� ��ĳ��
	public static String goTitle;
	public static String goInfo;
	public static void Print_Rule() { //���� ���� �����ϱ� ���� �޼ҵ�
	InGame_Print.Clean();
	System.out.println("\t\t\t���� ��Ģ!!!");
	System.out.println();
	System.out.println("\t����, ���Ǿ�, �𿪱���, ų�� �� �� ���� �����Ѵ�. ������ ĳ���Ϳ� ��밡 ī�带 ���� �����Ѵ�.");
	System.out.println();
	System.out.println("\tī�带 �� �� ��(����, ����, Ư���ɷ�) ���� ü���� ���ų� ��� ��� �ϸ� ���ӿ��� �¸��Ѵ�.");
	System.out.println();
	System.out.println("\t������ 10 ������ �����Ǿ� �ְ� �� ���� ü���� 0�� �ɽ� ������ �ٷ� ������.");
	System.out.println();
	System.out.println("\tī��� (��, ����)����, ����, Ư��ī�� �� 4 ������ �����Ǿ� �ִ�.");
	System.out.println();
	System.out.println("\t��, ��������� �� �ɸ��� ���� ������ �� ���߷��� �ٸ���.(�������ų� ��밡 ���� Ư�������� �� �ִ�.)");
	System.out.println();
	System.out.println("\t����ī��� �ɸ��͸��� ���� Ȯ���� �����ϸ� Ư��ī�忡 ����ȭ �� �� �ִ�.");
	System.out.println();
	System.out.println("\tƯ��ī��� ��� �ɸ��Ͱ� 1�徿 ���� ������ �� ȿ���� �ߵ������� �ɸ��� ���� �ٸ���.");
	System.out.println();
	System.out.print("\t�ƹ� Ű�� �Է��Ͻø� ���� ȭ������ �ǵ��� ���ϴ�.");
	goTitle = Back.next(); // �Է½� ����ȭ������ �̵�
} 


	public static void P_Info_Print(){ // ���� ������ ����ϴ� �޼ҵ�
		InGame_Print.Clean();
		System.out.println();
		System.out.println("\t1. ����");
		System.out.println();
		System.out.println();
		System.out.println("\tü�� : 8+2(��ź����)");
		System.out.println();
		System.out.println("\t���� : ������870(�ֹ���) 2�� - ������ 3, ���߷� : 60%");
		System.out.println("\t\t�۷�17(��������) 6�� - ������ 1, ���߷� :70%");
		System.out.println();
		System.out.println("\t���� : 3��\t����Ȯ�� : 70%");
		System.out.println();
		System.out.println("\tƯ�� ī�� ���� : ���й��п� �Բ� �����Ѵ�. ������ 1 ���ظ� �ش�.");
		System.out.println(" \t\t\t���� - ��밡 ����ī�带 ����Ͽ� ���� ���������� �ߵ�\r\n"
				+ "         ���� �����ϰų� �ٸ� ī�� ���� �ߵ����� �ʴ´�.");
		System.out.println();
		System.out.println("\t������ : ������ ���� ü�°� ���� �������� �ֹ���� �������� �÷��̰� �����ϴ�.");
		System.out.println();
		
		System.out.print("\t�ƹ� Ű�� �Է��Ͻø� ���� ȭ������ �ǵ��� ���ϴ�.");
		goInfo = Back.next(); // �Է½� ����ȭ������ �̵�
	}
	
	public static void M_Info_Print() {  // ���Ǿ� ������ ���
		InGame_Print.Clean();
		System.out.println("\t2. ���Ǿ�");
		System.out.println();
		System.out.println();
		System.out.println("\tü�� : 8");
		System.out.println();
		System.out.println("\t���� : ��̰�(�ֹ���) 4�� - ������ 2, ���߷� : 60%");
		System.out.println("\t\tM36������(��������)4�� - ������ 1, ���߷� :60%");
		System.out.println();
		System.out.println("\t���� : 3��\t����Ȯ�� : 70%");
		System.out.println();
		System.out.println("\t Ư�� ī�� ���鵹�� : ���� �����Ͽ� ����� ��ݿ� �´����Ѵ�. ������ 2 ���ظ� �ش�..");
		System.out.println(" \t\t\t���� - ��밡 �ֹ��� ī�带 ����Ͽ�  ���� ���� �� �ߵ�\r\n"
				+ "		  ���߿� �����ϰų� �ٸ� ī�� ���� �ߵ����� �ʴ´�.");
		System.out.println();
		System.out.println("\t������ : ���Ǿƴ� ���ݼ����� ���ٴ� ������ ������ Ȯ���� �����ʴ�.");
		
		System.out.println();
		System.out.print("\t�ƹ� Ű�� �Է��Ͻø� ���� ȭ������ �ǵ��� ���ϴ�.");
		goInfo = Back.next(); // �Է½� ����ȭ������ �̵�
	}
	
	public static void R_Info_Print() { // �� ���� ������ ���		
		InGame_Print.Clean();
		System.out.println("\t3. �𿪱���");
		System.out.println();
		System.out.println();
		System.out.println("\tü�� : 8");
		System.out.println();
		System.out.println("\t���� : AR15(�ֹ���) 3�� - ������ 2, ���߷� : 70%");
		System.out.println("\t\t����Ÿ92(��������)5�� - ������ 1, ���߷� :70%");
		System.out.println();
		System.out.println("\t���� : 3��\t����Ȯ�� : 70%");
		System.out.println();
		System.out.println("\tƯ�� ī�� ������: ���ܳ��� ���� �������� ���� �Ѵ�. ü��+1.");
		System.out.println(" \t\t\t���� - ����� ���ݿ� ���߸� ���� �� �ߵ�\r\n"
				+ "		                                     ����� ������ ���� �� �� �ߵ����� �ʴ´�.");
		System.out.println();
		System.out.println("\t������ : �𿪱����� �������� ���� �������� ���߷��� ���� �����Ȳ�� ����ġ�ᰡ �����ϴ�.");
		
		
		System.out.println();
		System.out.print("\t�ƹ� Ű�� �Է��Ͻø� ���� ȭ������ �ǵ��� ���ϴ�.");
		goInfo = Back.next(); // �Է½� ����ȭ������ �̵�
	}
	
	public static void K_Info_Print() { // ų�� ������ ���
		InGame_Print.Clean();
		System.out.println("\t4. ų��");
		System.out.println();
		System.out.println();
		System.out.println("\tü�� : 6");
		System.out.println();
		System.out.println("\t���� : m24(�ֹ���) 1�� - ������ 5, ���߷� : 80%");
		System.out.println("\t\t����Ʈ �̱�(��������)5�� - ������ 2, ���߷� :50%");
		System.out.println();
		System.out.println("\t���� : 3��\t����Ȯ�� : 80%");
		System.out.println();
		System.out.println("\tƯ�� ī�� ī���� : ��ī�ο� ������ ����� Ư��ī�忡 �ݰ��Ѵ�. ������ 3 ���ظ� �ش�.");
		System.out.println(" \t\t\t���� - ��밡 Ư�� ī�带 ���� ���� �� �ߵ�\r\n"
				+ "		                                    �ٸ� ����� Ư��ī���� ������ ������ ����� Ư��ī�� ���� �ߵ��Ѵ�.");
		System.out.println();
		System.out.println("\t������ :ų���� �ֹ����� �������� ���߷��� ���� ������ ü����6�̶�� �������� ������ �ִ�.");
		System.out.println();
		System.out.print("\t�ƹ� Ű�� �Է��Ͻø� ���� ȭ������ �ǵ��� ���ϴ�.");
		goInfo = Back.next(); // �Է½� ����ȭ������ �̵�
	}
	
	
	public static void Print_Info() {
	
			int Select;
			while(true) {
				InGame_Print.Clean();
				System.out.println("\tĳ���� ����");
				System.out.println();
				System.out.println();
				System.out.println("\t������ ������� ĳ������ ��ȣ�� �Է��ϼ��� ");
				System.out.println();
				System.out.println();
				System.out.println("\t1.����\t\t\t2.���Ǿ�");
				System.out.println();
				System.out.println("\t3.�𿪱���\t\t4.ų��");
				System.out.println();
				System.out.println("\t5.���� ȭ��");
				System.out.println();
				System.out.println();
				System.out.print("\t\t\t�Է� :\t");
				Select = Back.nextInt();
				
				if(Select == 1) {
					P_Info_Print(); // ���� ���� ��� �޼ҵ�
					continue; // �ƹ�Ű�� �Է½� ���� ȭ�鶧���� �ݺ�
				}
				else if(Select == 2) {
					M_Info_Print(); // ���Ǿ� ���� ��� �޼ҵ�
					continue; // �ƹ�Ű�� �Է½� ���� ȭ�鶧���� �ݺ�
				}
				else if(Select == 3) {
					R_Info_Print(); //  ���� ��� �޼ҵ�
					continue; // �ƹ�Ű�� �Է½� ���� ȭ�鶧���� �ݺ�
				}
				else if(Select == 4) {
					K_Info_Print(); // ų�� ���� ��� �޼ҵ�
					continue; // �ƹ�Ű�� �Է½� ���� ȭ�鶧���� �ݺ�
				}
				else if(Select == 5) {
					try{
					InGame_Print.Clean();
					System.out.println("\t\t ���� ȭ������ ���ư��ϴ�.");
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
						System.out.println("\t\t �߸� �Է��ϼ̽��ϴ�.");
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
	


