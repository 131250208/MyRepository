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
	JPanel CTP,ZYP;//����
	int Pass;
	public ImageRun(JPanel JP,int x,int y,int  w,int h,int compNum,int pass,JPanel ctp,JPanel zyp){//Ҫ�Ѷ��������ĸ�JFrame����������꣬�����Ŀ�͸ߣ������ڵڼ���
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
	
	public void getImageArray(ImageIcon[] ImageIcon){//��ȡ��������ķ���
		 img=ImageIcon;
	}
	public void isLoop(boolean j){//�����Ƿ�ѭ���ķ���
		loop=j;
	}
	public void setseconds(int s){
		seconds=s;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
			for(int i=0;i<img.length;i++){
		       jl.setIcon(img[i]);
		 
		       try {
				Thread.sleep(seconds);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				
			}
		       
		       
			}
			if(loop==false){
				for(int i=0;i<img.length;i++){
				    
				       img[i]=null;
				    						
					}
		      InputImage.sellectimg();
		      
		      if(Pass!=0){
		    	//����ؿ�
			      try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
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
		// TODO �Զ����ɵķ������
		// ȡ����Ļ�Ŀ��
				int width = Toolkit.getDefaultToolkit().getScreenSize().width;
				// ȡ����Ļ�ĸ߶�
				int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//				InputImage input1=new InputImage("donghua1",5,"png");
//				ImageIcon[] IMG_CLEARLIST_LABEL=input1.reImages();
		//ImageIcon[] IMG_CLEARLIST_LABEL=new ImageIcon[]{new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg1.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg2.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg3.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg4.png"),new ImageIcon("D:\\workplace\\Dotsandboxes\\src\\image\\\u80CC\u666F\\bg5.png")};
		JFrame jf1=new JFrame();
		// ���ô����С
		jf1.setSize(893, 620);
		//�����ޱ߿�
		jf1.setUndecorated(true);
		// ���ô������λ��
		
		jf1.setLocation((width - 893) / 2, (height - 620) / 2);
		// ������Ĺرշ�ʽ����ΪĬ�Ϲرպ�������
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setLayout(null);
		JPanel jp1=new JPanel();
		jf1.add(jp1);
		jp1.setBounds(0, 0, 893, 620);
		//���붯��!!!!!!!!!!!!!!!!!!!!!!!!
//		BofangDonghua bd=new BofangDonghua(jp1,0,0,768,576,100,"loginBackGround",125,"jpg",false);
		BofangDonghua bd1=new BofangDonghua(null,jp1,0,0,893,620,100,"donghua5",113,"jpg",false,0,0);
		bd1.vediostart();
//		ImageRun it=new ImageRun(jf1,0,0,893,620,1000);
//		it.getImageArray(IMG_CLEARLIST_LABEL);//��ȡ������������
//		it.isLoop(false);
//		//�����߳�
//		Thread t=new Thread(it);
//		t.start();
		//��ʾ����
		jf1.setVisible(true);
	}

}
