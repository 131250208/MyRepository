package src.org.game.test;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import src.org.game.frame.JPanel2p;
import src.org.game.frame.JPanelBuyPro;
import src.org.game.frame.JPanelCG;
import src.org.game.frame.JPanelCG.JPanelMCskill;
import src.org.game.frame.JPanelChooseHero;
import src.org.game.frame.JPanelChoosePass;
import src.org.game.frame.JPanelGuess;
import src.org.game.frame.JPanelRank;
import src.org.game.frame.JPanelRegister;
import src.org.game.frame.JPanelSetting;
import src.org.game.frame.JPanelWIN;
import src.org.game.frame.JPanelYXMS;
import src.org.game.frame.JPanelmoney;
import src.org.game.frame.JPanelteam;
import src.org.game.frame.MouseListenerXY;
import src.org.game.frame.Timetable;

public class TestJPanel {

	
	public TestJPanel(){
		
		//通用
//		JPanelCG j=new JPanelCG(0,0,null,null,null,null,0);
		JPanelBuyPro t=new JPanelBuyPro(null);
		
		JFrame jf=new JFrame();
		jf.setSize(t.getWidth()+20, t.getHeight()+50);
		jf.setLayout(null);
		jf.add(t);
		t.setBounds(0, 0, t.getWidth(), t.getHeight());
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 将窗体的关闭方式设置为默认关闭后程序结束
	t.setVisible(true);
	jf.repaint();
	jf.setVisible(true);
	
		//增加
	MouseListenerXY xy=new MouseListenerXY();
		t.addMouseListener(xy);
	
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJPanel test=new TestJPanel();
		               
	}

}
