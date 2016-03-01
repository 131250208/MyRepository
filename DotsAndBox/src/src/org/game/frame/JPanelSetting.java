package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelSetting extends JPanel  implements MouseListener{
	//控制visible
	boolean visible=false;
	
	//图片对象
		ImageIcon board=new ImageIcon("src/image/frameAndButton/Setting/board-original.png");
		ImageIcon style1=new ImageIcon("src/image/frameAndButton/Setting/111.png");
		ImageIcon style11=new ImageIcon("src/image/frameAndButton/Setting/11.png");
		ImageIcon style2=new ImageIcon("src/image/frameAndButton/Setting/222.png");
		ImageIcon style22=new ImageIcon("src/image/frameAndButton/Setting/22.png");
		ImageIcon style3=new ImageIcon("src/image/frameAndButton/Setting/333.png");
		ImageIcon style33=new ImageIcon("src/image/frameAndButton/Setting/33.png");
		ImageIcon style4=new ImageIcon("src/image/frameAndButton/Setting/444.png");
		ImageIcon style44=new ImageIcon("src/image/frameAndButton/Setting/44.png");
		ImageIcon close0=new ImageIcon("src/image/frameAndButton/Setting/close2.png");
		ImageIcon close11=new ImageIcon("src/image/frameAndButton/Setting/close1.png");
		ImageIcon open0=new ImageIcon("src/image/frameAndButton/Setting/open2.png");
		ImageIcon open11=new ImageIcon("src/image/frameAndButton/Setting/open1.png");
		
		ImageIcon easy0=new ImageIcon("src/image/frameAndButton/Setting/easy2.png");
		ImageIcon easy1=new ImageIcon("src/image/frameAndButton/Setting/easy1.png");
		ImageIcon mid0=new ImageIcon("src/image/frameAndButton/Setting/mid2.png");
		ImageIcon mid1=new ImageIcon("src/image/frameAndButton/Setting/mid1.png");
		ImageIcon difficult0=new ImageIcon("src/image/frameAndButton/Setting/difficult2.png");
		ImageIcon difficult1=new ImageIcon("src/image/frameAndButton/Setting/difficult1.png");
	
		ImageIcon yz1=new ImageIcon("src/image/frameAndButton/Setting/yz1.png");
		ImageIcon yz2=new ImageIcon("src/image/frameAndButton/Setting/yz2.png");
		ImageIcon yz3=new ImageIcon("src/image/frameAndButton/Setting/yz3.png");
		ImageIcon yz4=new ImageIcon("src/image/frameAndButton/Setting/yz4.png");
		
		//各选项的值
		 int Music=new GetSetting().Music,Sound=new GetSetting().Sound,Level=new GetSetting().Level,Style=new GetSetting().Style;
		
public JPanelSetting(){
	//设置面板的大小加上背景图片
	this.setSize(368, 480);
	this.setLayout(null);
	JLabel bg=new JLabel();
	bg.setIcon(board);
	bg.setBounds(0, 0, 368, 480);
	
	
	//各个按钮
	JLabel open1=new JLabel();
	JLabel open2=new JLabel();
	JLabel close1=new JLabel();
	JLabel close2=new JLabel();
	
	JLabel easy=new JLabel();
	JLabel mid=new JLabel();
	JLabel difficult=new JLabel();
	JLabel one=new JLabel();
	JLabel two=new JLabel();
	JLabel three=new JLabel();
	JLabel four=new JLabel();
	
	JLabel yz=new JLabel();
	
	//保存并关闭
	JLabel over=new JLabel();
	
//  加监控
  MouseListenerSetting ml5=new MouseListenerSetting(open1,null,close1,null,null,5,1,this);
  open1.addMouseListener(ml5);
  MouseListenerSetting ml6=new MouseListenerSetting(close1,null,open1,null,null,6,1,this);
  close1.addMouseListener(ml6);
  
  MouseListenerSetting ml55=new MouseListenerSetting(open2,null,close2,null,null,5,2,this);
  open2.addMouseListener(ml55);
  MouseListenerSetting ml66=new MouseListenerSetting(close2,null,open2,null,null,6,2,this);
  close2.addMouseListener(ml66);
  
  MouseListenerSetting ml7=new MouseListenerSetting(easy,null,mid,difficult,null,7,0,this);
  easy.addMouseListener(ml7);
  MouseListenerSetting ml8=new MouseListenerSetting(mid,null,easy,difficult,null,8,0,this);
  mid.addMouseListener(ml8);
  MouseListenerSetting ml9=new MouseListenerSetting(difficult,null,easy,mid,null,9,0,this);
  difficult.addMouseListener(ml9);
  
  
  //传递ML
  ml5.pass(ml6, null, null);
  ml6.pass(ml5, null, null);
  ml55.pass(ml66, null, null);
  ml66.pass(ml55, null, null);
  
  ml7.pass(ml8, ml9, null);
  ml8.pass(ml7, ml9, null);
  ml9.pass(ml7, ml8, null);

  MouseListenerSetting ml1=new MouseListenerSetting(one,yz,two,three,four,1,0,this);
  one.addMouseListener(ml1);
  MouseListenerSetting ml2=new MouseListenerSetting(two,yz,one,three,four,2,0,this);
  two.addMouseListener(ml2);
  MouseListenerSetting ml3=new MouseListenerSetting(three,yz,one,two,four,3,0,this);
  three.addMouseListener(ml3);
  MouseListenerSetting ml4=new MouseListenerSetting(four,yz,one,two,three,4,0,this);
  four.addMouseListener(ml4);
  //传递ML
  ml1.pass(ml2, ml3, ml4);
  ml2.pass(ml1, ml3, ml4);
  ml3.pass(ml1, ml2, ml4);
  ml4.pass(ml1, ml2, ml3);
  
	//各个按钮加上初始图片
	if(new GetSetting().Music==1){
	open1.setIcon(open11);
	 close1.setIcon(close0);
	 ml5.Button=-1;
	}
	else{
		open1.setIcon(open0);
		 close1.setIcon(close11);
		 ml6.Button=-1;
	}
	if(new GetSetting().Sound==1){
	open2.setIcon(open11);
	  close2.setIcon(close0);
	  ml55.Button=-1;
	}
	else{
		open2.setIcon(open0);
		  close2.setIcon(close11);
		  ml66.Button=-1;
	}
	if(new GetSetting().Level==1){
    easy.setIcon(easy1);
    mid.setIcon(mid0);
    difficult.setIcon(difficult0);
    ml7.Button=-1;
	}
	else if(new GetSetting().Level==2){
		 easy.setIcon(easy0);
		    mid.setIcon(mid1);
		    difficult.setIcon(difficult0);
		    ml8.Button=-1;
	}
	else if(new GetSetting().Level==3){
		easy.setIcon(easy0);
	    mid.setIcon(mid0);
	    difficult.setIcon(difficult1);
	    ml9.Button=-1;
	}
	switch(new GetSetting().Style){
	case 1:
    one.setIcon(style11);
    two.setIcon(style2);
    three.setIcon(style3);
    four.setIcon(style4);
    yz.setIcon(yz1);
    ml1.Button=-1;
   
    break;
	case 2:
	    one.setIcon(style1);
	    two.setIcon(style22);
	    three.setIcon(style3);
	    four.setIcon(style4);
	    yz.setIcon(yz2);
	    ml2.Button=-1;
	    break;
	case 3:
	    one.setIcon(style1);
	    two.setIcon(style2);
	    three.setIcon(style33);
	    four.setIcon(style4);
	    yz.setIcon(yz3);
	    ml3.Button=-1;
	    break;
	case 4:
	    one.setIcon(style1);
	    two.setIcon(style2);
	    three.setIcon(style3);
	    four.setIcon(style44);
	    yz.setIcon(yz4);
	    ml4.Button=-1;
	    break;
	}
    
    //加上按钮并设置位置
    this.add(open1,0);
    open1.setBounds(71, 106, open0.getIconWidth(), open0.getIconHeight());;
    this.add(close1,1);
    close1.setBounds(206, 106, close0.getIconWidth(), close0.getIconHeight());;
    this.add(open2,2);
    open2.setBounds(71, 186, open0.getIconWidth(), open0.getIconHeight());;
    this.add(close2,3);
    close2.setBounds(206, 186, close0.getIconWidth(), close0.getIconHeight());;
    
    this.add(easy,4);
    easy.setBounds(71, 261, easy0.getIconWidth(), easy0.getIconHeight());;
    this.add(mid,5);
    mid.setBounds(151, 261, mid0.getIconWidth(), mid0.getIconHeight());;
    this.add(difficult,6);
    difficult.setBounds(231, 261, difficult0.getIconWidth(), difficult0.getIconHeight());;
	
    this.add(one,7);
    one.setBounds(71, 341, style1.getIconWidth(), style1.getIconHeight());;
    this.add(two,8);
    two.setBounds(136, 341, style2.getIconWidth(), style2.getIconHeight());;
    this.add(three,9);
    three.setBounds(71, 376, style3.getIconWidth(), style3.getIconHeight());;
    this.add(four,10);
    four.setBounds(136, 376, style4.getIconWidth(), style4.getIconHeight());;
	
    this.add(yz,11);
    yz.setBounds(220, 338, 80, 80);
    
    this.add(over,12);
    over.setBounds(336, 2, 27, 20);
    over.addMouseListener(this);
    
	//加背景
    this.add(bg,13);
    

    
    
    //给面板加坐标监控
    MouseListenerXY xy=new    MouseListenerXY();
    bg.addMouseListener(xy);
    
}


@Override
public void mouseClicked(MouseEvent e) {
	// TODO 自动生成的方法存根
	
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO 自动生成的方法存根
	visible=false;
	this.setVisible(false);
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
