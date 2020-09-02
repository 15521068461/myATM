

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
	
	//获取文件
	  File filename = new File("C:\\example\\db.txt");
	//定义集合存储数据 （暂时创建的集合，没有考虑静态动态）
	  ArrayList<User> list = new ArrayList<>();
	
	  //构造函数
	  public ATMDB()  {
		  InputStreamReader reader;
		try {
			reader = new InputStreamReader( new FileInputStream(filename));
		  BufferedReader br = new BufferedReader(reader); 
		    
		  //取出db.txt,内容存入list
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

	//从文本中根据账号查询User对象
	  public User getUser(int cardNum) throws IOException {
	   for(int i=0;i<2;i++) {
		   if(list.get(i).cardNum==cardNum ) {
			   return list.get(i);
		   }
	   }
      return null ;
    }
	
	  //先清空旧文本，然后写入新文本并保存
	  public void write_in() throws IOException {
		  
		  clearInfoForFile("C:\\example\\db.txt");
		  FileWriter writer = new FileWriter(filename , true);
		    BufferedWriter out = new BufferedWriter(writer);

          for (int i = 0; i < list.size(); i++) {	    	
	       out.write(list.get(i).cardNum+","+list.get(i).password+","+list.get(i).money);
		    out.newLine();
	     }
    	  out.flush(); // 把缓存区内容压入文件  
        out.close(); // 最后记得关闭文件  
	  } 
	
	  //清空db.txt文本
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
