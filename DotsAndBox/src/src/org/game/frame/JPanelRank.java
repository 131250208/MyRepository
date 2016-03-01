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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelRank extends JPanel implements MouseListener {
	BufferedImage bg = null;
	BufferedImage achi1 = null;
	BufferedImage achi2 = null;
	BufferedImage achi3 = null;
	BufferedImage achi4 = null;
	BufferedImage achi11 = null;
	BufferedImage achi22 = null;
	BufferedImage achi33 = null;
	BufferedImage achi44= null;
	//����ͷ��
	BufferedImage cc = null;
	BufferedImage ys = null;
	BufferedImage lb = null;
	BufferedImage sq = null;
	BufferedImage zy = null;
	BufferedImage mc= null;
	//˫����
	BufferedImage bi=new BufferedImage(520,400,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g=bi.createGraphics();
	public JPanelRank(){
		this.setSize(520,400);
		this.setLayout(null);
		
		try {
			bg=ImageIO.read(new File("src/image/frameAndButton/rank/purified.jpg"));
			achi1=ImageIO.read(new File("src/image/frameAndButton/rank/yjsd1.jpg"));
			achi2=ImageIO.read(new File("src/image/frameAndButton/rank/jzlz1.jpg"));
			achi3=ImageIO.read(new File("src/image/frameAndButton/rank/sywc1.jpg"));
			achi4=ImageIO.read(new File("src/image/frameAndButton/rank/kokushimusou1.jpg"));
			achi11=ImageIO.read(new File("src/image/frameAndButton/rank/yjsd2.jpg"));
			achi22=ImageIO.read(new File("src/image/frameAndButton/rank/jzlz2.jpg"));
			achi33=ImageIO.read(new File("src/image/frameAndButton/rank/sywc2.jpg"));
			achi44=ImageIO.read(new File("src/image/frameAndButton/rank/kokushimusou2.jpg"));
			
			cc=ImageIO.read(new File("src/image/frameAndButton/rank/head/cc.png"));
			ys=ImageIO.read(new File("src/image/frameAndButton/rank/head/ys.png"));
			lb=ImageIO.read(new File("src/image/frameAndButton/rank/head/lb.png"));
			sq=ImageIO.read(new File("src/image/frameAndButton/rank/head/sq.png"));
			zy=ImageIO.read(new File("src/image/frameAndButton/rank/head/zy.png"));
			mc=ImageIO.read(new File("src/image/frameAndButton/rank/head/mc.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		
	}
	
	public void paint(Graphics g2) {
		
		
		//��������ɫ
		g.setColor(Color.WHITE);		   		  
		g.setFont(new Font("����", Font.BOLD,25));
		
		 
		 //���в�д��
		String[] data= new GetDataOfPlayer("wyc").sort().split(";");
		
			String Name1=data[0];
			String Name2=data[1];
			String Name3=data[2];
			
			String Money1=String.valueOf(new GetDataOfPlayer(Name1).Money);
			String Money2=String.valueOf(new GetDataOfPlayer(Name2).Money);
			String Money3=String.valueOf(new GetDataOfPlayer(Name3).Money);
			
			String title1=retitle(new GetDataOfPlayer(Name1).Money);
			String title2=retitle(new GetDataOfPlayer(Name2).Money);
			String title3=retitle(new GetDataOfPlayer(Name3).Money);
			
			int hero1=new GetDataOfPlayer(Name1).Hero;
			int hero2=new GetDataOfPlayer(Name2).Hero;
			int hero3=new GetDataOfPlayer(Name3).Hero;
			//������
			 g.drawImage(bg, 0,0,this);
			 //��ͷ��
			 drawhead(1,hero1);
			 drawhead(2,hero2);
			 drawhead(3,hero3);
			 
		 g.drawString(Name1, 110,163);
		 g.drawString(Money1, 110,190);
		 g.drawString(Name2, 270,163);
		 g.drawString(Money2, 270,190);
		 g.drawString(Name3, 428,163);
		 g.drawString(Money3, 428,190);
		 
		 //���Ʒ��
		 g.setFont(new Font("����", Font.BOLD,15));
		 g.drawString(title1, 110,213);
		 g.drawString(title2, 270,213);
		 g.drawString(title3, 428,213);
		 
		 
		 //���Ƴɾ�
		 //��һ��
		 if(new GetDataOfPlayer(Name1).Achieve1==0){
			 g.drawImage(achi1, 50,240,this);			 
		 }
		 if(new GetDataOfPlayer(Name1).Achieve2==0){
			 g.drawImage(achi2, 50,270,this);			 
		 }
		 if(new GetDataOfPlayer(Name1).Achieve3==0){
			 g.drawImage(achi3, 50,300,this);			 
		 }
		 if(new GetDataOfPlayer(Name1).Achieve4==0){
			 g.drawImage(achi4, 50,330,this);			 
		 }
		 
		 if(new GetDataOfPlayer(Name1).Achieve1==1){
			 g.drawImage(achi11, 50,240,this);			 
		 }
		 if(new GetDataOfPlayer(Name1).Achieve2==1){
			 g.drawImage(achi22, 50,270,this);			 
		 }
		 if(new GetDataOfPlayer(Name1).Achieve3==1){
			 g.drawImage(achi33, 50,300,this);			 
		 }
		 if(new GetDataOfPlayer(Name1).Achieve4==1){
			 g.drawImage(achi44, 50,330,this);			 
		 }
		 //�ڶ���
		 if(new GetDataOfPlayer(Name2).Achieve1==0){
			 g.drawImage(achi1, 210,240,this);			 
		 }
		 if(new GetDataOfPlayer(Name2).Achieve2==0){
			 g.drawImage(achi2, 210,270,this);			 
		 }
		 if(new GetDataOfPlayer(Name2).Achieve3==0){
			 g.drawImage(achi3, 210,300,this);			 
		 }
		 if(new GetDataOfPlayer(Name2).Achieve4==0){
			 g.drawImage(achi4, 210,330,this);			 
		 }
		 
		 if(new GetDataOfPlayer(Name2).Achieve1==1){
			 g.drawImage(achi11, 210,240,this);			 
		 }
		 if(new GetDataOfPlayer(Name2).Achieve2==1){
			 g.drawImage(achi22, 210,270,this);			 
		 }
		 if(new GetDataOfPlayer(Name2).Achieve3==1){
			 g.drawImage(achi33, 210,300,this);			 
		 }
		 if(new GetDataOfPlayer(Name2).Achieve4==1){
			 g.drawImage(achi44, 210,330,this);			 
		 }
		 
		 //������
		 if(new GetDataOfPlayer(Name3).Achieve1==0){
			 g.drawImage(achi1, 370,240,this);			 
		 }
		 if(new GetDataOfPlayer(Name3).Achieve2==0){
			 g.drawImage(achi2, 370,270,this);			 
		 }
		 if(new GetDataOfPlayer(Name3).Achieve3==0){
			 g.drawImage(achi3, 370,300,this);			 
		 }
		 if(new GetDataOfPlayer(Name3).Achieve4==0){
			 g.drawImage(achi4, 370,330,this);			 
		 }
		 
		 if(new GetDataOfPlayer(Name3).Achieve1==1){
			 g.drawImage(achi11, 370,240,this);			 
		 }
		 if(new GetDataOfPlayer(Name3).Achieve2==1){
			 g.drawImage(achi22, 370,270,this);			 
		 }
		 if(new GetDataOfPlayer(Name3).Achieve3==1){
			 g.drawImage(achi33, 370,300,this);			 
		 }
		 if(new GetDataOfPlayer(Name3).Achieve4==1){
			 g.drawImage(achi44, 370,330,this);			 
		 }
		 
		  g2.drawImage(bi, 0, 0, this);
	}
	
	
	
	//��ͷ��
	public void drawhead(int rank,int hero){
		if(rank==1){
			
			switch(hero){
			case 0: g.drawImage(cc, 58,48,this);			 				
				break;
			case 1: g.drawImage(ys, 58,48,this);			 				
			break;
			case 2: g.drawImage(sq, 58,48,this);			 				
			break;
			case 3: g.drawImage(lb, 58,48,this);			 				
			break;
			case 4: g.drawImage(zy, 58,48,this);			 				
			break;
			case 5: g.drawImage(mc, 58,48,this);			 				
			break;
			}
		}
		else if(rank==2){
			switch(hero){
			case 0: g.drawImage(cc, 216,48,this);			 				
				break;
			case 1: g.drawImage(ys, 216,48,this);			 				
			break;
			case 2: g.drawImage(sq, 216,48,this);			 				
			break;
			case 3: g.drawImage(lb, 216,48,this);			 				
			break;
			case 4: g.drawImage(zy, 216,48,this);			 				
			break;
			case 5: g.drawImage(mc, 216,48,this);			 				
			break;
			}
		}
		
		else if(rank==3){
			switch(hero){
			case 0: g.drawImage(cc, 374,48,this);			 				
				break;
			case 1: g.drawImage(ys, 374,48,this);			 				
			break;
			case 2: g.drawImage(sq, 374,48,this);			 				
			break;
			case 3: g.drawImage(lb, 374,48,this);			 				
			break;
			case 4: g.drawImage(zy, 374,48,this);			 				
			break;
			case 5: g.drawImage(mc, 374,48,this);			 				
			break;
			}
		}
		
	}
	
	//���ط�ŷ���
	public String retitle(int money ){
		String result="";
		if(money<=60){
			
			result="��ϰ����";
		}

		else if(money>60&&money<=80){
			
			result="�Խ���";
		}
else if(money>80&&money<=100){
			
			result="ƫ����";
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
	
	result="������";
}
else if(money>260){
	
	result="�󽫾�";
}
		return result;
		
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

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

}
