

public class ATMBO {
    

	//登录校验(并读取出数据)
	public int sign(int sno,String pw) throws Exception {
	
		//创建连接(已封装)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);
        // 发送数据
        String outputMsg = "SignIn&"+sno+"&"+pw;
        conn.sendString(outputMsg);
        // 接收数据
        String response = conn.recvString();
        // 关闭连接
        conn.close();
        if(!response.equals("登录失败")) {
	    return  Integer.valueOf(response);
        }else {
        	return 0;
        }
	}

	//查询余额
	public float checkMoney(int index) throws Exception {
		
		//创建连接(已封装)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);       
       //发送数据
        String outputMsg = "CheckMoneyService&"+index;
        conn.sendString(outputMsg);
         // 接收数据
        String response = conn.recvString();
        float result = Float.valueOf(response);
        // 关闭连接
        conn.close();
        return result;
		
	}
	
	//取钱
	public boolean getMoney( float money,int index) throws Exception  {
		    
	    //创建连接(已封装)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);       
        // 发送数据
        String outputMsg = "getMoneyService&"+money+"&"+index;
        conn.sendString(outputMsg);
        // 接收数据
        String response = conn.recvString();         
        // 关闭连接
        conn.close();
        return response.equals("取款成功");
	   
	   
	}
	//存钱
	public boolean putMoney(float money,int index) throws Exception {
		 
	    //创建连接(已封装)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);
        // 发送数据
        String outputMsg = "putMoneyService&"+money+"&"+index;
        conn.sendString(outputMsg);
        // 接收数据
        String response = conn.recvString();           
        // 关闭连接
        conn.close();
        return response.equals("存款成功");
	    
	  
	}
	//转账
	public int transfer(int otherNum,float money,int index) throws Exception {
	  	 
		//创建连接(已封装)
		ClientConnection conn = new ClientConnection();
		conn.connect( "127.0.0.1", 2019);     
        // 发送数据
        String outputMsg = "transferService&"+otherNum+"&"+money+"&"+index;
        conn.sendString(outputMsg);
        // 接收数据
        String response = conn.recvString();   
        // 关闭连接
        conn.close();
        if(response.equals("转账成功")) {
        return 1;
	       } 
        else {
        	 return -1;
        }
	}	
	
}
