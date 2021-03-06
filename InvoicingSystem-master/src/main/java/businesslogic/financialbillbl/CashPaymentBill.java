package businesslogic.financialbillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.GetVOandPO;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbl.Financial;
import businesslogic.financialbl.ServiceForUpdateMoney;
import po.BillState;
import po.BillStyle;
import po.CashPaymentPO;
import po.PO;
import po.ReceiptPO;
import po.Role;
import presentation.userui.Login;
import vo.VO;
import vo.financialBillVO.CashPaymentVO;
import vo.uservo.UserVO;

public class CashPaymentBill extends Bill implements GetVOandPO{
	
	private Role role ;//权限
	
	private BillStyle billstyle=BillStyle.CashPaymentBill;
	private String ID;
	private String account;	
	private double total;
	private BillState state;
	private Date date;	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private String op;//操作员 userName+userID
	
	public CashPaymentBill() {}
	public CashPaymentBill(CashPaymentVO vo) { 
		ArrayList<String> item = vo.getItem();
		ArrayList<Double> money=vo.getMoney(); 
		ArrayList<String> remark=vo.getRemark();
		    
		int length = item.size();
		for(int i=0;i<length;i++) {
			itemList.add(new Item(item.get(i), money.get(i), remark.get(i)));
		}
		this.account = vo.getAccount();
		this.total = vo.getTotal();
		this.role = vo.getRole();
		state = vo.getBillState();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		this.date = new Date();
		StubBillPool pool = new StubBillPool();
		ArrayList<CashPaymentBill> list = pool.getCashPaymentBill();
		ID = "XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		
		op = vo.getOp();
	}
	
	public String getOperator() {
		return this.op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role r) {
		this.role = r;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		ServiceForUpdateMoney f = new Financial();
		if(state == BillState.OVER) {
			int size = itemList.size();
			for(int i=0;i<size;i++) {
				Item temp = itemList.get(i);
				f.updateCashPaymentMoney(account, temp.getMoney());
			}
		} 
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	public CashPaymentVO getVO() {
		CashPaymentVO vo = new CashPaymentVO();
		vo.setAccount(account);
		vo.setID(ID);
		vo.setTotal(total);
		int size = itemList.size();
		ArrayList<String> item = new ArrayList<String>();
		ArrayList<String> remark = new ArrayList<String>();
		ArrayList<Double> money = new ArrayList<Double>();
		for(int i=0;i<size;i++) {
			Item temp = itemList.get(i);
			item.add(temp.getItemName());
			money.add(temp.getMoney());
			remark.add(temp.getRemark());
		}
		vo.setItem(item);
		vo.setMoney(money);
		vo.setRemark(remark);
		vo.setRole(role);
		vo.setBillStyle(billstyle);
		vo.setBillState(state);	
		vo.setOp(op);
		vo.setDate(date);
		return vo;
	}
	
	public CashPaymentPO getPO() {
		CashPaymentPO po = new CashPaymentPO();
		po.setAccount(account);
		po.setID(ID);
		int size = itemList.size();
		Item temp=null;
		ArrayList<String> item = new ArrayList<String>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> remark = new ArrayList<String>();				
		for(int i=0;i<size;i++){
			temp = itemList.get(i);
			item.add(temp.getItemName());
			money.add(temp.getMoney());
			remark.add(temp.getRemark());
		}
		po.setItems(item);
		po.setMoney(money);
		po.setRemark(remark);
		po.setRole(role);
		po.setState(state);
		po.setStyle(billstyle);
		po.setTotal(total);
		po.setDate(date);
		po.setOp(op);
		return po;
	}
	
	public void setPO (CashPaymentPO po) {
		ID = po.getID();
		account = po.getAccount();
		total = po.getTotal();
		state = po.getState();
		billstyle = po.getStyle();
		ArrayList<String> item = po.getItems();
		ArrayList<Double> money=po.getMoney(); 
		ArrayList<String> remark=po.getRemark();
		    
		int length = item.size();
		for(int i=0;i<length;i++) {
			itemList.add(new Item(item.get(i), money.get(i), remark.get(i)));
		}
		role = po.getRole();
		date = po.getDate();
		op = po.getOp();
	}
}
