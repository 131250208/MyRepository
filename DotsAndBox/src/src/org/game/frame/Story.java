package src.org.game.frame;

import javax.swing.JPanel;

public class Story implements Runnable {
	
	JPanel ZYP,ST1;
	JPanelYXMS MS;
	JPanelWIN Win;
	public Story(JPanelYXMS del,JPanelWIN del2,JPanel zyp,int pass,String addOfStory,//ɾ������壬�����Ŀ�����ϣ��ؿ����������ַ
			String addr1,//����ͼƬ��ַ
			String addr2//���°���ַ
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
		// TODO �Զ����ɵķ������
		
			
	}
}
