package src.org.game.frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Timetable extends JPanel implements  Runnable {
  
	
	
	//保存剩余时间
   
static int lefttime=180;
//中断计时
boolean isCountinue=true;
	//线程
	Thread t=new Thread(this);
	//显示时间的字符串
	String time="无";
	//图片
	BufferedImage background = null;
	Chess1 chess;
	ChessCG chess2;
	int S;
	public Timetable(Chess1 jp//传递棋盘
			,ChessCG jp2
			,int style//计时器种类   1代表超时随机下 2代表超时判负
			){
		
		//传参
		chess =jp;
		chess2 =jp2;
		S=style;
		//设置面板布局管理器
		this.setLayout(null);
		//设置面板大小
		this.setSize(150,30);
		//加坐标监听
		MouseListenerXY xy=new MouseListenerXY();
		this.addMouseListener(xy);
		//图片
try{
			
			
	background=ImageIO.read(new File("src/image/frameAndButton/timetable.png"));
	
          }catch(IOException e){
	     // TODO Auto-generated catch block
	    e.printStackTrace();
         }
		
	
	
	}
	
	public int getTime(){
		return lefttime;
	}
	public void setTime(int cmd){
		lefttime=cmd;
	}
	
	public void paint(Graphics g) {
		//双缓冲
		BufferedImage bi = new BufferedImage(150, 30,BufferedImage.TYPE_INT_RGB);
		Graphics g2 = bi.createGraphics();
		//画背景
		g2.drawImage(background,0, 0, this);
		//设置字体
		g2.setFont(new Font("宋体", 0, 14));
		//打出时间
		g2.drawString("剩余：" + time, 40,20);
		//双缓冲
		g.drawImage(bi, 0, 0, this);
	}

	
	
	public void timeStart(){
		t.start();
	}

	public void timeStop(){
		isCountinue=false;
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	
		while(isCountinue){
			
			time=lefttime/60+":"+(lefttime-lefttime/60*60);
			repaint();
			if(lefttime!=0){
			lefttime--;
			}
			else{
				if(S==1){
				chess.punish();
				chess.HIT=true;
				lefttime=180;
				}
				else if(S==2){
					if(chess2.isMine==true){
						chess2.timeover(2);
					}
					if(chess2.isMine==false){
						chess2.timeover(1);
					}
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
	
		}
		
		
	}
	
}
