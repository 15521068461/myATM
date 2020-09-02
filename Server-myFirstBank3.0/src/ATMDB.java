

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ATMDB {
	
	//��ȡ�ļ�
	  File filename = new File("C:\\example\\db.txt");
	//���弯�ϴ洢���� ����ʱ�����ļ��ϣ�û�п��Ǿ�̬��̬��
	  ArrayList<User> list = new ArrayList<>();
	
	  //���캯��
	  public ATMDB()  {
		  InputStreamReader reader;
		try {
			reader = new InputStreamReader( new FileInputStream(filename));
		  BufferedReader br = new BufferedReader(reader); 
		    
		  //ȡ��db.txt,���ݴ���list
		    for(int i = 0 ; i<2;i++) {
		    String line = br.readLine();
		    String[] strs = line.split(",");
		    User user =new User(Integer.valueOf(strs[0]),strs[1],Float.valueOf(strs[2]));
		    list.add(user);	    
		  }
		} catch (IOException e) {
			e.printStackTrace();
		} 
	  }

	//���ı��и����˺Ų�ѯUser����
	  public User getUser(int cardNum) throws IOException {
	   for(int i=0;i<2;i++) {
		   if(list.get(i).cardNum==cardNum ) {
			   return list.get(i);
		   }
	   }
      return null ;
    }
	
	  //����վ��ı���Ȼ��д�����ı�������
	  public void write_in() throws IOException {
		  
		  clearInfoForFile("C:\\example\\db.txt");
		  FileWriter writer = new FileWriter(filename , true);
		    BufferedWriter out = new BufferedWriter(writer);

          for (int i = 0; i < list.size(); i++) {	    	
	       out.write(list.get(i).cardNum+","+list.get(i).password+","+list.get(i).money);
		    out.newLine();
	     }
    	  out.flush(); // �ѻ���������ѹ���ļ�  
        out.close(); // ���ǵùر��ļ�  
	  } 
	
	  //���db.txt�ı�
	  public static  void clearInfoForFile(String fileName) {
		   File file =new File(fileName);
		   try {
		      if(!file.exists()) {
		         file.createNewFile();
		      }
		      FileWriter fileWriter =new FileWriter(file);
		      fileWriter.write("");
		      fileWriter.flush();
		      fileWriter.close();
		   } catch (IOException e) {
		      e.printStackTrace();
		   }
		}
	

}
