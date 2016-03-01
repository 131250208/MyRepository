package src.org.game.frame;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JPanelCG extends JPanel implements MouseListener {
	
	  //��ʼ��
		int i,j,m,n,mpoints=0,epoints=0,stepnum=0;
		//�����ܼ���
		int num=0;
		//���Ʒ��ذ�ť
		int work=1;
		
		            // ȡ����Ļ�Ŀ��
					int width = Toolkit.getDefaultToolkit().getScreenSize().width;
					// ȡ����Ļ�ĸ߶�
					int height = Toolkit.getDefaultToolkit().getScreenSize().height;
					
					// ����ͼƬ��ֵ
					
					// ����ͼƬ��ֵ
					BufferedImage bg1 = null;
					
					BufferedImage yz1 = null;
					BufferedImage yz2 = null;
					BufferedImage qp1 = null;
					BufferedImage wb1 = null;
					BufferedImage wb2= null;
					BufferedImage db1 = null;
					BufferedImage db2 = null;
					
					
					//�������������� 
					int x=0;
			          int y=0;
			          //�������бߣ�1��ʾ�Լ��ģ�2��ʾ�Է��ģ�0��ʾû��
			          int [][] hb=new int[6][5];
			          int [][] sb=new int[6][5];
			          //����box
			          int [][] box= new int[5][5];
			          
			          //��ʶ�ֵ�˭
			          boolean isMine=true;
			          //�������ⲽ��˭�ߵ�,1��ʾ���ߵģ�2��ʾ�Է�
			         int step=0;
			         //�жϱ����Ƿ����
			         boolean isOver=true;
			         
			         //Ӫկ��
			         JLabel myhousenum = new JLabel("\u8425\u5BE8");
			         JLabel dhousenum = new JLabel("\u8425\u5BE8");
			         //���ذ�ť
			         JLabel FH=new JLabel();
			 		ImageIcon fh=new ImageIcon("src/image/frameAndButton/jump/fh.jpg");
			 		ImageIcon fh2=new ImageIcon("src/image/frameAndButton/jump/fh2.jpg");
			       //���ݲ���������
			         JPanel zyp;
			         Timetable T;
			         int ms;
			        int Hero;
			        ChessCG QP;
			    	JPanelBuyPro PRO;
			      
			         //���ֵ��߼����ܵ��ж�
			         static boolean useSkill=false,haveusedSkill=false,bcisMYturn;
			      //��ʾ��
			         JLabel prom= new JLabel();
			         
			       //������
			         JLabel face1=new JLabel();
			         JLabel face2=new JLabel();
			         
			         
			     int  PASS;
			     JPanelYXMS BF;
			     JPanelStory BF2;
			     JPanelChoosePass BF3;
			     //��ʾ
			     JLabel promt1=new JLabel();
			     JLabel promt2=new JLabel();
			     //��ʾ��ͼƬ
			     ImageIcon p0=new ImageIcon("src/image/frameAndButton/prompt/skill/0.png");
			     ImageIcon p1=new ImageIcon("src/image/frameAndButton/prompt/skill/1.png");
			     ImageIcon p2=new ImageIcon("src/image/frameAndButton/prompt/skill/2.png");
			     ImageIcon p3=new ImageIcon("src/image/frameAndButton/prompt/skill/3.png");
			     ImageIcon p4=new ImageIcon("src/image/frameAndButton/prompt/skill/4.png");
			     ImageIcon p5=new ImageIcon("src/image/frameAndButton/prompt/skill/5.png");
			     ImageIcon p6=new ImageIcon("src/image/frameAndButton/prompt/skill/6.png");
			     ImageIcon p7=new ImageIcon("src/image/frameAndButton/prompt/skill/7.png");
			     ImageIcon p8=new ImageIcon("src/image/frameAndButton/prompt/skill/8.png");
			     ImageIcon p9=new ImageIcon("src/image/frameAndButton/prompt/skill/9.png");
			   //����
					SetMusic musicFighting=new SetMusic("src/music/bgm/fighting.wav",true,1);
public JPanelCG(int hero,//���ص�Ӣ���ǣ�
		int pass,JPanelYXMS bf,//ģʽ3
		JPanelStory bf2,//ģʽ1
		JPanelChoosePass bf3,//ģʽ2
		JPanel add,
		int MS//�ò��������Ǵ��ػ�����ͨ�˻�    1�Ǵ���  0����ͨ�˻���3��  2������
		) {
	
	
	//��ʼ��
	useSkill=false;
	haveusedSkill=false;
	//�ı�ؿ���Ϣ
	PASS=pass;
		//���ݲ���
	ms=MS;
	Hero=hero;
	    zyp=add;
	    BF=bf;
	    BF2=bf2;
	    BF3=bf3;
	  
	    //����
	    ChessCG qpcg = new ChessCG(myhousenum,dhousenum,this,zyp);
	    QP=qpcg;
	    //��ʱ
	    Timetable timetable=null;
	    if(MS==1||MS==2){
	    timetable = new Timetable(qpcg,qpcg,1);
	    }
	    else if(MS==0){
	    	 timetable = new Timetable(null,qpcg,2);
	    }
	    
	    //��������ֵ
	    T=timetable;
		// ��������С
		this.setSize(900, 650);
		//������岼�ֹ�����
		this.setLayout(null);
		
		JPanelBuyPro pro=new JPanelBuyPro(timetable); 
		
		PRO=pro;
        JPanelReady RD=new JPanelReady(timetable,3);
		
        if(MS==1||MS==2){
			//����������
				
			 this.add(pro,0);
			 pro.setVisible(true);
	
			}
			else if(MS==0){
				this.add(RD,0);
				RD.setVisible(true);
			
			}
		//�佫
		JLabel wjiang = new JLabel("\u6B66\u5C06");
		if(MS==1||MS==2){
			switch(Hero){
			case 0:
			wjiang.setIcon(new ImageIcon("src/image/hero/�ܲ�.jpg"));
			break;
			case 1:
				wjiang.setIcon(new ImageIcon("src/image/hero/Ԭ��.jpg"));
				break;
			case 2:
				wjiang.setIcon(new ImageIcon("src/image/hero/��Ȩ.jpg"));
				break;
			case 3:
				wjiang.setIcon(new ImageIcon("src/image/hero/����.jpg"));
				break;
			case 4:
				wjiang.setIcon(new ImageIcon("src/image/hero/���.jpg"));
				break;
			case 5:
				wjiang.setIcon(new ImageIcon("src/image/hero/��.jpg"));
				break;
			}
		}
		else if(MS==0){
			wjiang.setIcon(new ImageIcon("src/image/hero/�������.jpg"));
		}
		
		wjiang.setBackground(Color.BLACK);
		wjiang.setForeground(Color.BLACK);
		wjiang.setBounds(30, 140, 150, 200);
		this.add(wjiang,1);

		
		if(MS==1||MS==2){
		//�ҷ�����
	
		JLabel myskill = new JLabel("\u6280\u80FD");
		//�ҷ����ܼ��
		MouseListenerChangeimage mouseim=new MouseListenerChangeimage(null,myskill,2,hero);
		mouseim.work=1;
		myskill.addMouseListener(new MouseListenSkill());
		myskill.addMouseListener(new MouseListenerOfPromt(1));
		switch(Hero){
		case 0:
		myskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\0.png"));
		break;
		case 1:
			myskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\1.png"));
			break;
		case 2:
			myskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\2.png"));
			break;
		case 3:
			myskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\3.png"));
			break;
		case 4:
			myskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\4.png"));
			break;
		case 5:
			myskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\5.png"));
			break;
		}
		myskill.setBounds(10, 350, 180, 50);
		this.add(myskill,2);
		
		}
		
		if(MS==1||MS==2){
		//�ҷ�Ӫկ��
		myhousenum.setIcon(new ImageIcon("src\\image\\frameAndButton\\yzl\\0.png"));
		myhousenum.setBounds(30, 420, 100, 50);
		this.add(myhousenum,3);
		}
		else if(MS==0){
			//�ҷ�Ӫկ��
			myhousenum.setIcon(new ImageIcon("src\\image\\frameAndButton\\yzl\\0.png"));
			myhousenum.setBounds(30, 350, 100, 50);
			this.add(myhousenum,2);
		}
		
		
		
		//�Է��佫
		JLabel djiang = new JLabel("\u6B66\u5C06");
		switch(pass){
		case 1:djiang.setIcon(new ImageIcon("src/image/hero/Ԭ��.jpg"));
		break;
		case 2:djiang.setIcon(new ImageIcon("src/image/hero/��Ȩ.jpg"));
		break;
		case 3:djiang.setIcon(new ImageIcon("src/image/hero/����.jpg"));
		break;
		case 4:djiang.setIcon(new ImageIcon("src/image/hero/���.jpg"));
		break;
		case 5:djiang.setIcon(new ImageIcon("src/image/hero/��.jpg"));
		break;
		case 6:djiang.setIcon(new ImageIcon("src/image/hero/��������.jpg")); 
		break;
		case 7:djiang.setIcon(new ImageIcon("src/image/hero/�ƻ���.jpg"));
		break;
		case 8:djiang.setIcon(new ImageIcon("src/image/hero/������.jpg"));
		break;
		case 9:djiang.setIcon(new ImageIcon("src/image/hero/�����.jpg"));
		break;
		case 11:djiang.setIcon(new ImageIcon("src/image/hero/����.jpg"));
		break;
		}
		
		djiang.setForeground(Color.BLACK);
		djiang.setBackground(Color.BLACK);
		djiang.setBounds(722, 140, 150, 200);
		if(MS==1||MS==2){
		this.add(djiang,4);
		}
		else if(MS==0){
			this.add(djiang,3);
		}
		if(MS==1||MS==2){
		//�Է�����
		JLabel dskill = new JLabel("\u6280\u80FD");
	
	   MouseListenerChangeimage mouseim1=new MouseListenerChangeimage(null,dskill,2,PASS);
	   dskill.addMouseListener(new MouseListenerOfPromt(2));
	
		switch(pass){
		case 1:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\1.png"));
		break;
		case 2:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\2.png"));
		break;
		case 3:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\3.png"));
		break;
		case 4:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\4.png"));
		break;
		case 5:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\5.png"));
		break;
		case 6:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\6.png"));
		break;
		case 7:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\7.png"));
		break;
		case 8:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\8.png"));
		break;
		case 9:dskill.setIcon(new ImageIcon("src\\image\\frameAndButton\\9.png"));
		break;
		
		
		}
		dskill.setBounds(702, 350, 180, 50);
		this.add(dskill,5);
		}
		
		if(MS==1||MS==2){
		//�Է�Ӫկ����
		dhousenum.setIcon(new ImageIcon("src\\image\\frameAndButton\\yzl\\0.png"));
		dhousenum.setBounds(772, 420, 100, 50);
		this.add(dhousenum,6);
}
		
else if(MS==0){
	//�Է�Ӫկ����
			dhousenum.setIcon(new ImageIcon("src\\image\\frameAndButton\\yzl\\0.png"));
			dhousenum.setBounds(772, 350, 100, 50);
			this.add(dhousenum,4);
}
	
		
		//�ؿ���
		JLabel guanka = new JLabel("\u5173\u5361\u6570");
		guanka.setIcon(new ImageIcon("src/image/frameAndButton/passbox/pass"+PASS+".jpg"));
		guanka.setBounds(321, 10, 270, 60);
		if(MS==1||MS==2){
		this.add(guanka,7);
		}
		else if(MS==0){
			this.add(guanka,5);
		}
		//�����
		MouseListenerWG wg=new MouseListenerWG(qpcg);
		guanka.addMouseListener(wg);
		
		//��ʱ��
		timetable.setBounds(362, 569, 150, 30);
		if(MS==1||MS==2){
		this.add(timetable,8);
		}
		else if (MS==0){
			this.add(timetable,6);	
		}
		//��ʾ��
		prom.setBounds(705, 530, 160, 70);
		if(MS==1||MS==2){
			this.add(prom,9);
			}
			else if (MS==0){
				this.add(prom,7);
			}
	
		//������
		face1.setBounds(35, 10, 100, 100);
		face2.setBounds(758, 10, 100, 100);
		if(MS==1||MS==2){
			this.add(face1,10);
			this.add(face2,11);
			}
			
		
		//����
		qpcg.setBounds(215, 85, 470, 470);
		if(MS==1||MS==2){
			this.add(qpcg,12);
			}
			else if (MS==0){
				this.add(qpcg,8);
			}
	
		
		
	
		//���ذ�ť
		
		FH.setIcon(fh);
		FH.setBounds(745, 480, fh.getIconWidth(), fh.getIconHeight());
		if(MS==1||MS==2){
			this.add(FH,13);
			}
			else if (MS==0){
				this.add(FH,9);
			}
	
		
		FH.addMouseListener(this);

		//��ʾ��
		if(MS==1||MS==2){
			promt1.setBounds(180, 556, 180, 50);
			promt2.setBounds(514, 556, 180, 50);
			this.add(promt1,14);
			this.add(promt2,15);
			
		}
		//����
		JLabel jlback=new JLabel();
		ImageIcon imageback=new ImageIcon("src/image/background/bg"+PASS+".jpg");
		jlback.setIcon(imageback);
		if(MS==1||MS==2){
			this.add(jlback,16);
			}
			else if (MS==0){
				this.add(jlback,10);
			}
	
		jlback.setBounds(0, 0, 893, 620);
		MouseListenerXY xy=new MouseListenerXY();
		jlback.addMouseListener(xy);
		
		zyp.add(this);
		this.setBounds(0, 0, 900, 650);
		this.repaint();
		if(bf!=null){
		bf.setVisible(false);
		System.gc();
		bf=null;
		}
		if(bf2!=null){
			bf2.setVisible(false);
			System.gc();
			bf2=null;
		}
		if(bf3!=null){
			bf3.setVisible(false);
			System.gc();
			bf3=null;
		}
		musicFighting.play();
		this.setVisible(true);
		

	}
//ֹͣ��ʱ
public void timeStop(){
	T.timeStop();
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO �Զ����ɵķ������
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO �Զ����ɵķ������
	if(work==1){
			T.timeStop();
			musicFighting.stop();
			QP.jumpout=true;
			//��Ч
			SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
			musicConfirm.play();
			
			if(BF!=null){//ģʽ3
		//	JPanelYXMS yxms=new JPanelYXMS(zyp);
		//	zyp.add(yxms);
		//	yxms.setLocation(0, 0);
			BF.setVisible(true);
			this.setVisible(false);
			}
			if(BF2!=null){
				BF2.ms.setVisible(true);
				this.setVisible(false);
			}
			if(BF3!=null){
				BF3.MS.setVisible(true);
				this.setVisible(false);
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
	//��Ч
			SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
			musicEnter.play();
	FH.setIcon(fh2);
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO �Զ����ɵķ������
	FH.setIcon(fh);
}
	
public class JPanelMCskill extends JPanel implements MouseListener{

	//ͼƬ
	ImageIcon bg=new ImageIcon("src/image/frameAndButton/MCskill/board.jpg");
	ImageIcon h1=new ImageIcon("src/image/frameAndButton/MCskill/h1.jpg");
	ImageIcon h2=new ImageIcon("src/image/frameAndButton/MCskill/h2.jpg");
	ImageIcon s1=new ImageIcon("src/image/frameAndButton/MCskill/s1.jpg");
	ImageIcon s2=new ImageIcon("src/image/frameAndButton/MCskill/s2.jpg");
	//jl
	JLabel back=new JLabel();
	JLabel H=new JLabel();
	JLabel S=new JLabel();
	JLabel close=new JLabel();
	
	public JPanelMCskill() {
		//
		MouseListenerXY xy=new MouseListenerXY();
		this.addMouseListener(xy);
		this.setSize(250,180);
		this.setLayout(null);
		//
		H.setIcon(h1);
		S.setIcon(s1);
		S.setBounds(15, 102, 100, 50);
		H.setBounds(135, 102, 100, 50);
		close.setBounds(225, 2, 20, 15);
		close.addMouseListener(this);
		
		back.setIcon(bg);
		back.setBounds(0, 0, 250, 180);
		//
		this.add(H,0);
		this.add(S,1);
		this.add(close,2);
		this.add(back,3);
		//
		Button mls=new Button(1);
		Button mlh=new Button(2);
		S.addMouseListener(mls);
		H.addMouseListener(mlh);
	}
	
	public class Button implements MouseListener{

		int N;
		public Button(int num//1��ʾ�� 2��ʾ��
				){
			N=num;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			//��Ч
			SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
			musicConfirm.play();
			switch(N){
			case 1:
				//��
				SetMusic skillmc1=new SetMusic("src/music/skill/mc2.wav",false,2);
	       		 skillmc1.play();
				ChessCG.machaoskill=1;
				break;
			case 2:
				//��
				SetMusic skillmc2=new SetMusic("src/music/skill/mc1.wav",false,2);
       		 skillmc2.play();
				ChessCG.machaoskill=2;
				break;
			}
			JPanelMCskill.this.setVisible(false);
			QP.isOver=false;
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
			case 1:S.setIcon(s2);
				break;
			case 2:H.setIcon(h2);
				break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			switch(N){
			case 1:S.setIcon(s1);
				break;
			case 2:H.setIcon(h1);
				break;
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		this.setVisible(false);
		QP.isOver=false;
		QP.isMC=false;
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

	public class MouseListenSkill implements MouseListener{
	
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			if(haveusedSkill==false){
				useSkill=true;
				
				switch(Hero){
				
				case 0:
					//��Ч
					SetMusic skillcc=new SetMusic("src/music/skill/cc.wav",false,2);
					skillcc.play();
				if(ChessCG.isMine==true){
					bcisMYturn=true;
				}
				else if(ChessCG.isMine==false){
					bcisMYturn=false;
				}
				break;
				case 1:
					//��Ч
					SetMusic skillys=new SetMusic("src/music/skill/ys.wav",false,2);
					skillys.play();
					Timetable.lefttime=1800;
					haveusedSkill=true;
					break;
				case 2:
					//��Ч
					SetMusic skillsq=new SetMusic("src/music/skill/sq.wav",false,2);
					skillsq.play();
					QP.get=0;//�õ���ֱ����
				QP.HIT=true;
				QP.isMine=false;
				haveusedSkill=true;
					break;
				case 3:
					//��Ч
					SetMusic skilllb=new SetMusic("src/music/skill/lb.wav",false,2);
					skilllb.play();
					if(ChessCG.isMine==true){
					bcisMYturn=true;
				
					}
				
					else if(ChessCG.isMine==false){
					bcisMYturn=false;
				
					}
					break;
				case 4:
					//��Ч
					SetMusic skillzy=new SetMusic("src/music/skill/zy.wav",false,2);
					skillzy.play();
					if(ChessCG.isMine==true){
						bcisMYturn=true;
					}
					else if(ChessCG.isMine==false){
						bcisMYturn=false;
					}
					break;
				case 5:
					
					//������
					ChessCG.isMC=true;
					//����Ϊ������
					QP.isOver=true;
					
					//����ѡ�����
					JPanelMCskill mcskill=new JPanelMCskill();
					JPanelCG.this.add(mcskill,0);
					mcskill.setLocation(320, 220);
					mcskill.setVisible(true);
					
					num++;
					if(num==3){
					haveusedSkill=true;
					}
					break;
					
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
			
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}
		
	}

	public class MouseListenerOfPromt implements MouseListener{
 
		int N;
		public MouseListenerOfPromt(int num){//1����ߵ� 2���ұߵ�
			N=num;
		}
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
			if(N==1){
				switch(Hero){
				case 0:promt1.setIcon(p0);
					break;
				case 1:promt1.setIcon(p1);
					break;
				case 2:promt1.setIcon(p2);
					break;
				case 3:promt1.setIcon(p3);
					break;
				case 4:promt1.setIcon(p4);
					break;
				case 5:promt1.setIcon(p5);
					break;
				}
			}
			else if(N==2){

				
				switch(PASS){
				
				
				case 1:promt2.setIcon(p1);
					break;
				case 2:promt2.setIcon(p2);
					break;
				case 3:promt2.setIcon(p3);
					break;
				case 4:promt2.setIcon(p4);
					break;
				case 5:promt2.setIcon(p5);
					break;
				case 6:promt2.setIcon(p6);
					break;
				case 7:promt2.setIcon(p7);
					break;
				case 8:promt2.setIcon(p8);
					break;
				case 9:promt2.setIcon(p9);
					break;
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			if(N==1){
				promt1.setIcon(null);
			}
			else if(N==2){
				promt2.setIcon(null);
			}
		}
		
	}
}
