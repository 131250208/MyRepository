package src.org.game.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TreadMove implements Runnable {
//�����߳���ͣ
	boolean stop=false;
	
	JLabel jl=new JLabel();
	ImageIcon image1;
	int X1,Y1,X2,Y2,Seconds,Length,Length1,X,Y;
	int times=0;//�ƶ�����
	int x0,y0;//�����ظ���ʼ��
	//��󲥷����ֵ�ַ
	String s="��";
	public	TreadMove(JPanel addjp,//�����Ǹ�Jp��
			int x1,int y1,//��ʼ����
			int x2,int y2,//�յ�����
			String address,//ͼƬ��ַ
			int seconds,//���ʱ��
			int length,//�ƶ�����
int where//������һ��
			){
		
		ImageIcon image=new ImageIcon(address);
		image1=image;
		X1=x1;
		Y1=y1;
		x0=x1;
		y0=y1;
		X2=x2;
		Y2=y2;
		int y=Math.abs(Y2-Y1);
		int x=Math.abs(X2-X1);
		X=x;
		Y=y;
//		Addx=addx;
		Seconds=seconds;
		Length=length;
		if(x!=0){
		Length1=(int)(length*(y/x));
		}
		if(x==0){
			Length1=length;
		}
		jl.setSize(image1.getIconWidth(), image1.getIconHeight());
		jl.setIcon(image1);
		jl.setLocation(x1, y1);
		addjp.setLayout(null);
		addjp.add(jl,where);
		
	}
	
	public void move()
	{
		X1=x0;
		Y1=y0;
		stop=false;
		Thread t=new Thread(this);
		t.start();	
	}
	public void move(int xx,int yy)
	{
		X1=xx;
		Y1=yy;
		stop=false;
		Thread t=new Thread(this);
		t.start();	
	}
	
	
//	public static void main(String[] args) {
//		
//		JFrame jf=new JFrame();
//		jf.setSize(800,500);
//		jf.getContentPane().setLayout(null);
//		JPanel jp=new JPanel();
//		jp.setSize(800, 500);
//		jf.getContentPane().add(jp);
//		jp.setLayout(null);
//		
//		TreadMove TM=new TreadMove(jp,0,0,400,400,"src/image/������/Ӫկ/��/1.png",200,10);
//		jf.setVisible(true);
//		
//		
//	}
	
	
	
	
	public void addMouseListener(MouseAdapter M){
		jl.addMouseListener(M);
	}
	
	
	public void addMouseListener(MouseListener M){
		jl.addMouseListener(M);
	}
	
	public void setIcon(ImageIcon im){
		jl.setIcon(im);
	}
	public int moveTime(){
		int movetime=0;
		if(X!=0){
		movetime=Seconds*(X/Length);
		}
		if(Y!=0){
			movetime=Seconds*(Y/Length1);
		}
		return movetime;
		
	}
	
	public void setMusic(String addr){
		s=addr;
	}
	
	public void stop(){
		stop=true;
	}
	public void start(){
		stop=false;
		run();
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		
		jl.setBounds(X1, Y1, image1.getIconWidth(), image1.getIconHeight());
		
			while((X1!=X2||Y1!=Y2)&&!stop){
    	       times++;
    	       if(X1<X2){
					X1=X1+Length;
					
				}
				else if(X1>X2){
					X1=X1-Length;
				}
				if(Y1<Y2){
					Y1=Y1+Length1;
					
				}
				else if(Y1>Y2){
					Y1=Y1-Length1;
				}
				try {
			
					Thread.sleep(Seconds);
		
				
				} catch (InterruptedException e) {
			
					// TODO �Զ����ɵ� catch ��
			
					e.printStackTrace();
		
				}
    	 
	    
				jl.setBounds(X1, Y1, image1.getIconWidth(), image1.getIconHeight());
    	 
//				System.out.println(x1);
    	 
				
			}
			
			if(s.equals("��")==false){
				//��Ч
				SetMusic musicAch=new SetMusic(s,false,2);
				musicAch.play();
			}

	}

}
