
package Character;

public abstract class Warrior {
	public boolean Hit_Gun = false;  // 주무기 명중률을 위한 필드 
	public boolean Hit_Pistol = false; // 보조 무기 명중률을 위한 필드
	public boolean Success_Cover = false; // 엄폐 성공률을 위한 필드
	public boolean Success_Unique = false; // 특수 카드 조건 성공
	public boolean Selected_Unique = false; // 유니크 카드 선택여부
	
	
	// 한 턴이 지나고 성공결과와 특수카드 선택 초기화 하는 메소드
	public void Refresh() {
		Hit_Gun = false;  // 주무기 명중률을 위한 필드 
		Hit_Pistol = false; // 보조 무기 명중률을 위한 필드
		Success_Cover = false; // 엄폐 성공률을 위한 필드
		Success_Unique = false; // 특수 카드 조건 성공
		Selected_Unique = false; // 유니크 카드 선택여부
	}
	
	public abstract boolean Uniqe_Card(boolean O_Hit_gun,  boolean O_Hit_pistol,
													boolean O_Success_cover, boolean O_Selected_Unique) ;
	// 추상 메소드 특수 카드의 능력이 모두 다르기에 오버라이딩 필요
}
