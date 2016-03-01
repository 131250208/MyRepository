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
	
	//ͼƬ
	ImageIcon jump1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon jump2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	
	//
	JLabel jl=new JLabel();//��������
	JLabel next=new JLabel();
	JPanelYXMS ms;
	//����
	SetMusic musicStory=new SetMusic("src/music/bgm/storyready.wav",true,1);
	public JPanelStory(String addr1,//����ͼƬ��ַ
			String addr2,//���°���ַ
			JPanel zyp,
			int pass,
			String addOfStory//�������µ�ַ
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
		// TODO �Զ����ɵķ������
		
	}
	
	
	public static void main(String[] args) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {//����ؿ�
		// TODO �Զ����ɵķ������
		
				
	}

	@Override
	public void mousePressed(MouseEvent e) {
		musicStory.stop();
		//��Ч
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm.play();
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
					ImageRun.haveJump=true;
					 JPanelCG CG=new JPanelCG(0//�ܲٴ���
							 ,Pass,null,JPanelStory.this,null,ZYP,1);
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
		next.setIcon(jump2);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		next.setIcon(jump1);
	}
	
	
	
	
	//�ڲ���
	public class MouseListenerJump implements MouseListener {
		int PASS;
		JPanel CTP, ZYP;
		
		//ͼƬ
			ImageIcon jump1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
			ImageIcon jump2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
		public MouseListenerJump(int pass,JPanel ctp,JPanel zyp){
			PASS=pass;
			CTP=ctp;
			ZYP=zyp;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������

			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO �Զ����ɵķ������

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO �Զ����ɵķ������

			jl.setIcon(jump2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������

			jl.setIcon(jump1);
		}

	}

}
