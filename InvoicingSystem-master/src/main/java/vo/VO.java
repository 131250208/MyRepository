package vo;

import java.util.ArrayList;

import po.BillState;
import po.BillStyle;
import po.LevelStrategyStyle;
import po.ReachStrategyStyle;
import po.Role;
import po.StrategyStyle;
import businesslogic.financialbillbl.Item;
import businesslogic.financialbillbl.TransferAccount;

public class VO {
	private BillStyle billstyle;//单据类型
	private StrategyStyle strategystyle;//策略类型
	private LevelStrategyStyle level_strategy_style;//客户分层策略种类
	private ReachStrategyStyle reach_strategy_style;//满额促销种类
	private String ID="0000";
	double total;
	String account;//账户
	double[] money;//金额
	String[] item;
	String[] remark;
	String[] accounts;
	BillState state;
	Role operator;
	ArrayList<Item> itemList;		
	String customer;
	ArrayList<TransferAccount> transferlist;
	/*获取单据类型*/
	public BillStyle getBillStyle(){
		return billstyle;
		
	}
	/*获取策略类型*/
	public StrategyStyle getStrategyStyle(){
		return strategystyle;
		
	}
	/*获取满额促销种类*/
	public ReachStrategyStyle getReach_strategy_style() {
		return reach_strategy_style;
	}
	/*设置满额促销的种类*/
	public void setReach_strategy_style(ReachStrategyStyle reach_strategy_style) {
		this.reach_strategy_style = reach_strategy_style;
	}
	/*获取客户分层策略的种类*/
	public LevelStrategyStyle getLevel_strategy_style() {
		return level_strategy_style;
	}
	/*设置客户分层策略的种类*/
	public void setLevel_strategy_style(LevelStrategyStyle level_strategy_style) {
		this.level_strategy_style = level_strategy_style;
	}
}
