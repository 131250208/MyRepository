package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouselistenerPro implements MouseListener {
	
	//���ߺ���
	int proNum;
	boolean usePro=false;
	public MouselistenerPro(int num){
		proNum=num;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		usePro=true;
		if(proNum==1){//����1�ļ��
			
			if(ChessCG.Pronum==0){
			
				if(new GetDataOfPlayer(new GetNowPlayer().now).Bought1==1){	
					
					
					//��Ч
					SetMusic pro=new SetMusic("src/music/action/pro.wav",false,2);
					pro.play();
	 			
		 			
		 			if(ChessCG.isMine==true){
						JPanelCG.bcisMYturn=true;
					}
					else if(ChessCG.isMine==false){
						JPanelCG.bcisMYturn=false;
					}
	 			
		 			
		 			//���òܲټ���
		 			ChessCG.Pronum=1;
				}
				
				else{
					//��Ч
					SetMusic noPro=new SetMusic("src/music/action/ban.wav",false,2);
					noPro.play();
	 			
				}
			}
	
		}
		
		else if(proNum==2){
			if(ChessCG.Pronum==0){
				if(new GetDataOfPlayer(new GetNowPlayer().now).Bought2==1){	
					
					
					//��Ч
					SetMusic pro=new SetMusic("src/music/action/pro.wav",false,2);
					pro.play();

		 			
		 			if(ChessCG.isMine==true){
						JPanelCG.bcisMYturn=true;
					}
					else if(ChessCG.isMine==false){
						JPanelCG.bcisMYturn=false;
					}
					

					//������������
					ChessCG.Pronum=2;
		 			
					
				}
				else{
					//��Ч
					SetMusic noPro=new SetMusic("src/music/action/ban.wav",false,2);
					noPro.play();
	 			
				}	
				
				
			}

				
		}
		
        else if(proNum==3){
        	if(ChessCG.Pronum==0){
                
        		if(new GetDataOfPlayer(new GetNowPlayer().now).Bought3==1){	
    				
    				
                	//��Ч
    				SetMusic pro=new SetMusic("src/music/action/pro.wav",false,2);
    				pro.play();
	 			
                	
                	if(ChessCG.isMine==true){
    					JPanelCG.bcisMYturn=true;
    				}
    				else if(ChessCG.isMine==false){
    					JPanelCG.bcisMYturn=false;
    				}
    				
    				//������褼���
    				ChessCG.Pronum=3;
				}
                else{
    				//��Ч
    				SetMusic noPro=new SetMusic("src/music/action/ban.wav",false,2);
    				noPro.play();
     			
    			}
		
        	}
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

}
