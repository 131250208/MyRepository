package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerWG implements MouseListener {//外挂

	ChessCG C;
	int[][] HB,SB,BOX;
	
	public MouseListenerWG(ChessCG chess){
		C=chess;
		HB=chess.hb;
		SB=chess.sb;
		BOX=chess.box;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		for(int m=0;m<=5;m++){
			for(int n=0;n<=4;n++){
				HB[m][n]=1;
			}
		}
		for(int m=0;m<=5;m++){
			for(int n=0;n<=4;n++){
				SB[m][n]=1;
			}
		}
//		//检查是否有box
//		 for(int o=0;o<=4;o++){
//			 for(int p=0;p<=4;p++){
//				 if(HB[o][p]!=0&&HB[o+1][p]!=0&&SB[p][o]!=0&&SB[p+1][o]!=0){
//					 
//					 BOX[o][p]=1;
//					
//				
//									 
//					 				 }
//				
//					 
//					 
//				 }
//			 }
			
//		C.repaint();	 
			 
		 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		//System.out.println(new GetSetting().Music+";"+new GetSetting().Sound+";"+new GetSetting().Level+";"+new GetSetting().Style);
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
