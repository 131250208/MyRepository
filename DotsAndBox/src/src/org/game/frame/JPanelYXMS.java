package src.org.game.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;






import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JPanelYXMS extends JPanel implements MouseListener {
	ImageIcon re1=new ImageIcon("src/image/frameAndButton/jump/return1.png");
	ImageIcon re2=new ImageIcon("src/image/frameAndButton/jump/return2.png");
	JPanel zyp;
	Thread music;
	JLabel Return =new JLabel();
	JPanelZYJM ZYJM;
	
	//ͼƬ
	ImageIcon ms1=new ImageIcon("src/image/frameAndButton/YXMS/gs.png");
	ImageIcon ms2=new ImageIcon("src/image/frameAndButton/YXMS/zyms.png");
	ImageIcon ms3=new ImageIcon("src/image/frameAndButton/YXMS/rjms.png");
	ImageIcon ms4=new ImageIcon("src/image/frameAndButton/YXMS/srjj.png");
	ImageIcon ms5=new ImageIcon("src/image/frameAndButton/YXMS/qdms.png");
	//��ʾ��
	JLabel prom=new JLabel();
	
	SetMusic musicZJM=null;
	public JPanelYXMS(JPanel xmsaddwhere
			,JPanelZYJM ZJM
			) {
		ZYJM=ZJM;
		
		//������
		 zyp=xmsaddwhere;
//		 music=t;
		//���ô�С
		this.setSize(893, 620);
		setLayout(null);
		//��ʾ���ļ���
		MouseListenerProm ms1=new MouseListenerProm(1);
		MouseListenerProm ms2=new MouseListenerProm(2);
		MouseListenerProm ms3=new MouseListenerProm(3);
		MouseListenerProm ms4=new MouseListenerProm(4);
		MouseListenerProm ms5=new MouseListenerProm(5);
		
		//����
		
		TreadMove CG = new TreadMove(this,10, 105-550,10, 105,"src/image/frameAndButton/YXMS/cc2.png",30,50,0);
		MouseListenerYXMS MS1=new MouseListenerYXMS(1,this,zyp,CG);//�Ӽ���
		CG.addMouseListener(MS1);;
		CG.addMouseListener(ms1);
		//	����
		TreadMove P2 = new TreadMove(this,535, 105-550-450*3,535, 105,"src/image/frameAndButton/YXMS/mc2.jpg",30,50,1);
		
		MouseListenerYXMS MS4=new MouseListenerYXMS(4,this,zyp,P2);//�Ӽ���
		P2.addMouseListener(MS4);;
		P2.addMouseListener(ms4);;
		//�˻�
		TreadMove RJ = new TreadMove(this,360, 105-550-450*2,360, 105,"src/image/frameAndButton/YXMS/lvb2.jpg",30,50,2);
		
		MouseListenerYXMS MS3=new MouseListenerYXMS(3,this,zyp,RJ);//�Ӽ���
		RJ.addMouseListener(MS3);;
		RJ.addMouseListener(ms3);;
		
		//Ȧ��
		TreadMove QDT = new TreadMove(this,710, 105-550-450*4,710, 105,"src/image/frameAndButton/YXMS/zy2.png",30,50,3);
		MouseListenerYXMS MS5=new MouseListenerYXMS(5,this,zyp,QDT);//�Ӽ���
		QDT.addMouseListener(MS5);;
		QDT.addMouseListener(ms5);;
		//����ģʽ
		TreadMove ZY = new TreadMove(this,185, 105-550-450,185, 105,"src/image/frameAndButton/YXMS/lb2.png",30,50,4);
		MouseListenerYXMS MS2=new MouseListenerYXMS(2,this,zyp,ZY);//�Ӽ���
		ZY.addMouseListener(MS2);;
		ZY.addMouseListener(ms2);;	
		//���ذ�ť
		
				Return.setIcon(re1);
				Return.setBounds(385, 560, re1.getIconWidth(), re1.getIconHeight());
				add(Return,5);
				Return.addMouseListener(this);
				//��ʾ��
				prom.setBounds(50, 5, 793, 80);
				this.add(prom,6);
				//����
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setIcon(new ImageIcon("src\\image\\frameAndButton\\YXMS\\main.png"));
		lblNewLabel.setBounds(0, 0, 897, 623);
		add(lblNewLabel,7);
		
		//move
		CG.move();
		P2.move();
		RJ.move();
		QDT.move();
		ZY.move();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		ZYJM.remove();
		//��Ч
				SetMusic musicEnter=new SetMusic("src/music/action/confirm4.wav",false,2);
				musicEnter.play();
				
		ZYJM.setVisible(true);
		this.setVisible(false);
		
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
		Return.setIcon(re2);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		Return.setIcon(re1);
	}

	public class MouseListenerProm implements MouseListener{

		int N;
		
		public MouseListenerProm(int num){
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
			switch(N){
			case 1:prom.setIcon(ms1);
				break;
			case 2:prom.setIcon(ms2);
				break;
			case 3:prom.setIcon(ms3);
				break;
			case 4:prom.setIcon(ms4);
				break;
			case 5:prom.setIcon(ms5);
				break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			prom.setIcon(null);
		}
		
	}
	
	
}
