
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* 鏈嶅姟绔殑杩炴帴
 * 
 */
public class ServerConnection
{
	public String charset = "UTF-8";  // 瀛楃闆�: UTF-8 鎴� GBK
	
	private Socket sock ;	
    private InputStream inputStream ;
    private OutputStream outputStream ; 
	private byte[] inputBuffer = new byte[4000]; 
	
	public ServerConnection(Socket sock) throws Exception
	{
		this.sock = sock;
        inputStream= sock.getInputStream();
        outputStream = sock.getOutputStream(); 
	}
	
	public void close()
	{
		try {
			sock.close();
			sock = null;
		}catch(Exception e)
		{			
		}
	}
	
	// 鍙戦�佸瓧绗︿覆
	public void sendString(String msg) throws Exception
	{
		byte[] data = msg.getBytes( this.charset );
		outputStream.write(data);
	}
	
	// 鎺ユ敹瀛楃涓�
	public String recvString() throws Exception
	{
		int n = inputStream.read(inputBuffer);
		String msg = new String(inputBuffer, 0, n, "UTF-8");
		return msg;
	}
}
