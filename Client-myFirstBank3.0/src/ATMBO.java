

public class ATMBO {
    

	//��¼У��(����ȡ������)
	public int sign(int sno,String pw) throws Exception {
	
		//��������(�ѷ�װ)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);
        // ��������
        String outputMsg = "SignIn&"+sno+"&"+pw;
        conn.sendString(outputMsg);
        // ��������
        String response = conn.recvString();
        // �ر�����
        conn.close();
        if(!response.equals("��¼ʧ��")) {
	    return  Integer.valueOf(response);
        }else {
        	return 0;
        }
	}

	//��ѯ���
	public float checkMoney(int index) throws Exception {
		
		//��������(�ѷ�װ)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);       
       //��������
        String outputMsg = "CheckMoneyService&"+index;
        conn.sendString(outputMsg);
         // ��������
        String response = conn.recvString();
        float result = Float.valueOf(response);
        // �ر�����
        conn.close();
        return result;
		
	}
	
	//ȡǮ
	public boolean getMoney( float money,int index) throws Exception  {
		    
	    //��������(�ѷ�װ)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);       
        // ��������
        String outputMsg = "getMoneyService&"+money+"&"+index;
        conn.sendString(outputMsg);
        // ��������
        String response = conn.recvString();         
        // �ر�����
        conn.close();
        return response.equals("ȡ��ɹ�");
	   
	   
	}
	//��Ǯ
	public boolean putMoney(float money,int index) throws Exception {
		 
	    //��������(�ѷ�װ)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);
        // ��������
        String outputMsg = "putMoneyService&"+money+"&"+index;
        conn.sendString(outputMsg);
        // ��������
        String response = conn.recvString();           
        // �ر�����
        conn.close();
        return response.equals("���ɹ�");
	    
	  
	}
	//ת��
	public int transfer(int otherNum,float money,int index) throws Exception {
	  	 
		//��������(�ѷ�װ)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);     
        // ��������
        String outputMsg = "transferService&"+otherNum+"&"+money+"&"+index;
        conn.sendString(outputMsg);
        // ��������
        String response = conn.recvString();   
        // �ر�����
        conn.close();
        if(response.equals("ת�˳ɹ�")) {
        return 1;
	       } 
        else {
        	 return -1;
        }
	}	
	
}
