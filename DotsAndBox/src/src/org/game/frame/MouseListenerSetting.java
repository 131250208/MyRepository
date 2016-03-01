package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MouseListenerSetting implements MouseListener {
	//ͼƬ����
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
			ImageIcon close1=new ImageIcon("src/image/frameAndButton/Setting/close1.png");
			ImageIcon open0=new ImageIcon("src/image/frameAndButton/Setting/open2.png");
			ImageIcon open1=new ImageIcon("src/image/frameAndButton/Setting/open1.png");
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
			
			
			//��д�ļ�
			ReadAndWriteFile RW=new ReadAndWriteFile();
			
		
			//��ʹ�õ�ȫ�ֱ���
	JLabel JL,YZ,Other1,Other2,Other3;
	int Button,Num;
	MouseListenerSetting ML1;
	MouseListenerSetting ML2;
	MouseListenerSetting ML3;
	
	JPanelSetting JPS;
	public MouseListenerSetting(JLabel jl
			,JLabel yz//�п���Ҫ����Ӫկ
			,JLabel other1//�п���Ҫ��������
			,JLabel other2
			,JLabel other3
			
			,int button//�������Ƶ����ĸ�button 56����  789������   1234 10ȷ�� 
			,int num//�������ֿ��ػ�����Ч���� 1���� 2��Ч
			,JPanelSetting jps//�����������
			){
		JL=jl;
		YZ=yz;
		Button=button;
		Other1=other1;
		Other2=other2;
		Other3=other3;
		Num=num;
		JPS=jps;
		
	}
	
	public void pass(MouseListenerSetting ml1//����Ҫ������������
			,MouseListenerSetting ml2
			,MouseListenerSetting ml3){
		ML1=ml1;
		ML2=ml2;
		ML3=ml3;
	}
	public void change(int state,JLabel jl,int button){
		if(state==1){
		switch(button){
	      case 1:jl.setIcon(style11);
	      YZ.setIcon(yz1);
	    	  break;
	      case 2:jl.setIcon(style22);
	      YZ.setIcon(yz2);
	    	  break;
	      case 3:jl.setIcon(style33);
	      YZ.setIcon(yz3);
	    	  break;
	      case 4:jl.setIcon(style44);
	      YZ.setIcon(yz4);
	    	  break;
	      case 5:jl.setIcon(open1);
	    	  break;
	      case 6:jl.setIcon(close1);
	    	  break;
	      case 7:jl.setIcon(easy1);
	    	  break;
	      case 8:jl.setIcon(mid1);
	    	  break;
	      case 9:jl.setIcon(difficult1);
	    	  break;
	      }
		}
		
		else if(state==0){
		switch(button){
	      case 1:jl.setIcon(style1);
	    	  break;
	      case 2:jl.setIcon(style2);
	    	  break;
	      case 3:jl.setIcon(style3);
	    	  break;
	      case 4:jl.setIcon(style4);
	    	  break;
	      case 5:jl.setIcon(open0);
	    	  break;
	      case 6:jl.setIcon(close0);
	    	  break;
	      case 7:jl.setIcon(easy0);
	    	  break;
	      case 8:jl.setIcon(mid0);
	    	  break;
	      case 9:jl.setIcon(difficult0);
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
		//��Ч
		SetMusic musicConfirm=new SetMusic("src/music/action/confirm3.wav",false,2);
		musicConfirm.play();	

		 switch(Button){
	      case 1:
	    	//����ͼƬ  
	    	  JL.setIcon(style11);
	      
	      YZ.setIcon(yz1);
	      //������ť�ĳ�ԭ״̬
	      change(0,Other1,2);
	      change(0,Other2,3);
	      change(0,Other3,4);
	      //����������ÿ���
	      ML1.Button=2;
	      ML2.Button=3;
	      ML3.Button=4;
	      
	      Button=-1;
	      
	      //����Ч��
	      JPS.Style=1;
	      
	    	  break;
	      case 2:JL.setIcon(style22);
	      YZ.setIcon(yz2);
	      
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,1);
	      change(0,Other2,3);
	      change(0,Other3,4);
	      //����������ÿ���
	      ML1.Button=1;
	      ML2.Button=3;
	      ML3.Button=4;
	      Button=-1;
	      
	      //����Ч��
	      JPS.Style=2;
	    	  break;
	      case 3:JL.setIcon(style33);
	      YZ.setIcon(yz3);
	      
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,1);
	      change(0,Other2,2);
	      change(0,Other3,4);
	      //����������ÿ���
	      ML1.Button=1;
	      ML2.Button=2;
	      ML3.Button=4;
	      Button=-1;
	      //����Ч��
	      JPS.Style=3;
	    	  break;
	      case 4:JL.setIcon(style44);
	      YZ.setIcon(yz4);
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,1);
	      change(0,Other2,2);
	      change(0,Other3,3);
	      //����������ÿ���
	      ML1.Button=1;
	      ML2.Button=2;
	      ML3.Button=3;
	      Button=-1;
	      
	      //����Ч��
	      JPS.Style=4;
	    	  break;
	      case 5:JL.setIcon(open1);
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,6);
	     
	      //����������ÿ���
	      ML1.Button=6;
	     
	      Button=-1;
	      
	      //����Ч��
	      if(Num==1){
	    	  JPS.Music=1;
	    	  
	      }
	      else if(Num==2){
	    	 JPS.Sound=1;
	    	 
	      }
	    	  break;
	      case 6:JL.setIcon(close1);
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,5);
	     
	      //����������ÿ���
	      ML1.Button=5;
	      
	      Button=-1;
	      
	    //����Ч��
	      if(Num==1){
	    	  JPS.Music=0;
	    	  
	      }
	      else if(Num==2){
	    	 JPS.Sound=0;
	      }
	    	  break;
	      case 7:JL.setIcon(easy1);
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,8);
	      change(0,Other2,9);
	      //����������ÿ���
	      ML1.Button=8;
	      ML2.Button=9;
	      
	      Button=-1;
	      
	      //����Ч��
	      JPS.Level=1;
	    	  break;
	      case 8:JL.setIcon(mid1);
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,7);
	      change(0,Other2,9);
	      //����������ÿ���
	      ML1.Button=7;
	      ML2.Button=9;
	      
	      Button=-1;
	    //����Ч��
	      JPS.Level=2;
	    	  break;
	      case 9:JL.setIcon(difficult1);
	    //������ť�ĳ�ԭ״̬
	      change(0,Other1,7);
	      change(0,Other2,8);
	      //����������ÿ���
	      ML1.Button=7;
	      ML2.Button=8;
	      
	      Button=-1;
	      
	    //����Ч��
	      JPS.Level=3;
	    	  break;
	      }
		 
		 //����
		 save();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//��Ч
				SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
				musicEnter.play();
      switch(Button){
      case 1:JL.setIcon(style11);
      YZ.setIcon(yz1);
    	  break;
      case 2:JL.setIcon(style22);
      YZ.setIcon(yz2);
    	  break;
      case 3:JL.setIcon(style33);
      YZ.setIcon(yz3);
    	  break;
      case 4:JL.setIcon(style44);
      YZ.setIcon(yz4);
    	  break;
      case 5:JL.setIcon(open1);
    	  break;
      case 6:JL.setIcon(close1);
    	  break;
      case 7:JL.setIcon(easy1);
    	  break;
      case 8:JL.setIcon(mid1);
    	  break;
      case 9:JL.setIcon(difficult1);
    	  break;
      }
	}

	public void save(){
		String[] setting=new String[4];
		
		setting[0]=String.valueOf(JPS.Music);
		setting[1]=String.valueOf(JPS.Sound);
		setting[2]=String.valueOf(JPS.Level);
		setting[3]=String.valueOf(JPS.Style);
		
		RW.Write(setting, "src/txt/Setting.txt");
		
	}
	public void  drawYZ(){
		ArrayList<Integer> temp=new ArrayList<Integer>();		
		temp.add(ML1.Button);
	      temp.add(ML2.Button);
	      temp.add(ML3.Button);
	      temp.add(Button);
	      if(temp.contains(1)&&temp.contains(2)&&temp.contains(3)&&temp.contains(-1)){
	    	  YZ.setIcon(yz4);
	      }
	      else if(temp.contains(1)&&temp.contains(2)&&temp.contains(4)&&temp.contains(-1)){
	    	  YZ.setIcon(yz3);
	      }
	      else if(temp.contains(1)&&temp.contains(3)&&temp.contains(4)&&temp.contains(-1)){
	    	  YZ.setIcon(yz2);
	      }
	      else if(temp.contains(2)&&temp.contains(3)&&temp.contains(4)&&temp.contains(-1)){
	    	  YZ.setIcon(yz1);
	      }
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		 switch(Button){
	      case 1:JL.setIcon(style1);
	      this.drawYZ();
	    	  break;
	      case 2:JL.setIcon(style2);
	      this.drawYZ();
	    	  break;
	      case 3:JL.setIcon(style3);
	      this.drawYZ();
	    	  break;
	      case 4:JL.setIcon(style4);
	      this.drawYZ();
	    	  break;
	      case 5:JL.setIcon(open0);
	    	  break;
	      case 6:JL.setIcon(close0);
	    	  break;
	      case 7:JL.setIcon(easy0);
	    	  break;
	      case 8:JL.setIcon(mid0);
	    	  break;
	      case 9:JL.setIcon(difficult0);
	    	  break;
	      }
	}

}
