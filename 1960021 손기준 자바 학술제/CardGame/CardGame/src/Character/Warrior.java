
package Character;

public abstract class Warrior {
	public boolean Hit_Gun = false;  // �ֹ��� ���߷��� ���� �ʵ� 
	public boolean Hit_Pistol = false; // ���� ���� ���߷��� ���� �ʵ�
	public boolean Success_Cover = false; // ���� �������� ���� �ʵ�
	public boolean Success_Unique = false; // Ư�� ī�� ���� ����
	public boolean Selected_Unique = false; // ����ũ ī�� ���ÿ���
	
	
	// �� ���� ������ ��������� Ư��ī�� ���� �ʱ�ȭ �ϴ� �޼ҵ�
	public void Refresh() {
		Hit_Gun = false;  // �ֹ��� ���߷��� ���� �ʵ� 
		Hit_Pistol = false; // ���� ���� ���߷��� ���� �ʵ�
		Success_Cover = false; // ���� �������� ���� �ʵ�
		Success_Unique = false; // Ư�� ī�� ���� ����
		Selected_Unique = false; // ����ũ ī�� ���ÿ���
	}
	
	public abstract boolean Uniqe_Card(boolean O_Hit_gun,  boolean O_Hit_pistol,
													boolean O_Success_cover, boolean O_Selected_Unique) ;
	// �߻� �޼ҵ� Ư�� ī���� �ɷ��� ��� �ٸ��⿡ �������̵� �ʿ�
}
