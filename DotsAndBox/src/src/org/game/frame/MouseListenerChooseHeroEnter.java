package src.org.game.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerChooseHeroEnter implements MouseListener {
//���Ƽ����Ч
	int work=0;
	
	JLabel JL;
	JPanel ZYP;
	JPanelChooseHero Choose;
	
	ImageIcon en1=new ImageIcon("src/image/frameAndButton/jump/jump1.png");
	ImageIcon en2=new ImageIcon("src/image/frameAndButton/jump/jump2.png");
	public MouseListenerChooseHeroEnter(JLabel jl,//���Ƶİ�ť
			JPanelChooseHero jp1//���Ƶ�ѡ�����
			,JPanel zyp
			){
		Choose=jp1;
		ZYP=zyp;
		JL=jl;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		if(work==1){//�Ѿ������������  ���밴ť�����Ч
			Choose.musicChooseH.stop();//�ص�ѡ��Ӣ�۵�����
			//��Ч
			new SetMusic("src/music/action/confirm2.wav",false,2).play();
			
			
			//����ѡ��
			//��ȡ���ڵ������
			String nowPlay=new GetNowPlayer().now;
			//�޸�Ӣ�۴���
			int newHero=0;
			if(Choose.hero!=-1){
			newHero=Choose.hero;
			}
			
			new GetDataOfPlayer(nowPlay).change(9, newHero);
			//����ѡ��ؿ����
			JPanelChoosePass JPpass=new JPanelChoosePass(ZYP,Choose.MS);
			ZYP.add(JPpass);
			JPpass.setVisible(true);
			JPpass.setLocation(0, 0);
			//ѡ��Ӣ�������Ϊ���ɼ�
		Choose.setVisible(false);
		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		if(work==1){
			//��Ч
			SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
			musicEnter.play();

			JL.setIcon(en2);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		if(work==1){
JL.setIcon(en1);
		}
	}

}
