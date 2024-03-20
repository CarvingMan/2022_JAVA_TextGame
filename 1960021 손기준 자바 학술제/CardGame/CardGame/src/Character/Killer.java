package Character;
import java.util.Random;
/*
 킬러
 체력 6  // 킬러의 이점에 대한 불이익  
 무기 :	m24저격총 1장 - 데미지 : 5, 명중률 : 80%
            데저트이글 5장  	- 데미지 : 2, 명중률 : 50%  // 반동이 쎄서 정확도가 낮은 대신 데미지가 높다. 
 엄폐 :		5장			- 성공확률 80% - 킬러의 특성상 엄폐 확률 높다.
                                                     - 무기 카드수가 적기에 엄폐카드가 많다.
 특수 카드 카운터 : 날카로운 눈으로 상대의 특수카드에 반격한다. 데미지 3 피해를 준다.
                          조건 - 상대가 특수 카드를 선택 했을 시 발동
                                    다만 상대의 특수카드의 조건이 맞을시 상대의 특수카드 또한 발동한다.
 */

public class Killer extends Warrior{ 

	//체력
private int Life = 6; // 킬러 체력 

// 카드 이름

public final String Gun_Name = "m24저격총"; // 게임에 영향을 주는 변수는아니기에 public 사용
public final String Pistol_Name = "데저트이글";


//데미지
private  final int G_Damage = 5; // 주 무기 (m24) 데미지 final 로 값 고정
private  final int P_Damage = 2; // 보조 무기(데져트이글) 데미지
private final int U_Damage = 3; // 특수카드 데미지


//확률
private final int G_Hit_P = 8; // m24 명중률 80%   Pistol
private final int P_Hit_P = 5; // 데저트이글 리볼버 명중률 50% - 반동이 크다.
private final int Cover_P = 8; // 엄폐 확률 80%

// 카드 수
private final int G_Card = 1; // 주 무기 카드 수
private final int P_Card = 5; // 보조 무기 카드 수 
private  final int C_Card = 5; // 엄폐 카드 수
 

//-Getta 함수- 값을 가져와야 하는 것들만 생성 
// 값을 고정 했기에 Setta 함수는 없다.

public int getLife() {    // 잔여 생명 불러오기 접근지정자 private 때문에
	return Life;            // 				getta함수 사용
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


// 발사 하며 명중 하였는지 또는 엄폐에 성공하였는지 연산하는 메소드들

Random random = new Random();

public boolean Shot_Gun() { // 주무기 공격 메소드 성공 실패 반환
	if((random.nextInt(10)+1) <= G_Hit_P) { // 1~10 중 8보다 같거나 작다면 -> 80% 확률이다. 
		 super.Hit_Gun = true; // 80% 확률로 명중시 True 반환
	}
	else {
		super.Hit_Gun = false; // 실패시 False 반환
	}
	return super.Hit_Gun;
}

public boolean Shot_Pistol() { // 보조 무기  메소드 성공 실패 반환
	if((random.nextInt(10)+1) <= P_Hit_P) { // 1~10 중 5보다 같거나 작다면 -> 50% 확률이다. 
		 super.Hit_Pistol = true; // 60% 확률로 명중시 True 반환
	}
	else {
		super.Hit_Pistol = false; // 실패시 False 반환
	}
	return super.Hit_Pistol;
}

public boolean Cover() { // 엄폐 메소드 성공 실패 반환
	if((random.nextInt(10)+1) <= Cover_P) { // 1~10 중 8보다 같거나 작다면 -> 70% 확률이다. 
		 super.Success_Cover = true; // 80% 확률로 엄폐시 True 반환
	}
	else {
		super.Success_Cover = false; // 실패시 False 반환
	}
	return super.Success_Cover;
}

// 특수카드 효과 출력 메소드
public void Print_Unique() {
	System.out.print("카운터 - 이번턴에 상대가 특수 카드를 내었을 시 3데미지를 입힌다 ");
}

// 오버라이딩
//마피아 특수 카드 발동 조건 
// 매개변수 값은 상대 데이터 값을 참조
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
