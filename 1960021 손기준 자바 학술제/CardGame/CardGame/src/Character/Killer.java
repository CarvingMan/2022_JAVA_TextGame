package Character;
import java.util.Random;
/*
 ų��
 ü�� 6  // ų���� ������ ���� ������  
 ���� :	m24������ 1�� - ������ : 5, ���߷� : 80%
            ����Ʈ�̱� 5��  	- ������ : 2, ���߷� : 50%  // �ݵ��� �꼭 ��Ȯ���� ���� ��� �������� ����. 
 ���� :		5��			- ����Ȯ�� 80% - ų���� Ư���� ���� Ȯ�� ����.
                                                     - ���� ī����� ���⿡ ����ī�尡 ����.
 Ư�� ī�� ī���� : ��ī�ο� ������ ����� Ư��ī�忡 �ݰ��Ѵ�. ������ 3 ���ظ� �ش�.
                          ���� - ��밡 Ư�� ī�带 ���� ���� �� �ߵ�
                                    �ٸ� ����� Ư��ī���� ������ ������ ����� Ư��ī�� ���� �ߵ��Ѵ�.
 */

public class Killer extends Warrior{ 

	//ü��
private int Life = 6; // ų�� ü�� 

// ī�� �̸�

public final String Gun_Name = "m24������"; // ���ӿ� ������ �ִ� �����¾ƴϱ⿡ public ���
public final String Pistol_Name = "����Ʈ�̱�";


//������
private  final int G_Damage = 5; // �� ���� (m24) ������ final �� �� ����
private  final int P_Damage = 2; // ���� ����(����Ʈ�̱�) ������
private final int U_Damage = 3; // Ư��ī�� ������


//Ȯ��
private final int G_Hit_P = 8; // m24 ���߷� 80%   Pistol
private final int P_Hit_P = 5; // ����Ʈ�̱� ������ ���߷� 50% - �ݵ��� ũ��.
private final int Cover_P = 8; // ���� Ȯ�� 80%

// ī�� ��
private final int G_Card = 1; // �� ���� ī�� ��
private final int P_Card = 5; // ���� ���� ī�� �� 
private  final int C_Card = 5; // ���� ī�� ��
 

//-Getta �Լ�- ���� �����;� �ϴ� �͵鸸 ���� 
// ���� ���� �߱⿡ Setta �Լ��� ����.

public int getLife() {    // �ܿ� ���� �ҷ����� ���������� private ������
	return Life;            // 				getta�Լ� ���
}

public int getG_Damage() {
	return G_Damage;
}

public int getP_Damage() {
	return P_Damage;
}

public int getU_Damage() {
	return U_Damage;
}


public int getG_Card() {
	return G_Card;
}

public int getP_Card() {
	return P_Card;
}
public int getC_Card() {
	return C_Card;
}
public int getG_Hit_P() {
	return G_Hit_P;
}
public int getP_Hit_P() {
	return P_Hit_P;
}
public int getCover_P() {
	return Cover_P;
}


// �߻� �ϸ� ���� �Ͽ����� �Ǵ� ���� �����Ͽ����� �����ϴ� �޼ҵ��

Random random = new Random();

public boolean Shot_Gun() { // �ֹ��� ���� �޼ҵ� ���� ���� ��ȯ
	if((random.nextInt(10)+1) <= G_Hit_P) { // 1~10 �� 8���� ���ų� �۴ٸ� -> 80% Ȯ���̴�. 
		 super.Hit_Gun = true; // 80% Ȯ���� ���߽� True ��ȯ
	}
	else {
		super.Hit_Gun = false; // ���н� False ��ȯ
	}
	return super.Hit_Gun;
}

public boolean Shot_Pistol() { // ���� ����  �޼ҵ� ���� ���� ��ȯ
	if((random.nextInt(10)+1) <= P_Hit_P) { // 1~10 �� 5���� ���ų� �۴ٸ� -> 50% Ȯ���̴�. 
		 super.Hit_Pistol = true; // 60% Ȯ���� ���߽� True ��ȯ
	}
	else {
		super.Hit_Pistol = false; // ���н� False ��ȯ
	}
	return super.Hit_Pistol;
}

public boolean Cover() { // ���� �޼ҵ� ���� ���� ��ȯ
	if((random.nextInt(10)+1) <= Cover_P) { // 1~10 �� 8���� ���ų� �۴ٸ� -> 70% Ȯ���̴�. 
		 super.Success_Cover = true; // 80% Ȯ���� ����� True ��ȯ
	}
	else {
		super.Success_Cover = false; // ���н� False ��ȯ
	}
	return super.Success_Cover;
}

// Ư��ī�� ȿ�� ��� �޼ҵ�
public void Print_Unique() {
	System.out.print("ī���� - �̹��Ͽ� ��밡 Ư�� ī�带 ������ �� 3�������� ������ ");
}

// �������̵�
//���Ǿ� Ư�� ī�� �ߵ� ���� 
// �Ű����� ���� ��� ������ ���� ����
public  boolean Uniqe_Card(boolean O_Hit_Gun,  boolean O_Hit_Pistol, boolean O_Success_Cover, boolean O_Selected_Unique) {
	if( O_Selected_Unique== true ) {
			super.Success_Unique = true;
	}
	else {
		super.Success_Unique = false;
	}
	return super.Success_Unique;
}



}
