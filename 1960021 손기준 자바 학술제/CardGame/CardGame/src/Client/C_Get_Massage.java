/*
   �����带 ��ӹ޾� �޼����� ������ �۽� Ŭ���� 
 */
package Client;

import java.io.BufferedReader; // ���ۿ� �Է¹޾� String���� ���� - System.in�� ����ϱ� ���ϵ��� ����� ���� import
import java.io.IOException;  // ����� ���� ó���� �ϱ����� import
import java.io.InputStreamReader;  // char ���·� �Է��Ҽ� �ִ�. 
import java.net.Socket; // ���ϻ��


public class C_Get_Massage extends Thread{  //������ ���
private Socket Main_Socket; // ���ο��� Socket�� �ޱ� ����

// ������ run�޼ҵ� �������̵�
public void run() {
	super.run();
	
	try {
		BufferedReader C_Buffered_Massage = new BufferedReader(new InputStreamReader(Main_Socket.getInputStream()));
		//MainSocket�� InputStream���� ���ϰ� ����ϱ����� Buffered Reader �� ����
		
		String Get_Massage; // ���� �޼���
		
		while(true) { // ���� �ݺ����� Ŭ���̾�Ʈ�� ���Ḧ ���ҽñ��� �ݺ�
			
			Get_Massage = C_Buffered_Massage.readLine(); // ���Ͽ� �Էµ� �����͸� ���ڿ� ������ ��ȯ
			System.out.println("����	:	"+Get_Massage);
			}
		}catch(IOException e) {
			e.printStackTrace(); // ���� �߻��� Trace���ش�.
	}
	
	}


public void setMainSocket(Socket Socket) {	// �������� ���� ������ �ޱ����� Setta
	Main_Socket = Socket;	
}


}