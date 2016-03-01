package src.org.game.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelRegister extends JPanel implements MouseListener  {
	JLabel over=new JLabel();
	JTextField jtf=new JTextField(10);
	String s;//���յ��û����ǳ�
	String[] temp;//�ݴ��û���Ϣ
	//����װ�û���Ϣ��
	ArrayList<String> register=new ArrayList<String>();
	//��ȡ
	ReadAndWriteFile RW=new ReadAndWriteFile();
	//ͼƬ����
	ImageIcon backg=new ImageIcon("src/image/frameAndButton/register/board.jpg");
	ImageIcon over1=new ImageIcon("src/image/frameAndButton/register/over1.jpg");
	ImageIcon over2=new ImageIcon("src/image/frameAndButton/register/confirm2.jpg");
	
	//����
	MouseListenerChooseHero ML1,ML2,ML3,ML4,ML5,ML6;
	MouseListenerChooseHeroEnter ML7;
	JPanelChooseHero JP8;
	public JPanelRegister(MouseListenerChooseHero ml1,
			MouseListenerChooseHero ml2,
			MouseListenerChooseHero ml3,
			MouseListenerChooseHero ml4,
			MouseListenerChooseHero ml5,
			MouseListenerChooseHero ml6,
			MouseListenerChooseHeroEnter ml7,
			JPanelChooseHero jp8
			){
		//����
		ML1=ml1;
		ML2=ml2;
		ML3=ml3;
		ML4=ml4;
		ML5=ml5;
		ML6=ml6;
		ML7=ml7;
		JP8=jp8;
		
		this.setSize(300, 200);
		this.setLayout(null);
		
		//��ȡ�Ѿ��е��û�
		try {
			temp=RW.Read("src/txt/Register.txt");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		int size=temp.length;
		for(int i=0;i<size;i++){
			register.add(temp[i]);
		}
		
		
		//ȷ�ϱ�ǩ
		
		over.setIcon(over1);
		over.setBounds(106, 146, over1.getIconWidth(), over2.getIconHeight());
		over.addMouseListener(this);
		this.add(over,0);
		
		//�ı���
	
		jtf.setSize(190, 30);
	jtf.setForeground(Color.white);
		jtf.setLocation(57, 85);
		jtf.setOpaque(false);
		Font f=new Font("����",Font.PLAIN,25);
		jtf.setCaretColor(Color.white);
		jtf.setFont(f);
		this.add(jtf,1);
		
		//������ǩ
		JLabel bg=new JLabel();
		bg.setIcon(backg);
		bg.setBounds(0, 0, 300, 200);		
		this.add(bg,2);
		
		MouseListenerXY xy=new MouseListenerXY();
		bg.addMouseListener(xy);
	
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		
		 s=jtf.getText();
		//System.out.println(s);
		if(s.equals("")==false&&s.equals("wyc")==false&&s.equals("sb")==false){//��Ϊ�ղ���Ч �ų���������
			//��Ч
			SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
			musicConfirm.play();
			
		//�����û����浽nowpalyer
		String[] temp0=new String[1];
		temp0[0]=s;
		RW.Write(temp0, "src/txt/nowPlayer.txt");
		
		//Ϊ���û�����ռ�
		//�ж��û��Ƿ����
		int size1=register.size();
		int haveone=0;
		for(int i=0;i<size1;i++){
//			if(register.get(i).indexOf(s)!=-1){//����
//				haveone=1;
//				break;
//			}
			String[] data=register.get(i).split(";");
			if(data[0].equals(s)){
				haveone=1;
				break;
			}
		}
		
		
		
		if(haveone!=1){//���û�������
			//System.out.println(register.indexOf(s+";"));
			register.add(s+";100;0;0;0;0;0;0;0;-1;0");//�ǳ� ������ֵ 3������ 4���ɾ� Ӣ��  �ؿ�
			
			int size2=register.size();
			String[] temp1=new String[size2];
			for(int i=0;i<size2;i++){
				temp1[i]=register.get(i);
			}
			
			//д���ĵ�
			RW.Write(temp1,"src/txt/Register.txt");
		}
		else{
			//System.out.println("������Ѵ��ڣ�ֱ�ӽ�����Ϸ");
		}
		
		this.setVisible(false);
		
		//����������ص���Ч
		ML1.work=1;
		ML2.work=1;
		ML3.work=1;
		ML4.work=1;
		ML5.work=1;
		ML6.work=1;
		ML7.work=1;
		JP8.work=1;
		}
		
		else{
			//��Ч
			SetMusic musicban=new SetMusic("src/music/action/ban.wav",false,2);
			musicban.play();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		over.setIcon(over2);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		over.setIcon(over1);
	}
}
