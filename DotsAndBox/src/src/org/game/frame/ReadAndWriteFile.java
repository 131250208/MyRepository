package src.org.game.frame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteFile {
	
	
	
	public ReadAndWriteFile(){
		
	}
	
	public String[]//返回的字符串数组
			Read(String addr//要读取文件的地址
			) throws IOException{
		//从TXT文件按行中读取数据
			
				  File file=new File(addr);
			         if(!file.exists()||file.isDirectory())
			             throw new FileNotFoundException();
			         BufferedReader br=new BufferedReader(new FileReader(file));
			         String temp=null;
			         StringBuffer sb=new StringBuffer();
			         temp=br.readLine();
			         while(temp!=null){
			             sb.append(temp+",");
			             temp=br.readLine();
			         }
				String txt=sb.toString();
				String[] txtline=txt.split(",");
				return txtline;//返回字符串数组，每个元素是一行命令
	}
	public void Write(String outstring[],//要写入的数组
			String addr//要写入的文件地址
			){
		File file=new File(addr);
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			for(int i=0;i<outstring.length;i++){
			out.write(outstring[i]);
			out.newLine();
			}
			out.close();
			
		} 
		catch (IOException e) {
				
		}
		
	
		
		
		
		
	}
	
}
