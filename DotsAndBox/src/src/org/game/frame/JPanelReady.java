package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class JPanelReady extends JPanel implements MouseListener{
	Timetable Timetable;
	
	//图片对象
		ImageIcon over0=new ImageIcon("src/image/frameAndButton/Win/confirm0.png");
		ImageIcon over1=new ImageIcon("src/image/frameAndButton/Win/confirm1.png");
		
		ImageIcon npc0=new ImageIcon("src/image/frameAndButton/ready/turn/npcfirst0.jpg");
		ImageIcon npc1=new ImageIcon("src/image/frameAndButton/ready/turn/npcfirst1.jpg");
		ImageIcon player0=new ImageIcon("src/image/frameAndButton/ready/turn/playerfirst0.jpg");
		ImageIcon player1=new ImageIcon("src/image/frameAndButton/ready/turn/playerfirst1.jpg");
		
	private final JLabel background = new JLabel("New label");
	JLabel confirm = new JLabel("New label");
	JLabel player=new JLabel();
	JLabel npc=new JLabel();
	public JPanelReady(Timetable t
			,int ms//决定是哪个模式的提示栏
			){
		Timetable=t;
		this.setBounds(275, 220, 350, 200);
		setLayout(null);
		
		if(ms!=3){
		//确认按钮
		
		confirm.setBounds(65, 120, 224, 58);
		add(confirm,0);
		confirm.setIcon(over0);
		confirm.addMouseListener(this);//加监听
		}
		
		else if(ms==3){
			//谁先行
			player.setBounds(50, 120, 120, 50);
			npc.setBounds(180, 120, 120, 50);
			add(player,0);
			add(npc,1);
			player.setIcon(player0);
			npc.setIcon(npc0);
			player.addMouseListener(new buttonOfMS3(1));
			npc.addMouseListener(new buttonOfMS3(2));
		}
		//加背景图片
		
		background.setBounds(0, 0, 350, 200);
		background.setIcon(new ImageIcon("src/image/frameAndButton/ready/ready"+ms+".jpg"));
		if(ms!=3){
		add(background,1);
		}
		else if(ms==3){
			add(background,2);
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		//音效
		SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
		musicConfirm.play();
		Timetable.lefttime=180;
		Timetable.timeStart();
		if(Timetable.chess2!=null){
		Timetable.chess2.isOver=false;//游戏开始
		}
		else if (Timetable.chess!=null){
			Timetable.chess.isOver=false;//游戏开始
		}
		this.setVisible(false);
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
		confirm.setIcon(over1);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		confirm.setIcon(over0);
	}
	
	public class buttonOfMS3 implements MouseListener{

		int N;
		public buttonOfMS3(int num){
			N=num;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
			//音效
			new SetMusic("src/music/action/confirm2.wav",false,2).play();
					
			switch(N){
			case 1:
		
				Timetable.lefttime=180;
				Timetable.timeStart();
				if(Timetable.chess2!=null){
				Timetable.chess2.isOver=false;//游戏开始
				}
				else if (Timetable.chess!=null){
					Timetable.chess.isOver=false;//游戏开始
				}
				JPanelReady.this.setVisible(false);
				break;
			case 2:
			
				Timetable.lefttime=180;
				Timetable.timeStart();
				if(Timetable.chess2!=null){
				Timetable.chess2.isOver=false;//游戏开始
				}
				else if (Timetable.chess!=null){
					Timetable.chess.isOver=false;//游戏开始
				}
				JPanelReady.this.setVisible(false);
				//让电脑先走
				Timetable.chess2.get=0;//让电脑直接走
				Timetable.chess2.HIT=true;
				Timetable.chess2.isMine=false;
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
			new SetMusic("src/music/action/enter2.wav",false,2).play();
		
			switch(N){
			case 1:player.setIcon(player1);
				break;
			case 2:npc.setIcon(npc1);
				break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			switch(N){
			case 1:player.setIcon(player0);
				break;
			case 2:npc.setIcon(npc0);
				break;
			}
		}
		
	}
}
