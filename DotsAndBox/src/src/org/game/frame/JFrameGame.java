package src.org.game.frame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameGame extends JFrame {
	// 取得屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 取得屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//基层jp
				JPanel zyjp=new JPanel();
			
					
				
	public JFrameGame(){
		
			
			
				        
		// 设置标题
		this.setTitle("阿瞒的奇妙之旅");
		// 设置窗体大小
		this.setSize(900, 650);
		/*//设置无边框
		setUndecorated(true);*/
		// 设置窗体出现位置
		this.setLocation((width - 900) / 2, (height - 650) / 2);
		
		zyjp.setLayout(null);
		zyjp.setSize(893, 620);
		
		// 将窗体的关闭方式设置为默认关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(zyjp);
		
		
		//音乐开始
		SetMusic musicZJM=new SetMusic("src/music/test13.wav",false,1); 
		
		final JPanelZYJM panel = new JPanelZYJM(zyjp,musicZJM);
		musicZJM.play();
		zyjp.add(panel);
	
		//
		Toolkit toolkit=Toolkit.getDefaultToolkit(); //得到默认的ToolKit对象
		  Image image=toolkit.getImage("src/image/mouse/mouse.png"); //得到图像
		  Cursor customCursor=toolkit.createCustomCursor(image,new Point(0,0),"MyCursor"); //实例化自定义光标对象
		this.setCursor(customCursor);
		//
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image window=kit.getImage("src/image/window.jpg");
		setIconImage(window);
		
//		this.setUndecorated(true); // 去掉窗口的装饰
//		getRootPane().setWindowDecorationStyle(1); //通过改变参数来改变窗体样式
		
		this.setVisible(true);
		
		
		
		

		 
	}
	
	
	
	
	
	
}
