package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MouselistenerLink implements MouseListener {//�νӹؿ�

	
	JPanel ZYP;
	JPanelWIN Win;
	int MS;
	
	public MouselistenerLink(JPanelWIN win,JPanel zyp,
			int ms//������ĸ�ģʽ����Ӯ���� 12345
			){
		Win=win;
		ZYP=zyp;
		MS=ms;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������


		//��Ч
		SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
		musicConfirm.play();
if(MS==1){
	if(new GetDataOfPlayer("wyc").Money>=0){//�����������ֵ
	
		if(new GetDataOfPlayer("wyc").Pass!=9){
			if(Win.Win==1){
				int nextpass=new GetDataOfPlayer("wyc").Pass+1;
				new GetDataOfPlayer("wyc").change(10, nextpass);;
				}
			String donghua="donghua"+new GetDataOfPlayer("wyc").Pass,bg="src/image/background1/bg"+new GetDataOfPlayer("wyc").Pass+".jpg",story="src/image/story/story"+new GetDataOfPlayer("wyc").Pass+".png";
			Story st1=new Story(Win.CG.BF2.ms,Win,ZYP,new GetDataOfPlayer("wyc").Pass,donghua,bg,story);
		}
		else{
			//ͨ��
			if(Win.Win==1){
				//�Ŷӽ��ܼ���Ϸ˵��
				JPanelteam instruction=new JPanelteam();
				instruction.passZYJM(Win.CG.BF2.ms.ZYJM);
				ZYP.add(instruction);
			instruction.setLocation(0, 0);
			instruction.setVisible(true);
			Win.setVisible(false);
			instruction.move();
			
			//�ָ�����
					new GetDataOfPlayer("wyc").change(1, 100);
					new GetDataOfPlayer("wyc").change(2, 0);
					new GetDataOfPlayer("wyc").change(3, 0);
					new GetDataOfPlayer("wyc").change(4, 0);
					new GetDataOfPlayer("wyc").change(5, 0);
					new GetDataOfPlayer("wyc").change(6, 0);
					new GetDataOfPlayer("wyc").change(7, 0);
					new GetDataOfPlayer("wyc").change(8, 0);
					new GetDataOfPlayer("wyc").change(9, 0);
					new GetDataOfPlayer("wyc").change(10, 1);
			}
			else if(Win.Win==2){
				String donghua="donghua"+new GetDataOfPlayer("wyc").Pass,bg="src/image/background/bg"+new GetDataOfPlayer("wyc").Pass+".jpg",story="src/image/story/story"+new GetDataOfPlayer("wyc").Pass+".png";
				Story st1=new Story(Win.CG.BF2.ms,Win,ZYP,new GetDataOfPlayer("wyc").Pass,donghua,bg,story);
			}
		}
		
	}
	else if(new GetDataOfPlayer("wyc").Money<0){//���û��������  ������Ϸ����
		//����ģʽ���
		Win.setVisible(false);
		
		Win.CG.BF2.ms.setVisible(true);
		
		//�ָ�����
		new GetDataOfPlayer("wyc").change(1, 100);
		new GetDataOfPlayer("wyc").change(2, 0);
		new GetDataOfPlayer("wyc").change(3, 0);
		new GetDataOfPlayer("wyc").change(4, 0);
		new GetDataOfPlayer("wyc").change(5, 0);
		new GetDataOfPlayer("wyc").change(6, 0);
		new GetDataOfPlayer("wyc").change(7, 0);
		new GetDataOfPlayer("wyc").change(8, 0);
		new GetDataOfPlayer("wyc").change(9, 0);
		new GetDataOfPlayer("wyc").change(10, 1);
		
	}
}

else if(MS==4||MS==5){
	//����ģʽ���
	Win.setVisible(false);
	
	JPanelYXMS ms=Win.PP.BF;
	ms.setBounds(0, 0, 893, 620);
	ms.setVisible(true);
}

else if(MS==2){
	Win.setVisible(false);
	
	Win.CG.BF3.MS.setVisible(true);
}

else if(MS==3){
	Win.setVisible(false);
	
	Win.CG.BF.setVisible(true);
}

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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

}
