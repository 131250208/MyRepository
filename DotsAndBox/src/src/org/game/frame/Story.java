package src.org.game.frame;

import javax.swing.JPanel;

public class Story implements Runnable {
	
	JPanel ZYP,ST1;
	JPanelYXMS MS;
	JPanelWIN Win;
	public Story(JPanelYXMS del,JPanelWIN del2,JPanel zyp,int pass,String addOfStory,//删除的面板，加在哪块面板上，关卡数，剧情地址
			String addr1,//背景图片地址
			String addr2//故事板块地址
			){
		ZYP=zyp;
		MS=del;
		Win=del2;
		JPanel story=new JPanel();
		JPanelStory st1=new JPanelStory(addr1,addr2,zyp,pass,addOfStory,MS);
		ST1=st1;
		zyp.add(st1);
		
		
		st1.setVisible(true);
		if((del!=null)&&(del2!=null)){
		del2.setVisible(false);
		}
		else if((del!=null)&&(del2==null)){
			del.setVisible(false);
		}
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
			
	}
}
