package InGame;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Character.*;
/*
 �÷��̾ ���ǾƸ� ���������� ���� �޼ҵ带 ��� �ִ� Ŭ���� 
 */
public class Mafia_Start {
	public static int P_Life; // �÷��̾� ü��
	public static int C_Life; // ��ǻ�� ü��
	
	public static Scanner input = new Scanner(System.in);
	public static int turn = 10; // ���� �� ��
	public static int computer = 0; // ��ǻ��
	
	public static int Select_W; // �Է¹��� ���� ����
	public static int P_Select_Card; // ������ ī��  
	public static int C_Select_Card ;// ��ǻ�� ���� ī�� 
	
	// �÷��̾�
		public static int P_Rest_G = 0;      // ���� �� ���� ī��
		public static int P_Rest_P = 0;      // ���� ���� ���� ī�� 
		public static int P_Rest_C = 0;     //  ���� ���� ī�� 
		public static int P_Rest_U = 1;    //   ���� ����ũ ī�� - �������� 1���̴�.
		
		//��ǻ��
		public static int C_Rest_G = 0;      // ���� �� ���� ī��
		public static int C_Rest_P = 0;      // ���� ���� ���� ī�� 
		public static int C_Rest_C = 0;     //  ���� ���� ī�� 
		public static int C_Rest_U = 1;    //   ���� ����ũ ī�� - �������� 1���̴�.
		
		
		
