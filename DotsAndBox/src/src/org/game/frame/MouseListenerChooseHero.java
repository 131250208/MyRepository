package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MouseListenerChooseHero implements MouseListener {
int Hero;
JLabel JL,BG;
JPanelChooseHero JPChoose;
int work=0,haveChoose=-1;
MouseListenerChooseHero ml1,ml2,ml3,ml4,ml5;

ImageIcon cc2=new ImageIcon("src/image/frameAndButton/selection/cc2.jpg");
ImageIcon ys2=new ImageIcon("src/image/frameAndButton/selection/ys2.png");
ImageIcon sq2=new ImageIcon("src/image/frameAndButton/selection/sq2.png");
ImageIcon lb2=new ImageIcon("src/image/frameAndButton/selection/lb2.png");
ImageIcon zy2=new ImageIcon("src/image/frameAndButton/selection/zy2.png");
ImageIcon mc2=new ImageIcon("src/image/frameAndButton/selection/mc2.png");

ImageIcon cc1=new ImageIcon("src/image/frameAndButton/selection/cc1.jpg");
ImageIcon ys1=new ImageIcon("src/image/frameAndButton/selection/ys1.png");
ImageIcon sq1=new ImageIcon("src/image/frameAndButton/selection/sq1.png");
ImageIcon lb1=new ImageIcon("src/image/frameAndButton/selection/lb1.png");
ImageIcon zy1=new ImageIcon("src/image/frameAndButton/selection/zy1.png");
ImageIcon mc1=new ImageIcon("src/image/frameAndButton/selection/mc1.png");

ImageIcon bgcc2=new ImageIcon("src/image/frameAndButton/selection/bg/cc2.jpg");
ImageIcon bgys2=new ImageIcon("src/image/frameAndButton/selection/bg/ys2.jpg");
ImageIcon bgsq2=new ImageIcon("src/image/frameAndButton/selection/bg/sq2.jpg");
ImageIcon bglb2=new ImageIcon("src/image/frameAndButton/selection/bg/lb2.jpg");
ImageIcon bgzy2=new ImageIcon("src/image/frameAndButton/selection/bg/zy2.jpg");
ImageIcon bgmc2=new ImageIcon("src/image/frameAndButton/selection/bg/mc2.jpg");

ImageIcon bgcc1=new ImageIcon("src/image/frameAndButton/selection/bg/cc1.jpg");
ImageIcon bgys1=new ImageIcon("src/image/frameAndButton/selection/bg/ys1.jpg");
ImageIcon bgsq1=new ImageIcon("src/image/frameAndButton/selection/bg/sq1.jpg");
ImageIcon bglb1=new ImageIcon("src/image/frameAndButton/selection/bg/lb1.jpg");
ImageIcon bgzy1=new ImageIcon("src/image/frameAndButton/selection/bg/zy1.jpg");
ImageIcon bgmc1=new ImageIcon("src/image/frameAndButton/selection/bg/mc1.jpg");


ImageIcon backg=new ImageIcon("src/image/frameAndButton/selection/board-original.jpg");



	public MouseListenerChooseHero(JLabel jl,//监控的JL
			int hero//012345
			,JLabel bg//监控背景
			,JPanelChooseHero JPC
			){
		JPChoose=JPC;
		Hero=hero;
		JL=jl;
      BG=bg;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		//取消其他监控
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){//也要自己有效才行
			
			
			
			if(ml1.work==1){
	ml1.work=0;
			}
			else{
				ml1.work=1;
			}
			if(ml2.work==1){
	ml2.work=0;
			}
			else{
				ml2.work=1;
			}
			if(ml3.work==1){
	ml3.work=0;
			}
			else{
				ml3.work=1;
			}
			if(ml4.work==1){
	ml4.work=0;
			}
			else{
				ml4.work=1;
			}
			if(ml5.work==1){
	ml5.work=0;
			}
			else{
				ml5.work=1;
			}

			
			//选择生效
			if(haveChoose==-1){
				
				//音效
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm5.wav",false,2);
				musicConfirm.play();
			
			switch(Hero){

			case 0:haveChoose=0;
			JPChoose.hero=0;//选择生效 改变英雄代号
				break;
			case 1:haveChoose=1;
			JPChoose.hero=1;//选择生效 改变英雄代号
				break;
			case 2:haveChoose=2;
			JPChoose.hero=2;//选择生效 改变英雄代号
				break;
			case 3:haveChoose=3;
			JPChoose.hero=3;//选择生效 改变英雄代号
				break;
			case 4:haveChoose=4;
			JPChoose.hero=4;//选择生效 改变英雄代号
				break;
			case 5:haveChoose=5;
			JPChoose.hero=5;//选择生效 改变英雄代号
				break;
			}
			//换背景
					switch(Hero){

					case 0:BG.setIcon(bgcc2);
						break;
					case 1:BG.setIcon(bgys2);
						break;
					case 2:BG.setIcon(bgsq2);
						break;
					case 3:BG.setIcon(bglb2);
					
						break;
					case 4:BG.setIcon(bgzy2);
					
						break;
					case 5:BG.setIcon(bgmc2);
						break;
					}
			}
			else{//取消选择
				haveChoose=-1;
				//音效
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm3.wav",false,2);
				musicConfirm.play();
				JPChoose.hero=-1;//选择取消 改变英雄代号
				//换背景
				switch(Hero){

				case 0:BG.setIcon(bgcc1);
					break;
				case 1:BG.setIcon(bgys1);
					break;
				case 2:BG.setIcon(bgsq1);
					break;
				case 3:BG.setIcon(bglb1);
				
					break;
				case 4:BG.setIcon(bgzy1);
				
					break;
				case 5:BG.setIcon(bgmc1);
					break;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
if(work==1){
	//音效
	SetMusic musicEnter=new SetMusic("src/music/action/enter.wav",false,2);
	musicEnter.play();
	
	//换卡牌
	
	if(haveChoose==-1){
		switch(Hero){

		case 0:JL.setIcon(cc1);
			break;
		case 1:JL.setIcon(ys1);
			break;
		case 2:JL.setIcon(sq1);
			break;
		case 3:JL.setIcon(lb1);
		
			break;
		case 4:JL.setIcon(zy1);
		
			break;
		case 5:JL.setIcon(mc1);
			break;
	
			

		}
		
		//换背景
		switch(Hero){

		case 0:BG.setIcon(bgcc1);
			break;
		case 1:BG.setIcon(bgys1);
			break;
		case 2:BG.setIcon(bgsq1);
			break;
		case 3:BG.setIcon(bglb1);
		
			break;
		case 4:BG.setIcon(bgzy1);
		
			break;
		case 5:BG.setIcon(bgmc1);
			break;
		}
	}
}
	}
	
	public void passML(
			MouseListenerChooseHero M1//控制其他五个监控
			,MouseListenerChooseHero M2
			,MouseListenerChooseHero M3
			,MouseListenerChooseHero M4
			,MouseListenerChooseHero M5
			){
		ml1=M1;
		ml2=M2;
		ml3=M3;
		ml4=M4;
		ml5=M5;
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
			if(haveChoose==-1){
		switch(Hero){

		case 0:JL.setIcon(cc2);
			break;
		case 1:JL.setIcon(ys2);
			break;
		case 2:JL.setIcon(sq2);
			break;
		case 3:JL.setIcon(lb2);
		
			break;
		case 4:JL.setIcon(zy2);
		
			break;
		case 5:JL.setIcon(mc2);
			break;
			

		}
		//换背景
		BG.setIcon(backg);
		}
		}
	}

}
