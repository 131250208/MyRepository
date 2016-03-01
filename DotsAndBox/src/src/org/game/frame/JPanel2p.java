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

public class JPanel2p extends JPanel implements MouseListener {//2p与特殊模式都用这个
	           //初始化
	int i,j,m,n,mpoints=0,epoints=0,stepnum=0;
	            // 取得屏幕的宽度
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				// 取得屏幕的高度
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
				
                //控制返回按钮
				int work=1;
				 
				
				// 赋给图片初值
				BufferedImage bg1 = null;
				
				BufferedImage yz1 = null;
				BufferedImage yz2 = null;
				BufferedImage qp1 = null;
				BufferedImage wb1 = null;
				BufferedImage wb2= null;
				BufferedImage db1 = null;
				BufferedImage db2 = null;
				//图片
				ImageIcon Bg0=new ImageIcon("src/image/background/ms0.jpg");
				ImageIcon Bg1=new ImageIcon("src/image/background/ms1.jpg");
				//图片
				ImageIcon p1=new ImageIcon("src/image/frameAndButton/prompt/p1.png");
				//保存横杠中心坐标 
				int x=0;
		          int y=0;
		          //保存所有边，1表示自己的，2表示对方的，0表示没有
		          int [][] hb=new int[6][5];
		          int [][] sb=new int[6][5];
		          //保存box
		          int [][] box= new int[5][5];
		          
		          //标识轮到谁
		          boolean isMine=true;
		          //保存上这步是谁走的,1表示我走的，2表示对方
		         int step=0;
		         //判断本局是否结束
		         boolean isOver=true;
		         Chess1 qpP = new Chess1();
		         
		         JLabel background=new JLabel();
		         		         		         
		         Timetable timetable = new Timetable(qpP,null,1);
		     //
		     	JLabel myhousenum = new JLabel("\u8425\u5BE8");
		     	JLabel dhousenum = new JLabel("\u8425\u5BE8");
		     	
		     	//
		     	//传递参数与引用
		         JPanel zyp;
		         Timetable T;
		         
		       //返回按钮
		         JLabel FH=new JLabel();
		 		ImageIcon fh=new ImageIcon("src/image/frameAndButton/jump/fh.jpg");
		 		ImageIcon fh2=new ImageIcon("src/image/frameAndButton/jump/fh2.jpg");
		 		
		 		//音乐
				SetMusic musicFighting=new SetMusic("src/music/bgm/fighting.wav",true,1);
				JPanelYXMS BF;
				 //提示栏
		         JLabel prom= new JLabel();
	public JPanel2p(JPanelYXMS bf,JPanel add,
			int ms//1表示2p 0表示特殊
			) {
		
		BF=bf;
		musicFighting.play();
		//设置背景
		
	
		if(ms==1){
			background.setIcon(Bg1);
	
		}
		else if(ms==0){
			background.setIcon(Bg0);
			
		}
		
		
		//传递参数
		zyp=add;
		qpP.pass(myhousenum, dhousenum, this, zyp,ms);
		//System.out.println("ms="+ms);
		 //传递引用值
	    T=timetable;
	    
		// 设置面板大小
		this.setSize(900, 650);
		//设置面板布局管理器
		this.setLayout(null);
//		ImageIcon imageicon=new ImageIcon("d:/workplace/Dotsandboxes/src/image/光标/光标2.png");
//		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imageicon.getImage(), new Point(0,0),"invisiblecursor"));
		
		
		
		
		
		JLabel wjiang = new JLabel("\u6B66\u5C06");
		if(ms==1){
		wjiang.setIcon(new ImageIcon("src/image/hero/马超.jpg"));
		}
		else if(ms==0){
			wjiang.setIcon(new ImageIcon("src/image/hero/曹操.jpg"));	
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
			djiang.setIcon(new ImageIcon("src/image/hero/吕布.jpg"));
			}
			else if(ms==0){
				djiang.setIcon(new ImageIcon("src/image/hero/周瑜.jpg"));	
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
		
		
		//准备
		if(ms==1){
		JPanelReady RD=new JPanelReady(timetable,4);
		this.add(RD,0);
		}
		else if(ms==0){
			JPanelReady RD=new JPanelReady(timetable,5);
			this.add(RD,0);
		}
		
		//提示栏
				prom.setBounds(705, 530, 160, 70);
				this.add(prom,-1);
				prom.setIcon(p1);
				
		//棋盘
		qpP.setBounds(215, 85, 470, 470);
		this.add(qpP,1);
	
		
		//返回按钮
		
				FH.setIcon(fh);
				FH.setBounds(745, 480, fh.getIconWidth(), fh.getIconHeight());
				this.add(FH,-1);
				FH.addMouseListener(this);
		
		background.setBounds(0, 0, 893, 620);
		this.add(background);
		
		
		//交替
		zyp.add(this);
		this.setBounds(0, 0, 893, 620);
		this.repaint();
		bf.setVisible(false);
		this.setVisible(true);
		

	}
	
	
	
	
	
	//停止计时
	public void timeStop(){
		T.timeStop();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
					musicFighting.stop();
					//音效
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
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		//音效
		SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
		musicEnter.play();
		FH.setIcon(fh2);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		FH.setIcon(fh);
	}
}
