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
	                        "身为剑体,|钢铁之血灼璃之心.|手创千剑,身经百战;|无一败绩,无一知己.|常一人自醉于剑丘之巅;|此生亦无任何意义;|故此身，定为无限剑成;|故此命，定为无限剑制.",
	                        "I am the bone of my sword;|Steel is my body, and fire is my blood.|I have created over a thousand blades.|Have withstood pain to create many weapons.|Yet,those hands will never hold anything.|So as I pray, unlimited blade works." };
//	        this.setTitle("Java图形程序中的对话逐字显示(由Loonframework提供)");
//	        this.setLocation(400, 200);
	        this.setSize(500, 395);
//	        this.setResizable(false);
	        this.setLayout(null);
	        try {
	        	StartFlash fl=new StartFlash(ImageIO.read(new File("D:/workplace/游戏说明介绍/flash/200812021228206032688.jpg")),abracadabra,50,5000);
				this.add(fl);
				fl.setBounds(0, 0, 500, 395);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
//	        this.setVisible(true);
	}
}
