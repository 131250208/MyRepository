package src.org.game.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JPanelBuyPro extends JPanel implements MouseListener{
	
	int buy1=0,buy2=0,buy3=0;//标记购买的道具的有无
	int cost1=20,cost2=20,cost3=50;//购买道具的单价
	int Money=new GetDataOfPlayer(new GetNowPlayer().now).Money,M=new GetDataOfPlayer(new GetNowPlayer().now).Money,Cost;//势力值和总花费
	Timetable Timetable;
	//存取
	ReadAndWriteFile RW=new ReadAndWriteFile();
	//图片对象
		ImageIcon wzsy0=new ImageIcon("src/image/frameAndButton/PurchasePro/wzsy0.png");
		ImageIcon wzsy1=new ImageIcon("src/image/frameAndButton/PurchasePro/wzsy1.png");
		ImageIcon tthr0=new ImageIcon("src/image/frameAndButton/PurchasePro/tthr0.png");
		ImageIcon tthr1=new ImageIcon("src/image/frameAndButton/PurchasePro/tthr1.png");
		ImageIcon fdcx0=new ImageIcon("src/image/frameAndButton/PurchasePro/fdcx0.png");
		ImageIcon fdcx1=new ImageIcon("src/image/frameAndButton/PurchasePro/fdcx1.png");
		
		ImageIcon confirm0=new ImageIcon("src/image/frameAndButton/PurchasePro/confirm0.png");
		ImageIcon confirm1=new ImageIcon("src/image/frameAndButton/PurchasePro/confirm1.png");
		//道具提示
		ImageIcon pro1=new ImageIcon("src/image/frameAndButton/prompt/pro1.png");
		ImageIcon pro2=new ImageIcon("src/image/frameAndButton/prompt/pro2.png");
		ImageIcon pro3=new ImageIcon("src/image/frameAndButton/prompt/pro3.png");
		
		JLabel over = new JLabel("New button");
		JLabel promt=new JLabel();//提示道具功能
		
		JPanelmoney money = new JPanelmoney(String.valueOf(Money));
		JPanelmoney cost =new JPanelmoney(String.valueOf(Cost));

		DJL djlan;
	public JPanelBuyPro(Timetable timetable) {
		Timetable=timetable;
		this.setSize(584, 342);
		this.setLocation(154, 139);
	
			
	
		this.setLayout(null);
		
		final JLabel pro1 = new JLabel("pro1");
		pro1.setForeground(Color.WHITE);
		pro1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e){
				if(buy1==0){
					buy1=1;
					}
					
					else if(buy1==1){
						pro1.setIcon(wzsy0);
						buy1=0;
					}
				//势力值改变和总花费
				
				Cost=(buy1-new GetDataOfPlayer(new GetNowPlayer().now).Bought1)*cost1+(buy2-new GetDataOfPlayer(new GetNowPlayer().now).Bought2)*cost2+(buy3-new GetDataOfPlayer(new GetNowPlayer().now).Bought3)*cost3;
				Money=M-Cost;
				money.update(String.valueOf(Money));
				cost.update(String.valueOf(Cost));
				
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm.play();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				pro1.setIcon(wzsy1);
				//音效
				SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
				musicEnter.play();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(buy1==0){
				pro1.setIcon(wzsy0);
				}
			}
		});
		pro1.setBounds(125, 110, wzsy0.getIconWidth(), wzsy0.getIconHeight());
		if(new GetDataOfPlayer(new GetNowPlayer().now).Bought1==0){
		pro1.setIcon(wzsy0);
		}
		else if(new GetDataOfPlayer(new GetNowPlayer().now).Bought1==1){
			pro1.setIcon(wzsy1);
			buy1=1;
		}
		this.add(pro1,0);
		pro1.addMouseListener(new promtOfPro(1));
		
		final JLabel pro2 = new JLabel("pro2");
		pro2.setForeground(Color.WHITE);
		pro2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
			@Override
			public void mousePressed(MouseEvent e){
				if(buy2==0){
					buy2=1;
					}
					
					else if(buy2==1){
						pro2.setIcon(fdcx0);
						buy2=0;
					}
				//势力值改变和总花费
				
				Cost=(buy1-new GetDataOfPlayer(new GetNowPlayer().now).Bought1)*cost1+(buy2-new GetDataOfPlayer(new GetNowPlayer().now).Bought2)*cost2+(buy3-new GetDataOfPlayer(new GetNowPlayer().now).Bought3)*cost3;				Money=M-Cost;
				money.update(String.valueOf(Money));
				cost.update(String.valueOf(Cost));
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm.play();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pro2.setIcon(fdcx1);
				SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
				musicEnter.play();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(buy2==0){
				pro2.setIcon(fdcx0);
				}
			}
		});
		pro2.setBounds(248, 110, fdcx0.getIconWidth(), fdcx0.getIconHeight());
		if(new GetDataOfPlayer(new GetNowPlayer().now).Bought2==0){
			pro2.setIcon(fdcx0);
			}
			else if(new GetDataOfPlayer(new GetNowPlayer().now).Bought2==1){
				pro2.setIcon(fdcx1);
				buy2=1;
			}
		this.add(pro2,1);
		pro2.addMouseListener(new promtOfPro(2));
		
		final JLabel pro3 = new JLabel("pro3");
		pro3.setForeground(Color.WHITE);
		pro3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e){
				if(buy3==0){
					buy3=1;
					}
					
					else if(buy3==1){
						pro3.setIcon(tthr0);
						buy3=0;
					}
				//势力值改变和总花费
				
				Cost=(buy1-new GetDataOfPlayer(new GetNowPlayer().now).Bought1)*cost1+(buy2-new GetDataOfPlayer(new GetNowPlayer().now).Bought2)*cost2+(buy3-new GetDataOfPlayer(new GetNowPlayer().now).Bought3)*cost3;				Money=M-Cost;
				money.update(String.valueOf(Money));
				cost.update(String.valueOf(Cost));
				SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
				musicConfirm.play();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pro3.setIcon(tthr1);
				SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
				musicEnter.play();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(buy3==0){
				pro3.setIcon(tthr0);
				}
			}
		});
		pro3.setBounds(370, 110, tthr0.getIconWidth(), tthr0.getIconHeight());
		if(new GetDataOfPlayer(new GetNowPlayer().now).Bought3==0){
			pro3.setIcon(tthr0);
			}
			else if(new GetDataOfPlayer(new GetNowPlayer().now).Bought3==1){
				pro3.setIcon(tthr1);
				buy3=1;
			}
		this.add(pro3,2);
		pro3.addMouseListener(new promtOfPro(3));
		
		//提示栏
		promt.setBounds(117, 200, 350, 25);
	    add(promt,3);
	    
		//确认
		
		over.setForeground(Color.WHITE);
		over.addMouseListener(this);
		over.setBounds(242, 270,confirm0.getIconWidth(), confirm0.getIconHeight());
		over.setIcon(confirm0);
		this.add(over,4);
		//势力
		
		money.setForeground(Color.WHITE);
		money.setBounds(53, 245, 100, 50);
		money.setBackground(Color.BLACK);
		this.add(money,5);
		//花费
		
		cost.setForeground(Color.WHITE);
		cost.setBounds(421, 245, 100, 50);
		cost.setBackground(Color.BLACK);
		this.add(cost,6);
		//背景
		JLabel background = new JLabel("background");
		background.setIcon(new ImageIcon("src\\image\\frameAndButton\\PurchasePro\\board-modified.png"));
		background.setBounds(0, 0, 584, 342);
		this.add(background,7);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(Money>=0){
			//标记已买的道具为有
			String[] MP=new String[4];
			new GetDataOfPlayer(new GetNowPlayer().now).change(1, Money);
			
			if(new GetDataOfPlayer(new GetNowPlayer().now).Pass!=7){
			new GetDataOfPlayer(new GetNowPlayer().now).change(2, buy1);
			new GetDataOfPlayer(new GetNowPlayer().now).change(3, buy2);
			new GetDataOfPlayer(new GetNowPlayer().now).change(4, buy3);
			}
			else if(new GetDataOfPlayer(new GetNowPlayer().now).Pass==7){
				
				//音效
				SetMusic skillhhr=new SetMusic("src/music/skill/hhr.wav",false,2);
				skillhhr.play();
				new GetDataOfPlayer(new GetNowPlayer().now).change(2, 0);
				new GetDataOfPlayer(new GetNowPlayer().now).change(3, 0);
				new GetDataOfPlayer(new GetNowPlayer().now).change(4, 0);
				
			}
		}
		Timetable.lefttime=180;
		Timetable.timeStart();
		Timetable.chess2.isOver=false;//游戏开始
		this.setVisible(false);
		
		if(Timetable.chess2.bf2.ms==1||Timetable.chess2.bf2.ms==2){
			//道具框架
			djlan = new DJL();
			djlan.setBounds(30, 480, 150, 120);
			Timetable.chess2.bf2.add(djlan,0);
			Timetable.chess2.bf2.repaint();
			}
		
		SetMusic musicConfirm=new SetMusic("src/music/action/confirm2.wav",false,2);
		musicConfirm.play();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		over.setIcon(confirm1);
		SetMusic musicEnter=new SetMusic("src/music/action/enter2.wav",false,2);
		musicEnter.play();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		over.setIcon(confirm0);
	}
	
	public class promtOfPro implements MouseListener{

		int N;
		public promtOfPro(int num){
			N=num;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			switch(N){
			case 1:promt.setIcon(pro1);
				break;
			case 2:promt.setIcon(pro2);
				break;
			case 3:promt.setIcon(pro3);
				break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			promt.setIcon(null);
		}
		
	}
}
