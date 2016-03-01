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
	
	//���
	
			JLabel background=new JLabel();
			JLabel back=new JLabel();
			
			TreadMove T;
			JPanelZYJM JP;
			
			//����
			SetMusic musicTeam=new SetMusic("src/music/bgm/wangyue.wav",true,1);
	public JPanelteam(){
		
		this.setSize(893, 620);
		
		
		
		background.setIcon(bg);
		back.setIcon(back1);
		
		//λ�����С
		background.setBounds(0, 0, 893, 620);
		back.setBounds(385, 560, back1.getIconWidth(), back1.getIconHeight());
		
		//�����
		this.add(back,0);
		TreadMove team = new TreadMove(this,0,620,0,-1240,"src/image/story/team.png",100,5,1);
	
		T=team;
		
		this.add(background,2);
		//�Ӽ���
		Back ml=new Back();
		back.addMouseListener(ml);
		
		
	}
	public void move(){
		//��ʼ
		//����
				
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
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
			//��Ч
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
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO �Զ����ɵķ������
			//��Ч
			SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
			musicEnter.play();
			back.setIcon(back2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			back.setIcon(back1);
		}
		
	}
}
