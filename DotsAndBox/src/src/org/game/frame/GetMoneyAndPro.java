package src.org.game.frame;

import java.io.IOException;

public class GetMoneyAndPro {
	
	ReadAndWriteFile RW=new ReadAndWriteFile();
	int Money,bought1,bought2,bought3;
	
	
	public GetMoneyAndPro(){
	String[] temp=new 	String[4];
	try {
		temp=RW.Read("src/txt/MoneyAndPro.txt");
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	Money=Integer.parseInt(temp[0]);
	bought1=Integer.parseInt(temp[1]);
	bought2=Integer.parseInt(temp[2]);
	bought3=Integer.parseInt(temp[3]);
	
	}
}
