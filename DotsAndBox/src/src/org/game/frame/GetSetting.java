package src.org.game.frame;

import java.io.IOException;

public class GetSetting {
	ReadAndWriteFile RW=new ReadAndWriteFile();
	int Music,Sound,Level,Style;
	String[] setting=new String[4];
	public GetSetting(){
		try {
			setting=RW.Read("src/txt/Setting.txt");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		Music=Integer.parseInt(setting[0]);
		Sound=Integer.parseInt(setting[1]);
		Level=Integer.parseInt(setting[2]);
		Style=Integer.parseInt(setting[3]);
		
	}
	
	
}
