package po;

import java.util.ArrayList;

import po.stockpo.CommodityPO;

public class LevelStrategyPO extends PO{
	private StrategyStyle strategystyle=StrategyStyle.LevelStrategy;
	private LevelStrategyStyle level_strategy_style=LevelStrategyStyle.Default;
	
	private String ID;
	private int level;//客户等级
	private double Limit;//消费金额下限
	
	private ArrayList<CommodityPO> alOfCommodity=new ArrayList<CommodityPO>();//赠品信息数组
	private double discountrate;//打折比例
	private double couponrate;//代金券赠送比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	private String operator;
	public ArrayList<CommodityPO> getAlOfCommodity() {
		return alOfCommodity;
	}
	public void setAlOfCommodity(ArrayList<CommodityPO> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
	}
	public double getDiscountrate() {
		return discountrate;
	}
	public void setDiscountrate(double discountrate) {
		this.discountrate = discountrate;
	}
	public double getCouponrate() {
		return couponrate;
	}
	public void setCouponrate(double couponrate) {
		this.couponrate = couponrate;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public int getLastTime() {
		return LastTime;
	}
	public void setLastTime(int lastTime) {
		LastTime = lastTime;
	}
	
	public LevelStrategyStyle getLevel_strategy_style() {
		return level_strategy_style;
	}
	public void setLevel_strategy_style(LevelStrategyStyle level_strategy_style) {
		this.level_strategy_style = level_strategy_style;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getLimit() {
		return Limit;
	}
	public void setLimit(double limit) {
		Limit = limit;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getOperator()
	{
		return operator;
	}
	public void setOperator(String operator)
	{
		this.operator = operator;
	}
}
