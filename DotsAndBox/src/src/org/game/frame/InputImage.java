package src.org.game.frame;

import java.util.Arrays;

import javax.swing.ImageIcon;

public class InputImage {

	static ImageIcon[] imgs=null;
	static int i;
	static int l;
	public InputImage(String filename,int length,String type){
		l=length;
		imgs=new ImageIcon[length];
		for(i=0;i<length;i++){
			
			imgs[i]=new ImageIcon("src/image\\vedio\\"+filename+"\\"+String.valueOf(i)+"."+type);
		}
	}
	
	public ImageIcon[] reImages(){
		
		return imgs;
		
	}
	public static void sellectimg(){
		//System.out.println(l);
      for(i=0;i<l;i++){
			
        imgs[i]=null;		}
	}
	
}


