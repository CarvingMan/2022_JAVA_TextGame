/*
  Ŭ���̾�Ʈ �����带 �����Ű�� Ŭ����
 */
package Client;
import java.io.IOException;  //����� ���� ó���� ���� import
import java.net.Socket; // ���� ���
import java.net.SocketException;

public class Client_Start {


	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
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
