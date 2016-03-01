package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MouseListenerChangeimage implements MouseListener {

	//图片
		ImageIcon dj001=new ImageIcon("src\\image\\frameAndButton\\dj-1.png");
		ImageIcon dj002=new ImageIcon("src\\image\\frameAndButton\\dj-2.png");
		ImageIcon dj003=new ImageIcon("src\\image\\frameAndButton\\dj-3.png");
		
		ImageIcon dj01=new ImageIcon("src\\image\\frameAndButton\\dj01.png");
		ImageIcon dj02=new ImageIcon("src\\image\\frameAndButton\\dj02.png");
		ImageIcon dj03=new ImageIcon("src\\image\\frameAndButton\\dj03.png");
	
	JButton JB;
	JLabel JL;
	int Choosecomp,Chooseimage;
	//
	int work=0;
	//马超计数
	int num=0;
	//查看有无道具
    int havePro1=new GetDataOfPlayer(new GetNowPlayer().now).Bought1;
    int havePro2=new GetDataOfPlayer(new GetNowPlayer().now).Bought2;
    int havePro3=new GetDataOfPlayer(new GetNowPlayer().now).Bought3;

	public MouseListenerChangeimage(JButton jb,JLabel jl,int choosecomp,//选择容器类型
			int chooseimage //选择需要的图片
			){
		JB=jb;
		JL=jl;
		Choosecomp=choosecomp;
		Chooseimage=chooseimage;
		if(choosecomp==1){
		jb.addMouseListener(this);
		}
		if(choosecomp==2){
		jl.addMouseListener(this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
			if(Chooseimage==0){//曹操技能按钮
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\00.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\00.png"));	
				}
				work=0;
			}
			if(Chooseimage==5){//马超技能
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\55.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\55.png"));	
				}
				num++;
				if(num==3){
				work=0;
				}
			}
			if(Chooseimage==4){//周瑜技能
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\44.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\44.png"));	
		
				}
				work=0;
			}
			
			if(Chooseimage==3){//刘备节能按钮
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\33.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\33.png"));	
				}
				work=0;
			}
			if(Chooseimage==2){//孙权技能按钮
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\22.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\22.png"));	
				}
				work=0;
			}
			if(Chooseimage==1){//袁绍技能按钮
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\11.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\11.png"));	
		
				}
				work=0;
			}
			
			if(Chooseimage==6){//任我行技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\66.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\66.png"));	
		
				}
				work=0;
			}
			if(Chooseimage==7){//黄慧蓉技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\77.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\77.png"));	
		
				}
				work=0;
			}
			if(Chooseimage==8){//王誉量技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\88.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\88.png"));	
		
				}
				work=0;
			}
			if(Chooseimage==9){//王雨城技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\99.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\99.png"));	
		
				}
				work=0;
			}
			if(Chooseimage==10){//道具1按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj11.png"));		
					havePro1=0;
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj11.png"));	
					havePro1=0;
				}

			}
			if(Chooseimage==11){//道具2按钮
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj22.png"));		
					havePro2=0;
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj22.png"));	
					havePro2=0;
				}

			}
			if(Chooseimage==12){//道具3按钮
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj33.png"));		
					havePro3=0;
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj33.png"));	
					havePro3=0;
				}

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

		if(work==1){
			if(Chooseimage==10){//道具1按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(dj001);		
					work=0;
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(dj001);	
					work=0;
				}

			}
			if(Chooseimage==11){//道具2按钮
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(dj002);		
					work=0;
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(dj002);	
					work=0;
				}

			}
			if(Chooseimage==12){//道具3按钮
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(dj003);		
					work=0;
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(dj003);	
					work=0;
				}

			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(work==1){
			if(Chooseimage==0){//曹操技能按钮
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\000.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\000.png"));	
				}
			}
	if(Chooseimage==5){//马超技能
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\555.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\555.png"));	
				}
			}
			if(Chooseimage==4){//周瑜技能
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\444.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\444.png"));	
		
				}

			}
			
			if(Chooseimage==3){//刘备节能按钮
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\333.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\333.png"));	
				}
			}
			if(Chooseimage==2){//孙权技能按钮
				
				if(Choosecomp==1){					
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\222.png"));		
				}		
				if(Choosecomp==2){			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\222.png"));	
				}
			}
			if(Chooseimage==1){//袁绍技能按钮
				
		
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\111.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\111.png"));	
		
				}

			}
			
			if(Chooseimage==6){//任我行技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\666.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\666.png"));	
		
				}

			}
			if(Chooseimage==7){//黄慧蓉技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\777.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\777.png"));	
		
				}

			}
			if(Chooseimage==8){//王誉量技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\888.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\888.png"));	
		
				}

			}
			if(Chooseimage==9){//王雨城技能按钮
				
				
				if(Choosecomp==1){					
			
					JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\999.png"));		
		
				}		
		
				if(Choosecomp==2){			
			
					JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\999.png"));	
		
				}

			}
			if(Chooseimage==10){//技能1按钮
       			
       			
       			if(Choosecomp==1){					
       		
       				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj1.png"));		
       	
       			}		
       	
       			if(Choosecomp==2){			
       		
       				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj1.png"));	
       	
       			}

       		}
       		if(Chooseimage==11){//技能2按钮
       			
       
       			if(Choosecomp==1){					
       		
       				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj2.png"));		
       	
       			}		
       	
       			if(Choosecomp==2){			
       		
       				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj2.png"));	
       	
       			}

       		}
       		if(Chooseimage==12){//技能3按钮
       			
       	
       			if(Choosecomp==1){					
       		
       				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj3.png"));		
       	
       			}		
       	
       			if(Choosecomp==2){			
       		
       				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\dj3.png"));	
       	
       			}

       		}
       		SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
    		musicEnter.play();
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
           if(work==1){
        	   if(Chooseimage==0){//曹操技能按钮
       			
       			if(Choosecomp==1){					
       				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\0.png"));		
       			}		
       			if(Choosecomp==2){			
       				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\0.png"));	
       			}
       		}
                    if(Chooseimage==5){//马超技能
            			
            			if(Choosecomp==1){					
            				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\5.png"));		
            			}		
            			if(Choosecomp==2){			
            				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\5.png"));	
            			}
            		}
            		if(Chooseimage==4){//周瑜技能
            			
            	
            			if(Choosecomp==1){					
            		
            				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\4.png"));		
            	
            			}		
            	
            			if(Choosecomp==2){			
            		
            				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\4.png"));	
            	
            			}

            		}
            		
            		if(Chooseimage==3){//孙权节能按钮
            			
            			if(Choosecomp==1){					
            				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\3.png"));		
            			}		
            			if(Choosecomp==2){			
            				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\3.png"));	
            			}
            		}
            		if(Chooseimage==2){//刘备技能按钮
            			
            			if(Choosecomp==1){					
            				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\2.png"));		
            			}	
            			if(Choosecomp==2){			
            				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\2.png"));	
            			}
            		}
            		if(Chooseimage==1){//袁绍技能按钮
            			
            	
            			if(Choosecomp==1){					
            		
            				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\1.png"));		
            	
            			}		
            	
            			if(Choosecomp==2){			
            		
            				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\1.png"));	
            	
            			}

            		}
            		
           		
           		if(Chooseimage==6){//任我行技能按钮
           			
           			
           			if(Choosecomp==1){					
           		
           				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\6.png"));		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\6.png"));	
           	
           			}

           		}
           		if(Chooseimage==7){//黄慧蓉技能按钮
           			
           			
           			if(Choosecomp==1){					
           		
           				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\7.png"));		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\7.png"));	
           	
           			}

           		}
           		if(Chooseimage==8){//王誉量技能按钮
           			
           			
           			if(Choosecomp==1){					
           		
           				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\8.png"));		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\8.png"));	
           	
           			}

           		}
           		if(Chooseimage==9){//王雨城技能按钮
           			
           			
           			if(Choosecomp==1){					
           		
           				JB.setIcon(new ImageIcon("src\\image\\frameAndButton\\9.png"));		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(new ImageIcon("src\\image\\frameAndButton\\9.png"));	
           	
           			}

           		}
            		if(Chooseimage==10){//技能1按钮
           			
           			
           			if(Choosecomp==1){					
           		
           				JB.setIcon(dj01);		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(dj01);	
           	
           			}

           		}
           		if(Chooseimage==11){//技能2按钮
           			
           
           			if(Choosecomp==1){					
           		
           				JB.setIcon(dj02);		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(dj02);	
           	
           			}

           		}
           		if(Chooseimage==12){//技能3按钮
           			
           	
           			if(Choosecomp==1){					
           		
           				JB.setIcon(dj03);		
           	
           			}		
           	
           			if(Choosecomp==2){			
           		
           				JL.setIcon(dj03);	
           	
           			}

           		}
       	}
           }

	
}
