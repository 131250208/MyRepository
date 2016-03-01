package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerZJM implements MouseListener {
	TreadMove JL;
JPanel zyjp;
JPanelZYJM ZJM;
Thread tmusic2;
	int  N;
	
			//设置面板
			JPanelSetting ST=new JPanelSetting();
			//排行榜
			JPanelRank rk=new JPanelRank();
			
			
			SetMusic Music;
	public MouseListenerZJM(int num,//jl标记12345
			TreadMove jl//控制的jl
			,JPanel zyp
			,JPanelZYJM zjm
			,SetMusic M
			){
		N=num;
		zyjp=zyp;
		ZJM=zjm;
		Music=M;
		JL=jl;
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
				switch(N){

				case 1:
					Music.stop();
				//声明模式面板
				JPanelYXMS ms=new JPanelYXMS(zyjp,ZJM);
				
			
				ZJM.setVisible(false);
				
				zyjp.add(ms);
				ms.setBounds(0, 0, 893, 620);
				ms.setVisible(true);
					break;
				case 2:	
					Music.stop();
					//团队介绍及游戏说明
					JPanelteam instruction=new JPanelteam();
					instruction.passZYJM(ZJM);
					zyjp.add(instruction);
				instruction.setLocation(0, 0);
				instruction.setVisible(true);
				ZJM.setVisible(false);
				instruction.move();
					break;
				case 3:
					if(ST.visible==false){
						ST.visible=true;
						ZJM.add(ST,0);
					
						ST.setLocation(184, 70);
						ST.setVisible(ST.visible);
					}
				
				
					else{
						ST.visible=false;
						ST.setVisible(ST.visible);
					
				
					}
					break;
				case 4:

					if(ST.visible==false){
						ST.visible=true;
						ZJM.add(rk,0);
					
					rk.setLocation(120, 90);
					rk.setVisible(ST.visible);
					}
					else{
						ST.visible=false;
						rk.setVisible(ST.visible);
					}
		            
					break;
				case 5:	System.exit(0);
					break;
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
		switch(N){

		case 1:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/start1.png"));
			break;
		case 2:	JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/instruction1.png"));

			break;
		case 3:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/setting1.png"));
			break;
		case 4:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/ranklist1.png"));
			break;
		case 5:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/exit1.png"));
			break;
			
		}
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		switch(N){

		case 1:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/start0.png"));
			break;
		case 2:	JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/instruction0.png"));

			break;
		case 3:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/setting0.png"));
			break;
		case 4:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/ranklist0.png"));
			break;
		case 5:JL.setIcon(new ImageIcon("src/image/frameAndButton/zyjm/exit0.png"));
			break;
			
		}
	}

}
