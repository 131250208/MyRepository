package src.org.game.frame;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageRun implements Runnable {

	ImageIcon[] img=null;
	JLabel jl=new JLabel();
	boolean loop=true;
	static boolean haveJump=false;
	int seconds;
	JPanel CTP,ZYP;//引用
	int Pass;
	public ImageRun(JPanel JP,int x,int y,int  w,int h,int compNum,int pass,JPanel ctp,JPanel zyp){//要把动画加入哪个JFrame，加入的坐标，动画的宽和高，安排在第几层
	Pass =pass;
	CTP=ctp;
	ZYP=zyp;
		
	haveJump=false;
	
		jl.setSize(w, h);
		
		JP.setLayout(null);
		JP.add(jl,compNum);
	
		jl.setBounds(x, y, w, h);
//		jl.setIcon(IMG_CLEARLIST_LABEL[0]);
		
		
	}
	
	public void getImageArray(ImageIcon[] ImageIcon){//获取动画数组的方法
		 img=ImageIcon;
	}
	public void isLoop(boolean j){//设置是否循环的方法
		loop=j;
	}
	public void setseconds(int s){
		seconds=s;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			for(int i=0;i<img.length;i++){
		       jl.setIcon(img[i]);
		 
		       try {
				Thread.sleep(seconds);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}
		       
		       
			}
			if(loop==false){
				for(int i=0;i<img.length;i++){
				    
				       img[i]=null;
				    						
					}
		      InputImage.sellectimg();
		      
		      if(Pass!=0){
		    	//加入关卡
			      try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						
					}
			      if(haveJump==false){
			    	  //System.out.println("??");
//		      JPanelCG CG=new JPanelCG(0,Pass,CTP,ZYP,1);
			      }
		      }
		      
				

				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// 取得屏幕的宽度
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				// 取得屏幕的高度
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//				InputImage input1=new InputImage("donghua1",5,"png");
//				ImageIcon[] IMG_CLEARLIST_LABEL=input1.reImages();
		//ImageIcon[] IMG_CLEARLIST_LABEL=new ImageIcon[]{new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg1.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg2.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg3.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg4.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg5.png")};
		JFrame jf1=new JFrame();
		// 设置窗体大小
		jf1.setSize(893, 620);
		//设置无边框
		jf1.setUndecorated(true);
		// 设置窗体出现位置
		
		jf1.setLocation((width - 893) / 2, (height - 620) / 2);
		// 将窗体的关闭方式设置为默认关闭后程序结束
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setLayout(null);
		JPanel jp1=new JPanel();
		jf1.add(jp1);
		jp1.setBounds(0, 0, 893, 620);
		//加入动画!!!!!!!!!!!!!!!!!!!!!!!!
//		BofangDonghua bd=new BofangDonghua(jp1,0,0,768,576,100,"loginBackGround",125,"jpg",false);
		BofangDonghua bd1=new BofangDonghua(null,jp1,0,0,893,620,100,"donghua5",113,"jpg",false,0,0);
		bd1.vediostart();
//		ImageRun it=new ImageRun(jf1,0,0,893,620,1000);
//		it.getImageArray(IMG_CLEARLIST_LABEL);//获取动画对象数组
//		it.isLoop(false);
//		//启动线程
//		Thread t=new Thread(it);
//		t.start();
		//显示窗口
		jf1.setVisible(true);
	}

}
