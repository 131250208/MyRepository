package src.org.game.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JPanelWIN extends JPanel implements MouseListener{
//ͼƬ����
	ImageIcon over0=new ImageIcon("src/image/frameAndButton/Win/confirm0.png");
	ImageIcon over1=new ImageIcon("src/image/frameAndButton/Win/confirm1.png");
	//����ʤ��ͼ
	ImageIcon cc1=new ImageIcon("src/image/frameAndButton/Win/cc.jpg");
	ImageIcon ys1=new ImageIcon("src/image/frameAndButton/Win/ys.jpg");
	ImageIcon sq1=new ImageIcon("src/image/frameAndButton/Win/sq.jpg");
	ImageIcon lb1=new ImageIcon("src/image/frameAndButton/Win/lb.jpg");
	ImageIcon zy1=new ImageIcon("src/image/frameAndButton/Win/zy.jpg");
	ImageIcon mc1=new ImageIcon("src/image/frameAndButton/Win/mc.jpg");
	ImageIcon lrwx1=new ImageIcon("src/image/frameAndButton/Win/lrwx.jpg");
	ImageIcon hhr1=new ImageIcon("src/image/frameAndButton/Win/hhr.jpg");
	ImageIcon wyl1=new ImageIcon("src/image/frameAndButton/Win/wyl.jpg");
	ImageIcon wyc1=new ImageIcon("src/image/frameAndButton/Win/wyc.jpg");
	ImageIcon fbbz1=new ImageIcon("src/image/frameAndButton/Win/fbbz.jpg");
	ImageIcon lvb1=new ImageIcon("src/image/frameAndButton/Win/lvb.jpg");
	//����ܱ�ͼ
	ImageIcon cc0=new ImageIcon("src/image/frameAndButton/Win/cc2.jpg");
	ImageIcon ys0=new ImageIcon("src/image/frameAndButton/Win/ys2.jpg");
	ImageIcon sq0=new ImageIcon("src/image/frameAndButton/Win/sq2.jpg");
	ImageIcon lb0=new ImageIcon("src/image/frameAndButton/Win/lb2.jpg");
	ImageIcon zy0=new ImageIcon("src/image/frameAndButton/Win/zy2.jpg");
	ImageIcon mc0=new ImageIcon("src/image/frameAndButton/Win/mc2.jpg");
	ImageIcon lrwx0=new ImageIcon("src/image/frameAndButton/Win/lrwx2.jpg");
	ImageIcon hhr0=new ImageIcon("src/image/frameAndButton/Win/hhr2.jpg");
	ImageIcon wyl0=new ImageIcon("src/image/frameAndButton/Win/wyl2.jpg");
	ImageIcon wyc0=new ImageIcon("src/image/frameAndButton/Win/wyc2.jpg");
	ImageIcon fbbz0=new ImageIcon("src/image/frameAndButton/Win/fbbz2.jpg");
	ImageIcon lvb0=new ImageIcon("src/image/frameAndButton/Win/lvb2.jpg");
	
	ImageIcon passall=new ImageIcon("src/image/frameAndButton/Win/over.jpg");
	JLabel over = new JLabel("New button");
	
	int Win,P1,P2,MS;
	JLabel wj = new JLabel();
	JLabel dj = new JLabel();
	JLabel passAll = new JLabel();
	Background background = new Background();
	JPanelCG CG;//��linkʹ��
	JPanel2p PP;
	public JPanelWIN(int win//��Ӯ���
			,JPanel zyp,
			int ms//�������ĸ�ģʽ����Ӯ��� 12345
			,int p1//�ҷ�����  0�ܲ�1Ԭ�� 2��Ȩ3����4���5��6��������7�ƻ���8������9�����10�������11����
			,int p2//�з�����
			,JPanelCG cg
			,JPanel2p pp
			){
		
		//����
		Win=win;
		P1=p1;
		P2=p2;
		MS=ms;
		CG=cg;
		PP=pp;
		this.setSize(893, 620);
		setLayout(null);
		this.setBounds(0, 0, 893, 620);
	
		
		if(ms==1&&new GetDataOfPlayer("wyc").Pass==9&&win==1){
			//System.out.println("passall");
			passAll.setIcon(passall);
			
		}
		
		wj.setBounds(97, 90, 210, 270);	
		dj.setBounds(595, 90, 210, 270);
		setHero();
		
		passAll.setBounds(103, 100, passall.getIconWidth(), passall.getIconHeight());
		passAll.setVisible(true);
		add(passAll,0);
		add(dj,1);
		add(wj,2);
		
		MouselistenerLink ML=new MouselistenerLink(this,zyp,ms);//���
		over.setIcon(over0);
		over.addMouseListener(this);
		over.addMouseListener(ML);
		over.setBounds(346, 490, over0.getIconWidth(), over0.getIconHeight());
		add(over,3);
		
		
		background.setLocation(0, 0);
		add(background,4);
	}

	public class Background extends JPanel{
		BufferedImage bg= null;
		public Background(){
			this.setSize(893, 620);
			
			try {
				bg=ImageIO.read(new File("src\\image\\frameAndButton\\Win\\board.png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}
		public void paint(Graphics g2) {
			BufferedImage bi=new BufferedImage(893,620,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g=bi.createGraphics();
			
			//��������ɫ
			g.setColor(Color.WHITE);		   		  
			g.setFont(new Font("����", Font.BOLD,25));
			//������
			 g.drawImage(bg, 0,0,this);
			if(MS==1||MS==2){
			
				 int moneyOfNowPlayer=new GetDataOfPlayer(new GetNowPlayer().now).Money;
					String titleOfNowPlayer=retitle(moneyOfNowPlayer);
					g.drawString(String.valueOf(moneyOfNowPlayer), 442,355);
					g.drawString(titleOfNowPlayer, 410,405);
			}
			else if(MS==3){
				g.drawString(String.valueOf(999), 442,355);
				g.drawString(" ����", 410,405);
			}
			else if(MS==4){
				g.drawString(String.valueOf(999), 442,355);
				g.drawString("�廢�Ͻ�", 410,405);
			}
			else if(MS==5){
				g.drawString(String.valueOf(999), 442,355);
				g.drawString("  ة��", 410,405);
			}
			  g2.drawImage(bi, 0, 0, this);
		}
	}
	
	public String retitle(int money ){
		String result="";
		if(money<0){
			result="�ܾ�����";
		}
		else if(money>=0&&money<=60){
			
			result="��ϰ����";
		}

		else if(money>60&&money<=80){
			
			result=" �Խ���";
		}
else if(money>80&&money<=100){
			
			result=" ƫ����";
		}
else if(money>100&&money<=120){
	
	result="��Զ����";
}
else if(money>120&&money<=140){
	
	result="���彫��";
}
else if(money>140&&money<=160){
	
	result="���佫��";
}
else if(money>160&&money<=180){
	
	result="��������";
}
else if(money>180&&money<=200){
	
	result="��������";
}
else if(money>200&&money<=220){
	
	result="���ｫ��";
}
else if(money>220&&money<=240){
	
	result="��������";
}
else if(money>240&&money<=260){
	
	result=" ������";
}
else if(money>260){
	
	result=" �󽫾�";
}
		return result;
		
	}
	public void setHero(){
		if(Win==1){//p1ʤ��
			switch(P1){//��P1��ͼ
			case 0:wj.setIcon(cc1);
			break;
			case 1:wj.setIcon(ys1);
			break;
			case 2:wj.setIcon(sq1);
			break;
			case 3:wj.setIcon(lb1);
			break;
			case 4:wj.setIcon(zy1);
			break;
			case 5:wj.setIcon(mc1);
			break;
			case 6:wj.setIcon(lrwx1);
			break;
			case 7:wj.setIcon(hhr1);
			break;
			case 8:wj.setIcon(wyl1);
			break;
			case 9:wj.setIcon(wyc1);
			break;
			case 10:wj.setIcon(fbbz1);
			break;
			case 11:wj.setIcon(lvb1);
			break;
			
			}
			
			switch(P2){//��P2��ͼ
			case 0:dj.setIcon(cc0);
			break;
			case 1:dj.setIcon(ys0);
			break;
			case 2:dj.setIcon(sq0);
			break;
			case 3:dj.setIcon(lb0);
			break;
			case 4:dj.setIcon(zy0);
			break;
			case 5:dj.setIcon(mc0);
			break;
			case 6:dj.setIcon(lrwx0);
			break;
			case 7:dj.setIcon(hhr0);
			break;
			case 8:dj.setIcon(wyl0);
			break;
			case 9:dj.setIcon(wyc0);
			break;
			case 10:dj.setIcon(fbbz0);
			break;
			case 11:dj.setIcon(lvb0);
			break;
			
			}
		}
		else if(Win==2){//���P2Ӯ��
			switch(P1){//��P1��ͼ
			case 0:wj.setIcon(cc0);
			break;
			case 1:wj.setIcon(ys0);
			break;
			case 2:wj.setIcon(sq0);
			break;
			case 3:wj.setIcon(lb0);
			break;
			case 4:wj.setIcon(zy0);
			break;
			case 5:wj.setIcon(mc0);
			break;
			case 6:wj.setIcon(lrwx0);
			break;
			case 7:wj.setIcon(hhr0);
			break;
			case 8:wj.setIcon(wyl0);
			break;
			case 9:wj.setIcon(wyc0);
			break;
			case 10:wj.setIcon(fbbz0);
			break;
			case 11:wj.setIcon(lvb0);
			break;
			
			}
			
			switch(P2){//��P2��ͼ
			case 0:dj.setIcon(cc1);
			break;
			case 1:dj.setIcon(ys1);
			break;
			case 2:dj.setIcon(sq1);
			break;
			case 3:dj.setIcon(lb1);
			break;
			case 4:dj.setIcon(zy1);
			break;
			case 5:dj.setIcon(mc1);
			break;
			case 6:dj.setIcon(lrwx1);
			break;
			case 7:dj.setIcon(hhr1);
			break;
			case 8:dj.setIcon(wyl1);
			break;
			case 9:dj.setIcon(wyc1);
			break;
			case 10:dj.setIcon(fbbz1);
			break;
			case 11:dj.setIcon(lvb1);
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		over.setIcon(over1);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		over.setIcon(over0);
	}
}
