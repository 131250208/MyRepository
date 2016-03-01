package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelteam extends JPanel {

	ImageIcon bg=new ImageIcon("src/image/story/bg.jpg");
	ImageIcon back1=new ImageIcon("src/image/frameAndButton/jump/return1.png");
	ImageIcon back2=new ImageIcon("src/image/frameAndButton/jump/return2.png");
	
	//组件
	
			JLabel background=new JLabel();
			JLabel back=new JLabel();
			
			TreadMove T;
			JPanelZYJM JP;
			
			//音乐
			SetMusic musicTeam=new SetMusic("src/music/bgm/wangyue.wav",true,1);
	public JPanelteam(){
		
		this.setSize(893, 620);
		
		
		
		background.setIcon(bg);
		back.setIcon(back1);
		
		//位置与大小
		background.setBounds(0, 0, 893, 620);
		back.setBounds(385, 560, back1.getIconWidth(), back1.getIconHeight());
		
		//加组件
		this.add(back,0);
		TreadMove team = new TreadMove(this,0,620,0,-1240,"src/image/story/team.png",100,5,1);
	
		T=team;
		
		this.add(background,2);
		//加监听
		Back ml=new Back();
		back.addMouseListener(ml);
		
		
	}
	public void move(){
		//开始
		//音乐
				
				musicTeam.play();
				T.move();
	}
	public void start(){
		T.start();
	}
	public void stop(){
		T.stop();
	}
	public void passZYJM(JPanelZYJM jp){
		JP=jp;
	}
	public class Back implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
			//音效
			SetMusic musicConfirm=new SetMusic("src/music/action/confirm4.wav",false,2);
			musicConfirm.play();
			
			musicTeam.stop();
			JP.remove();
			JP.setVisible(true);
			stop();
			JPanelteam.this.setVisible(false);
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
			back.setIcon(back2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			back.setIcon(back1);
		}
		
	}
}
