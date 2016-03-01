package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelChooseHero extends JPanel implements MouseListener {
//监控生效值
	int work=1;
	ImageIcon cc2=new ImageIcon("src/image/frameAndButton/selection/cc2.jpg");
	ImageIcon ys2=new ImageIcon("src/image/frameAndButton/selection/ys2.png");
	ImageIcon sq2=new ImageIcon("src/image/frameAndButton/selection/sq2.png");
	ImageIcon lb2=new ImageIcon("src/image/frameAndButton/selection/lb2.png");
	ImageIcon zy2=new ImageIcon("src/image/frameAndButton/selection/zy2.png");
	ImageIcon mc2=new ImageIcon("src/image/frameAndButton/selection/mc2.png");
	ImageIcon ys3=new ImageIcon("src/image/frameAndButton/selection/ys3.png");
	ImageIcon sq3=new ImageIcon("src/image/frameAndButton/selection/sq3.png");
	ImageIcon lb3=new ImageIcon("src/image/frameAndButton/selection/lb3.png");
	ImageIcon zy3=new ImageIcon("src/image/frameAndButton/selection/zy3.png");
	ImageIcon mc3=new ImageIcon("src/image/frameAndButton/selection/mc3.png");
	
	ImageIcon bg=new ImageIcon("src/image/frameAndButton/selection/board-original.jpg");
	JLabel Return =new JLabel();//返回按钮
	ImageIcon re1=new ImageIcon("src/image/frameAndButton/jump/return1.png");
	ImageIcon re2=new ImageIcon("src/image/frameAndButton/jump/return2.png");
	//进入按钮
	JLabel Enter =new JLabel();
	ImageIcon en1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon en2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	JPanel ZYP;
	
	//最终英雄代号
	int hero=-1;
	JPanelYXMS MS;
	
	//音乐
	SetMusic musicChooseH=new SetMusic("src/music/bgm/choosehero.wav",true,1); 
	public JPanelChooseHero(JPanel zyp,JPanelYXMS ms){
		ZYP=zyp;//传参
		MS=ms;
		this.setSize(893, 620);
		this.setLayout(null);
		
		JLabel backg=new JLabel();
		JLabel cc=new JLabel();
		JLabel sq=new JLabel();
		JLabel lb=new JLabel();
		JLabel zy=new JLabel();
		JLabel mc=new JLabel();
		JLabel ys=new JLabel();
		
		//规格
		backg.setSize(893, 620);
		cc.setSize(cc2.getIconWidth(), cc2.getIconHeight());
		lb.setSize(cc2.getIconWidth(), cc2.getIconHeight());
		zy.setSize(cc2.getIconWidth(), cc2.getIconHeight());
		mc.setSize(cc2.getIconWidth(), cc2.getIconHeight());
		ys.setSize(cc2.getIconWidth(), cc2.getIconHeight());
		sq.setSize(cc2.getIconWidth(), cc2.getIconHeight());
		
		//加图片
		backg.setIcon(bg);
		cc.setIcon(cc2);
		ys.setIcon(ys3);
		sq.setIcon(sq3);
		lb.setIcon(lb3);
		zy.setIcon(zy3);
		mc.setIcon(mc3);
		//监控
				MouseListenerChooseHero ml0=new MouseListenerChooseHero(cc,0,backg,this);
				MouseListenerChooseHero ml1=new MouseListenerChooseHero(ys,1,backg,this);
				MouseListenerChooseHero ml2=new MouseListenerChooseHero(sq,2,backg,this);
				MouseListenerChooseHero ml3=new MouseListenerChooseHero(lb,3,backg,this);
				MouseListenerChooseHero ml4=new MouseListenerChooseHero(zy,4,backg,this);
				MouseListenerChooseHero ml5=new MouseListenerChooseHero(mc,5,backg,this);
				MouseListenerChooseHeroEnter MLE=new MouseListenerChooseHeroEnter(Enter,this,zyp);
		//登录界面
				JPanelRegister Register=new JPanelRegister(ml0,ml1,ml2,ml3,ml4,ml5,MLE,this);
				Register.setLocation(295, 210);
				this.add(Register,0);
				Register.setVisible(true);
		//位置
		
		this.add(ys,1);
		ys.setLocation(667, 170);
		this.add(mc,2);
		mc.setLocation(227, 200);
		this.add(zy,3);
		zy.setLocation(772, 140);
		this.add(lb,4);
		lb.setLocation(122, 170);
		this.add(sq,5);
		sq.setLocation(562, 200);
		this.add(cc,6);
		cc.setLocation(17, 140);
		
		
		
		//传递控制其他监控
		ml0.passML(ml1, ml2, ml3, ml4, ml5);
		ml1.passML(ml0, ml2, ml3, ml4, ml5);
		ml2.passML(ml1, ml3, ml4, ml5, ml0);
		ml3.passML(ml0, ml1, ml2, ml4, ml5);
		ml4.passML(ml0, ml1, ml2, ml3, ml5);
		ml5.passML(ml0, ml1, ml2, ml3, ml4);
		
		//加监控
		
		cc.addMouseListener(ml0);
		if(new GetLock().pass1==1){
			ys.setIcon(ys2);
		ys.addMouseListener(ml1);
		}
		if(new GetLock().pass2==1){
			sq.setIcon(sq2);
			sq.addMouseListener(ml2);
		}
		if(new GetLock().pass3==1){
			lb.setIcon(lb2);
			lb.addMouseListener(ml3);
		}
		if(new GetLock().pass4==1){
			zy.setIcon(zy2);
		zy.addMouseListener(ml4);
		}
		if(new GetLock().pass5==1){
			mc.setIcon(mc2);
		mc.addMouseListener(ml5);
		}
		
		//返回按钮
		
		Return.setIcon(re1);
		Return.setBounds(30, 560, re1.getIconWidth(), re1.getIconHeight());
		add(Return,7);
		Return.addMouseListener(this);
		//进入按钮
		Enter.setIcon(en1);
		Enter.setBounds(743, 10, re1.getIconWidth(), re1.getIconHeight());
		add(Enter,8);

		Enter.addMouseListener(MLE);
		this.add(backg,9);
		backg.setLocation(0, 0);
		
				musicChooseH.play();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
			musicChooseH.stop();//关掉选择英雄的音乐
			//音效
			SetMusic musicConfirm=new SetMusic("src/music/action/confirm4.wav",false,2);
			musicConfirm.play();
//		JPanelYXMS ms=new JPanelYXMS(ZYP);
//		ZYP.add(ms);
		MS.setVisible(true);
		this.setVisible(false);
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

		Return.setIcon(re2);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
		Return.setIcon(re1);
		}
	}
}
