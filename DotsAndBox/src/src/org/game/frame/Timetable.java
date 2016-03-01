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
  
	
	
	//����ʣ��ʱ��
   
static int lefttime=180;
//�жϼ�ʱ
boolean isCountinue=true;
	//�߳�
	Thread t=new Thread(this);
	//��ʾʱ����ַ���
	String time="��";
	//ͼƬ
	BufferedImage background = null;
	Chess1 chess;
	ChessCG chess2;
	int S;
	public Timetable(Chess1 jp//��������
			,ChessCG jp2
			,int style//��ʱ������   1����ʱ����� 2����ʱ�и�
			){
		
		//����
		chess =jp;
		chess2 =jp2;
		S=style;
		//������岼�ֹ�����
		this.setLayout(null);
		//��������С
		this.setSize(150,30);
		//���������
		MouseListenerXY xy=new MouseListenerXY();
		this.addMouseListener(xy);
		//ͼƬ
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
		//˫����
		BufferedImage bi = new BufferedImage(150, 30,BufferedImage.TYPE_INT_RGB);
		Graphics g2 = bi.createGraphics();
		//������
		g2.drawImage(background,0, 0, this);
		//��������
		g2.setFont(new Font("����", 0, 14));
		//���ʱ��
		g2.drawString("ʣ�ࣺ" + time, 40,20);
		//˫����
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
		// TODO �Զ����ɵķ������
		
	
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
	
		}
		
		
	}
	
}
