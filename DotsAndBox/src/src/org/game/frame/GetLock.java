package src.org.game.frame;

import java.io.IOException;

public class GetLock {
	
	ReadAndWriteFile RW=new ReadAndWriteFile();
	String[] lock;
    int pass1,pass2,pass3,pass4,pass5;
	public GetLock(){
	
		try {
		lock=RW.Read("src/txt/lock.txt");
	
		} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	
		}

		pass1=Integer.parseInt(lock[0]);
		pass2=Integer.parseInt(lock[1]);
		pass3=Integer.parseInt(lock[2]);
		pass4=Integer.parseInt(lock[3]);
		pass5=Integer.parseInt(lock[4]);
		
	}
	
	public void deblocking(int pass){
		switch(pass){
		case 1:pass1=1;
			break;
		case 2:pass2=1;
			break;
		case 3:pass3=1;
			break;
		case 4:pass4=1;
			break;
		case 5:pass5=1;
			break;
		}
		
		lock[0]=String.valueOf(pass1);
		lock[1]=String.valueOf(pass2);
		lock[2]=String.valueOf(pass3);
		lock[3]=String.valueOf(pass4);
		lock[4]=String.valueOf(pass5);
		
		RW.Write(lock, "src/txt/lock.txt");
		
	}
}
