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
	
	public String[]//���ص��ַ�������
			Read(String addr//Ҫ��ȡ�ļ��ĵ�ַ
			) throws IOException{
		//��TXT�ļ������ж�ȡ����
			
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
				return txtline;//�����ַ������飬ÿ��Ԫ����һ������
	}
	public void Write(String outstring[],//Ҫд�������
			String addr//Ҫд����ļ���ַ
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
