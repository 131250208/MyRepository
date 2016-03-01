package src.org.game.frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.org.game.frame.JPanelYXMS;


public class JPanelZYJM extends JPanel implements  Runnable{
	
	
	
	Thread	tmusic2;
	
	
		
		//传递
		JPanel zyjp;
		SetMusic MM;
		
		
		final TreadMove ranklist= new TreadMove(this,963+85+350*2*3+1400*5+8000,305,563+85,305,"src/image/frameAndButton/zyjm/ranklist0.png",13,50,0);
		final TreadMove logo = new TreadMove(this,1015+85+350*2*5+1400*5+8000,350,0,350,"src/image/frameAndButton/zyjm/logo.png",13,50,0);
		final TreadMove exit = new TreadMove(this,963+85+350*2*4+1400*5+8000,397,563+85,397,"src/image/frameAndButton/zyjm/exit0.png",13,50,0);
		final TreadMove setting = new TreadMove(this,963+85+350*2*2+1400*5+8000,213,563+85,213,"src/image/frameAndButton/zyjm/setting0.png",13,50,0);
		final TreadMove instruction = new TreadMove(this,963+85+350*2+1400*5+8000,121,563+85,121,"src/image/frameAndButton/zyjm/instruction0.png",13,50,0);
		final TreadMove start = new TreadMove(this,963+85+1400*5+8000,27,563+85,27,"src/image/frameAndButton/zyjm/start0.png",13,50,0);
		
		
	public JPanelZYJM(JPanel zyp
		,SetMusic M
			) {
		MM=M;
		zyjp=zyp;
		
				
				
				
				
				
				this.setBounds(0, 0, 893, 620);
				
				this.setLayout(null);
				

//				JLabel temp=new JLabel();
//				temp.setBounds(0, 0, 5, 5);
//				panel.add(temp,0);
				

				
				MouseListenerZJM ml1=new MouseListenerZJM(1,start,zyjp,this,MM);
				start.addMouseListener(ml1);
				
				
				MouseListenerZJM ml2=new MouseListenerZJM(2,instruction,zyjp,this,MM);
				instruction.addMouseListener(ml2);
				
				
				MouseListenerZJM ml3=new MouseListenerZJM(3,setting,zyjp,this,MM);
				setting.addMouseListener(ml3);
				
				
				MouseListenerZJM ml4=new MouseListenerZJM(4,ranklist,zyjp,this,MM);
				ranklist.addMouseListener(ml4);
				
				
				
				MouseListenerZJM ml5=new MouseListenerZJM(5,exit,zyjp,this,MM);
				exit.addMouseListener(ml5);
				
				
				
				BofangDonghua bdh1=new BofangDonghua(null,this,0,0,893,620,100,"zjmdh",39,"jpg",false,6,0);
				bdh1.vediostart();
				this.setVisible(true);
				start.move();
				instruction.move();
				setting.move();
				ranklist.move();
				exit.move();
				logo.move();

				
	}
	public void remove(){
		start.move(963+85,27);
		instruction.move(963+85+350*2,121);
		setting.move(963+85+350*2*2,213);
		ranklist.move(963+85+350*2*3,305);
		exit.move(963+85+350*2*4,397);
		logo.move(1015+85+350*2*5,350);
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
	}
}