package src.org.game.frame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameGame extends JFrame {
	// ȡ����Ļ�Ŀ��
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// ȡ����Ļ�ĸ߶�
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//����jp
				JPanel zyjp=new JPanel();
			
					
				
	public JFrameGame(){
		
			
			
				        
		// ���ñ���
		this.setTitle("����������֮��");
		// ���ô����С
		this.setSize(900, 650);
		/*//�����ޱ߿�
		setUndecorated(true);*/
		// ���ô������λ��
		this.setLocation((width - 900) / 2, (height - 650) / 2);
		
		zyjp.setLayout(null);
		zyjp.setSize(893, 620);
		
		// ������Ĺرշ�ʽ����ΪĬ�Ϲرպ�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(zyjp);
		
		
		//���ֿ�ʼ
		SetMusic musicZJM=new SetMusic("src/music/test13.wav",false,1); 
		
		final JPanelZYJM panel = new JPanelZYJM(zyjp,musicZJM);
		musicZJM.play();
		zyjp.add(panel);
	
		//
		Toolkit toolkit=Toolkit.getDefaultToolkit(); //�õ�Ĭ�ϵ�ToolKit����
		  Image image=toolkit.getImage("src/image/mouse/mouse.png"); //�õ�ͼ��
		  Cursor customCursor=toolkit.createCustomCursor(image,new Point(0,0),"MyCursor"); //ʵ�����Զ��������
		this.setCursor(customCursor);
		//
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image window=kit.getImage("src/image/window.jpg");
		setIconImage(window);
		
//		this.setUndecorated(true); // ȥ�����ڵ�װ��
//		getRootPane().setWindowDecorationStyle(1); //ͨ���ı�������ı䴰����ʽ
		
		this.setVisible(true);
		
		
		
		

		 
	}
	
	
	
	
	
	
}
