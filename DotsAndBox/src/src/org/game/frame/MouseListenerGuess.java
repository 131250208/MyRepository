package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerGuess implements MouseListener {
	//ͼƬ����
		ImageIcon fp=new ImageIcon("src/image/frameAndButton/guess/diamond.png");
		ImageIcon heit=new ImageIcon("src/image/frameAndButton/guess/spade.png");
		ImageIcon mh=new ImageIcon("src/image/frameAndButton/guess/club.png");
		ImageIcon hongt=new ImageIcon("src/image/frameAndButton/guess/heart.png");
		
		ImageIcon fp2=new ImageIcon("src/image/frameAndButton/guess/diamond2.png");
		ImageIcon heit2=new ImageIcon("src/image/frameAndButton/guess/spade2.png");
		ImageIcon mh2=new ImageIcon("src/image/frameAndButton/guess/club2.png");
		ImageIcon hongt2=new ImageIcon("src/image/frameAndButton/guess/heart2.png");
		
		int temp=(int) (Math.random()*3);//0123
	int Guess;
	ChessCG Chess;
	JPanel GUESS;
	JLabel JL;
	public MouseListenerGuess(ChessCG chess,
			int guess,//jl��� Ҳ�ǲµ�����
			JPanel G,
			JLabel jl
			
			){
	
		Guess=guess;
		Chess=chess;
		GUESS=G;
		JL=jl;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
//         GUESS.setVisible(false);
         
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		  //System.out.println(temp);
		 if(Guess!=temp){//���û����,������Ļغ�
       	  Chess.get=0;
       	  Chess.HIT=true;
       	  Chess.isMine=false;
       	  //System.out.println("���� û����");
         }
		 else{
			 //System.out.println("�Բ� ������");
		 }
		 GUESS.setVisible(false);
		 //��������
		 Chess.isOver=false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		switch(Guess){
		case 0:
				JL.setIcon(fp2);
				break;
		case 1:
				JL.setIcon(heit2);
				break;
		case 2:
				JL.setIcon(mh2);
				break;
		case 3:
				JL.setIcon(hongt2);
				break;
		}	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//��ͼƬ
		switch(Guess){
		case 0:
				JL.setIcon(fp);
				break;
		case 1:
				JL.setIcon(heit);
				break;
		case 2:
				JL.setIcon(mh);
				break;
		case 3:
				JL.setIcon(hongt);
				break;
		}	
		}

}
