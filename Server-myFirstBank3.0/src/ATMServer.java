

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;



public class ATMServer{

	public static void main(String[] args) throws Exception{
		try {
		// ����������, ������ 2019 �˿�
        ServerSocket serverSock = new ServerSocket(2019);
        System.out.println("����������,�ȴ�����...");
 
        
        while(true) {
        	// ��������,�����ȴ�,ֱ���пͻ��˷������� ...
            Socket conn = serverSock.accept();
            ServiceHandler handler = new ServiceHandler(conn);
            handler.start(); 

             }
         } catch (IOException e) {
             e.printStackTrace();
		}
	}

}
