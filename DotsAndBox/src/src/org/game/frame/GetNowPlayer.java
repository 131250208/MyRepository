package src.org.game.frame;

import java.io.IOException;

public class GetNowPlayer {
	ReadAndWriteFile RW=new ReadAndWriteFile();
	String now;
	String[] temp;
	public GetNowPlayer(){
		try {
			temp=RW.Read("src/txt/nowPlayer.txt");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		now=temp[0];
	}
	
}
