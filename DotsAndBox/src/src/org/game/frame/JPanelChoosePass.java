package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelChoosePass extends JPanel implements MouseListener {
//图片
	ImageIcon BG=new ImageIcon("src/image/frameAndButton/selection/pass/bg1.jpg");
	//未解锁
	ImageIcon cbs1=new ImageIcon("src/image/frameAndButton/selection/pass/cbs1.jpg");
	ImageIcon cbx1=new ImageIcon("src/image/frameAndButton/selection/pass/cbx1.jpg");
	ImageIcon cbp1=new ImageIcon("src/image/frameAndButton/selection/pass/cbp1.jpg");
	ImageIcon gd1=new ImageIcon("src/image/frameAndButton/selection/pass/gd1.jpg");
	ImageIcon tg1=new ImageIcon("src/image/frameAndButton/selection/pass/tg1.jpg");
	//暗
	ImageIcon cbs2=new ImageIcon("src/image/frameAndButton/selection/pass/cbs2.jpg");
	ImageIcon cbx2=new ImageIcon("src/image/frameAndButton/selection/pass/cbx2.jpg");
	ImageIcon cbp2=new ImageIcon("src/image/frameAndButton/selection/pass/cbp2.jpg");
	ImageIcon gd2=new ImageIcon("src/image/frameAndButton/selection/pass/gd2.jpg");
	ImageIcon tg2=new ImageIcon("src/image/frameAndButton/selection/pass/tg2.jpg");
	//亮
	ImageIcon cbs3=new ImageIcon("src/image/frameAndButton/selection/pass/cbs3.jpg");
	ImageIcon cbx3=new ImageIcon("src/image/frameAndButton/selection/pass/cbx3.jpg");
	ImageIcon cbp3=new ImageIcon("src/image/frameAndButton/selection/pass/cbp3.jpg");
	ImageIcon gd3=new ImageIcon("src/image/frameAndButton/selection/pass/gd3.jpg");
	ImageIcon tg3=new ImageIcon("src/image/frameAndButton/selection/pass/tg3.jpg");
	//返回与进入
	ImageIcon Back1=new ImageIcon("src/image/frameAndButton/jump/return1.png");
	ImageIcon Enter1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon Back2=new ImageIcon("src/image/frameAndButton/jump/return2.png");
	ImageIcon Enter2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	//将领名称
	ImageIcon ys=new ImageIcon("src/image/frameAndButton/prompt/ys.png");
	ImageIcon sq=new ImageIcon("src/image/frameAndButton/prompt/sq.png");
	ImageIcon lb=new ImageIcon("src/image/frameAndButton/prompt/lb.png");
	ImageIcon zy=new ImageIcon("src/image/frameAndButton/prompt/zy.png");
	ImageIcon mc=new ImageIcon("src/image/frameAndButton/prompt/mc.png");
	
	//组件
	JLabel bg=new JLabel();
	JLabel pass1=new JLabel();
	JLabel pass2=new JLabel();
	JLabel pass3=new JLabel();
	JLabel pass4=new JLabel();
	JLabel pass5=new JLabel();
	JLabel back=new JLabel();
	JLabel enter=new JLabel();
	
	JLabel hero=new JLabel();
	//监听
	MouseListenerPass mlpass1=new MouseListenerPass(1);
	MouseListenerPass mlpass2=new MouseListenerPass(2);
	MouseListenerPass mlpass3=new MouseListenerPass(3);
	MouseListenerPass mlpass4=new MouseListenerPass(4);
	MouseListenerPass mlpass5=new MouseListenerPass(5);
	//最终选择关卡
	int lastPass=-1;
	//主要jp
	JPanel ZYP;
	JPanelYXMS MS;
	//音乐
		SetMusic musicChooseP=new SetMusic("src/music/bgm/choosepass.wav",true,1); 
	public JPanelChoosePass(JPanel zyp,JPanelYXMS ms){
		ZYP=zyp;
		MS=ms;
		this.setSize(893, 620);
		this.setLayout(null);
		
		//加初始图片
		bg.setIcon(BG);
		pass1.setIcon(gd1);
		pass2.setIcon(cbs1);
		pass3.setIcon(cbp1);
		pass4.setIcon(cbx1);
		pass5.setIcon(tg1);
		back.setIcon(Back1);
		enter.setIcon(Enter1);
		
		//设置组件位置与大小
		bg.setBounds(0, 0, 893, 620);
        back.setBounds(30, 560, Back1.getIconWidth(), Back1.getIconHeight());   
        enter.setBounds(743, 10, Enter1.getIconWidth(), Enter1.getIconHeight());
        pass1.setBounds(40, 30+20, 392, 158);
        pass2.setBounds(40, 200+20, 392, 158);
        pass3.setBounds(40, 370+20, 392, 158);
        pass4.setBounds(470, 90+20, 392, 158);
        pass5.setBounds(470, 260+20, 392, 158);
		hero.setBounds(540, 450, 250, 100);
		//加上组件
		this.add(back,0);
		this.add(enter,1);
		this.add(pass1,2);
		this.add(pass2,3);
		this.add(pass3,4);
		this.add(pass4,5);
		this.add(pass5,6);
	 
		this.add(hero,7);
		this.add(bg,8);
		
		
		//加监听
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
	
	//内部监听类  关卡
	public class MouseListenerPass implements MouseListener{
 
		int P;
		int work=1;
		public MouseListenerPass(int pass){
			P=pass;
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			if(work==1){
			if(lastPass==-1){
				//音效
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm5.wav",false,2);
				musicConfirm.play();
			switch(P){//锁上其他关卡
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
			lastPass=P;//关卡选择生效
			}
			else {
				lastPass=-1;//取消关卡选择
				switch(P){//解锁其他关卡
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
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			if(work==1){
				if(lastPass==-1){
					//音效
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
			// TODO 自动生成的方法存根
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
	//内部监听类  返回与进入
	public class MouseListenerEandB implements MouseListener{
		

		int N;

		public MouseListenerEandB(int num){

			N=num;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
			musicChooseP.stop();
			switch(N){
			
			case 1:
				//音效
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm4.wav",false,2);
				musicConfirm.play();
				
				JPanelChooseHero JPhero=new JPanelChooseHero(ZYP,MS);
			    ZYP.add(JPhero);
			    JPhero.setVisible(true);
			    JPhero.setLocation(0, 0);
			    JPanelChoosePass.this.setVisible(false);
			    
			break;
			case 2:
				//音效
				SetMusic musicConfirm2=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm2.play();
				
				//读取现在的玩家名
				String nowPlay=new GetNowPlayer().now;
				//修改关卡代号
				int temppass=1;
				if(lastPass!=-1){
					temppass=lastPass;
				}
				new GetDataOfPlayer(nowPlay).change(10, temppass);
				
				//进入关卡
				int hero=new GetDataOfPlayer(nowPlay).Hero;
				int pass=new GetDataOfPlayer(nowPlay).Pass;
				JPanelCG gamezy=new JPanelCG(hero,pass,null,null,JPanelChoosePass.this,ZYP,2);
				
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
			// TODO 自动生成的方法存根
			switch(N){
			case 1:back.setIcon(Back1);
				break;
			case 2:enter.setIcon(Enter1);
			break;
			}
		}
		
	}
	
	//外部类的监听
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

}
