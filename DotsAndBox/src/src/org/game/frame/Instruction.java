package src.org.game.frame;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Instruction extends JPanel{
	  public Instruction(){
	        String[] abracadabra = new String[] {
	                        "��Ϊ����,|����֮Ѫ����֮��.|�ִ�ǧ��,����ս;|��һ�ܼ�,��һ֪��.|��һ�������ڽ���֮��;|���������κ�����;|�ʴ�����Ϊ���޽���;|�ʴ�������Ϊ���޽���.",
	                        "I am the bone of my sword;|Steel is my body, and fire is my blood.|I have created over a thousand blades.|Have withstood pain to create many weapons.|Yet,those hands will never hold anything.|So as I pray, unlimited blade works." };
//	        this.setTitle("Javaͼ�γ����еĶԻ�������ʾ(��Loonframework�ṩ)");
//	        this.setLocation(400, 200);
	        this.setSize(500, 395);
//	        this.setResizable(false);
	        this.setLayout(null);
	        try {
	        	StartFlash fl=new StartFlash(ImageIO.read(new File("D:/workplace/��Ϸ˵������/flash/200812021228206032688.jpg")),abracadabra,50,5000);
				this.add(fl);
				fl.setBounds(0, 0, 500, 395);
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
//	        this.setVisible(true);
	}
}
