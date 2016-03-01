package src.org.game.frame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelmoney extends JPanel {
//图片
	BufferedImage bg = null;
	
	int money;
	
	String str="10";
	public JPanelmoney(String s){
		//传递
		str=s;
		
		this.setSize(100, 50);
		
		try {
			bg=ImageIO.read(new File("src/image/frameAndButton/PurchasePro/frame.jpg"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
	
	public void paint(Graphics g2) {
		BufferedImage bi=new BufferedImage(100,50,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g=bi.createGraphics();
		//笔刷大小
		 Stroke stroke=new BasicStroke(10.0f);
		   g.setStroke(stroke);
		   g.setColor(Color.WHITE);
		   
		   g.setFont(new Font("宋体", Font.BOLD,30));
		   
		   
		   //居中
		   FontMetrics fm = g.getFontMetrics();
		   int stringWidth = fm.stringWidth(str); 
		   int stringAscent = fm.getAscent(); 
		   int stringDescent = fm.getDescent (); 
		   int x = this.getWidth() / 2 - stringWidth / 2; 
		   int y = this.getHeight() / 2 + (stringAscent - stringDescent) / 2; 
		   
		   g.drawImage(bg, 0,0,this);
		   g.drawString(str, x, y-3);
		   
		   g2.drawImage(bi, 0, 0, this);
	}
	
	public void update(String s){
		str=s;
		this.repaint();
	}
}
