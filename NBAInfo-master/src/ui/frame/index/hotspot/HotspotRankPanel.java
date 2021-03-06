package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ui.frame.larger.LargerPanel;
import ui.frame.larger.LargerScrollPane;
import ui.system.UIData;

@SuppressWarnings("serial")
public class HotspotRankPanel extends JPanel implements ActionListener{

	int x = HotspotBounds.HotspotRankX;
	int y = HotspotBounds.HotspotRankY;
	int width = HotspotBounds.HotspotRankWidth;
	int height = HotspotBounds.HotspotRankHeight;
	
	HotSpotComboBox1 cb_1;
	HotSpotComboBox2 cb_2;
	RankingPanel rankingPanel;
	JButton searchButton, searchButton2;

	public HotspotRankPanel(){
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
//		this.setBackground(new Color(0.1f,0.1f,0.1f,0.7f));
		
		searchButton = new JButton("查看");
		searchButton.setBounds((int) (755  * UIData.changeX), (int) (30 * UIData.changeY),
				(int) (200 * UIData.changeX), (int) (35 * UIData.changeY));
		searchButton.setBackground(Color.DARK_GRAY);
		searchButton.setForeground(Color.WHITE);
		searchButton.addActionListener(this);
		searchButton.setVisible(true);
		this.add(searchButton);
		
		searchButton2 = new JButton("查看更多");
		searchButton2.setBounds((int) (1000  * UIData.changeX), (int) (30 * UIData.changeY),
				(int) (200 * UIData.changeX), (int) (35 * UIData.changeY));
		searchButton2.setBackground(Color.DARK_GRAY);
		searchButton2.setForeground(Color.WHITE);
		searchButton2.addActionListener(this);
		searchButton2.setVisible(true);
		this.add(searchButton2);
		
		cb_1 = new HotSpotComboBox1();
		this.add(cb_1);
		cb_2 = new HotSpotComboBox2();
		this.add(cb_2);
		rankingPanel = new RankingPanel();
		this.add(rankingPanel);
	}
	
	public static int index1 = 0, index2 = 0;
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == searchButton){
			index1 = cb_1.getSelectedIndex();
			index2 = cb_2.getSelectedIndex();
			RankingPanel.update.doClick();
		}
		
		if(e.getSource() == searchButton2){
			LargerPanel.addHotPanel.doClick();
			LargerScrollPane.turnto.doClick();
		}
	}
	
	
	class HotSpotComboBox1 extends JComboBox<String>{
		
		int x = (int)(85 * UIData.changeX);
		int y = (int)(30 * UIData.changeY);
		int width = (int)(300 * UIData.changeX);
		int height = (int)(30 * UIData.changeY);
		
		public HotSpotComboBox1(){
			this.setBounds(x, y, width, height);
			addItem();
			this.setVisible(true);
			this.setBackground(Color.DARK_GRAY);
			this.setForeground(Color.WHITE);	
		}
		
		private void addItem(){	
			this.addItem("常规赛球员数据王");
			this.addItem("季后赛球员赛季王");
			this.addItem("常规赛队伍数据王");
			this.addItem("季后赛队伍数据王");
		}
	}

class HotSpotComboBox2 extends JComboBox<String>{
		
		int x = (int)(415 * UIData.changeX);
		int y = (int)(30 * UIData.changeY);
		int width = (int)(300 * UIData.changeX);
		int height = (int)(30 * UIData.changeY);
		
		public HotSpotComboBox2(){
			this.setBounds(x, y, width, height);
			addItem();
			this.setVisible(true);
			this.setBackground(Color.DARK_GRAY);
			this.setForeground(Color.WHITE);	
		}
		
		private void addItem(){	
			this.addItem("得分");
			this.addItem("助攻");
			this.addItem("篮板");
			this.addItem("盖帽");
			this.addItem("抢断");
			this.addItem("命中率");
			this.addItem("三分命中率");
			this.addItem("罚球命中率");
		}
	}
	
}
