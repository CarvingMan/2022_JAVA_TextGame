package Character;

import java.util.Random;
/*
 ���� 
 ü�� 8+2 // ��ź���� ���� +2 ��
 ���� :	������ ���� 2�� - ������ : 3, ���߷� : 60%
            �۷�17 6��  	- ������ :1, ���߷� : 70% 
 ���� :		3��			- ����Ȯ�� 70%
 Ư�� ī�� ���� : ���й��п� �Բ� �����Ѵ�. ������ 1 ���ظ� �ش�.
                          ���� - ��밡 ����ī�带 ����Ͽ� ���� ���������� �ߵ�
                                     ���� �����ϰų� �ٸ� ī�� ���� �ߵ����� �ʴ´�.
 */

public class Police extends Warrior{ 

	//ü��
private int Life = 10; // ���� ü�� 

// ī�� �̸�

public final String Gun_Name = "������870"; // ���ӿ� ������ �ִ� �����¾ƴϱ⿡ public ���
public final String Pistol_Name = "�۷�17";


//������
private  final int G_Damage = 3; // �� ����(����) ������(Gun) final �� �� ����
private  final int P_Damage = 1; // ���� ����(�۷�) ������
private final int U_Damage = 1;


//Ȯ��
private final int G_Hit_P = 6; // ���� ���߷� 60%   Pistol
private final int P_Hit_P = 7; // �۷� ���߷� 70%
private final int Cover_P = 7; // ���� Ȯ�� 70%

// ī�� ��
private final int G_Card = 2; // �� ���� ī�� ��
private final int P_Card = 6; // ���� ���� ī�� �� 
private  final int C_Card = 3; // ���� ī�� ��
 

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
	if((random.nextInt(10)+1) <= G_Hit_P) { // 1~10 �� 6���� ���ų� �۴ٸ� -> 60% Ȯ���̴�. 
		 super.Hit_Gun = true; // 60% Ȯ���� ���߽� True ��ȯ
	}
	else {
		super.Hit_Gun = false; // ���н� False ��ȯ
	}
	return super.Hit_Gun;
}

public boolean Shot_Pistol() { // ���� ����  �޼ҵ� ���� ���� ��ȯ
	if((random.nextInt(10)+1) <= P_Hit_P) { // 1~10 �� 7���� ���ų� �۴ٸ� -> 70% Ȯ���̴�. 
		 super.Hit_Pistol = true; // 70% Ȯ���� ���߽� True ��ȯ
	}
	else {
		super.Hit_Pistol = false; // ���н� False ��ȯ
	}
	return super.Hit_Pistol;
}

public boolean Cover() { // ���� �޼ҵ� ���� ���� ��ȯ
	if((random.nextInt(10)+1) <= Cover_P) { // 1~10 �� 7���� ���ų� �۴ٸ� -> 70% Ȯ���̴�. 
		 super.Success_Cover = true; // 70% Ȯ���� ����� True ��ȯ
	}
	else {
		super.Success_Cover = false; // ���н� False ��ȯ
	}
	return super.Success_Cover;
}

// Ư��ī�� ȿ�� ��� �޼ҵ�
public  void Print_Unique() {
	System.out.print("���� - �̹��Ͽ� ��밡 ����ī�带 ���� ���������� 1�������� ������ ");
}

// �������̵�
//���� Ư�� ī�� �ߵ� ���� 
// �Ű����� ���� ��� ������ ���� ����
public  boolean Uniqe_Card(boolean O_Hit_Gun,  boolean O_Hit_Pistol, boolean O_Success_Cover, boolean O_Selected_Unique) {
	if( O_Success_Cover== true ) {
			super.Success_Unique = true;
	}
	else {
		super.Success_Unique = false;
	}
	return super.Success_Unique;
}



}
