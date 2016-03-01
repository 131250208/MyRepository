package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MouseListenerYXMS implements MouseListener {
	ReadAndWriteFile RW=new ReadAndWriteFile();
	int MS;
	JPanel ZYP;
	JPanelYXMS Bf;
	TreadMove T;
	//图片对象
	ImageIcon image11=new ImageIcon("src/image/frameAndButton/YXMS/cc.png");
	ImageIcon image22=new ImageIcon("src/image/frameAndButton/YXMS/lb.png");
	ImageIcon image33=new ImageIcon("src/image/frameAndButton/YXMS/lvb.jpg");
	ImageIcon image44=new ImageIcon("src/image/frameAndButton/YXMS/mc.jpg");
	ImageIcon image55=new ImageIcon("src/image/frameAndButton/YXMS/zy.png");
	
	ImageIcon image1=new ImageIcon("src/image/frameAndButton/YXMS/cc2.png");
	ImageIcon image2=new ImageIcon("src/image/frameAndButton/YXMS/lb2.png");
	ImageIcon image3=new ImageIcon("src/image/frameAndButton/YXMS/lvb2.jpg");
	ImageIcon image4=new ImageIcon("src/image/frameAndButton/YXMS/mc2.jpg");
	ImageIcon image5=new ImageIcon("src/image/frameAndButton/YXMS/zy2.png");
public MouseListenerYXMS(int ms,//第几个模式
		JPanelYXMS bf,JPanel zyp//传递要用的
		,TreadMove t
		){
	
	Bf=bf;
	ZYP=zyp;
	MS=ms;
	T=t;
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		//音效
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm5.wav",false,2);
				musicConfirm.play();
		if(MS==1){
			//"wyc"保存到nowpalyer
			String[] temp0=new String[1];
			temp0[0]="wyc";
			RW.Write(temp0, "src/txt/nowPlayer.txt");
			
			String donghua="donghua"+new GetDataOfPlayer(new GetNowPlayer().now).Pass,bg="src/image/background1/bg"+new GetDataOfPlayer(new GetNowPlayer().now).Pass+".jpg",story="src/image/story/story"+new GetDataOfPlayer(new GetNowPlayer().now).Pass+".png";
		Story st1=new Story(Bf,null,ZYP,new GetDataOfPlayer(new GetNowPlayer().now).Pass,donghua,bg,story);
		}
		
		if(MS==2){
			JPanelChooseHero ChooseHero=new JPanelChooseHero(ZYP,Bf);
			
			
		
			ZYP.add(ChooseHero);
			ZYP.setLocation(0, 0);
		
			ZYP.setVisible(true);
			Bf.setVisible(false);
		}
if(MS==3){
	//普通人机对战
	
	//"sb"保存到nowpalyer
	String[] temp0=new String[1];
	temp0[0]="sb";
	RW.Write(temp0, "src/txt/nowPlayer.txt");
	
	JPanelCG RJ=new JPanelCG(10,11,Bf,null,null,ZYP,0);
	
		}
if(MS==4){
	JPanel2p P2=new JPanel2p(Bf,ZYP,1);
}
if(MS==5){
	JPanel2p QD=new JPanel2p(Bf,ZYP,0);
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
				SetMusic musicEnter=new SetMusic("src/music/action/enter.wav",false,2);
				musicEnter.play();
switch(MS){
case 1:T.setIcon(image11);
break;
case 2:T.setIcon(image22);
break;
case 3:T.setIcon(image33);
break;
case 4:T.setIcon(image44);
break;
case 5:T.setIcon(image55);
break;

}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		
		switch(MS){
		case 1:T.setIcon(image1);
		break;
		case 2:T.setIcon(image2);
		break;
		case 3:T.setIcon(image3);
		break;
		case 4:T.setIcon(image4);
		break;
		case 5:T.setIcon(image5);
		break;

		}
	}

}
