package src.org.game.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;

public class DJL extends JPanel {

	int x,y;
	int[] djl=new int[3];
	BufferedImage xdj1= null;
	BufferedImage xdj2= null;
	BufferedImage Ddj= null;
	
	
	//图片
	ImageIcon dj001=new ImageIcon("src\\image\\frameAndButton\\dj-1.png");
	ImageIcon dj002=new ImageIcon("src\\image\\frameAndButton\\dj-2.png");
	ImageIcon dj003=new ImageIcon("src\\image\\frameAndButton\\dj-3.png");
	
	ImageIcon dj01=new ImageIcon("src\\image\\frameAndButton\\dj01.png");
	ImageIcon dj02=new ImageIcon("src\\image\\frameAndButton\\dj02.png");
	ImageIcon dj03=new ImageIcon("src\\image\\frameAndButton\\dj03.png");
	
	MouselistenerPro pro1=new MouselistenerPro(1);
	MouselistenerPro pro2=new MouselistenerPro(2);
	MouselistenerPro pro3=new MouselistenerPro(3);
	public DJL(){
		
		
         this.setSize(150, 120);
      
         
         //查看有无道具
         int havePro1=new GetDataOfPlayer(new GetNowPlayer().now).Bought1;
         int havePro2=new GetDataOfPlayer(new GetNowPlayer().now).Bought2;
         int havePro3=new GetDataOfPlayer(new GetNowPlayer().now).Bought3;

         setLayout(null);
         JLabel dj1=new JLabel();
         dj1.addMouseListener(pro1);
         if(havePro1==1){
        	 dj1.setIcon(dj01);
        	 MouseListenerChangeimage mouseim1=new MouseListenerChangeimage(null,dj1,2,10);
        	 mouseim1.work=1;
         }
         else{
        	 dj1.setIcon(dj001);
         }
        
	     
         dj1.setBounds(15, 12, 121, 27);
         this.add(dj1,0);
         
         JLabel dj2 = new JLabel();
         dj2.addMouseListener(pro2);
         if(havePro2==1){
        	 dj2.setIcon(dj02);
        	 MouseListenerChangeimage mouseim2=new MouseListenerChangeimage(null,dj2,2,11);
        	 mouseim2.work=1;
         }
         else{
        	 dj2.setIcon(dj002);
         }
        
         dj2.setBounds(15, 42, 121, 27);
         add(dj2,1);
         
         JLabel dj3 = new JLabel();
         dj3.addMouseListener(pro3);
         if(havePro3==1){
        	 dj3.setIcon(dj03);
        	 MouseListenerChangeimage mouseim3=new MouseListenerChangeimage(null,dj3,2,12);
        	 mouseim3.work=1;
         }
         else{
        	 dj3.setIcon(dj003);
         }
         
         dj3.setBounds(15, 72, 121, 27);
         add(dj3,2);
         
         JLabel background = new JLabel("New label");
         background.setIcon(new ImageIcon("src\\image\\frameAndButton\\djk.png"));
         background.setBounds(0, 0, 150, 120);
         add(background,3);
     
	
	this.repaint();
	}
}

	