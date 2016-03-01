package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerChooseHeroEnter implements MouseListener {
//控制监控生效
	int work=0;
	
	JLabel JL;
	JPanel ZYP;
	JPanelChooseHero Choose;
	
	ImageIcon en1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon en2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	public MouseListenerChooseHeroEnter(JLabel jl,//控制的按钮
			JPanelChooseHero jp1//控制的选择界面
			,JPanel zyp
			){
		Choose=jp1;
		ZYP=zyp;
		JL=jl;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		if(work==1){//已经输入了玩家名  进入按钮变得有效
			Choose.musicChooseH.stop();//关掉选择英雄的音乐
			//音效
			new SetMusic("src/music/action/confirm2.wav",false,2).play();
			
			
			//保存选择
			//读取现在的玩家名
			String nowPlay=new GetNowPlayer().now;
			//修改英雄代号
			int newHero=0;
			if(Choose.hero!=-1){
			newHero=Choose.hero;
			}
			
			new GetDataOfPlayer(nowPlay).change(9, newHero);
			//设置选择关卡面板
			JPanelChoosePass JPpass=new JPanelChoosePass(ZYP,Choose.MS);
			ZYP.add(JPpass);
			JPpass.setVisible(true);
			JPpass.setLocation(0, 0);
			//选择英雄面板设为不可见
		Choose.setVisible(false);
		
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
			SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
			musicEnter.play();

			JL.setIcon(en2);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
JL.setIcon(en1);
		}
	}

}