		// ���� �޼ҵ�
		public static void M_Start() { // ���ǾƸ� ���� �� �� ����
			Mafia Player = new Mafia(); //�÷��̾� ��ü ����
			P_Life = Player.getLife();  // �� ���� ü�� ����
			
			P_Rest_G = Player.getG_Card();  // ���� ī�� �ʱⰪ�� getta �Լ��� ����
			P_Rest_P = Player.getP_Card();
			P_Rest_C = Player.getC_Card();
			
			
			Random random = new Random();
			computer = random.nextInt(4)+1; // 1~4 Ȯ���� ��ǻ�Ͱ� ���縦 ����
			if(computer == 1) {
				Police Com = new Police(); // ��ǻ�� 
				C_Life = Com.getLife();  // ��ǻ�� ü�� ����
				
				C_Rest_G = Com.getG_Card();  // ���� ī�� �ʱⰪ�� getta �Լ��� ����
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // ȭ�� ��ȯ
				InGame_Print.Selected_M(); // ���õ� ȭ�� ��� �Լ�
				for(int i = 1; i <= turn; i++) {
					if((C_Life <=0 )|| (P_Life <= 0)) {   // ü���� 0���� �۰ų� ���� �� �ٷ� ��������
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"��° ��\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t�̹� �Ͽ� ���� ī���� ��ȣ�� �Է� �ϼ���");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t������ : "+Player.getG_Damage()
																	+"\t���߷�"+Player.getG_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t������ : "+Player.getP_Damage()
																	+"\t���߷�"+Player.getP_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  ���� \t\t\tȮ�� : "+Player.getCover_P()+"0%\t���� �� �� : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t���� �� �� : "+P_Rest_U);
							System.out.println();
							System.out.println("\t��� ü�� :\t" +C_Life);
							System.out.println("\t��� ü�� :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t�Է� : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_P == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_C == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_U == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									System.out.println("\t\t\t �߸� �Է� �Ͽ����ϴ�. �ٽ� �Է��ϼ���");
									System.out.println("\n\n\n\n\n\n\n\n");
									try {
									TimeUnit.SECONDS.sleep(1);
									}catch(Exception e) {
							            System.out.println(e.getMessage());
													}
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // ��ǻ�͵� ī�� ����	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_P --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_C --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_U --;  // ��ǻ�� ī�� ���� �Ҹ�
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // ��ǻ�� ī�� ���� �Ϸ�
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// ���� ������ ī�忡 ���� ��� ����
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // ����Ʈ ������ ����ũ ������ ��ŭ ��� ü�� ����
								}
								// �Ѵ� ����ũ�� �´µ� �����ϴ� ���� ų�� �ۿ� ����.
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
											P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
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
										C_Life -= Player.getG_Damage(); // �÷��̾� ü�� ����
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // �÷��̾� ü�� ����
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // �ƹ��� Ư�� ī�带 �� ������
							  if(Com.Success_Cover ==false) {  // ��밡 ���� �����ϰų� �� ���� ��
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // �÷��̾ ���� �����ϰų� �� ������ 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
									}
							  }
						  
						  }
							
						///�÷��̾� �� ���
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t������ "+Player.getG_Damage() 
										+",\t���߷�"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("���� !! ��뿡�� "+Player.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "������ "+Player.getP_Damage()
										+",\t���߷�"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("���� !! ��뿡�� "+Player.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("����! ��뿡�� "+Player.getU_Damage()+"�������� �������ϴ�.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("�����Ͽ����ϴ�.");
								}
							}
							
							//// ��ǻ�� �� ���
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t������ "+Com.getG_Damage() 
										+",\t���߷�"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "������ "+Com.getP_Damage()
										+",\t���߷�"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("����! ��ſ��� "+Com.getU_Damage()+"�������� �������ϴ�.");
								}
								else {
									System.out.println("�����Ͽ����ϴ�.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("����� ü�� : "+C_Life);
							System.out.println("����� ü�� : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// ������		
							Player.Refresh(); // ���� �ʱⰪ �ʱ�ȭ
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // ü���� 0 ������ �� 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//���Ӱ��
				InGame_Print.Clean();
				try {
					System.out.println("\t\t������ �Ϸ� �߽��ϴ�.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t���\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t�� ������ ���ºη� ���� �����ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �¸��߽��ϴ�!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �й� �߽��ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
				
			}
			else if(computer == 2) {
				Mafia Com = new Mafia(); // ��ǻ�� 
				C_Life = Com.getLife();  // ��ǻ�� ü�� ����
				
				C_Rest_G = Com.getG_Card();  // ���� ī�� �ʱⰪ�� getta �Լ��� ����
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // ȭ�� ��ȯ
				InGame_Print.Selected_M(); // ���õ� ȭ�� ��� �Լ�
				for(int i = 1; i <= turn; i++) {
					if((C_Life <=0 )|| (P_Life <= 0)) {   // ü���� 0���� �۰ų� ���� �� �ٷ� ��������
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"��° ��\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t�̹� �Ͽ� ���� ī���� ��ȣ�� �Է� �ϼ���");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t������ : "+Player.getG_Damage()
																	+"\t���߷�"+Player.getG_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t������ : "+Player.getP_Damage()
																	+"\t���߷�"+Player.getP_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  ���� \t\t\tȮ�� : "+Player.getCover_P()+"0%\t���� �� �� : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t���� �� �� : "+P_Rest_U);
							System.out.println();
							System.out.println("\t��� ü�� :\t" +C_Life);
							System.out.println("\t��� ü�� :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t�Է� : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_P == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_C == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_U == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									System.out.println("\t\t\t �߸� �Է� �Ͽ����ϴ�. �ٽ� �Է��ϼ���");
									System.out.println("\n\n\n\n\n\n\n\n");
									try {
									TimeUnit.SECONDS.sleep(1);
									}catch(Exception e) {
							            System.out.println(e.getMessage());
													}
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // ��ǻ�͵� ī�� ����	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_P --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_C --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_U --;  // ��ǻ�� ī�� ���� �Ҹ�
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // ��ǻ�� ī�� ���� �Ϸ�
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// ���� ������ ī�忡 ���� ��� ����
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // ����Ʈ ������ ����ũ ������ ��ŭ ��� ü�� ����
								}
								// �Ѵ� ����ũ�� �´µ� �����ϴ� ���� ų�� �ۿ� ����.
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
											P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
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
										C_Life -= Player.getG_Damage(); // �÷��̾� ü�� ����
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // �÷��̾� ü�� ����
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // �ƹ��� Ư�� ī�带 �� ������
							  if(Com.Success_Cover ==false) {  // ��밡 ���� �����ϰų� �� ���� ��
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // �÷��̾ ���� �����ϰų� �� ������ 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
									}
							  }
						  
						  }
							
						///�÷��̾� �� ���
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t������ "+Player.getG_Damage() 
										+",\t���߷�"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("���� !! ��뿡�� "+Player.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "������ "+Player.getP_Damage()
										+",\t���߷�"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("���� !! ��뿡�� "+Player.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("����! ��뿡�� "+Player.getU_Damage()+"�������� �������ϴ�.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("�����Ͽ����ϴ�.");
								}
							}
							
							//// ��ǻ�� �� ���
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t������ "+Com.getG_Damage() 
										+",\t���߷�"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "������ "+Com.getP_Damage()
										+",\t���߷�"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("����! ��ſ��� "+Com.getU_Damage()+"�������� �������ϴ�.");
								}
								else {
									System.out.println("�����Ͽ����ϴ�.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("����� ü�� : "+C_Life);
							System.out.println("����� ü�� : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// ������		
							Player.Refresh(); // ���� �ʱⰪ �ʱ�ȭ
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // ü���� 0 ������ �� 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//���Ӱ��
				InGame_Print.Clean();
				try {
					System.out.println("\t\t������ �Ϸ� �߽��ϴ�.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t���\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t�� ������ ���ºη� ���� �����ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �¸��߽��ϴ�!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �й� �߽��ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
			}
			else if(computer == 3) {  // ��ǻ�Ͱ� �� �����϶�
				Retired_Soldier Com = new Retired_Soldier(); // ��ǻ�� 
				C_Life = Com.getLife();  // ��ǻ�� ü�� ����
				
				C_Rest_G = Com.getG_Card();  // ���� ī�� �ʱⰪ�� getta �Լ��� ����
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // ȭ�� ��ȯ
				InGame_Print.Selected_M(); // ���õ� ȭ�� ��� �Լ�
				for(int i = 1; i <= turn; i++) {
					if((C_Life <= 0 )|| (P_Life <= 0)) {   // ü���� 0���� �۰ų� ���� �� �ٷ� ��������
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"��° ��\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t�̹� �Ͽ� ���� ī���� ��ȣ�� �Է� �ϼ���");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t������ : "+Player.getG_Damage()
																	+"\t���߷�"+Player.getG_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t������ : "+Player.getP_Damage()
																	+"\t���߷�"+Player.getP_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  ���� \t\t\tȮ�� : "+Player.getCover_P()+"0%\t���� �� �� : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t���� �� �� : "+P_Rest_U);
							System.out.println();
							System.out.println("\t��� ü�� :\t" +C_Life);
							System.out.println("\t��� ü�� :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t�Է� : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_P == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_C == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_U == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									System.out.println("\t\t\t �߸� �Է� �Ͽ����ϴ�. �ٽ� �Է��ϼ���");
									System.out.println("\n\n\n\n\n\n\n\n");
									try {
									TimeUnit.SECONDS.sleep(1);
									}catch(Exception e) {
							            System.out.println(e.getMessage());
													}
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // ��ǻ�͵� ī�� ����	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_P --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_C --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_U --;  // ��ǻ�� ī�� ���� �Ҹ�
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // ��ǻ�� ī�� ���� �Ϸ�
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// ���� ������ ī�忡 ���� ��� ����
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // ����Ʈ ������ ����ũ ������ ��ŭ ��� ü�� ����
								}
								// �Ѵ� ����ũ�� �´µ� �����ϴ� ���� ų�� �ۿ� ����.
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
											P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
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
										C_Life -= Player.getG_Damage(); // �÷��̾� ü�� ����
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // �÷��̾� ü�� ����
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // �ƹ��� Ư�� ī�带 �� ������
							  if(Com.Success_Cover ==false) {  // ��밡 ���� �����ϰų� �� ���� ��
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // �÷��̾ ���� �����ϰų� �� ������ 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
									}
							  }
						  
						  }
							
						///�÷��̾� �� ���
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t������ "+Player.getG_Damage() 
										+",\t���߷�"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("���� !! ��뿡�� "+Player.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "������ "+Player.getP_Damage()
										+",\t���߷�"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("���� !! ��뿡�� "+Player.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("����! ��뿡�� "+Player.getU_Damage()+"�������� �������ϴ�.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("�����Ͽ����ϴ�.");
								}
							}
							
							//// ��ǻ�� �� ���
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t������ "+Com.getG_Damage() 
										+",\t���߷�"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "������ "+Com.getP_Damage()
										+",\t���߷�"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("����!  ü���� 1 ȸ�� �մϴ�.");
								}
								else {
									System.out.println("�����Ͽ����ϴ�.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("����� ü�� : "+C_Life);
							System.out.println("����� ü�� : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// ������		
							Player.Refresh(); // ���� �ʱⰪ �ʱ�ȭ
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // ü���� 0 ������ �� 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//���Ӱ��
				InGame_Print.Clean();
				try {
					System.out.println("\t\t������ �Ϸ� �߽��ϴ�.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t���\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t�� ������ ���ºη� ���� �����ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �¸��߽��ϴ�!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �й� �߽��ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
			}
			else if(computer == 4) {
				Killer Com = new Killer(); // ��ǻ�� 
				C_Life = Com.getLife();  // ��ǻ�� ü�� ����
				
				C_Rest_G = Com.getG_Card();  // ���� ī�� �ʱⰪ�� getta �Լ��� ����
				C_Rest_P = Com.getP_Card();
				C_Rest_C = Com.getC_Card();
				
				
				InGame_Print.Clean(); // ȭ�� ��ȯ
				InGame_Print.Selected_M(); // ���õ� ȭ�� ��� �Լ�
				for(int i = 1; i <= turn; i++) {
					if((C_Life <=0 )|| (P_Life <= 0)) {   // ü���� 0���� �۰ų� ���� �� �ٷ� ��������
						break;
					}
					else {
						while(true){
							InGame_Print.Clean();
							System.out.println("\t\t"+i+"��° ��\t\t\t\t");
							System.out.println();
							System.out.println();
							System.out.println("\t\t�̹� �Ͽ� ���� ī���� ��ȣ�� �Է� �ϼ���");
							System.out.println();
							System.out.println("\t1. "+Player.Gun_Name+ "\t������ : "+Player.getG_Damage()
																	+"\t���߷�"+Player.getG_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_G );
							System.out.println();
							System.out.println("\t2. "+Player.Pistol_Name+ "\t������ : "+Player.getP_Damage()
																	+"\t���߷�"+Player.getP_Hit_P()+"0%"+"\t���� �� �� : "+P_Rest_P );
							System.out.println();
							System.out.println("\t3.  ���� \t\t\tȮ�� : "+Player.getCover_P()+"0%\t���� �� �� : "+P_Rest_C );
							System.out.println();
							System.out.print("\t4. ");
							Player.Print_Unique();
							System.out.println("\t���� �� �� : "+P_Rest_U);
							System.out.println();
							System.out.println("\t��� ü�� :\t" +C_Life);
							System.out.println("\t��� ü�� :\t" +P_Life);
							System.out.println();
							System.out.print("\t\t\t\t \t�Է� : ");
							P_Select_Card = input.nextInt();
						
								if(P_Select_Card == 1) {  
									if(P_Rest_G == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_P == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_C == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									if(P_Rest_U == 0) {  // ���� ī�尡 ������
										try {
											InGame_Print.Clean();
											System.out.println("\t\t\t ���� ī�尡 �����ϴ�. �ٽ� �Է��ϼ���");
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
									System.out.println("\t\t\t �߸� �Է� �Ͽ����ϴ�. �ٽ� �Է��ϼ���");
									System.out.println("\n\n\n\n\n\n\n\n");
									try {
									TimeUnit.SECONDS.sleep(1);
									}catch(Exception e) {
							            System.out.println(e.getMessage());
													}
								}
								
							}
							while(true) {
								
							C_Select_Card = random.nextInt(4)+1;  // ��ǻ�͵� ī�� ����	
							
							if(C_Select_Card == 1) {
								if(C_Rest_G == 0) {
									continue;
								}
								else {
									C_Rest_G --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_P --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_C --;  // ��ǻ�� ī�� ���� �Ҹ�
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
									C_Rest_U --;  // ��ǻ�� ī�� ���� �Ҹ�
									Com.Selected_Unique = true;
									break;
									}
								}
							}  // ��ǻ�� ī�� ���� �Ϸ�
							
							InGame_Print.Print_C_Select();
							InGame_Print.Clean();
						
							
							
							// ���� ������ ī�忡 ���� ��� ����
							if(Player.Selected_Unique == true && Com.Selected_Unique == true) {
								Player.Uniqe_Card(Com.Hit_Gun, Com.Hit_Pistol, Com.Success_Cover, Com.Selected_Unique);
								if(Player.Success_Unique == true) {
									C_Life -= Player.getU_Damage();   // ����Ʈ ������ ����ũ ������ ��ŭ ��� ü�� ����
								}
								// �Ѵ� ����ũ�� �´µ� �����ϴ� ���� ų�� �ۿ� ����.
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
											P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
										}
										else if(Com.Hit_Pistol == true) {
											P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
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
										C_Life -= Player.getG_Damage(); // �÷��̾� ü�� ����
									}	
									else if(Player.Hit_Pistol == true) {
										C_Life -= Player.getP_Damage(); // �÷��̾� ü�� ����
										}
								}
							}
						  else if(Player.Selected_Unique == false && Com.Selected_Unique == false) { // �ƹ��� Ư�� ī�带 �� ������
							  if(Com.Success_Cover ==false) {  // ��밡 ���� �����ϰų� �� ���� ��
								  if(Player.Hit_Gun == true) {  
									  C_Life -= Player.getG_Damage();
								  }
								  else if(Player.Hit_Pistol == true) {
									  C_Life -= Player.getP_Damage();
								  }
							  }
							   if(Player.Success_Cover == false) { // �÷��̾ ���� �����ϰų� �� ������ 
								   if(Com.Hit_Gun == true) {
										P_Life -= Com.getG_Damage(); // �÷��̾� ü�� ����
									}
									else if(Com.Hit_Pistol == true) {
										P_Life -= Com.getP_Damage(); // �÷��̾� ü�� ����
									}
							  }
						  
						  }
							
						///�÷��̾� �� ���
							InGame_Print.Clean();
							try {
							TimeUnit.SECONDS.sleep(1);
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(P_Select_Card == 1) {
								System.out.println(Player.Gun_Name + ",\t������ "+Player.getG_Damage() 
										+",\t���߷�"+Player.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Gun == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false){
										System.out.println("���� !! ��뿡�� "+Player.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(P_Select_Card == 2) {
								System.out.println(Player.Pistol_Name + "������ "+Player.getP_Damage()
										+",\t���߷�"+Player.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Hit_Pistol == true) {
									if(Com.Success_Cover == true || Com.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Com.Success_Cover == false && Com.Success_Unique == false) {
										System.out.println("���� !! ��뿡�� "+Player.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Player.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(P_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Player.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Cover == true) {
									if(Com.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Com.Success_Unique == false) {
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Player.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(P_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Player.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Player.Success_Unique == true) {
									System.out.println("����! ��뿡�� "+Player.getU_Damage()+"�������� �������ϴ�.");
								}
								else if(Player.Success_Unique == false){
									System.out.println("�����Ͽ����ϴ�.");
								}
							}
							
							//// ��ǻ�� �� ���
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.print("\t\t ����� ī�� : ");
							TimeUnit.SECONDS.sleep(1);
							if(C_Select_Card == 1) {
								System.out.println(Com.Gun_Name + ",\t������ "+Com.getG_Damage() 
										+",\t���߷�"+Com.getG_Hit_P()+"0%" );
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Gun == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getG_Damage()+"�������� �������ϴ�.");
									}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
							}
							else if(C_Select_Card == 2) {
								System.out.println(Com.Pistol_Name + "������ "+Com.getP_Damage()
										+",\t���߷�"+Com.getP_Hit_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Hit_Pistol == true) {
									if(Player.Success_Cover == true || Player.Success_Unique == true) {
										System.out.println("���������� ����� ī��� ȿ���� ��ȿó�� �ƽ��ϴ�.");
									}
									else if(Player.Success_Cover == false && Player.Success_Unique == false){
										System.out.println("���� !! ��ſ��� "+Com.getP_Damage()+"�������� �������ϴ�.");
										}
								}
								else if(Com.Hit_Gun == false) {
									System.out.println("������ ���������ϴ�.");
								}
									
							}
							else if(C_Select_Card == 3) {
								System.out.println("����" +",\t������ : "+Com.getCover_P()+"0%");
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Cover == true) {
									if(Player.Success_Unique == true) {
										System.out.println("���� �����Ͽ����� ����� Ư�� ī�忡 ȿ���� ����ȭ �˴ϴ�.");
									}
									else if(Player.Success_Unique == false){
										System.out.println("���� ���� �߽��ϴ�.");
									}
								}
								else if(Com.Success_Cover == false) {
									System.out.println("���� ���� �߽��ϴ�.");
								}
							}
							else if(C_Select_Card == 4) {
								System.out.print("Ư��ī�� : ");
								Com.Print_Unique();
								System.out.println();
								TimeUnit.SECONDS.sleep(1);
								System.out.print("\t\t��� : ");
								TimeUnit.SECONDS.sleep(1);
								if(Com.Success_Unique == true) {
									System.out.println("����! ��ſ��� "+Com.getU_Damage()+"�������� �������ϴ�.");
								}
								else {
									System.out.println("�����Ͽ����ϴ�.");
								}
							}	
							TimeUnit.SECONDS.sleep(1);
							System.out.println();
							System.out.println();
							System.out.println("����� ü�� : "+C_Life);
							System.out.println("����� ü�� : "+ P_Life);
							System.out.println();
							System.out.println();
							TimeUnit.SECONDS.sleep(5);
							}catch(Exception e) {
					            System.out.println(e.getMessage());
											}
					
							// ������		
							Player.Refresh(); // ���� �ʱⰪ �ʱ�ȭ
							Com.Refresh();  
							if(P_Life <= 0 ||C_Life <= 0) {   // ü���� 0 ������ �� 
								break;
							}
							if(i < 10) {
							InGame_Print.Next_Turn_Print();
							}
					}
				}
				//���Ӱ��
				InGame_Print.Clean();
				try {
					System.out.println("\t\t������ �Ϸ� �߽��ϴ�.\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					InGame_Print.Clean();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("\t\t\t\t\t\t���\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					TimeUnit.SECONDS.sleep(2);
					InGame_Print.Clean();
					if(P_Life == C_Life) {
						System.out.println("\t\t\t�� ������ ���ºη� ���� �����ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life >= C_Life) {
					System.out.println("\n\n\n\n\n\n\n");
					System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �¸��߽��ϴ�!!!\n");
					System.out.println("\n\n\n\n\n\n\n\n");
					}
					else if(P_Life <= C_Life) {
						System.out.println("\n\n\n\n\n\n\n");
						System.out.println("\t\t\t���(���Ǿ�)�� �� �������� �й� �߽��ϴ�!!!\n");
						System.out.println("\n\n\n\n\n\n\n\n");
						}
					TimeUnit.SECONDS.sleep(3);
					
					}catch(Exception e) {
			            System.out.println(e.getMessage());
									}		
			}
		}
}

