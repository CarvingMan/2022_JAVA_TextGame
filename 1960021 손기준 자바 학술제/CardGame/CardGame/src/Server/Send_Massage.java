/*
   �����带 ��ӹ޾� �޼����� ������ �۽� Ŭ���� 
 */
package Server;

import java.io.BufferedReader; // ���ۿ� �Է¹޾� String���� ���� - System.in�� ����ϱ� ���ϵ��� ����� ���� import
import java.io.IOException;  // ����� ���� ó���� �ϱ����� import
import java.io.InputStreamReader;  // char ���·� �Է��Ҽ� �ִ�. 
import java.io.PrintWriter; // OutputStream ���� ����ϱ� ���ϰ� �ϱ����� import
//File(String), OutputStream, Writer ���� ��ü�� �μ��� �޾� �� �����ϰ� ��Ʈ���� ������ �� �ִ�.

import java.net.Socket; // ���ϻ��


public class Send_Massage extends Thread {
	
	private Socket Main_Socket;  // ���ο��� Socket�� �ޱ� ����
	
// run  �޼ҵ� ������
	public void run() {
		
		super.run();
		try {
			BufferedReader Buffered_Massage = new BufferedReader(new InputStreamReader(System.in)); 
			// System.in�� ����ϱ� ���ϰ� �ϱ����� BufferedReader Ŭ������ ����
			// System.in ���� �����͸� readLine()���� �޾� ���ڿ��� ���ۿ� ���� �� 
			PrintWriter Send_Writer = new PrintWriter(Main_Socket.getOutputStream());
			//OutputStream ��ü�� �μ��� �޾� �� �����ϰ� ��Ʈ���� ����
			// Main_Socket.getOutputStream()		->		������ ��½�Ʈ���� ��ȯ
			String Send_Massage; // ��Ʈ���� �޼���
			
			while(true) { // ���� ������ �������� ���۰���
			
				Send_Massage = Buffered_Massage.readLine(); // BufferedReaderd ���� �Է¹��� ���ڿ� ����
															 // readLine() : BufferedReader�� �޼ҵ� ������ �о� String���� ��ȯ
				
				Send_Writer.println(Send_Massage); //  ���ۿ� ����� �Է� ���� �� ���
				Send_Writer.flush(); // ���� flush
			}
			
		
		}catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	public void setMain_Socket(Socket Socket) {
		Main_Socket = Socket;  // �������� ���� ������ �ޱ����� Setta
	}

}
