/*
   �����带 ��ӹ޾� �޼����� ������ Ŭ���̾�Ʈ �۽� Ŭ���� 
 */
package Client;

import java.io.BufferedReader; // ���ۿ� �Է¹޾� String���� ���� - System.in�� ����ϱ� ���ϵ��� ����� ���� import
import java.io.IOException;  // ����� ���� ó���� �ϱ����� import
import java.io.InputStreamReader;  // char ���·� �Է��Ҽ� �ִ�. 
import java.io.PrintWriter; // OutputStream ���� ����ϱ� ���ϰ� �ϱ����� import
//File(String), OutputStream, Writer ���� ��ü�� �μ��� �޾� �� �����ϰ� ��Ʈ���� ������ �� �ִ�.

import java.net.Socket; // ���ϻ��





public class C_Send_Massage extends Thread {
	
	private Socket Main_Socket;  // ���ο��� Socket�� �ޱ� ����
	
// run  �޼ҵ� ������
	public void run() {
		
		super.run();
		
		try {
			BufferedReader C_Buffered_Massage = new BufferedReader(new InputStreamReader(System.in)); 
			// System.in�� ����ϱ� ���ϰ� �ϱ����� BufferedReader Ŭ������ ����
			// System.in ���� �����͸� readLine()���� �޾� ���ڿ��� ���ۿ� ���� �� 
			PrintWriter C_Send_Writer = new PrintWriter(Main_Socket.getOutputStream());
			//OutputStream ��ü�� �μ��� �޾� �� �����ϰ� ��Ʈ���� ����
			// Main_Socket.getOutputStream()		->		������ ��½�Ʈ���� ��ȯ
			String C_Send_Massage; // ��Ʈ���� �޼���
			while(true) { // ���� ������ �������� ���۰���
				
				C_Send_Massage = C_Buffered_Massage.readLine(); // BufferedReaderd ���� �Է¹��� ���ڿ� ����
															 // readLine() : BufferedReader�� �޼ҵ� ������ �о� String���� ��ȯ
				
				if(C_Send_Massage.equals("����")) {// equals = ���ڿ� �� �޼ҵ� (==)�� �޸� ������ü�� ���Ѵ�. �ּҰ�X
					break;
				}
				
				C_Send_Writer.println(C_Send_Massage); //  ���ۿ� ����� �Է� ���� �� ���
				C_Send_Writer.flush(); // ���� flush
			}
			C_Buffered_Massage.close();  // �ݺ��� ���ӽ� ������ ����� ���߰� ��������
	 		C_Send_Writer.close();
	 		Main_Socket.close();
		
	 		
		}catch(IOException e) {
			e.printStackTrace(); 
			
		}
		
	}
	public void setMain_Socket(Socket Socket) {
		Main_Socket = Socket;  // �������� ���� ������ �ޱ����� Setta
	}

}
