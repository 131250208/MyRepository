package src.org.game.frame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chess1 extends JPanel implements MouseListener {
	 int i,j,m,n,mpoints=0,epoints=0,stepnum=0,boxnum=0,MS=-1;
	//CG �ı���
	 boolean wuyong2,HIT=false,DEL=false;
	// ����ͼƬ��ֵ
				BufferedImage bg1 = null;
				
				BufferedImage yz1 = null;
				BufferedImage yz2 = null;
				BufferedImage qp1 = null;
				BufferedImage wb1 = null;
				BufferedImage wb2= null;
				BufferedImage db1 = null;
				BufferedImage db2 = null,Q=null;
				
				BufferedImage wb01 = null;
				BufferedImage wb02= null;
				BufferedImage db01 = null;
				BufferedImage db02 = null;
				//�������������� 
				int x=0;
		          int y=0;
		          //�������бߣ�1��ʾ�Լ��ģ�2��ʾ�Է��ģ�0��ʾû��
		          int [][] hb=new int[6][5];
		          int [][] sb=new int[6][5];
		          
		          int[][] bfHB=new int[6][5];
		          int [][] bfSB=new int[6][5];
		          //����box
		          int [][] box= new int[5][5];
		          
		          //��ʶ�ֵ�˭
		          static boolean isMine=true;
		          //�������ⲽ��˭�ߵ�,1��ʾ���ߵģ�2��ʾ�Է�
		         int step=0;
		         //�жϱ����Ƿ����
		         boolean isOver=true;
		         //Timetable Ti=new Timetable();
		       //Ӫկ��
		      	JLabel yzk1;
		     	JLabel yzk2;
		     	
		     	JPanel2p bf2;
		     	JPanel zyp2;
		     	
		     	//�������������ȷ��Ŀ��Ӫկ
				 int r1=(int) (Math.random()*4);
				   int r2=(int) (Math.random()*4);
				 //ͼƬ
					ImageIcon p1=new ImageIcon("src/image/frameAndButton/prompt/p1.png");  
					ImageIcon p2=new ImageIcon("src/image/frameAndButton/prompt/p2.png");  
	public Chess1(){
		//System.out.println("MS="+MS);
		
		HIT=false;
		isMine=true;
		
		// ���ô����С
		this.setSize(470, 470);

		
		// Ϊ������������
		this.addMouseListener(this);
		
		
		 try{
				
				
				qp1=ImageIO.read(new File("src/image/������/qp1.png"));
				
				wb1=ImageIO.read(new File("src/image/������/wb1.png"));
				wb2=ImageIO.read(new File("src/image/������/wb2.png"));
				db1=ImageIO.read(new File("src/image/������/db1.png"));
				db2=ImageIO.read(new File("src/image/������/db2.png"));
				
				wb01=ImageIO.read(new File("src/image/������/wb01.png"));
				wb02=ImageIO.read(new File("src/image/������/wb02.png"));
				db01=ImageIO.read(new File("src/image/������/db01.png"));
				db02=ImageIO.read(new File("src/image/������/db02.png"));
				Q=ImageIO.read(new File("src/image/������/napkin.png"));
	          }catch(IOException e){
		     // TODO Auto-generated catch block
		    e.printStackTrace();
	         }
		
		 
		 
			try {
				yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/1.png"));
				yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}
	
	//���ݲ���
	public void pass(JLabel jl1,JLabel jl2,//Ҫ�ı�Ӫկ��Ŀ������lb
			JPanel2p bf1,//֮ǰ��������̵�jp
			JPanel zyp1//������Ҫjp
			,int ms
			){
		//���ݲ���
		bf2=bf1;
		zyp2=zyp1;
		 yzk1=jl1;
		 yzk2=jl2;
		 MS=ms;
		 if(ms==1){
		 try {
			 switch(new GetSetting().Style){
			 case 1:
				 yz1=ImageIO.read(new File("src/image/������/Ӫկ/��/1.png"));
					yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/1.png"));
					break;
			 case 2:
				 yz1=ImageIO.read(new File("src/image/������/Ӫկ/��/2.png"));
					yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/2.png"));
					break;
			 case 3:
				 yz1=ImageIO.read(new File("src/image/������/Ӫկ/��/3.png"));
					yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/3.png"));
					break;
			 case 4:
				 yz1=ImageIO.read(new File("src/image/������/Ӫկ/��/4.png"));
					yz2=ImageIO.read(new File("src/image/������/Ӫկ/����/4.png"));
					break;
			 }
				
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		 }
		 else if(ms==0){
			 try {
				 switch(new GetSetting().Style){
				 case 1:
					yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/1.png"));
					yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/1.png"));
					break;
				 case 2:
						yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/2.png"));
						yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/2.png"));
						break;
				 case 3:
						yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/3.png"));
						yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/3.png"));
						break;
				 case 4:
						yz1=ImageIO.read(new File("src/image/������/Ӫկ/κ/4.png"));
						yz2=ImageIO.read(new File("src/image/������/Ӫկ/��/4.png"));
						break;
				 }
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			 }
		 
	}
	//�ı�Ӫկ����
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
	public void paint(Graphics g3) {
		BufferedImage bi=new BufferedImage(470,470,BufferedImage.TYPE_INT_ARGB);
		Graphics g=bi.createGraphics();
		Graphics2D g4=bi.createGraphics();
		
		
		   g.drawImage(qp1,0, 0, this);
		   Graphics2D g2=(Graphics2D)g;
		 //�����߿�Ϊ2.0
		   Stroke stroke=new BasicStroke(2.0f);
		   g4.setStroke(stroke);
		   g.setColor(Color.BLACK);
		   g4.setColor(Color.BLACK);
	//��������
		   for( i=0;i<11;i++){
		   g4.drawLine(35, 35+40*i, 435, 35+40*i);
		   }
		   for( i=0;i<11;i++){
			   g4.drawLine(35+40*i, 35, 35+40*i, 435);
			   } 
		   for(i=0;i<6;i++){
			   for(j=0;j<6;j++){
		       g.fillOval(30+80*j, 30+80*i, 10, 10);
			   }
		   }
		   
		 //�����Ȧ��ģʽ  ����Ȧ
			if(MS==0){
			for(int o=0;o<=4;o++){
				 for(int p=0;p<=4;p++){
					 if(box[o][p]==3){
						 g.drawImage(Q,p*80+35 ,o*80+35 , this); 
					 }
					
				 }
				
			}
			}
		 //���ƺ��
			for(m=0;m<=5;m++){
				for(n=0;n<=4;n++){
					if(hb[m][n]==1){
						//���ƺ��ɫ��
						int tempx=n*80+75;
						int tempy=m*80+35;
					g.drawImage(wb1, tempx-40, tempy-5, this);
					}
					else if(hb[m][n]==2){
						int tempx=n*80+75;
						int tempy=m*80+35;
					g.drawImage(db1, tempx-40, tempy-5, this);
					}
				}
			}
			
		//��������
			for(m=0;m<=5;m++){
				for(n=0;n<=4;n++){
					if(sb[m][n]==1){
						//��������ɫ��
						int tempx=m*80+35-5;
						int tempy=n*80+35;
					g.drawImage(wb2, tempx, tempy, this);
					
					}
					else if(sb[m][n]==2){
						int tempx=m*80+35-5;
						int tempy=n*80+35;
					g.drawImage(db2, tempx, tempy, this);
										
					}
				
				}
			}
			
			//�����±�
			for(m=0;m<=5;m++){
				for(n=0;n<=4;n++){
					if(sb[m][n]!=bfSB[m][n]){
						if(sb[m][n]==1){
							int tempx=m*80+35-5;
							int tempy=n*80+35;
						g.drawImage(wb02, tempx, tempy, this);
						}
						else if(sb[m][n]==2){
							int tempx=m*80+35-5;
							int tempy=n*80+35;
						g.drawImage(db02, tempx, tempy, this);
						}
					}
					else if(hb[m][n]!=bfHB[m][n]){
						if(hb[m][n]==1){
							int tempx=n*80+75;
							int tempy=m*80+35;
						g.drawImage(wb01, tempx-40, tempy-5, this);
						}
						else if(hb[m][n]==2){
							int tempx=n*80+75;
							int tempy=m*80+35;
						g.drawImage(db01, tempx-40, tempy-5, this);
						}
					}
				}
				
			}
			//����box
			for(int o=0;o<=4;o++){
				 for(int p=0;p<=4;p++){
					 if(box[o][p]==1){
						 g.drawImage(yz1,p*80+35 ,o*80+35 , this); 
					 }
					 else if(box[o][p]==2){
						 g.drawImage(yz2,p*80+35 ,o*80+35 , this); 
					 }
				 }
				
			}
			
			
			g3.drawImage(bi,0,0,this);
			g2.drawImage(bi,0,0,this);
	     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	
	//��ʱ�����
	public void punish(){
		 AIpunish punish=new AIpunish();
     
      int a=punish.returnArray(hb, sb, box, 0, isMine);
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
      this.repaint();
      if(isMine=true){
    	  isMine=false;
      }
      else{
    	  isMine=true;
      }
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		// TODO �Զ����ɵķ������
				//System.out.println("X:"+e.getX()); //System.out.println("Y:"+e.getY());
				x=e.getX();
				 y=e.getY();
				 
				 if(MS==0){
					   box[r1][r2]=3;
					}	
				 
				 for(int i=0;i<=1;i++){
					 if(i==0){
					 if(isOver==false){//��λ����������
				 
						 //�������1
				 
						 for(int k=0;k<=4;k++){
					for(int g=0;g<=4;g++){ 
				 
				        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(y-80*g)-35>=0){
					     //System.out.println("hit");
					     
					     
					     if( hb[g][k]==0){
					    	 //����ԭ����
					    	 SaveBf();
					    	//��Ч
								SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
								musicSword.play();
					  //��������ʱ
					      	 Timetable.lefttime=180;
					    	 
					    	 stepnum++;
					     			     if(isMine==true){
					         
					     			    	 hb[g][k]=1;
									          step=1;
									          //System.out.println("hb"+g+k+"="+hb[g][k]);
									          isMine=false;

					   			     			     }
					     		     else if(isMine==false){
					    	
					     		    	 hb[g][k]=2;
								    	 step=2;
									     //System.out.println("hb"+g+k+"="+hb[g][k]);
									     isMine=true;
						     				     
									     }
					     }
				      }
					}
				 }
				 //�������2
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					      if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(y-80*g)-115<=0){
						     //System.out.println("hit2");
						    
						    if(hb[g+1][k]==0){
						    	 //����ԭ����
						    	 SaveBf();
						    	//��Ч
								SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
								musicSword.play();
						    	 Timetable.lefttime=180;
						    	stepnum++;
						         if(isMine==true){
						         hb[g+1][k]=1;
						        step=1;
						        //System.out.println("hb"+(g+1)+k+"="+hb[g+1][k]);
						        isMine=false;
						         }
						        else if(isMine==false){
						    	 hb[g+1][k]=2;
						    	 step=2;
							     //System.out.println("hb"+(g+1)+k+"="+hb[g+1][k]);
							     isMine=true;
						        }
						    }
					      }
						}
					 }
				 //�������3
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					       if((x-80*k)<(y-80*g)&&(x-80*k)+(y-80*g)-150<0&&(x-80*k)-35>=0){
						     //System.out.println("hit3");
						    
						    if(sb[k][g]==0){
						    	 //����ԭ����
						    	 SaveBf();
						    	//��Ч
								SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
								musicSword.play();
						    	 Timetable.lefttime=180;
						    	 stepnum++;
						     if(isMine==true){
						    	 sb[k][g]=1;
						    	 step=1;
							     //System.out.println("sb"+k+g+"="+sb[k][g]);
							     isMine=false;
							     }
						     else if(isMine==false){
						    	 sb[k][g]=2;
						    	 step=2;
							     //System.out.println("sb"+k+g+"="+sb[k][g]);
							     isMine=true;
						     }
						    }
					      }
						}
					 }
				 //�������4
				 for(int k=0;k<=4;k++){
						for(int g=0;g<=4;g++){ 
					 
					        if((x-80*k)>(y-80*g)&&(x-80*k)+(y-80*g)-150>0&&(x-80*k)-115<=0){
						     //System.out.println("hit4");
						   
						     if(sb[k+1][g]==0){
						    	 //����ԭ����
						    	 SaveBf();
						    	//��Ч
									SetMusic musicSword=new SetMusic("src/music/action/sword.wav",false,2);
									musicSword.play();
						    	 Timetable.lefttime=180;
						    	  stepnum++;
						         if(isMine==true){
						    	 
						    	 sb[k+1][g]=1;
						    	 step=1;
							     //System.out.println("sb"+(k+1)+g+"="+sb[k+1][g]);
							     isMine=false;
							     					     
							     }
						      else if(isMine==false){
						    	 sb[k+1][g]=2;
						    	 step=2;
							     //System.out.println("sb"+(k+1)+g+"="+sb[k+1][g]);
							     isMine=true;
						      }
						    }
					      }
						}
					 }
				 
				 //����Ƿ���box
				 for(int o=0;o<=4;o++){
					 for(int p=0;p<=4;p++){
						 if(hb[o][p]!=0&&hb[o+1][p]!=0&&sb[p][o]!=0&&sb[p+1][o]!=0){
							 if(box[o][p]==0||box[o][p]==3){
							 box[o][p]=step;
							//��Ч
								SetMusic musicGet=new SetMusic("src/music/action/getbox.wav",false,2);
								musicGet.play();
							 //System.out.println("step="+step);
							 //��������
							 if(step==1){
								 isMine=true;
								 
							 }
							 else if(step==2){
								 isMine=false;
								 
							 }
							 
							 				 }
						
							 
							 
						 }
					 }
					 
				 }
				 
				
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
					 }
				
				
				
				 }
					 this.repaint();	 
				 }
				 
				
				 //
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//����ʾ
		if(isMine==true){
		bf2.prom.setIcon(p1);
		}
		else{
			bf2.prom.setIcon(p2);
		}
		
		//�ж���Ӯ
		 
		 if(MS==1){//�����2pģʽ ���ø��ж�
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
			mpoints=0;
			epoints=0;
			isOver=true;
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
			if(mpoints>epoints){
				//System.out.println("the first player win");
				//System.out.println("firstplayer:secondplayer="+mpoints+":"+epoints);
				//��ʾ��Ӯ����
				bf2.work=0;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				JPanel judge=new JPanelWIN(1,zyp2,4,5,11,null,bf2);
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
			else if(mpoints<epoints){
				//System.out.println("the second player win");
				//System.out.println("firstplayer:secondplayer="+mpoints+":"+epoints);
				
				//��ʾ��Ӯ����
				bf2.work=0;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				JPanel judge=new JPanelWIN(2,zyp2,4,5,11,null,bf2);
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
		}
		 
		 else if(MS==0){//���������ģʽ

				if(box[r1][r2]==1){
					//System.out.println("the first player win");
					//��ʾ��Ӯ����
					bf2.work=0;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					JPanel judge=new JPanelWIN(1,zyp2,5,0,4,null,bf2);
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
				else if(box[r1][r2]==2){
					//System.out.println("the second player win");
					//��ʾ��Ӯ����
					bf2.work=0;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					JPanel judge=new JPanelWIN(2,zyp2,5,0,4,null,bf2);
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
				//��ʾ��������
				if(box[r1][r2]!=0&&box[r1][r2]!=3){
					isOver=true;
				}
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

	//����ԭ����
	public void SetBfHB(){
		
		for(int i=0;i<=5;i++){
			for(int j=0;j<=4;j++){
				bfHB[i][j]=hb[i][j];
			}
		}
		
	}
	

	public void SetBfSB(){
		for(int i=0;i<=5;i++){
			for(int j=0;j<=4;j++){
				bfSB[i][j]=sb[i][j];
			}
		}
		
		
	}
	
	public void SaveBf(){
		SetBfSB();
		SetBfHB();
	}
}
