package src.org.game.frame;




import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessCG extends Chess1 implements MouseListener {
     int boxnum=0,wuyong1;
    int achieve1=0;
 	int stepnum1=0;
 	int achieve2=0;
 	int get;
 	int voiceOfLvb=0;
 	int change=0;
 	//�����Ȩ�Ƿ����˼���
 	boolean haveUseSunQuan=false;
 	boolean jumpout=false;
 	//����Ƿ��õ��ߴ��
 	boolean InterruptOfPro=false;
 	//��ǵ�����û�еõ�Ӫկ
 	static int a=0;
 	//��ǵ����Ƿ����˼���
 	int b1=0,b2=0,b3=0,b4=0,b5=0,b6=0,b7=0,b8=0,b9=0,b10=0,b88=0;
 	//����ԭ����
 	int[][] ysb=new int[6][5];
  	int[][] yhb=new int[6][5];
 	int[][] ybox=new int[5][5];

// 	static boolean isMyturn=true;
 	//Ӫկ��
 	JLabel yzk1;
	JLabel yzk2;
	
	JPanelCG bf2;
	JPanel zyp2;
	

	//��褼��ܵ������ж�
	int zyjnld;
//�ж��Ƿ���������	
	  int tempOfMc;
	  int Mc=0;
	//��ȡ����
	GetSetting Gets=new GetSetting();
	static int Pronum=0;
	static boolean isMC=false;
	static int machaoskill=0;
	
	//ͼƬ
	ImageIcon p1=new ImageIcon("src/image/frameAndButton/prompt/p1.png");
	ImageIcon npc=new ImageIcon("src/image/frameAndButton/prompt/npc.png");
	ImageIcon nox=new ImageIcon("src/image/frameAndButton/prompt/x.png");
	ImageIcon noy=new ImageIcon("src/image/frameAndButton/prompt/y.png");
	
 	//�������߳�
 	Thread t=new Thread(new computer());
	public ChessCG(JLabel jl1,JLabel jl2,//Ҫ�ı�Ӫկ��Ŀ������lb
			JPanelCG bf1,//֮ǰ��������̵�jp
			JPanel zyp1//������Ҫjp
			){
		Pronum=0;
		isMC=false;
		machaoskill=0;
		a=0;
		//���ݲ���
				bf2=bf1;
				zyp2=zyp1;
		//�ı�Ӫկ
		try {
			switch(new GetDataOfPlayer(new GetNowPlayer().now).Pass){//ͨ���ؿ���Ϣ�����øı�з�Ӫկ
			case 1:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 2:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/4.png"));			
									break;
				}
			break;
			case 3:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/4.png"));			
									break;
				}
			break;
			case 4:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/4.png"));			
									break;
				}
			break;
			case 5:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 6:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 7:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 8:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 9:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 11:
				switch(new GetSetting().Style){
								case 1:								
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			}
			
			switch(bf2.Hero){//����Ӣ����Ϣ�ĺ����ñ��Լ�Ӫկ
			case 0:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/4.png"));			
									break;
				}
			break;
			case 1:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 2:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 3:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 4:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 5:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			case 10:
				switch(new GetSetting().Style){
								case 1:								
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));								
									break;
								case 2:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));			
									break;
								case 3:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));			
									break;
								case 4:			
									yz1=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));			
									break;
				}
			break;
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		get=0;
		

				 yzk1=jl1;
				 yzk2=jl2;
				//�ı�Ӫկ��
				switch(mpoints){
				case 0:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\0.png"));
				break;
				case 1:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\1.png"));
				break;
				case 2:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\2.png"));
				break;
				case 3:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\3.png"));
				break;
				case 4:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\4.png"));
				break;
				case 5:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\5.png"));
				break;
				case 6:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\6.png"));
				break;
				case 7:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\7.png"));
				break;
				case 8:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\8.png"));
				break;
				case 9:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\9.png"));
				break;
				case 10:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\10.png"));
				break;
				case 11:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\11.png"));
				break;
				case 12:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\12.png"));
				break;
				case 13:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\13.png"));
				break;
				case 14:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\14.png"));
				break;
				case 15:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\15.png"));
				break;
				case 16:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\16.png"));
				break;
				case 17:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\17.png"));
				break;
				case 18:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\18.png"));
				break;
				case 19:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\19.png"));
				break;
				case 20:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\20.png"));
				break;
				case 21:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\21.png"));
				break;
				case 22:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\22.png"));
				break;
				case 23:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\23.png"));
				break;
				case 24:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\24.png"));
				break;
				case 25:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\25.png"));
				break;
				}
				switch(epoints){
				case 0:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\0.png"));
				break;
				case 1:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\1.png"));
				break;
				case 2:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\2.png"));
				break;
				case 3:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\3.png"));
				break;
				case 4:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\4.png"));
				break;
				case 5:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\5.png"));
				break;
				case 6:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\6.png"));
				break;
				case 7:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\7.png"));
				break;
				case 8:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\8.png"));
				break;
				case 9:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\9.png"));
				break;
				case 10:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\10.png"));
				break;
				case 11:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\11.png"));
				break;
				case 12:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\12.png"));
				break;
				case 13:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\13.png"));
				break;
				case 14:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\14.png"));
				break;
				case 15:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\15.png"));
				break;
				case 16:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\16.png"));
				break;
				case 17:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\17.png"));
				break;
				case 18:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\18.png"));
				break;
				case 19:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\19.png"));
				break;
				case 20:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\20.png"));
				break;
				case 21:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\21.png"));
				break;
				case 22:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\22.png"));
				break;
				case 23:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\23.png"));
				break;
				case 24:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\24.png"));
				break;
				case 25:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\25.png"));
				break;
				
				}
		t.start();		
	}
	
	public void changeimage(JLabel jl1,JLabel jl2){
		//�ı�Ӫկ��
		switch(mpoints){
		case 0:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\0.png"));
		break;
		case 1:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\1.png"));
		break;
		case 2:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\2.png"));
		break;
		case 3:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\3.png"));
		break;
		case 4:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\4.png"));
		break;
		case 5:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\5.png"));
		break;
		case 6:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\6.png"));
		break;
		case 7:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\7.png"));
		break;
		case 8:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\8.png"));
		break;
		case 9:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\9.png"));
		break;
		case 10:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\10.png"));
		break;
		case 11:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\11.png"));
		break;
		case 12:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\12.png"));
		break;
		case 13:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\13.png"));
		break;
		case 14:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\14.png"));
		break;
		case 15:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\15.png"));
		break;
		case 16:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\16.png"));
		break;
		case 17:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\17.png"));
		break;
		case 18:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\18.png"));
		break;
		case 19:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\19.png"));
		break;
		case 20:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\20.png"));
		break;
		case 21:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\21.png"));
		break;
		case 22:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\22.png"));
		break;
		case 23:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\23.png"));
		break;
		case 24:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\24.png"));
		break;
		case 25:jl1.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\25.png"));
		break;
		}
		switch(epoints){
		case 0:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\0.png"));
		break;
		case 1:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\1.png"));
		break;
		case 2:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\2.png"));
		break;
		case 3:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\3.png"));
		break;
		case 4:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\4.png"));
		break;
		case 5:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\5.png"));
		break;
		case 6:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\6.png"));
		break;
		case 7:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\7.png"));
		break;
		case 8:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\8.png"));
		break;
		case 9:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\9.png"));
		break;
		case 10:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\10.png"));
		break;
		case 11:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\11.png"));
		break;
		case 12:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\12.png"));
		break;
		case 13:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\13.png"));
		break;
		case 14:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\14.png"));
		break;
		case 15:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\15.png"));
		break;
		case 16:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\16.png"));
		break;
		case 17:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\17.png"));
		break;
		case 18:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\18.png"));
		break;
		case 19:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\19.png"));
		break;
		case 20:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\20.png"));
		break;
		case 21:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\21.png"));
		break;
		case 22:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\22.png"));
		break;
		case 23:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\23.png"));
		break;
		case 24:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\24.png"));
		break;
		case 25:jl2.setIcon(new ImageIcon("src/image\\frameAndButton\\yzl\\25.png"));
		break;
		
		
		}
	}
	
	public String renameOfLook(int numOfHero,int distance){
		String s1="",s2="",result="";
		switch(numOfHero){
		case 0:s1="cc";
			break;
		case 1:s1="ys";
			break;
		case 2:s1="sq";
		
			break;
		case 3:s1="lb";
			break;
		case 4:s1="zy";
			break;
		case 5:s1="mc";
			break;
			
		}
		if(distance>=-25&&distance<-10){
			s2="1";
		}
		else if(distance>=-10&&distance<-5){
			s2="2";
		}


		else if(distance>=-5&&distance<0){
			s2="3";
		}

		else if(distance>=0&&distance<5){
			s2="4";
		}

		else if(distance>=5&&distance<10){
	

			s2="5";
		}
		else if(distance>=10&&distance<=25){
			s2="6";

		}
		result="src/image/frameAndButton/expression/"+s1+s2+".jpg";
		
		return result;
		
	}
	public void changeLook(){
		if(bf2.PASS<=5){
		int D1=mpoints-epoints;
		 int D2=epoints-mpoints;
		 String addOfP1=renameOfLook(bf2.Hero,D1);
		 String addOfP2=renameOfLook(bf2.PASS,D2);
		 bf2.face1.setIcon(new ImageIcon(addOfP1));
		 bf2.face2.setIcon(new ImageIcon(addOfP2));
		}
	}
	
	public void JudgeAchieve4(){
		boolean result=false;
		int D=mpoints-epoints;
		if(D>=15){
			result=true;
		}
	
		if(result){
			new GetDataOfPlayer(new GetNowPlayer().now).change(8, 1);
		}
		
	}
	
	public void functionOfDEL(int num){//1�Ǽ���2�ǵ���
		if(JPanelCG.bcisMYturn==false){//����ü���ʱ�����Լ��غ�
			//ɨ������
			 for(int k=0;k<=4;k++){
					for(int g=0;g<=4;g++){ 
				 
				        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(y-80*g)-35>=0){
					    
					     
					     if( hb[g][k]!=0){
					    	 
					     			   DEL=true;  
					     			 
					     					//��Ч
					     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
					     					del.play();
					     	 			
					     				
					          hb[g][k]=0;
					          Timetable.lefttime=180;    
					            
									  
					     }
						 
				      }
					}
				
				 }
				 //�������2
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					      if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(y-80*g)-115<=0){
					    	  
					      
						    if(hb[g+1][k]!=0){
						    	 
						    	 DEL=true;  
						    	//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
						         hb[g+1][k]=0;
						         Timetable.lefttime=180;
						    }
					      }
						}
					
					 }
				 //�������3
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					       if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(x-80*k)-35>=0){
						    if(sb[k][g]!=0){
						    	
						    	 DEL=true;  
						    	//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
						    	 sb[k][g]=0;
						         Timetable.lefttime=180;
						    }
					      }
						}
						 
					 }
				 //�������4
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(x-80*k)-115<=0){
						     if(sb[k+1][g]!=0){
						    	 
						    	 DEL=true;  
						    	//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
						    	 sb[k+1][g]=0;
						         Timetable.lefttime=180;
						      
						    }
					      }
						}
					
					 }
				 
				 //����Ƿ��б�ɾ����box
				 for(int o=0;o<=4;o++){
					 for(int p=0;p<=4;p++){
						 if(hb[o][p]==0||hb[o+1][p]==0||sb[p][o]==0||sb[p+1][o]==0){
							 if(box[o][p]!=0){
							 box[o][p]=0;
																		 
							 				 }
						
							 
							 
						 }
					 }
					 
				 }//ɾ�߼���
				 if(DEL==true){//����ɹ�ɾ��
					 DEL=false;
					 this.repaint();
					 if(num==1){		
						 JPanelCG.useSkill=false;				 				 							 
							 JPanelCG.haveusedSkill=true;
				 			}
					 else{
						Pronum=0;
						 new GetDataOfPlayer(new GetNowPlayer().now).change(3, 0);
					 }
					 //�����Լ��غ��ü��� ֻ�ܼ���������öԷ���
			 
					 get=0;
					 HIT=true;
					 isMine=false;
			 
				 }
				 
				 
		 }
		 else if(JPanelCG.bcisMYturn==true){//����ü���ʱ���Լ��غ�
			 
			 //ɨ������
			 for(int k=0;k<=4;k++){
					for(int g=0;g<=4;g++){ 
				 
				        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(y-80*g)-35>=0){
					    
					     
					     if( hb[g][k]!=0){
					    	 
					     			   DEL=true; 
					     			//��Ч
				     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
				     					del.play();
					          hb[g][k]=0;
					          Timetable.lefttime=180;    
					            
									  
					     }
						 
				      }
					}
				
				 }
				 //�������2
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					      if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(y-80*g)-115<=0){
					    	  
					      
						    if(hb[g+1][k]!=0){
						    	 
						    	//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
						    	 DEL=true;  
						         hb[g+1][k]=0;
						         Timetable.lefttime=180;
						    }
					      }
						}
					
					 }
				 //�������3
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					       if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(x-80*k)-35>=0){
						    if(sb[k][g]!=0){
						    	
						    	 DEL=true;  
						    	//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
						    	 sb[k][g]=0;
						         Timetable.lefttime=180;
						    }
					      }
						}
						 
					 }
				 //�������4
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(x-80*k)-115<=0){
						     if(sb[k+1][g]!=0){
						    	 
						    	 DEL=true;  
						    	//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
						    	 sb[k+1][g]=0;
						         Timetable.lefttime=180;
						      
						    }
					      }
						}
					
					 }
				 
				 //����Ƿ��б�ɾ����box
				 for(int o=0;o<=4;o++){
					 for(int p=0;p<=4;p++){
						 if(hb[o][p]==0||hb[o+1][p]==0||sb[p][o]==0||sb[p+1][o]==0){
							 if(box[o][p]!=0){
							 box[o][p]=0;
																		 
							 				 }
						
							 
							 
						 }
					 }
					 
				 }//ɾ�߼���
				 if(DEL==true){//����ɹ�ɾ��
				  
					 DEL=false;
			
					 this.repaint();
			 			if(num==1){		
					 JPanelCG.useSkill=false;				 				 							 
						 JPanelCG.haveusedSkill=true;
			 			}
			 			else{
							Pronum=0;
							 new GetDataOfPlayer(new GetNowPlayer().now).change(3, 0);
						 }
				 }
		 }
	}
	
	public void fuctionOfChange(int num){//1�Ǽ���2�ǵ���
		//ɨ������
		 for(int k=0;k<=4;k++){
				for(int g=0;g<=4;g++){ 
			 
			        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(y-80*g)-35>=0){
				    
				     
				     if( hb[g][k]!=0){
				    	 
				     			   DEL=true;  
				     			//��Ч
			     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
			     					del.play();
				          hb[g][k]=0;
				          Timetable.lefttime=180;    
				            
								  
				     }
					 
			      }
				}
			
			 }
			 //�������2
			 for(int k=0;k<=4;k++){
					for(int g=0;g<=4;g++){ 
				 
				      if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(y-80*g)-115<=0){
				    	  
				      
					    if(hb[g+1][k]!=0){
					    	 
					    	 DEL=true;  
					    	//��Ч
		     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
		     					del.play();
					         hb[g+1][k]=0;
					         Timetable.lefttime=180;
					    }
				      }
					}
				
				 }
			 //�������3
			 for(int k=0;k<=4;k++){
					for(int g=0;g<=4;g++){ 
				 
				       if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(x-80*k)-35>=0){
					    if(sb[k][g]!=0){
					    	
					    	 DEL=true;  
					    	//��Ч
		     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
		     					del.play();
					    	 sb[k][g]=0;
					         Timetable.lefttime=180;
					    }
				      }
					}
					 
				 }
			 //�������4
			 for(int k=0;k<=4;k++){
					for(int g=0;g<=4;g++){ 
				 
				        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(x-80*k)-115<=0){
					     if(sb[k+1][g]!=0){
					    	 
					    	 DEL=true;  
					    	//��Ч
		     					SetMusic del=new SetMusic("src/music/action/break.wav",false,2);
		     					del.play();
					    	 sb[k+1][g]=0;
					         Timetable.lefttime=180;
					      
					    }
				      }
					}
				
				 }
			 
			 //����Ƿ��б�ɾ����box
			 for(int o=0;o<=4;o++){
				 for(int p=0;p<=4;p++){
					 if(hb[o][p]==0||hb[o+1][p]==0||sb[p][o]==0||sb[p+1][o]==0){
						 if(box[o][p]!=0){
						 box[o][p]=0;
																	 
						 				 }
					
						 
						 
					 }
				 }
				 
			 }//ɾ�߼���
			 
			 if(DEL==true){//����ɹ�ɾ��
			
				 DEL=false;
				 this.repaint();			 
				 if(num==1){		
					 JPanelCG.useSkill=false;				 				 							 
						 JPanelCG.haveusedSkill=true;
			 			}
			 			else{
							Pronum=0;
							 new GetDataOfPlayer(new GetNowPlayer().now).change(4, 0);
						 }
				 zyjnld=1;//���ʹ�ü���δ����  ���������������

			 }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		x=e.getX();
		 y=e.getY();
		// //System.out.println("isOver="+isOver+";isMine="+isMine+";get="+get+";hit="+HIT);
		 
		 //�����ļ���
		 if(JPanelCG.useSkill==true&&bf2.Hero==3&&Pronum==0){
			 
			 //System.out.println("������������,DEL="+DEL);
			 functionOfDEL(1);
		 }
		 //��褼���
		 else if(JPanelCG.useSkill==true&&bf2.Hero==4&&Pronum==0){
			 //System.out.println("������褼���,DEL="+DEL);
			 
			 fuctionOfChange(1);
		 
		 }
		 else if(Pronum==2){
			 //System.out.println("�������2,DEL="+DEL);
			 functionOfDEL(2);
		 }

		 else if(Pronum==3){
			 //System.out.println("�������3,DEL="+DEL);
			 fuctionOfChange(2);
		 }
		 else if((!(JPanelCG.useSkill==true&&bf2.Hero==3))&&(!(JPanelCG.useSkill==true&&bf2.Hero==4))&&Pronum!=2&&Pronum!=3){//�������еĲ���
			
			 
			 //�ж���Ϸ�Ƿ���������������ٸı�����
		 
		 
		 if(isOver==false&&isMine==true){
			 //��λ����������
		 //�������1
			 //System.out.println("�ҵ������غ�"+"useskill="+JPanelCG.useSkill+"haveusedSkill="+JPanelCG.haveusedSkill+"bcisMYturn="+JPanelCG.bcisMYturn);
			 
		 for(int k=0;k<=4;k++){
			for(int g=0;g<=4;g++){ 
		 
		        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(y-80*g)-35>=0){
			     
			   
			     
			     if( hb[g][k]==0&&b5!=1){
			    	 
			    	 //����ԭ����
			    	 SaveBf();
			    	 get=0;
			    	 stepnum1++;
			    	//��Ч
						SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
						musicSword.play();
			     			     
			          hb[g][k]=1;
			          HIT=true;
			          
			        //�ָ��������ܷ�ӡǰ��
			 		 b5=0;
			          Timetable.lefttime=180;    
			            
							  
			     }
				 
		      }
			}
		
		 }
		 //�������2
		 for(int k=0;k<=4;k++){
				for(int g=0;g<=4;g++){ 
			 
			      if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(y-80*g)-115<=0){
				     
				   
				    if(hb[g+1][k]==0&&b5!=1){
				    	 //����ԭ����
				    	 SaveBf();
				    	 get=0;
				    	stepnum1++;
				    	//��Ч
						SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
						musicSword.play();
				         hb[g+1][k]=1;
				         HIT=true;
				         
				       //�ָ��������ܷ�ӡǰ��
						 b5=0;
				         Timetable.lefttime=180;
				    }
			      }
				}
			
			 }
		 //�������3
		 for(int k=0;k<=4;k++){
				for(int g=0;g<=4;g++){ 
			 
			       if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(x-80*k)-35>=0){
				     
				  
				    if(sb[k][g]==0&&b5!=2){
				    	 //����ԭ����
				    	 SaveBf();
				    	 get=0;
				    	 stepnum1++;
				    	//��Ч
							SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
							musicSword.play();
				    	 sb[k][g]=1;
				    	 HIT=true;
				         
				       //�ָ��������ܷ�ӡǰ��
						 b5=0;
				         Timetable.lefttime=180;
				    }
			      }
				}
				 
			 }
		 //�������4
		 for(int k=0;k<=4;k++){
				for(int g=0;g<=4;g++){ 
			 
			        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(x-80*k)-115<=0){
				     
				 
				     if(sb[k+1][g]==0&&b5!=2){
				    	 //����ԭ����
				    	 SaveBf();
				    	   get=0;
				    	  stepnum1++;
				    	//��Ч
							SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
							musicSword.play();
				    	 sb[k+1][g]=1;
				    	 HIT=true;
				         
				       //�ָ��������ܷ�ӡǰ��
						 b5=0;
				         Timetable.lefttime=180;
				      
				    }
			      }
				}
			
			 }
		 
		 //����Ƿ���box
		 int boxOfOneStep=0;
		 for(int o=0;o<=4;o++){
			 for(int p=0;p<=4;p++){
				 if(hb[o][p]!=0&&hb[o+1][p]!=0&&sb[p][o]!=0&&sb[p+1][o]!=0){
					 if(box[o][p]==0){
						 
						//��Ч
							SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
							musicGet.play();
					 box[o][p]=1;
					 get=1; 
					 boxOfOneStep++;
							achieve2++;//���������ۼ�		 
					 				 }
				
					 
					 
				 }
			 }
			
			 
			 
		 }
		 
		 if(boxOfOneStep==2){
			 achieve1++;
		 }
		 if(achieve1>=3){//һ��˫��ɾʹ��
			 new GetDataOfPlayer(new GetNowPlayer().now).change(5, 1);
		 }
		 //System.out.println(achieve2);
		 if(achieve2>=9){//����������
			 new GetDataOfPlayer(new GetNowPlayer().now).change(6, 1);
		 }
		 
		 int achieve3=0;
		 for(int i=0;i<=4;i++){
			 if(hb[0][i]==1&&hb[5][i]==1&&sb[0][i]==1&&sb[5][i]==1){
				 achieve3++;
			 }
				 
		 }
		 if(achieve3==5){//ʮ��Χ�Ǵ��
			 new GetDataOfPlayer(new GetNowPlayer().now).change(7, 1);
		 }
		 
		 //�ж��Ƿ����˼���(�ܲټ���
		 if(JPanelCG.useSkill==true&&bf2.Hero==0&&Pronum==0){
			 //System.out.println("����ܲټ���");
			 if(JPanelCG.bcisMYturn==false){
			
				 get=0;
				 JPanelCG.useSkill=false;
					 JPanelCG.haveusedSkill=true;
			 }
			 else if(JPanelCG.bcisMYturn==true){
				 
				 get=1;
				 JPanelCG.useSkill=false;
					 JPanelCG.haveusedSkill=true;
			 }
		 }
		 //�ж��Ƿ����˵���1
		 if(Pronum==1){
			 //System.out.println("�������1");
			 if(JPanelCG.bcisMYturn==false){
			
				 get=0;
				 Pronum=0;
				 new GetDataOfPlayer(new GetNowPlayer().now).change(2, 0);
			 }
			 else if(JPanelCG.bcisMYturn==true){
				 
				 get=1;
				 Pronum=0;
				 new GetDataOfPlayer(new GetNowPlayer().now).change(2, 0);
			 }
		 }
		 //����3 ��褵ļӱ�
		 
		 if(zyjnld==1){
			 if(JPanelCG.bcisMYturn==false){
			 get=0;
			 zyjnld=0;
			 }
			 else if(JPanelCG.bcisMYturn==true){
				 get=1;
				 zyjnld=0;
			 }
		 }


		// //System.out.println("stepnum="+stepnum1);

		 mpoints=0;
		 epoints=0;
		 for(i=0;i<=4;i++){
				for(j=0;j<=4;j++){
					if(box[i][j]==1){
						mpoints++;
					}
					else if(box[i][j]==2){
						epoints++;
					}
				}
		 }
		this.repaint();
		 changeimage(yzk1,yzk2);
		 changeLook();
		 
		 
		//ת���߶�Ȩ
		if(get==0&&HIT==true){
			isMine=false;
		}
		
		 }
       
		 
		 }//�������еĲ���
	}

	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//�������ж���Ӯ
				boxnum=0;
				for(int o=0;o<=4;o++){
					 for(int p=0;p<=4;p++){
						 if(box[o][p]!=0){
							 boxnum++;
							 
						 }
							 						 
					 }			 
				}	 
				//System.out.println("boxnum="+boxnum);
				if(boxnum==25){
					isOver=true;
					mpoints=0;
					epoints=0;
					for(i=0;i<=4;i++){
						for(j=0;j<=4;j++){
							if(box[i][j]==1){
								mpoints++;
							}
							else if(box[i][j]==2){
								epoints++;
							}
						}
					}
					
					JudgeAchieve4();//�ж��Ƿ��ɳɾ� ��ʿ��˫
					if(mpoints>epoints){
						if(bf2.PASS!=6||(bf2.PASS==6&&b6==1)){
							change=1;
						//��������ģʽ�еı���
						int pass=new GetDataOfPlayer(new GetNowPlayer().now).Pass;
						if(pass<=5&&pass>=1){
						new GetLock().deblocking(pass);
						}
						//System.out.println("firstplayer:secondplayer="+mpoints+":"+epoints);
						//��ʾ��Ӯ����
						jumpout=true;
						bf2.work=0;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						if(bf2.ms==1){
							
								JPanel judge=new JPanelWIN(1,zyp2,1,0,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
								
								zyp2.add(judge);
								//�ص�ս������
								bf2.musicFighting.stop();
								//��Ӯ����
								SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
								musicJudge.play();
								judge.setVisible(true);
								//�����̵�ʱ���ʱֹͣ
								bf2.timeStop();
								//����ԭ���̲��ɼ�
								bf2.setVisible(false);
					
							}
						else if(bf2.ms==2){
							JPanel judge=new JPanelWIN(1,zyp2,2,bf2.Hero,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
							
							zyp2.add(judge);
							//�ص�ս������
						bf2.musicFighting.stop();
							//��Ӯ����
							SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
							musicJudge.play();
							judge.setVisible(true);
							//�����̵�ʱ���ʱֹͣ
							bf2.timeStop();
							//����ԭ���̲��ɼ�
							bf2.setVisible(false);
							}
							else if(bf2.ms==0){
								JPanel judge=new JPanelWIN(1,zyp2,3,10,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
								
								zyp2.add(judge);
								//�ص�ս������
							bf2.musicFighting.stop();
								//��Ӯ����
								SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
								musicJudge.play();
								judge.setVisible(true);
								//�����̵�ʱ���ʱֹͣ
								bf2.timeStop();
								//����ԭ���̲��ɼ�
								bf2.setVisible(false);
							}
						}
						else if(bf2.PASS==6&&b6==0){
							SkillOfRWX();
							isOver=false;
						}
					}
					else if(mpoints<epoints){
						change=1;
						//System.out.println("firstplayer:secondplayer="+mpoints+":"+epoints);
						//��ʾ��Ӯ����
						jumpout=true;
						bf2.work=0;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						if(bf2.ms==1){
							JPanel judge=new JPanelWIN(2,zyp2,1,0,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
							
							zyp2.add(judge);
							//�ص�ս������
						bf2.musicFighting.stop();
							//��Ӯ����
							SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
							musicJudge.play();
							judge.setVisible(true);
							//�����̵�ʱ���ʱֹͣ
							bf2.timeStop();
							//����ԭ���̲��ɼ�
							bf2.setVisible(false);
							}
						else if(bf2.ms==2){
							JPanel judge=new JPanelWIN(2,zyp2,2,bf2.Hero,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
							
							zyp2.add(judge);
							//�ص�ս������
						bf2.musicFighting.stop();
							//��Ӯ����
							SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
							musicJudge.play();
							judge.setVisible(true);
							//�����̵�ʱ���ʱֹͣ
							bf2.timeStop();
							//����ԭ���̲��ɼ�
							bf2.setVisible(false);
							}
							else if(bf2.ms==0){
								JPanel judge=new JPanelWIN(2,zyp2,3,10,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
								
								zyp2.add(judge);
								//�ص�ս������
							bf2.musicFighting.stop();
								//��Ӯ����
								SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
								musicJudge.play();
								judge.setVisible(true);
								//�����̵�ʱ���ʱֹͣ
								bf2.timeStop();
								//����ԭ���̲��ɼ�
								bf2.setVisible(false);
							}
					}
					if(change==1){
					changeMoney();
					}
				}
				//System.out.println(get+";"+HIT+";"+isMine);
	}

	public void changeMoney(){
		//��������ֵ
		int money=new GetDataOfPlayer(new GetNowPlayer().now).Money;
		int Dis=mpoints-epoints;
		if(Dis<0){//��
		new GetDataOfPlayer(new GetNowPlayer().now).change(1, money+Dis); 
		}
		else if(Dis>=0){//Ӯ�мӳ�
			new GetDataOfPlayer(new GetNowPlayer().now).change(1, money+Dis+bf2.PASS*5+15); 
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}



	
public void timeover(int num){//1����P1ʤ 2����P2ʤ
		
		//��ʾ��Ӯ����
	jumpout=true;
	bf2.work=0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		JPanel judge=new JPanelWIN(num,zyp2,3,10,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
		
		zyp2.add(judge);
		//�ص�ս������
	
		bf2.musicFighting.stop();
		//��Ӯ����
		SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
		musicJudge.play();
		judge.setVisible(true);
		//�����̵�ʱ���ʱֹͣ
		bf2.timeStop();
		//����ԭ���̲��ɼ�
		bf2.setVisible(false);
	}


	public void SkillOfRWX(){
		 //��Ч
		SetMusic skillrwx=new SetMusic("src/music/skill/lrwx.wav",false,2);
		skillrwx.play();
	   //�����պ��
	   for(m=0;m<=5;m++){		       				
		   for(n=0;n<=4;n++){		       					
			   int temp=(int) (Math.random()*10);
				    
			   if(temp>=5){
					hb[m][n]=0;
				    
				    }
				    
		   }
	   }
	   //����������
	   for(m=0;m<=5;m++){		       				
		   for(n=0;n<=4;n++){		       					
			   int temp=(int) (Math.random()*10);
				    
			   if(temp>=5){
					sb[m][n]=0;
				    
				    }
				    
		   }
	   }
	   
	   //���box
	
		 for(int o=0;o<=4;o++){
			 for(int p=0;p<=4;p++){
				 if(hb[o][p]==0||hb[o+1][p]==0||sb[p][o]==0||sb[p+1][o]==0){
					 
				
					 box[o][p]=0;
				 }
			 }
			
			 
			 
		 }
		 this.repaint(); 

		 b6=1;
	}

	public class computer implements  Runnable{

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			while(jumpout==false){
				if(get==0&& HIT==true&&isMine==false){
					//System.out.println("���Իغ�");
					
					//��վ��������ۼ�
					achieve2=0;
					
					bf2.prom.setIcon(npc);//��ʾ���Իغ�
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					 //���õ��Լ���AI
					//��һ�غ͵���ؼ����ڽ�������
				
			           //��2�ؼ�����Ȩ
					AIsunquan computersk2=new AIsunquan();
			           if(b2==0&&new GetDataOfPlayer(new GetNowPlayer().now).Pass==2&&haveUseSunQuan==false){
			        	   //������Ȩ����AI�ж��Ƿ���
			        	   b2 = computersk2.returnArray(hb, sb, box, wuyong1, wuyong2); 
			        	   if(b2!=0){//��Ȩ��������
			        		 //��Ч
								SetMusic skillsq=new SetMusic("src/music/skill/sq.wav",false,2);
								skillsq.play();
								haveUseSunQuan=true;
			        		   //�����Ѿ���IF���������غ�
			        	   }
			           }
			           
			       	//�����ؼ�������
				         AIdelete computersk3=new AIdelete();
				         if(b3==0&&new GetDataOfPlayer(new GetNowPlayer().now).Pass==3){
				        	 //����ԭ����
					    	 SaveBf();
				        	 b3 = computersk3.returnArray(hb, sb, box, wuyong1, wuyong2);
				           if(b3!=0){
				        	 //��Ч
								SetMusic skilllb=new SetMusic("src/music/skill/lb.wav",false,2);
								skilllb.play();
				           }
				           ChessCG.this.repaint();
				           //����Ӫկ
				  		 mpoints=0;
						 epoints=0;
						 for(i=0;i<=4;i++){
								for(j=0;j<=4;j++){
									if(box[i][j]==1){
										mpoints++;
									}
									else if(box[i][j]==2){
										epoints++;
									}
								}
						 }
				           changeimage(yzk1,yzk2);
				         
				  		 changeLook();
				           
				         }  //��3�ؼ��ܽ���
				           
			           //���Ĺؼ���
			           if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==4&&b4==0){
			        	   AIchange computersk4=new AIchange();
			        	   //����ԭ����
					    	 SaveBf();
			        	   b4=computersk4.returnArray(hb, sb, box, wuyong1, wuyong2);
			        	   if(b4!=0){
			        		 //��Ч
								SetMusic skillzy=new SetMusic("src/music/skill/zy.wav",false,2);
								skillzy.play();
			        	   }
			        	   ChessCG.this.repaint();
				           //����Ӫկ
				  		 mpoints=0;
						 epoints=0;
						 for(i=0;i<=4;i++){
								for(j=0;j<=4;j++){
									if(box[i][j]==1){
										mpoints++;
									}
									else if(box[i][j]==2){
										epoints++;
									}
								}
						 }
				      changeimage(yzk1,yzk2);
				  		 changeLook();
			           }//���Ĺؼ��ܽ���
			           //����ؼ����ڻغϽ�������
			           //�����ؼ���
			           if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==6&&b6==0){
			        	   AIlrwxnew computersk6=new AIlrwxnew();
			        	   b6=computersk6.returnArray(hb, sb, box, isMine);
			        	   
			        	   if(b6==1){
			        		   SkillOfRWX();
			        	   }
			        		  
			           }
			           //���߹ؼ��� �ƻ���
			       
			           //�ڰ˹ؼ��� ������
			           //System.out.println(new GetDataOfPlayer(new GetNowPlayer().now).Pass==8&&b8==0);
			           if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==8&&b8==0){
			        	b88=0;//�ָ�
//			        	   double sjnum=Math.random();//�������
			        	   double sjnum1=Math.random();
			        	   int cbnum=0;
			        	   int sjnum2=(int)(Math.random()*5);//���ѡ��һ�л���һ��
			        	   
			        	   if(sjnum1>=0.7){//���ʹ�ü���
			        
			        		   
			        			//������һ��ռ���˶�����
//				        	   if(sjnum>=0.5){
				        		   for(i=0;i<=4;i++){
				        			   if(hb[sjnum2][i]!=0){
				        				   cbnum++;
				        			   }
				        		   }
				        		   
//				        	   }
//				        	   else if(sjnum<0.5){
//				        		   for(i=0;i<=4;i++){
//				        			   if(sb[sjnum2][i]!=0){
//				        				   cbnum++;
//				        			   }
//				        		   }
//				        	   }
							
				        	   if(cbnum!=5){//����������ľ�ʹ�ü���
				        		   SaveBf();
				        		   b88=1;//ʹ���˼���
				        		   //��Ч
									SetMusic skillwyl=new SetMusic("src/music/skill/wyl.wav",false,2);
									skillwyl.play();
									//��Ч
									new SetMusic("src/music/action/sword.wav",false,2).play();
									
//				        		   if(sjnum>=0.5){
					        		   for(i=0;i<=4;i++){
					        			   hb[sjnum2][i]=2;
					        		   }
//					        	   }
//					        	   else if(sjnum<0.5){
//					        		   for(i=0;i<=4;i++){
//					        			   sb[sjnum2][i]=2;
//					        		   }
//					        	   }
				        		   
				        		 //����Ƿ���box
						      		 for(int o=0;o<=4;o++){
						      			 for(int p=0;p<=4;p++){
						      				 if(hb[o][p]!=0&&hb[o+1][p]!=0&&sb[p][o]!=0&&sb[p+1][o]!=0){
						      					 if(box[o][p]==0){
						      						 
						      						//��Ч
						      							SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
						      							musicGet.play();
						      					 box[o][p]=2;
						      					 				 }
						      				 }
						      			 }
						      		 }
						        	ChessCG.this.repaint();
				        	   }
			        	   }
			           }
			           
			           
			         
			         
			         if(b2!=1){//��Ȩ�ļ���   �ü����������غ�
			        	 
			        	 
			        	 //���õ��Իغ�AI
			         
			        
			         
			        	 AIcomputer computer=null ;
			         
			 
			        
			        	 if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==3||new GetDataOfPlayer(new GetNowPlayer().now).Pass==5||new GetDataOfPlayer(new GetNowPlayer().now).Pass==6||new GetDataOfPlayer(new GetNowPlayer().now).Pass==7||new GetDataOfPlayer(new GetNowPlayer().now).Pass==8){
			         
			        	 
			        		 if(isMC==false){
			        		
			        			 computer = new AIeasy();
			        	 
			        		 }
			        	 
			        		 else{
			        		
			        			 computer=new AImachao();
			        	 
			        		 }
			         
			         
			         
			        	 }
			         
			        	 else if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==1||new GetDataOfPlayer(new GetNowPlayer().now).Pass==2||new GetDataOfPlayer(new GetNowPlayer().now).Pass==4||new GetDataOfPlayer(new GetNowPlayer().now).Pass==9){
			        	 
			        		 if(isMC==false){
			        		 
			        			 computer = new AIreallyeasy();
			        	 
			        		 }
			        	 
			        		 else{
			        		
			        			 computer=new AImachao();
			        	 
			        		 }
			         
			         
			        	 }
			         
			         
			        	 else if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==11){
			        	 
			        		 switch(Gets.Level){
				        	 
			        		 case 1:computer = new AIreallyeasy();
			              
			        		 break;
			        	 
			        		 case 2:computer = new AIeasy();
		        		 
			        		 break;
			        	 
			        		 case 3:computer = new AIhard();
		        		 
			        		 break;
			        	 }
			        	 
			         
			        	 }
			         
			         
			        	 if(isMC==false){
			        		 //����ԭ����
					    	 SaveBf();
			        		 a = computer.returnArray(hb, sb, box, wuyong1, wuyong2);
			        	 
			        	 
			        		 if(a!=1){
								
			        			 //��Ч
									SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
									musicSword.play();
								 }
								
			        	 
			        		 else if(a==1){
									//��Ч
										SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
										musicGet.play();
								 }
			         
			        	 }
			         
			         
			        	 else{
			        		 //����ԭ����
					    	 SaveBf();
			        		 a = computer.returnArray(hb, sb, box, machaoskill, wuyong2);
					
						 
						
			        		 if(a!=1){
								//��Ч
									SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
									musicSword.play();
									 isMC=false;
						 
			        		 }
						 
								 
						 
			        		 else if(a==1){
									//��Ч
										SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
										musicGet.play();
						 
			        		 }
						
			         
			        	 }
						
			        	 // //System.out.println("isOver="+isOver+";isMine="+isMine+";get="+get+";hit="+HIT);
						 ChessCG.this.repaint();
						 mpoints=0;
						 epoints=0;
						 
						 for(i=0;i<=4;i++){
								for(j=0;j<=4;j++){
									if(box[i][j]==1){
										mpoints++;
									}
									else if(box[i][j]==2){
										epoints++;
									}
								}
						 }
						 
						 changeimage(yzk1,yzk2);
						 changeLook();
						 stepnum1++;
						 
						 int comstep=1;
					 //System.out.println("��������һ��");
					 
					 while(a==1){
						 voiceOfLvb=1;//������˵һ�λ�
						 try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
							}//˼��
						 //ȷ���Ƿ�ʹ���˵���
						 
						
 
								 if(bf2.PRO.djlan!=null){
									 if(bf2.PRO.djlan.pro1.usePro==true||bf2.PRO.djlan.pro2.usePro==true||bf2.PRO.djlan.pro3.usePro==true){
										 InterruptOfPro=true;
									 }
									
								 }
								 
								
						 if((JPanelCG.bcisMYturn==false&&(JPanelCG.useSkill==true||InterruptOfPro)&&(bf2.Hero==0||bf2.Hero==3||bf2.Hero==4))||jumpout==true){
							 //System.out.println("break computer");
							 
							//�ָ�
							 if(bf2.PRO.djlan!=null){
								 if(bf2.PRO.djlan.pro1.usePro==true||bf2.PRO.djlan.pro2.usePro==true||bf2.PRO.djlan.pro3.usePro==true){
									 InterruptOfPro=false;
									 bf2.PRO.djlan.pro1.usePro=false;
									 bf2.PRO.djlan.pro2.usePro=false;
									 bf2.PRO.djlan.pro3.usePro=false;
								 }
								
							 }
							 //p1�õ��ߴ�ϵ��� �����������
							 break;
						 }
						 
						 
						 
						 if(isMC==true){
							 //����ԭ����
					    	 SaveBf();
							 a = computer.returnArray(hb, sb, box, machaoskill, wuyong2);
							 if(a!=1){
									//��Ч
										SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
										musicSword.play();
										 isMC=false;
									 }
									 else if(a==1){
										//��Ч
											SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
											musicGet.play();
									 }
							
				         }
				         else{
				        	 //����ԭ����
					    	 SaveBf();
				        	 a = computer.returnArray(hb, sb, box, wuyong1, wuyong2);
				        	 if(a!=1){
									//��Ч
										SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
										musicSword.play();
									 }
									 else if(a==1){
										//��Ч
											SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
											musicGet.play();
									 }
				         }
						// //System.out.println("isOver="+isOver+";isMine="+isMine+";get="+get+";hit="+HIT);
						 ChessCG.this.repaint();
						 //����Ӫկ
						 mpoints=0;
						 epoints=0;
						 for(i=0;i<=4;i++){
								for(j=0;j<=4;j++){
									if(box[i][j]==1){
										mpoints++;
									}
									else if(box[i][j]==2){
										epoints++;
									}
								}
						 }
						 changeimage(yzk1,yzk2);//��Ӫկ���ĵ�
						 changeLook();
						 stepnum1++;
						 comstep++;
						 //System.out.println("�������˵�"+comstep+"��");
					
						
					 }//while����
			         
			         }//��Ȩ�ü���������Ȩ�غ�
			         
			         else{//�ָ���Ȩ
			        	 b2=0;
			         }
			         
			       //����ؼ���,��
			       tempOfMc=(int)(Math.random()*9);
			         
			           if((new GetDataOfPlayer(new GetNowPlayer().now).Pass==5)&&tempOfMc>6){
			        	//����������   
			        	   Mc=1;
			        		int sbnum=0,hbnum=0;//�����ʹ�ü���ʱ��ʣ�ĺ�ߺ�����λ����
			        		
			        	   for(i=0;i<=5;i++){
			        		   for(j=0;j<=4;j++){
			        			  if(hb[i][j]==0){
			        				  
			        				  hbnum++;
			        			  }
			        		   }
			        		   
			        	   }
			        	   for(i=0;i<=5;i++){
			        		   for(j=0;j<=4;j++){
			        			  if(sb[i][j]==0){
			        				  
			        				  sbnum++;
			        			  }
			        		   }
			        		   
			        	   }
			        	   SetMusic skillmc=null;
			        	   if(hbnum<=sbnum){//���� ���
			        		 skillmc=new SetMusic("src/music/skill/mc1.wav",false,2);
			        		 skillmc.play();
			        		 bf2.prom.setIcon(nox);
			        		   b5=1;
			        	   }
			        	   else if(hbnum>sbnum){//������ �尡
			        		   skillmc=new SetMusic("src/music/skill/mc2.wav",false,2);
				        		 skillmc.play();
				        		 bf2.prom.setIcon(noy);
			        		   b5=2;
			        	   }
			           }
			           
			           
			           
			         //�ھŹؼ��� �����
			           int temp1=(int)(Math.random()*9);
			           if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==9&&temp1>=6){
			        	 //��Ч
			        	   
			        	   SetMusic skillwyc=null;
			        	   
			        	   int numOfSkill=(int)(Math.random()*2);
			        	   if(numOfSkill==0){
							skillwyc=new SetMusic("src/music/skill/wyc1.wav",false,2);
			        	   }
			        	   else if(numOfSkill==1){
			        		   skillwyc=new SetMusic("src/music/skill/wyc2.wav",false,2);
			        	   }
	 
			        	   else if(numOfSkill==2){
			        		   skillwyc=new SetMusic("src/music/skill/wyc3.wav",false,2);
			        	   }
			        	   
							skillwyc.play();
			        	   //�����´�����ѡ��ɫ
			        	   JPanelGuess gs=new JPanelGuess(ChessCG.this);
			        	   gs.setBounds(720, 20, 100, 100);
			        	   bf2.add(gs,0);
			        	   gs.setVisible(true);
			        	   bf2.repaint();
			        	 
			        	   //��ס����
			        	   isOver=true;
			        	   
			        	   
			        	   b9=1;
			           }
			           
			           
					 HIT=false;
					 ChessCG.this.repaint();
					 isMine=true;
				 	 Timetable.lefttime=180;
				 	 
				 	//��һ�ؼ���
						AIyuanshao computersk1=new AIyuanshao();
						if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==1&&isOver==false){
						 
							b1 = computersk1.returnArray(hb, sb, box, wuyong1, wuyong2);
						
							if(b1==1){
								//��Ч
								SetMusic skillys=new SetMusic("src/music/skill/ys.wav",false,2);
								skillys.play();
								Timetable.lefttime=3;
						
							}
						}
				 	 //���ԻغϽ���
						//������Ч
						if(bf2.PASS==11){
						
							
							mpoints=0;
							epoints=0;
							for(i=0;i<=4;i++){
								for(j=0;j<=4;j++){
									if(box[i][j]==1){
										mpoints++;
									}
									else if(box[i][j]==2){
										epoints++;
									}
								}
							}
							int DisOfrj=epoints-mpoints;
							if((DisOfrj>=5)&&voiceOfLvb==1){
								
								switch(Gets.Level){
								case 1:
									//��Ч
									SetMusic easy=new SetMusic("src/music/skill/easy.wav",false,2);
									easy.play();
									break;
								case 2:
									//��Ч
									SetMusic mid=new SetMusic("src/music/skill/mid.wav",false,2);
									mid.play();
									break;
								case 3:
									//��Ч
									SetMusic difficult=new SetMusic("src/music/skill/difficult.wav",false,2);
									difficult.play();
									break;
								}
								voiceOfLvb=0;
							}
						}
						
					 //�ж���Ӯ
					 boxnum=0;
						for(int o=0;o<=4;o++){
							 for(int p=0;p<=4;p++){
								 if(box[o][p]!=0){
									 boxnum++;
									 
								 }
									 						 
							 }			 
						}	 
						
						
						//System.out.println("boxnum="+boxnum);
						if(boxnum==25){
							isOver=true;
							mpoints=0;
							epoints=0;
							for(i=0;i<=4;i++){
								for(j=0;j<=4;j++){
									if(box[i][j]==1){
										mpoints++;
									}
									else if(box[i][j]==2){
										epoints++;
									}
								}
							}
							
							if(mpoints>epoints){
								if(bf2.PASS!=6||(bf2.PASS==6&&b6==1)){
									change=1;
									//��������ģʽ�еı���
									int pass=new GetDataOfPlayer(new GetNowPlayer().now).Pass;
									if(pass<=5&&pass>=1){
									new GetLock().deblocking(pass);
									}
									//System.out.println("firstplayer:secondplayer="+mpoints+":"+epoints);
									//��ʾ��Ӯ����
									jumpout=true;
									bf2.work=0;
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO �Զ����ɵ� catch ��
										e.printStackTrace();
									}
									if(bf2.ms==1){
									JPanel judge=new JPanelWIN(1,zyp2,1,0,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
									
									zyp2.add(judge);
									//�ص�ս������
								bf2.musicFighting.stop();
									//��Ӯ����
									SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
									musicJudge.play();
									judge.setVisible(true);
									//�����̵�ʱ���ʱֹͣ
									bf2.timeStop();
									//����ԭ���̲��ɼ�
									bf2.setVisible(false);
									}
									else if(bf2.ms==2){
										JPanel judge=new JPanelWIN(1,zyp2,2,bf2.Hero,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
										
										zyp2.add(judge);
										//�ص�ս������
									bf2.musicFighting.stop();
										//��Ӯ����
										SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
										musicJudge.play();
										judge.setVisible(true);
										//�����̵�ʱ���ʱֹͣ
										bf2.timeStop();
										//����ԭ���̲��ɼ�
										bf2.setVisible(false);
										}
									else if(bf2.ms==0){
										JPanel judge=new JPanelWIN(1,zyp2,3,10,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
										
										zyp2.add(judge);
										//�ص�ս������
									bf2.musicFighting.stop();
										//��Ӯ����
										SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
										musicJudge.play();
										judge.setVisible(true);
										//�����̵�ʱ���ʱֹͣ
										bf2.timeStop();
										//����ԭ���̲��ɼ�
										bf2.setVisible(false);
									}
								}
								else if(bf2.PASS==6&&b6==0){
									SkillOfRWX();
									isOver=false;
								}	
							}
							else if(mpoints<epoints){
								
								//System.out.println("firstplayer:secondplayer="+mpoints+":"+epoints);
								//��ʾ��Ӯ����
								jumpout=true;
								bf2.work=0;
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO �Զ����ɵ� catch ��
									e.printStackTrace();
								}
								
								
								if(bf2.ms==1){
									JPanel judge=new JPanelWIN(2,zyp2,1,0,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
									
									zyp2.add(judge);
									//�ص�ս������
								bf2.musicFighting.stop();
									//��Ӯ����
									SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
									musicJudge.play();
									judge.setVisible(true);
									//�����̵�ʱ���ʱֹͣ
									bf2.timeStop();
									//����ԭ���̲��ɼ�
									bf2.setVisible(false);
									}
								else if(bf2.ms==2){
									JPanel judge=new JPanelWIN(2,zyp2,2,bf2.Hero,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
									
									zyp2.add(judge);
									//�ص�ս������
								bf2.musicFighting.stop();
									//��Ӯ����
									SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
									musicJudge.play();
									judge.setVisible(true);
									//�����̵�ʱ���ʱֹͣ
									bf2.timeStop();
									//����ԭ���̲��ɼ�
									bf2.setVisible(false);
									}
									else if(bf2.ms==0){
										JPanel judge=new JPanelWIN(2,zyp2,3,10,new GetDataOfPlayer(new GetNowPlayer().now).Pass,bf2,null);
										
										zyp2.add(judge);
										//�ص�ս������
									bf2.musicFighting.stop();
										//��Ӯ����
										SetMusic musicJudge=new SetMusic("src/music/bgm/end.wav",false,1);
										musicJudge.play();
										judge.setVisible(true);
										//�����̵�ʱ���ʱֹͣ
										bf2.timeStop();
										//����ԭ���̲��ɼ�
										bf2.setVisible(false);
									}
								change=1;
							}
							//��������ֵ
							if(change==1){//�������м���ʱ����������
								changeMoney();
								}
						}
						
						
						if(Mc!=1){
							bf2.prom.setIcon(p1);//������ʾp1�غ�
							}
							Mc=0;	
				 }
			}
			
			System.gc();
		}
		
	}
}
