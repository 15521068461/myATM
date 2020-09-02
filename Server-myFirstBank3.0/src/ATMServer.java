

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;



public class ATMServer{

	public static void main(String[] args) throws Exception{
		try {
		// 建立服务器, 服务于 2019 端口
        ServerSocket serverSock = new ServerSocket(2019);
        System.out.println("服务器启动,等待连接...");
 
        
        while(true) {
        	// 监听请求,阻塞等待,直接有客户端发起连接 ...
            Socket conn = serverSock.accept();
            ServiceHandler handler = new ServiceHandler(conn);
            handler.start(); 

             }
         } catch (IOException e) {
             e.printStackTrace();
		}
	}

}
