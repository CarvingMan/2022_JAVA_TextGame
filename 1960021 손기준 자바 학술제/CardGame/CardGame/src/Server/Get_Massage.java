/*
   �����带 ��ӹ޾� �޼����� ������ �۽� Ŭ���� 
 */
package Server;

import java.io.BufferedReader; // ���ۿ� �Է¹޾� String���� ���� - System.in�� ����ϱ� ���ϵ��� ����� ���� import
import java.io.IOException;  // ����� ���� ó���� �ϱ����� import
import java.io.InputStreamReader;  // char ���·� �Է��Ҽ� �ִ�. 
import java.net.Socket; // ���ϻ��


public class Get_Massage extends Thread{  //������ ���
private Socket Main_Socket; // ���ο��� Socket�� �ޱ� ����

// ������ run�޼ҵ� �������̵�
public void run() {
	super.run();
	
	try {
		BufferedReader Buffered_Massage = new BufferedReader(new InputStreamReader(Main_Socket.getInputStream()));
		//MainSocket�� InputStream���� ���ϰ� ����ϱ����� Buffered Reader �� ����
		
		String Get_Massage; // ���� �޼���
		
		while(true) { // ���� �ݺ����� Ŭ���̾�Ʈ�� ���Ḧ ���ҽñ��� �ݺ�
			Get_Massage = Buffered_Massage.readLine(); // ���Ͽ� �Էµ� �����͸� ���ڿ� ������ ��ȯ
			
			if(Get_Massage == null) { // ���� �����Ͱ� null �Ͻ� ���Ͽ����� ������ �� �̱⿡ ���ѹݺ��� Ż��
				System.out.println("\tŬ���̾�Ʈ�� ������ ������ϴ�.");
				break;
			}
			else
			{
				System.out.println("Ŭ���̾�Ʈ	:	"+Get_Massage);
			}
		}
		
		Buffered_Massage.close();  // ���� ����
	}catch(IOException e) {
			e.printStackTrace(); // ���� �߻��� Trace���ش�.
		
	}
	
	
}

public void setMainSocket(Socket Socket) {	// �������� ���� ������ �ޱ����� Setta
	Main_Socket = Socket;	
}


}