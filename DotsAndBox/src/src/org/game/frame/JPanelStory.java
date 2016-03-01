package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStory extends JPanel implements  Runnable,MouseListener{

	
	int Movetime1,Pass;
	JPanel ZYP;
	String AddOfStory;
	int pages;
	
	//图片
	ImageIcon jump1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon jump2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	
	//
	JLabel jl=new JLabel();//动画跳过
	JLabel next=new JLabel();
	JPanelYXMS ms;
	//音乐
	SetMusic musicStory=new SetMusic("src/music/bgm/storyready.wav",true,1);
	public JPanelStory(String addr1,//背景图片地址
			String addr2,//故事板块地址
			JPanel zyp,
			int pass,
			String addOfStory//动画故事地址
			,JPanelYXMS MS
			){
		ms=MS;
		ZYP=zyp;
		AddOfStory=addOfStory;
		Pass=pass;
		
		this.setSize(893, 620);
		this.setLayout(null);
		JLabel jlBg=new JLabel();
		ImageIcon imagebg=new ImageIcon(addr1);
		jlBg.setBounds(0, 0, 893, 620);
		jlBg.setIcon(imagebg);

		TreadMove story=new TreadMove(this,0,620,0,0,addr2,100,5,0);
		this.add(jlBg,1);
		
		story.move();

		musicStory.play();
		
		 Movetime1=story.moveTime();
		 //System.out.println( Movetime1);
		Thread t=new Thread(this);
		t.start();
	
		this.add(next,0);
		next.setIcon(jump1);
		next.setBounds(743, 560, jump1.getIconWidth(), jump1.getIconHeight());
		next.addMouseListener(this);
	}

	public int movetime(){
		
		return Movetime1;
		
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	}
	
	
	public static void main(String[] args) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {//进入关卡
		// TODO 自动生成的方法存根
		
				
	}

	@Override
	public void mousePressed(MouseEvent e) {
		musicStory.stop();
		//音效
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm.play();
		// TODO 自动生成的方法存根
//		this.setVisible(false);
//		JPanel ctp=new JPanel();
//		ctp.setSize(893, 620);
//		
//		switch(new GetDataOfPlayer("wyc").Pass){
//		case 1:pages=84;
//		break;
//		case 2:pages=108;
//		break;
//		case 3:pages=103;
//		break;
//		case 4:pages=107;
//		break;
//		case 5:pages=100;
//		break;
//		case 6:pages=107;
//		break;
//		}
//		BofangDonghua bdh1=new BofangDonghua(ZYP,ctp,0,0,893,620,100,AddOfStory,pages,"jpg",false,0,Pass);
//	
//		ctp.add(jl,0);
//		jl.setBounds(743, 560, jump1.getIconWidth(), jump1.getIconHeight());
//		MouseListenerJump jump=new MouseListenerJump(Pass,ctp,ZYP);
//		jl.setIcon(jump1);
//		jl.addMouseListener(jump);
//		bdh1.vediostart();
//		ZYP.add(ctp);
//		ctp.setVisible(true);
		// TODO 自动生成的方法存根
					ImageRun.haveJump=true;
					 JPanelCG CG=new JPanelCG(0//曹操闯关
							 ,Pass,null,JPanelStory.this,null,ZYP,1);
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
		next.setIcon(jump2);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		next.setIcon(jump1);
	}
	
	
	
	
	//内部类
	public class MouseListenerJump implements MouseListener {
		int PASS;
		JPanel CTP, ZYP;
		
		//图片
			ImageIcon jump1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
			ImageIcon jump2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
		public MouseListenerJump(int pass,JPanel ctp,JPanel zyp){
			PASS=pass;
			CTP=ctp;
			ZYP=zyp;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根

			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根

			jl.setIcon(jump2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根

			jl.setIcon(jump1);
		}

	}

}
