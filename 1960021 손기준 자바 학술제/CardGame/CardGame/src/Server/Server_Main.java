/*
   ������ ���θ޼ҵ� Ŭ����
 */

package Server;

import java.io.IOException; // ����� ���� ó���� ���� import
import java.net.ServerSocket; //���� ���ϻ��
import java.net.Socket; // Ŭ���̾�Ʈ�� ���� ���
public class Server_Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket S_Socket = null;
		Socket C_Socket = null;
		try {
			S_Socket = new ServerSocket(8889); // ���� ���� ��ü����
						//(new ServerSocket(���� port)) Ŭ���̾�Ʈ�� ������ �ޱ� ���� ��ٸ���.
			
			 C_Socket = S_Socket.accept();
				//������ Ŭ���̾�Ʈ�κ��� ���� ��û�� ������ accept()�޼ҵ忡�� ���ӵ� Ŭ���̾�Ʈ��
	          	//����ϵ��� ���� Ŭ���̾�Ʈ ������ ���� �����Ѵ�.
	          
			Get_Massage G_Massage = new Get_Massage(); // Get_Massage ������ ����
			G_Massage.setMainSocket(C_Socket); // Get_Massage�� MainSocket�� C_Socket Set
			
			Send_Massage S_Massage = new Send_Massage(); //Send_Massage ������ ����
			S_Massage.setMain_Socket(C_Socket); // Send_Massge�� MainSocket�� C_Socket Set
			
			
			
			G_Massage.start();  // �� ���� ������ ����
			S_Massage.start();
				
		}catch(IOException e) {
			e.printStackTrace(); // ���� �߻��� Trace
		}
		finally {
	         try {
	        		S_Socket.close(); // ��������
	         }catch(Exception ignored) {
	            
	         }
	      }
		
	}

}
