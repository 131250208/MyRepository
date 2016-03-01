package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouselistenerPro implements MouseListener {
	
	//道具号码
	int proNum;
	boolean usePro=false;
	public MouselistenerPro(int num){
		proNum=num;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		usePro=true;
		if(proNum==1){//道具1的监控
			
			if(ChessCG.Pronum==0){
			
				if(new GetDataOfPlayer(new GetNowPlayer().now).Bought1==1){	
					
					
					//音效
					SetMusic pro=new SetMusic("src/music/action/pro.wav",false,2);
					pro.play();
	 			
		 			
		 			if(ChessCG.isMine==true){
						JPanelCG.bcisMYturn=true;
					}
					else if(ChessCG.isMine==false){
						JPanelCG.bcisMYturn=false;
					}
	 			
		 			
		 			//调用曹操技能
		 			ChessCG.Pronum=1;
				}
				
				else{
					//音效
					SetMusic noPro=new SetMusic("src/music/action/ban.wav",false,2);
					noPro.play();
	 			
				}
			}
	
		}
		
		else if(proNum==2){
			if(ChessCG.Pronum==0){
				if(new GetDataOfPlayer(new GetNowPlayer().now).Bought2==1){	
					
					
					//音效
					SetMusic pro=new SetMusic("src/music/action/pro.wav",false,2);
					pro.play();

		 			
		 			if(ChessCG.isMine==true){
						JPanelCG.bcisMYturn=true;
					}
					else if(ChessCG.isMine==false){
						JPanelCG.bcisMYturn=false;
					}
					

					//调用刘备技能
					ChessCG.Pronum=2;
		 			
					
				}
				else{
					//音效
					SetMusic noPro=new SetMusic("src/music/action/ban.wav",false,2);
					noPro.play();
	 			
				}	
				
				
			}

				
		}
		
        else if(proNum==3){
        	if(ChessCG.Pronum==0){
                
        		if(new GetDataOfPlayer(new GetNowPlayer().now).Bought3==1){	
    				
    				
                	//音效
    				SetMusic pro=new SetMusic("src/music/action/pro.wav",false,2);
    				pro.play();
	 			
                	
                	if(ChessCG.isMine==true){
    					JPanelCG.bcisMYturn=true;
    				}
    				else if(ChessCG.isMine==false){
    					JPanelCG.bcisMYturn=false;
    				}
    				
    				//调用周瑜技能
    				ChessCG.Pronum=3;
				}
                else{
    				//音效
    				SetMusic noPro=new SetMusic("src/music/action/ban.wav",false,2);
    				noPro.play();
     			
    			}
		
        	}
        }
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
