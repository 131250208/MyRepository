package src.org.game.frame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelGuess extends JPanel {
//图片对象
	ImageIcon fp=new ImageIcon("src/image/frameAndButton/guess/diamond.png");
	ImageIcon heit=new ImageIcon("src/image/frameAndButton/guess/spade.png");
	ImageIcon mh=new ImageIcon("src/image/frameAndButton/guess/club.png");
	ImageIcon hongt=new ImageIcon("src/image/frameAndButton/guess/heart.png");
	ImageIcon backg=new ImageIcon("src/image/frameAndButton/guess/board.jpg");
	
	
	public JPanelGuess(ChessCG chess){
		
		//设置面板
		this.setSize(100, 100);
		this.setLayout(null);
		//加label
		JLabel jl1=new JLabel();
		JLabel jl2=new JLabel();
		JLabel jl3=new JLabel();
		JLabel jl4=new JLabel();
		JLabel bg=new JLabel();
		//加图片
		jl1.setIcon(fp);
		jl2.setIcon(heit);
		jl3.setIcon(mh);
		jl4.setIcon(hongt);
		bg.setIcon(backg);
		//位置
		jl1.setBounds(0, 0, 50, 50);
		jl2.setBounds(50, 0, 50, 50);
		jl3.setBounds(0, 50, 50, 50);
		jl4.setBounds(50, 50, 50, 50);
		bg.setBounds(0, 0, 100, 100);
		
		//加组件
	
		this.add(jl4,0);
		this.add(jl3,1);
		this.add(jl2,2);
		this.add(jl1,3);
		this.add(bg,4);
		//加监听
		MouseListenerGuess ml1=new MouseListenerGuess(chess,0,this,jl1);
		MouseListenerGuess ml2=new MouseListenerGuess(chess,1,this,jl2);
		MouseListenerGuess ml3=new MouseListenerGuess(chess,2,this,jl3);
		MouseListenerGuess ml4=new MouseListenerGuess(chess,3,this,jl4);
		
		jl1.addMouseListener(ml1);
		jl2.addMouseListener(ml2);
		jl3.addMouseListener(ml3);
		jl4.addMouseListener(ml4);
		
		
	}
}
