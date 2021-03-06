package businesslogic.examinebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AlertBillPO;
import po.BillState;
import po.BillStyle;
import po.CashPaymentPO;
import po.GiftBillPO;
import po.PaymentPO;
import po.PurBackSheetPO;
import po.PurSheetPO;
import po.ReceiptPO;
import po.SaleBackSheetPO;
import po.SaleSheetPO;
import po.SpillsLossBillPO;
import vo.AlertBillVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.Item;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.financialbillbl.TransferAccount;
import businesslogic.salebillbl.PurBackSheet;
import businesslogic.salebillbl.PurSheet;
import businesslogic.salebillbl.SaleBackSheet;
import businesslogic.salebillbl.SaleSheet;
import dataservice.billdataservice.CommodityBillSaverService;
import dataservice.billdataservice.FinancialBillSaverService;
import dataservice.billdataservice.SaleBillSaverService;

public class StubBillPool {



	private static ArrayList<StubGiftBill> alOfGiftBill=new ArrayList<StubGiftBill>();//change these 3 bill list to static to avoid a bug by lhw
	private static ArrayList<StubSpillsLossBill> alOfSpillsLossBill=new ArrayList<StubSpillsLossBill>();
	private static ArrayList<StubAlertBill> alOfAlertBill=new ArrayList<StubAlertBill>();
	private ArrayList<PurSheet> alOfPurSheet=new ArrayList<PurSheet>();
	private ArrayList<PurBackSheet> alOfPurBackSheet=new ArrayList<PurBackSheet>();
	private ArrayList<SaleSheet> alOfSaleSheet=new ArrayList<SaleSheet>();
	private ArrayList<SaleBackSheet> alOfSaleBackSheet=new ArrayList<SaleBackSheet>();
	private ArrayList<ReceiptBill> alOfReceiptBill=new ArrayList<ReceiptBill>();
	private ArrayList<PaymentBill> alOfPaymentBill=new ArrayList<PaymentBill>();
	private ArrayList<CashPaymentBill> alOfCashPaymentBill=new ArrayList<CashPaymentBill>();
	//读取文档中的对象
	//SaleBillSaverService sbs=new SaleBillSaver();
	//FinancialBillSaverService fbs=new FinancialBillSaver();
	//CommodityBillSaverService cbs=new CommodityBillSaver();
	/*构造函数*/
	public StubBillPool(){
	
		

//		清除保存的记录
//		save();
		
		read();
		
	}
	
