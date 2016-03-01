package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelChoosePass extends JPanel implements MouseListener {
//ͼƬ
	ImageIcon BG=new ImageIcon("src/image/frameAndButton/selection/pass/bg1.jpg");
	//δ����
	ImageIcon cbs1=new ImageIcon("src/image/frameAndButton/selection/pass/cbs1.jpg");
	ImageIcon cbx1=new ImageIcon("src/image/frameAndButton/selection/pass/cbx1.jpg");
	ImageIcon cbp1=new ImageIcon("src/image/frameAndButton/selection/pass/cbp1.jpg");
	ImageIcon gd1=new ImageIcon("src/image/frameAndButton/selection/pass/gd1.jpg");
	ImageIcon tg1=new ImageIcon("src/image/frameAndButton/selection/pass/tg1.jpg");
	//��
	ImageIcon cbs2=new ImageIcon("src/image/frameAndButton/selection/pass/cbs2.jpg");
	ImageIcon cbx2=new ImageIcon("src/image/frameAndButton/selection/pass/cbx2.jpg");
	ImageIcon cbp2=new ImageIcon("src/image/frameAndButton/selection/pass/cbp2.jpg");
	ImageIcon gd2=new ImageIcon("src/image/frameAndButton/selection/pass/gd2.jpg");
	ImageIcon tg2=new ImageIcon("src/image/frameAndButton/selection/pass/tg2.jpg");
	//��
	ImageIcon cbs3=new ImageIcon("src/image/frameAndButton/selection/pass/cbs3.jpg");
	ImageIcon cbx3=new ImageIcon("src/image/frameAndButton/selection/pass/cbx3.jpg");
	ImageIcon cbp3=new ImageIcon("src/image/frameAndButton/selection/pass/cbp3.jpg");
	ImageIcon gd3=new ImageIcon("src/image/frameAndButton/selection/pass/gd3.jpg");
	ImageIcon tg3=new ImageIcon("src/image/frameAndButton/selection/pass/tg3.jpg");
	//���������
	ImageIcon Back1=new ImageIcon("src/image/frameAndButton/jump/return1.png");
	ImageIcon Enter1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon Back2=new ImageIcon("src/image/frameAndButton/jump/return2.png");
	ImageIcon Enter2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	//��������
	ImageIcon ys=new ImageIcon("src/image/frameAndButton/prompt/ys.png");
	ImageIcon sq=new ImageIcon("src/image/frameAndButton/prompt/sq.png");
	ImageIcon lb=new ImageIcon("src/image/frameAndButton/prompt/lb.png");
	ImageIcon zy=new ImageIcon("src/image/frameAndButton/prompt/zy.png");
	ImageIcon mc=new ImageIcon("src/image/frameAndButton/prompt/mc.png");
	
	//���
	JLabel bg=new JLabel();
	JLabel pass1=new JLabel();
	JLabel pass2=new JLabel();
	JLabel pass3=new JLabel();
	JLabel pass4=new JLabel();
	JLabel pass5=new JLabel();
	JLabel back=new JLabel();
	JLabel enter=new JLabel();
	
	JLabel hero=new JLabel();
	//����
	MouseListenerPass mlpass1=new MouseListenerPass(1);
	MouseListenerPass mlpass2=new MouseListenerPass(2);
	MouseListenerPass mlpass3=new MouseListenerPass(3);
	MouseListenerPass mlpass4=new MouseListenerPass(4);
	MouseListenerPass mlpass5=new MouseListenerPass(5);
	//����ѡ��ؿ�
	int lastPass=-1;
	//��Ҫjp
	JPanel ZYP;
	JPanelYXMS MS;
	//����
		SetMusic musicChooseP=new SetMusic("src/music/bgm/choosepass.wav",true,1); 
	public JPanelChoosePass(JPanel zyp,JPanelYXMS ms){
		ZYP=zyp;
		MS=ms;
		this.setSize(893, 620);
		this.setLayout(null);
		
		//�ӳ�ʼͼƬ
		bg.setIcon(BG);
		pass1.setIcon(gd1);
		pass2.setIcon(cbs1);
		pass3.setIcon(cbp1);
		pass4.setIcon(cbx1);
		pass5.setIcon(tg1);
		back.setIcon(Back1);
		enter.setIcon(Enter1);
		
		//�������λ�����С
		bg.setBounds(0, 0, 893, 620);
        back.setBounds(30, 560, Back1.getIconWidth(), Back1.getIconHeight());   
        enter.setBounds(743, 10, Enter1.getIconWidth(), Enter1.getIconHeight());
        pass1.setBounds(40, 30+20, 392, 158);
        pass2.setBounds(40, 200+20, 392, 158);
        pass3.setBounds(40, 370+20, 392, 158);
        pass4.setBounds(470, 90+20, 392, 158);
        pass5.setBounds(470, 260+20, 392, 158);
		hero.setBounds(540, 450, 250, 100);
		//�������
		this.add(back,0);
		this.add(enter,1);
		this.add(pass1,2);
		this.add(pass2,3);
		this.add(pass3,4);
		this.add(pass4,5);
		this.add(pass5,6);
	 
		this.add(hero,7);
		this.add(bg,8);
		
		
		//�Ӽ���
		MouseListenerEandB mlback=new MouseListenerEandB(1);
		back.addMouseListener(mlback);
		MouseListenerEandB mlenter=new MouseListenerEandB(2);
		enter.addMouseListener(mlenter);
		
		if(new GetLock().pass1==1){
			pass1.setIcon(gd2);
		
			pass1.addMouseListener(mlpass1);
		}
		if(new GetLock().pass2==1){
			pass2.setIcon(cbs2);

			pass2.addMouseListener(mlpass2);
		}
		if(new GetLock().pass3==1){
			pass3.setIcon(cbp2);

			pass3.addMouseListener(mlpass3);
		}
		if(new GetLock().pass4==1){
			pass4.setIcon(cbx2);
			
			pass4.addMouseListener(mlpass4);
		}
		if(new GetLock().pass5==1){
			pass5.setIcon(tg2);
			
			pass5.addMouseListener(mlpass5);
		}
		
		musicChooseP.play();
	}
	
	//�ڲ�������  �ؿ�
	public class MouseListenerPass implements MouseListener{
 
		int P;
		int work=1;
		public MouseListenerPass(int pass){
			P=pass;
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			if(work==1){
			if(lastPass==-1){
				//��Ч
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm5.wav",false,2);
				musicConfirm.play();
			switch(P){//���������ؿ�
			case 1:
				mlpass2.work=0;			
				mlpass3.work=0;			
				mlpass4.work=0;			
				mlpass5.work=0;
				break;
			case 2:
				mlpass1.work=0;			
				mlpass3.work=0;			
				mlpass4.work=0;			
				mlpass5.work=0;
				break;
			case 3:
				mlpass2.work=0;			
				mlpass1.work=0;			
				mlpass4.work=0;			
				mlpass5.work=0;
				break;
			case 4:
				mlpass2.work=0;			
				mlpass3.work=0;			
				mlpass1.work=0;			
				mlpass5.work=0;
				break;
			case 5:
				mlpass2.work=0;			
				mlpass3.work=0;			
				mlpass4.work=0;			
				mlpass1.work=0;
				break;
			}
			lastPass=P;//�ؿ�ѡ����Ч
			}
			else {
				lastPass=-1;//ȡ���ؿ�ѡ��
				switch(P){//���������ؿ�
				case 1:
					mlpass2.work=1;			
					mlpass3.work=1;			
					mlpass4.work=1;			
					mlpass5.work=1;
					break;
				case 2:
					mlpass1.work=1;			
					mlpass3.work=1;			
					mlpass4.work=1;			
					mlpass5.work=1;
					break;
				case 3:
					mlpass2.work=1;			
					mlpass1.work=1;			
					mlpass4.work=1;			
					mlpass5.work=1;
					break;
				case 4:
					mlpass2.work=1;			
					mlpass3.work=1;			
					mlpass1.work=1;			
					mlpass5.work=1;
					break;
				case 5:
					mlpass2.work=1;			
					mlpass3.work=1;			
					mlpass4.work=1;			
					mlpass1.work=1;
					break;
				}
			}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO �Զ����ɵķ������
			if(work==1){
				if(lastPass==-1){
					//��Ч
					SetMusic musicEnter=new SetMusic("src/music/action/enter.wav",false,2);
					musicEnter.play();
					
					switch(P){
					case 1:pass1.setIcon(gd3);
					hero.setIcon(ys);
					break;
					case 2:pass2.setIcon(cbs3);
					hero.setIcon(sq);
					break;
					case 3:pass3.setIcon(cbp3);
					hero.setIcon(lb);
					break;
					case 4:pass4.setIcon(cbx3);
					hero.setIcon(zy);
					break;
					case 5:pass5.setIcon(tg3);
					hero.setIcon(mc);
					break;
					}
			
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			if(work==1){
				if(lastPass==-1){
				
					switch(P){
					case 1:pass1.setIcon(gd2);							
					break;
					case 2:pass2.setIcon(cbs2);
					break;
					case 3:pass3.setIcon(cbp2);
					break;
					case 4:pass4.setIcon(cbx2);
					break;
					case 5:pass5.setIcon(tg2);
					break;
					
				
					}
					hero.setIcon(null);
				}
			}
			
		}
		
	}
	//�ڲ�������  ���������
	public class MouseListenerEandB implements MouseListener{
		

		int N;

		public MouseListenerEandB(int num){

			N=num;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
			musicChooseP.stop();
			switch(N){
			
			case 1:
				//��Ч
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm4.wav",false,2);
				musicConfirm.play();
				
				JPanelChooseHero JPhero=new JPanelChooseHero(ZYP,MS);
			    ZYP.add(JPhero);
			    JPhero.setVisible(true);
			    JPhero.setLocation(0, 0);
			    JPanelChoosePass.this.setVisible(false);
			    
			break;
			case 2:
				//��Ч
				SetMusic musicConfirm2=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm2.play();
				
				//��ȡ���ڵ������
				String nowPlay=new GetNowPlayer().now;
				//�޸Ĺؿ�����
				int temppass=1;
				if(lastPass!=-1){
					temppass=lastPass;
				}
				new GetDataOfPlayer(nowPlay).change(10, temppass);
				
				//����ؿ�
				int hero=new GetDataOfPlayer(nowPlay).Hero;
				int pass=new GetDataOfPlayer(nowPlay).Pass;
				JPanelCG gamezy=new JPanelCG(hero,pass,null,null,JPanelChoosePass.this,ZYP,2);
				
			break;
			}
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
			
			switch(N){
			case 1:back.setIcon(Back2);
				break;
			case 2:enter.setIcon(Enter2);
			break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			switch(N){
			case 1:back.setIcon(Back1);
				break;
			case 2:enter.setIcon(Enter1);
			break;
			}
		}
		
	}
	
	//�ⲿ��ļ���
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

}
