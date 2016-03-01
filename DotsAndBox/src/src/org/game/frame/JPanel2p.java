package src.org.game.frame;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Window.Type;

import javax.swing.*;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class JPanel2p extends JPanel implements MouseListener {//2p������ģʽ�������
	           //��ʼ��
	int i,j,m,n,mpoints=0,epoints=0,stepnum=0;
	            // ȡ����Ļ�Ŀ��
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				// ȡ����Ļ�ĸ߶�
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
				
                //���Ʒ��ذ�ť
				int work=1;
				 
				
				// ����ͼƬ��ֵ
				BufferedImage bg1 = null;
				
				BufferedImage yz1 = null;
				BufferedImage yz2 = null;
				BufferedImage qp1 = null;
				BufferedImage wb1 = null;
				BufferedImage wb2= null;
				BufferedImage db1 = null;
				BufferedImage db2 = null;
				//ͼƬ
				ImageIcon Bg0=new ImageIcon("src/image/background/ms0.jpg");
				ImageIcon Bg1=new ImageIcon("src/image/background/ms1.jpg");
				//ͼƬ
				ImageIcon p1=new ImageIcon("src/image/frameAndButton/prompt/p1.png");
				//�������������� 
				int x=0;
		          int y=0;
		          //�������бߣ�1��ʾ�Լ��ģ�2��ʾ�Է��ģ�0��ʾû��
		          int [][] hb=new int[6][5];
		          int [][] sb=new int[6][5];
		          //����box
		          int [][] box= new int[5][5];
		          
		          //��ʶ�ֵ�˭
		          boolean isMine=true;
		          //�������ⲽ��˭�ߵ�,1��ʾ���ߵģ�2��ʾ�Է�
		         int step=0;
		         //�жϱ����Ƿ����
		         boolean isOver=true;
		         Chess1 qpP = new Chess1();
		         
		         JLabel background=new JLabel();
		         		         		         
		         Timetable timetable = new Timetable(qpP,null,1);
		     //
		     	JLabel myhousenum = new JLabel("\u8425\u5BE8");
		     	JLabel dhousenum = new JLabel("\u8425\u5BE8");
		     	
		     	//
		     	//���ݲ���������
		         JPanel zyp;
		         Timetable T;
		         
		       //���ذ�ť
		         JLabel FH=new JLabel();
		 		ImageIcon fh=new ImageIcon("src/image/frameAndButton/jump/fh.jpg");
		 		ImageIcon fh2=new ImageIcon("src/image/frameAndButton/jump/fh2.jpg");
		 		
		 		//����
				SetMusic musicFighting=new SetMusic("src/music/bgm/fighting.wav",true,1);
				JPanelYXMS BF;
				 //��ʾ��
		         JLabel prom= new JLabel();
	public JPanel2p(JPanelYXMS bf,JPanel add,
			int ms//1��ʾ2p 0��ʾ����
			) {
		
		BF=bf;
		musicFighting.play();
		//���ñ���
		
	
		if(ms==1){
			background.setIcon(Bg1);
	
		}
		else if(ms==0){
			background.setIcon(Bg0);
			
		}
		
		
		//���ݲ���
		zyp=add;
		qpP.pass(myhousenum, dhousenum, this, zyp,ms);
		//System.out.println("ms="+ms);
		 //��������ֵ
	    T=timetable;
	    
		// ��������С
		this.setSize(900, 650);
		//������岼�ֹ�����
		this.setLayout(null);
//		ImageIcon imageicon=new ImageIcon("d:/workplace/Dotsandboxes/src/image/���/���2.png");
//		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imageicon.getImage(), new Point(0,0),"invisiblecursor"));
		
		
		
		
		
		JLabel wjiang = new JLabel("\u6B66\u5C06");
		if(ms==1){
		wjiang.setIcon(new ImageIcon("src/image/hero/��.jpg"));
		}
		else if(ms==0){
			wjiang.setIcon(new ImageIcon("src/image/hero/�ܲ�.jpg"));	
		}
		wjiang.setBackground(Color.BLACK);
		wjiang.setForeground(Color.BLACK);
		wjiang.setBounds(30, 140, 150, 200);
		this.add(wjiang);
		
		
	
		myhousenum.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\0.png"));
		myhousenum.setBounds(30, 350, 100, 50);
		this.add(myhousenum);
		
		
		JLabel djiang = new JLabel("\u6B66\u5C06");
		if(ms==1){
			djiang.setIcon(new ImageIcon("src/image/hero/����.jpg"));
			}
			else if(ms==0){
				djiang.setIcon(new ImageIcon("src/image/hero/���.jpg"));	
			}
		djiang.setForeground(Color.BLACK);
		djiang.setBackground(Color.BLACK);
		djiang.setBounds(722, 140, 150, 200);
		this.add(djiang);
		
//		JButton dskill = new JButton("\u6280\u80FD");
//		dskill.setIcon(new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u6846\u67B6\u4E0E\u6309\u94AE\\jn5.png"));
//		dskill.setBounds(722, 350, 150, 50);
//		this.add(dskill);
		
		
		dhousenum.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\0.png"));
		dhousenum.setBounds(772, 350, 100, 50);
		this.add(dhousenum);
		
		JLabel guanka = new JLabel("\u5173\u5361\u6570");
		
		if(ms==1){
		guanka.setIcon(new ImageIcon("src/image/frameAndButton/passbox/nf.jpg"));
		}
		
         
		else if(ms==0){
			guanka.setIcon(new ImageIcon("src/image/frameAndButton/passbox/jdzdz.jpg"));
		}
		guanka.setBounds(320, 10, 270, 60);
		this.add(guanka);
		
		
		
		
		timetable.setBounds(392, 569, 150, 30);
		this.add(timetable);
//		timetable.lefttime=180;
//		timetable.timeStart();
		
		
		//׼��
		if(ms==1){
		JPanelReady RD=new JPanelReady(timetable,4);
		this.add(RD,0);
		}
		else if(ms==0){
			JPanelReady RD=new JPanelReady(timetable,5);
			this.add(RD,0);
		}
		
		//��ʾ��
				prom.setBounds(705, 530, 160, 70);
				this.add(prom,-1);
				prom.setIcon(p1);
				
		//����
		qpP.setBounds(215, 85, 470, 470);
		this.add(qpP,1);
	
		
		//���ذ�ť
		
				FH.setIcon(fh);
				FH.setBounds(745, 480, fh.getIconWidth(), fh.getIconHeight());
				this.add(FH,-1);
				FH.addMouseListener(this);
		
		background.setBounds(0, 0, 893, 620);
		this.add(background);
		
		
		//����
		zyp.add(this);
		this.setBounds(0, 0, 893, 620);
		this.repaint();
		bf.setVisible(false);
		this.setVisible(true);
		

	}
	
	
	
	
	
	//ֹͣ��ʱ
	public void timeStop(){
		T.timeStop();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		if(work==1){
					musicFighting.stop();
					//��Ч
							SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
							musicConfirm.play();
							
					
					timetable.timeStop();
				//	JPanelYXMS yxms=new JPanelYXMS(zyp,BF.ZYJM);
				//	zyp.add(yxms);
				//	yxms.setLocation(0, 0);
					BF.setVisible(true);
					this.setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//��Ч
		SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
		musicEnter.play();
		FH.setIcon(fh2);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		FH.setIcon(fh);
	}
}