	/*需要向单据池中加入一张库存赠送单*/
	public void add (StubGiftBill gb){
		read();
		alOfGiftBill.add(gb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张报溢/报损单*/
	public void add (StubSpillsLossBill spb){
		read();
		alOfSpillsLossBill.add(spb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张库存报警单*/
	public void add (StubAlertBill ab){
		//read();deleted by lhw
		alOfAlertBill.add(ab);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张进货单*/
	public void add (PurSheet ps){
		read();
		alOfPurSheet.add(ps);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张进货退货单*/
	public void add (PurBackSheet pbs){
		read();
		alOfPurBackSheet.add(pbs);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张销售单*/
	public void add (SaleSheet ss){
		read();
		alOfSaleSheet.add(ss);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张销售退货单*/
	public void add (SaleBackSheet sbs){
		read();
		alOfSaleBackSheet.add(sbs);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张收款单*/
	public void add (ReceiptBill rb){
		read();
		alOfReceiptBill.add(rb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张付款单*/
	public void add (PaymentBill pb){
		read();
		alOfPaymentBill.add(pb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张现金费用单*/
	public void add (CashPaymentBill cpb){
		read();
		alOfCashPaymentBill.add(cpb);
		//保存
		this.save();
	}
	/*需要从单据池筛选指定状态的所有赠送单*/
	public ArrayList<StubGiftBill> getGiftBill (BillState st){
		read();
		ArrayList<StubGiftBill> result=new ArrayList<StubGiftBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubGiftBill temp:alOfGiftBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		return result;	
	}
	/*需要从单据池筛选指定状态的所有报溢/报损单*/
	public ArrayList<StubSpillsLossBill> getSpillsLossBill (BillState st){
		read();
		ArrayList<StubSpillsLossBill> result=new ArrayList<StubSpillsLossBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubSpillsLossBill temp:alOfSpillsLossBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有库存报警单*/
	public ArrayList<StubAlertBill> getAlertBill (BillState st){
		read();
		ArrayList<StubAlertBill> result=new ArrayList<StubAlertBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubAlertBill temp:alOfAlertBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有进货单*/
	public ArrayList<PurSheet> getPurSheet (BillState st){
		read();
		ArrayList<PurSheet> result=new ArrayList<PurSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(PurSheet temp:alOfPurSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<PurBackSheet> getPurBackSheet (BillState st){
		read();
		ArrayList<PurBackSheet> result=new ArrayList<PurBackSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(PurBackSheet temp:alOfPurBackSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<SaleSheet> getSaleSheet (BillState st){
		read();
		ArrayList<SaleSheet> result=new ArrayList<SaleSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(SaleSheet temp:alOfSaleSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<SaleBackSheet> getSaleBackSheet (BillState st){
		read();
		ArrayList<SaleBackSheet> result=new ArrayList<SaleBackSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(SaleBackSheet temp:alOfSaleBackSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<ReceiptBill> getReceiptBill (BillState st){
		read();
		ArrayList<ReceiptBill> result=new ArrayList<ReceiptBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(ReceiptBill temp:alOfReceiptBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;	
	}
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentBill> getPaymentBill (BillState st){
		read();
		ArrayList<PaymentBill> result=new ArrayList<PaymentBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(PaymentBill temp:alOfPaymentBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		return result;
	}
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentBill> getCashPaymentBill (BillState st){
		read();
		ArrayList<CashPaymentBill> result=new ArrayList<CashPaymentBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(CashPaymentBill temp:alOfCashPaymentBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}	
		return result;
	}
	/*获取单据池所有赠送单*/
	public ArrayList<StubGiftBill> getGiftBill (){
		read();
		return alOfGiftBill;	
	}
	/*获取单据池的所有报溢/报损单*/
	public ArrayList<StubSpillsLossBill> getSpillsLossBill (){
		read();
		return alOfSpillsLossBill;
	}
	/*获取单据池的所有库存报警单*/
	public ArrayList<StubAlertBill> getAlertBill (){
		//read();deleted by lhw
		return alOfAlertBill;
	}
	/*获取单据池的所有进货单*/
	public ArrayList<PurSheet> getPurSheet (){
		read();
		return alOfPurSheet;
	}
	/*获取单据池的所有进货退货单*/
	public ArrayList<PurBackSheet> getPurBackSheet (){
		read();
		return alOfPurBackSheet;
	}
	/*获取单据池的所有销售单*/
	public ArrayList<SaleSheet> getSaleSheet (){
		read();
		return alOfSaleSheet;
	}
	/*获取单据池的所有销售退货单*/
	public ArrayList<SaleBackSheet> getSaleBackSheet (){
		read();
		return alOfSaleBackSheet;
	}
	/*获取单据池的所有收款单*/
	public ArrayList<ReceiptBill> getReceiptBill (){
		read();
		return alOfReceiptBill;	
	}
	/*获取单据池的所有付款单*/
	public ArrayList<PaymentBill> getPaymentBill (){
		read();
		return alOfPaymentBill;
	}
	/*获取单据池的所有现金费用单*/
	public ArrayList<CashPaymentBill> getCashPaymentBill (){
		read();
		return alOfCashPaymentBill;
	}
   /*修改单据信息*/
	public void change(GiftBillVO gb){
		read();
		for(int i=0;i<alOfGiftBill.size();i++){
			if(alOfGiftBill.get(i).getID().equals(gb.getID())){//寻找相同编号
				//进行修改
				//修改赠品
				//转换vo成商品数组
				ArrayList<MockCommodity> gift=new ArrayList<MockCommodity>();
				for(int j=0;j<gb.getComs().size();j++){
					gift.add(new MockCommodity(gb.getComs().get(j)));
				}
				//进行修改
				alOfGiftBill.get(i).setComs(gift);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(SpillsLossBillVO slb){
		read();
		for(int i=0;i<alOfSpillsLossBill.size();i++){
			if(alOfSpillsLossBill.get(i).getID().equals(slb.getID())){//寻找相同编号
				//进行修改
				//修改报溢报损的商品数量
				alOfSpillsLossBill.get(i).setCom(new MockCommodity(slb.getCom()));
				//修改操作员
				alOfSpillsLossBill.get(i).setOperator(slb.getOperator());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(AlertBillVO ab){
		read();
		for(int i=0;i<alOfAlertBill.size();i++){
			if(alOfAlertBill.get(i).getID().equals(ab.getID())){//寻找相同编号
				//进行修改
				//暂定不能修改
			}
		}
		//保存
		this.save();
	}
	public void change(PurSheetVO ps){
		read();
		for(int i=0;i<alOfPurSheet.size();i++){
			if(alOfPurSheet.get(i).getid().equals(ps.getid())){//寻找相同编号
				//进行修改
				//修改客户
				alOfPurSheet.get(i).setCustomer(new Customer(ps.getcustomer()));//阿超改动了一下；如有问题，快来告诉我;
				//修改仓库
				alOfPurSheet.get(i).setstock(ps.getstock());
				//修改操作员
				alOfPurSheet.get(i).setop(ps.getop());
				//修改商品清单
				ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
				for(int j=0;j<ps.getsheet().size();j++){
					temp.add(new MockCommodity(ps.getsheet().get(j)));
				}
				alOfPurSheet.get(i).setsheet(temp);
				//修改总金额
				alOfPurSheet.get(i).setmoney1(ps.getmoney1());
				//修改备注
				alOfPurSheet.get(i).setwords(ps.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(PurBackSheetVO pbs){
		read();
		for(int i=0;i<alOfPurBackSheet.size();i++){
			if(alOfPurBackSheet.get(i).getid().equals(pbs.getid())){//寻找相同编号
				//进行修改
				//修改客户
				alOfPurBackSheet.get(i).setCustomer(new Customer(pbs.getcustomer()));//阿超改动了一下；如有问题，快来告诉我;
				//修改仓库
				alOfPurBackSheet.get(i).setstock(pbs.getstock());
				//修改操作员
				alOfPurBackSheet.get(i).setop(pbs.getop());
				//修改商品清单
				ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
				for(int j=0;j<pbs.getsheet().size();j++){
					temp.add(new MockCommodity(pbs.getsheet().get(j)));
				}
				alOfPurBackSheet.get(i).setsheet(temp);
				//修改总金额
				alOfPurBackSheet.get(i).setmoney1(pbs.getmoney1());
				//修改备注
				alOfPurBackSheet.get(i).setwords(pbs.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(SaleSheetVO ss){
		read();
		for(int i=0;i<alOfSaleSheet.size();i++){
			if(alOfSaleSheet.get(i).getid().equals(ss.getid())){//寻找相同编号
				//进行修改
				//修改客户
				alOfSaleSheet.get(i).setCustomer(new Customer(ss.getcustomer()));//阿超改动了一下；如有问题，快来告诉我;
				//修改仓库
				alOfSaleSheet.get(i).setstock(ss.getstock());
				//修改操作员
				alOfSaleSheet.get(i).setop(ss.getop());
				//修改商品清单
				ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
				for(int j=0;j<ss.getsheet().size();j++){
					temp.add(new MockCommodity(ss.getsheet().get(j)));
				}
				alOfSaleSheet.get(i).setsheet(temp);
				//修改总金额
				alOfSaleSheet.get(i).setmoney1(ss.getmoney1());
				//修改使用代金券
				alOfSaleSheet.get(i).setpmoney(ss.getpmoney());
				//修改折让金额
				alOfSaleSheet.get(i).setdiscount(ss.getdiscount());
				//修改最终金额
				alOfSaleSheet.get(i).setmoney2(ss.getmoney2());
				//修改备注
				alOfSaleSheet.get(i).setwords(ss.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(SaleBackSheetVO sbs){
		read();
		for(int i=0;i<alOfSaleBackSheet.size();i++){
			if(alOfSaleBackSheet.get(i).getid().equals(sbs.getid())){//寻找相同编号
				//进行修改
				//修改客户
				alOfSaleBackSheet.get(i).setCustomer(new Customer(sbs.getcustomer()));//阿超改动了一下；如有问题，快来告诉我;
				//修改仓库
				alOfSaleBackSheet.get(i).setstock(sbs.getstock());
				//修改操作员
				alOfSaleBackSheet.get(i).setop(sbs.getop());
				//修改商品清单
				ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
				for(int j=0;j<sbs.getsheet().size();j++){
					temp.add(new MockCommodity(sbs.getsheet().get(j)));
				}
				alOfSaleBackSheet.get(i).setsheet(temp);
				//修改总金额
				alOfSaleBackSheet.get(i).setmoney1(sbs.getmoney1());
				//修改使用代金券
				alOfSaleBackSheet.get(i).setpmoney(sbs.getpmoney());
				//修改折让金额
				alOfSaleBackSheet.get(i).setdiscount(sbs.getdiscount());
				//修改最终金额
				alOfSaleBackSheet.get(i).setmoney2(sbs.getmoney2());
				//修改备注
				alOfSaleBackSheet.get(i).setwords(sbs.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(ReceiptVO rb){
		read();
		for(int i=0;i<alOfReceiptBill.size();i++){
			if(alOfReceiptBill.get(i).getID().equals(rb.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfReceiptBill.get(i).setCustomer(rb.getCustomer());
				//修改操作员
				alOfReceiptBill.get(i).setOp(rb.getOp());
				//修改总额
				alOfReceiptBill.get(i).setTotal(rb.getTotal());
				//修改转账列表
				ArrayList<String> account = rb.getAccounts();
				ArrayList<Double> money = rb.getMoney();
				ArrayList<String> remark = rb.getRemark();
				ArrayList<TransferAccount> transferlist = new ArrayList<TransferAccount>();
				int length = account.size();
				for(int j=0;j<length;j++) {
					transferlist.add(new TransferAccount(account.get(j), money.get(j), remark.get(j)));
				}
				alOfReceiptBill.get(i).setTransferlist(transferlist);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(PaymentVO pb){
		read();
		for(int i=0;i<alOfPaymentBill.size();i++){
			if(alOfPaymentBill.get(i).getID().equals(pb.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfPaymentBill.get(i).setCustomer(pb.getCustomer());
				//修改操作员
				alOfPaymentBill.get(i).setOp(pb.getOp());
				//修改总额
				alOfPaymentBill.get(i).setTotal(pb.getTotal());
				//修改转账列表
				ArrayList<String> account = pb.getAccounts();
				ArrayList<Double> money = pb.getMoney();
				ArrayList<String> remark = pb.getRemark();
				ArrayList<TransferAccount> transferlist = new ArrayList<TransferAccount>();
				int length = account.size();
				for(int j=0;j<length;j++) {
					transferlist.add(new TransferAccount(account.get(j), money.get(j), remark.get(j)));
				}
				alOfReceiptBill.get(i).setTransferlist(transferlist);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(CashPaymentVO cb){
		read();
		for(int i=0;i<alOfCashPaymentBill.size();i++){
			System.out.println(alOfCashPaymentBill.get(i).getID()+":"+cb.getID());
			if(alOfCashPaymentBill.get(i).getID().equals(cb.getID())){//寻找相同编号
				//进行修改
				//修改银行账户
				alOfCashPaymentBill.get(i).setAccount(cb.getAccount());
				//修改操作员
				alOfCashPaymentBill.get(i).setOp(cb.getOp());
				//修改总额
				alOfCashPaymentBill.get(i).setTotal(cb.getTotal());
				//修改条目清单
				ArrayList<String> item = cb.getItem();
				ArrayList<Double> money=cb.getMoney(); 
				ArrayList<String> remark=cb.getRemark();
				ArrayList<Item> itemList = new ArrayList<Item>();
				int length = item.size();
				for(int j=0;j<length;j++) {
					itemList.add(new Item(item.get(j), money.get(j), remark.get(j)));
				}
				alOfCashPaymentBill.get(i).setItemList(itemList);
				//修改完毕
				System.out.println("现金费用单修改完毕");
				break;
			}
		}
		//保存
		this.save();
	}
	/*改单据状态*/
	public void transformState(BillStyle style,String ID,BillState state){
		read();
		switch(style){
		case GiftBill:
			for(int i=0;i<alOfGiftBill.size();i++){
				if(alOfGiftBill.get(i).getID().equals(ID)){
					alOfGiftBill.get(i).setState(state);
				}
			}
			break;
		case SpillsLossBill:
			for(int i=0;i<alOfSpillsLossBill.size();i++){
				if(alOfSpillsLossBill.get(i).getID().equals(ID)){
					alOfSpillsLossBill.get(i).setState(state);
				}
			}
			break;
		case AlertBill:
			for(int i=0;i<alOfAlertBill.size();i++){
				if(alOfAlertBill.get(i).getID().equals(ID)){
					alOfAlertBill.get(i).setState(state);
				}
			}
			break;
		case PurSheet:
			for(int i=0;i<alOfPurSheet.size();i++){
				System.out.println(ID+" : "+alOfPurSheet.get(i).getid());
				if(alOfPurSheet.get(i).getid().equals(ID)){
					alOfPurSheet.get(i).setState(state);
				}
			}
			break;
		case PurBackSheet:
			for(int i=0;i<alOfPurBackSheet.size();i++){
				if(alOfPurBackSheet.get(i).getid().equals(ID)){
					alOfPurBackSheet.get(i).setState(state);
				}
			}
			break;
		case SaleSheet:
			for(int i=0;i<alOfSaleSheet.size();i++){
				if(alOfSaleSheet.get(i).getid().equals(ID)){
					alOfSaleSheet.get(i).setState(state);
				}
			}
			break;
		case SaleBackSheet:
			for(int i=0;i<alOfSaleBackSheet.size();i++){
				if(alOfSaleBackSheet.get(i).getid().equals(ID)){
					alOfSaleBackSheet.get(i).setState(state);
				}
			}
			break;
		case ReceiptBill:
			for(int i=0;i<alOfReceiptBill.size();i++){
				System.out.println(alOfReceiptBill.get(i).getID()+":"+ID);
				if(alOfReceiptBill.get(i).getID().equals(ID)){
					System.out.println("找到并修改");
					alOfReceiptBill.get(i).setState(state);
				}
			}
			break;
		case PaymentBill:
			for(int i=0;i<alOfPaymentBill.size();i++){
				if(alOfPaymentBill.get(i).getID().equals(ID)){
					alOfPaymentBill.get(i).setState(state);
				}
			}
			break;
		case CashPaymentBill:
			for(int i=0;i<alOfCashPaymentBill.size();i++){
				if(alOfCashPaymentBill.get(i).getID().equals(ID)){
					alOfCashPaymentBill.get(i).setState(state);
				}
			}
			break;
			
		}
		//保存
		save();
	}
	/*实时读取池中数组对象*/
	public void read(){
		alOfGiftBill.clear();
		alOfSpillsLossBill.clear();
		alOfAlertBill.clear();
		alOfPurSheet.clear();
		alOfPurBackSheet.clear();
		alOfSaleSheet.clear();
		alOfSaleBackSheet.clear();
		alOfReceiptBill.clear();
		alOfPaymentBill.clear();
		alOfCashPaymentBill.clear();
		//将返回的PO对象的信息传入真正的单据对象
		//赠送单
		ArrayList<GiftBillPO> GiftBillListPO = null;
		try {
			CommodityBillSaverService cbs = null;
			try
			{
				cbs = (CommodityBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/CommodityBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			GiftBillListPO = cbs.getGiftBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(GiftBillListPO!=null){
			for(GiftBillPO tempPO:GiftBillListPO){
				StubGiftBill gb=new StubGiftBill();
				gb.setPO(tempPO);
				alOfGiftBill.add(gb);
			}
		}
		//报警单
		ArrayList<AlertBillPO> AlertBillListPO = null;
		try {
			CommodityBillSaverService cbs = null;
			try
			{
				cbs = (CommodityBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/CommodityBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			AlertBillListPO = cbs.getAlertBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(AlertBillListPO!=null){
			for(AlertBillPO tempPO:AlertBillListPO){
				StubAlertBill ab=new StubAlertBill();
				ab.setPO(tempPO);
				alOfAlertBill.add(ab);
			}
		}
		//报溢报损单
		ArrayList<SpillsLossBillPO> SpillsLossBillListPO = null;
		try {
			CommodityBillSaverService cbs = null;
			try
			{
				cbs = (CommodityBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/CommodityBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			SpillsLossBillListPO = cbs.getSpillsLossBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(SpillsLossBillListPO!=null){
			for(SpillsLossBillPO tempPO:SpillsLossBillListPO){
				StubSpillsLossBill slb=new StubSpillsLossBill();
				slb.setPO(tempPO);
				alOfSpillsLossBill.add(slb);
			}
		}
		//进货单
		ArrayList<PurSheetPO> PurSheetListPO = null;
		try {
			SaleBillSaverService sbs = null;
			try
			{
				sbs = (SaleBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/SaleBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			PurSheetListPO = sbs.getPurSheet();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(PurSheetListPO!=null){
			for(PurSheetPO tempPO:PurSheetListPO){
				PurSheet ps=new PurSheet();
				ps.setPO(tempPO);
				alOfPurSheet.add(ps);
			}
		}
		//进货退货单
		ArrayList<PurBackSheetPO> PurBackSheetListPO = null;
		try {
			SaleBillSaverService sbs = null;
			try
			{
				sbs = (SaleBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/SaleBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			PurBackSheetListPO = sbs.getPurBackSheet();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(PurBackSheetListPO!=null){
			for(PurBackSheetPO tempPO:PurBackSheetListPO){
				PurBackSheet pbs=new PurBackSheet();
				pbs.setPO(tempPO);
				alOfPurBackSheet.add(pbs);
			}
		}
		//销售单
		ArrayList<SaleSheetPO> SaleSheetListPO = null;
		try {
			SaleBillSaverService sbs = null;
			try
			{
				sbs = (SaleBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/SaleBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			SaleSheetListPO = sbs.getSaleSheet();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(SaleSheetListPO!=null){
			for(SaleSheetPO tempPO:SaleSheetListPO){
				SaleSheet ss=new SaleSheet();
				ss.setPO(tempPO);
				alOfSaleSheet.add(ss);
			}
		}
		//销售退货单
		ArrayList<SaleBackSheetPO> SaleBackSheetListPO = null;
		try {
			SaleBillSaverService sbs = null;
			try
			{
				sbs = (SaleBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/SaleBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			SaleBackSheetListPO = sbs.getSaleBackSheet();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(SaleBackSheetListPO!=null){
			for(SaleBackSheetPO tempPO:SaleBackSheetListPO){
				SaleBackSheet salebs=new SaleBackSheet();
				salebs.setPO(tempPO);
				alOfSaleBackSheet.add(salebs);
			}
		}
		//收款单
		ArrayList<ReceiptPO> ReceiptBillListPO = null;
		try {
			FinancialBillSaverService fbs = null;
			try
			{
				fbs = (FinancialBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/FinancialBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			ReceiptBillListPO = fbs.getReceipt();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(ReceiptBillListPO!=null){
			for(ReceiptPO tempPO:ReceiptBillListPO){
				ReceiptBill rcb=new ReceiptBill();
				rcb.setPO(tempPO);
				alOfReceiptBill.add(rcb);
			}
		}
		//付款单
		ArrayList<PaymentPO> PaymentBillListPO = null;
		try {
			FinancialBillSaverService fbs = null;
			try
			{
				fbs = (FinancialBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/FinancialBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			PaymentBillListPO = fbs.getPayment();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(PaymentBillListPO!=null){
			for(PaymentPO tempPO:PaymentBillListPO){
				PaymentBill pmb=new PaymentBill();
				pmb.setPO(tempPO);
				alOfPaymentBill.add(pmb);
			}
		}
		//现金费用单
		ArrayList<CashPaymentPO> CashPaymentBillListPO = null;
		try {
			FinancialBillSaverService fbs = null;
			try
			{
				fbs = (FinancialBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/FinancialBillSaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			CashPaymentBillListPO = fbs.getCashPayment();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(CashPaymentBillListPO!=null){
			for(CashPaymentPO tempPO:CashPaymentBillListPO){
				CashPaymentBill cpb=new CashPaymentBill();
				cpb.setPO(tempPO);
				alOfCashPaymentBill.add(cpb);
			}
		}

	}
	/*实时保存池中数组对象*/
	public void save(){
		//保存文档中的对象
		SaleBillSaverService sbs = null;
		try
		{
			sbs = (SaleBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/SaleBillSaver");
		}
		catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		}
		catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		catch (NotBoundException e1)
		{
			e1.printStackTrace();
		}
		//SaleBillSaverService sbs=new SaleBillSaver();
		FinancialBillSaverService fbs = null;
		try
		{
			fbs = (FinancialBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/FinancialBillSaver");
		}
		catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		}
		catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		catch (NotBoundException e1)
		{
			e1.printStackTrace();
		}
		//FinancialBillSaverService fbs=new FinancialBillSaver();
		CommodityBillSaverService cbs = null;
		try
		{
			cbs = (CommodityBillSaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/CommodityBillSaver");
		}
		catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		}
		catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		catch (NotBoundException e1)
		{
			e1.printStackTrace();
		}
		//CommodityBillSaverService cbs=new CommodityBillSaver();
		
		//赠送单
		ArrayList<GiftBillPO> GiftBillPO=new ArrayList<GiftBillPO>();
		for(StubGiftBill temp:alOfGiftBill){//遍历数组，将对应PO对象加到新数组中
			GiftBillPO.add(temp.getPO());
		}
		try {
			cbs.saveGiftBill(GiftBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//报溢报损单
		ArrayList<SpillsLossBillPO> SpillsLossBillPO=new ArrayList<SpillsLossBillPO>();
		for(StubSpillsLossBill temp:alOfSpillsLossBill){//遍历数组，将对应PO对象加到新数组中
			SpillsLossBillPO.add(temp.getPO());
		}
		try {
			cbs.saveSpillsLossBill(SpillsLossBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//报警单
		ArrayList<AlertBillPO> AlertBillPO=new ArrayList<AlertBillPO>();
		for(StubAlertBill temp:alOfAlertBill){//遍历数组，将对应PO对象加到新数组中
			AlertBillPO.add(temp.getPO());
		}
		try {
			cbs.saveAlertBill(AlertBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		};//保存PO数组到txt
		//进货单
		ArrayList<PurSheetPO> PurSheetPO=new ArrayList<PurSheetPO>();
		for(PurSheet temp:alOfPurSheet){//遍历数组，将对应PO对象加到新数组中
			PurSheetPO.add(temp.getPO());
		}
		try {
			sbs.savePurSheet(PurSheetPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//进货退货单
		ArrayList<PurBackSheetPO> PurBackSheetPO=new ArrayList<PurBackSheetPO>();
		for(PurBackSheet temp:alOfPurBackSheet){//遍历数组，将对应PO对象加到新数组中
			PurBackSheetPO.add(temp.getPO());
		}
		try {
			sbs.savePurBackSheet(PurBackSheetPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt

		//销售单
		ArrayList<SaleSheetPO> SaleSheetPO=new ArrayList<SaleSheetPO>();
		for(SaleSheet temp:alOfSaleSheet){//遍历数组，将对应PO对象加到新数组中
			SaleSheetPO.add(temp.getPO());
		}
		try {
			sbs.saveSaleSheet(SaleSheetPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//销售退货单
		ArrayList<SaleBackSheetPO> SaleBackSheetPO=new ArrayList<SaleBackSheetPO>();
		for(SaleBackSheet temp:alOfSaleBackSheet){//遍历数组，将对应PO对象加到新数组中
			SaleBackSheetPO.add(temp.getPO());
		}
		try {
			sbs.saveSaleBackSheet(SaleBackSheetPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//收款单
		ArrayList<ReceiptPO> ReceiptBillPO=new ArrayList<ReceiptPO>();
		for(ReceiptBill temp:alOfReceiptBill){//遍历数组，将对应PO对象加到新数组中
			ReceiptBillPO.add(temp.getPO());
		}
		try {
			fbs.saveReceipt(ReceiptBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//收款单
		ArrayList<PaymentPO> PaymentBillPO=new ArrayList<PaymentPO>();
		for(PaymentBill temp:alOfPaymentBill){//遍历数组，将对应PO对象加到新数组中
			PaymentBillPO.add(temp.getPO());
		}
		try {
			fbs.savePayment(PaymentBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//收款单
		ArrayList<CashPaymentPO> CashPaymentBillPO=new ArrayList<CashPaymentPO>();
		for(CashPaymentBill temp:alOfCashPaymentBill){//遍历数组，将对应PO对象加到新数组中
			CashPaymentBillPO.add(temp.getPO());
		}
		try {
			fbs.saveCashPayment(CashPaymentBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
	}
}
