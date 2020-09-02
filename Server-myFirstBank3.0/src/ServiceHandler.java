
import java.net.Socket;


/* 将 Connection 交给 ServiceHandler 来完全负责
 * 
 */
public class ServiceHandler extends Thread {
	 int index ;
	Socket socket;
	ATMDB db = new ATMDB();
	 
	public ServiceHandler(Socket socket) {
		this.socket = socket;
        
	}

	@Override
	public void run() {
		try {
			
			ServerConnection conn = new ServerConnection(socket);
			String[] input = recvData(conn);
			
			// 登录
			if (input[0].equals("SignIn")) {
				delungResponse(conn,input);
			}
			// 查询余额
			else if (input[0].equals("CheckMoneyService")) {
				chaxunResponse(conn,input);
			}
			// 取款
			else if (input[0].equals("getMoneyService")) {
				qukuangResponse(conn,input);
			}
			// 存款
			else if (input[0].equals("putMoneyService")) {
				cunkuangResponse(conn,input);
			}
			// 转账
			else if (input[0].equals("transferService")) {
				zhuanzhangResponse(conn,input);
			}
			// 关闭socket
			conn.close();
			conn = null;

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
//*******************************函数定义*********************************************************//
	
	// 接受客户端的请求数据
	public String[] recvData(ServerConnection conn) throws Exception {
		// 接受数据
		String request = conn.recvString();
		// 判断接收到的数据
		String[] input = request.split("&");
		return input;
	}
	// 登录
	public void delungResponse(ServerConnection conn,String[] input) throws Exception {

		/* 发送数据：响应返回数据 */
		String response;
		if (db.getUser(Integer.valueOf(input[1])) != null
				&& db.getUser(Integer.valueOf(input[1])).password.equals(input[2])) {
			index = Integer.valueOf(input[1]);
			response = String.valueOf(index);
		} else {
			response = "登录失败";
		}
		conn.sendString(response);
	}
	// 查询余额
	public void chaxunResponse(ServerConnection conn,String[] input) throws Exception {
		/* 发送数据：响应返回数据 */
		String response = String.valueOf(db.getUser(Integer.valueOf(input[1])).getMoney());
		conn.sendString(response);
	}
	// 取款
	public void qukuangResponse(ServerConnection conn,String[] input) throws Exception {
		String response;
		if (db.getUser(Integer.valueOf(input[2])).getMoney() < Float.valueOf(input[1])) {
			response = "取款失败！";
		} else {
			db.getUser(Integer.valueOf(input[2])).setMoney(db.getUser(Integer.valueOf(input[2])).getMoney() - Float.valueOf(input[1]));
			response = "取款成功";
			db.write_in();
		}
		conn.sendString(response);
	}
	// 存款
	public void cunkuangResponse(ServerConnection conn,String[] input) throws Exception {
		String response;
		if (Float.valueOf(input[1]) < 0) {
			response = "存款失败！";
		} else {
			db.getUser(Integer.valueOf(input[2])).setMoney(db.getUser(Integer.valueOf(input[2])).getMoney() + Float.valueOf(input[1]));
			response = "存款成功";
			db.write_in();
		}
		conn.sendString(response);
	}
	// 转账
	public void zhuanzhangResponse(ServerConnection conn,String[] input) throws Exception {
		String response;
		if (db.getUser(Integer.valueOf(input[1])) != null) {
			if (db.getUser(Integer.valueOf(input[3])).getMoney() >= Float.valueOf(input[2])) {
				db.getUser(Integer.valueOf(input[3])).setMoney(db.getUser(Integer.valueOf(input[3])).getMoney() - Float.valueOf(input[2]));
				db.getUser(Integer.valueOf(input[1]))
						.setMoney(db.getUser(Integer.valueOf(input[1])).getMoney() + Float.valueOf(input[2]));
				db.write_in();
				response = "转账成功";
			} else {
				response = "余额不足";
			}
		} else {
			response = "账号不存在";
		}
		conn.sendString(response);
	}

}