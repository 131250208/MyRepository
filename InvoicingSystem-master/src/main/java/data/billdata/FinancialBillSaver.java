package data.billdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CashPaymentPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.Tool;
import dataservice.billdataservice.FinancialBillSaverService;


public class FinancialBillSaver extends UnicastRemoteObject implements FinancialBillSaverService{

	/*构造函数*/
	public FinancialBillSaver()throws RemoteException{
		
	}
	/*保存付款单*/
	public void savePayment(ArrayList<PaymentPO> pb)throws RemoteException{
		String filename = "PaymentPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(pb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*保存收款单*/
	public void saveReceipt(ArrayList<ReceiptPO> rb)throws RemoteException{
		String filename = "ReceiptPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(rb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*保存现金费用单*/
	public void saveCashPayment(ArrayList<CashPaymentPO> cpb)throws RemoteException{
		String filename = "CashPaymentPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(cpb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*获取付款单*/
	public ArrayList<PaymentPO> getPayment()throws RemoteException{
		File filename = Tool.Opendoc("PaymentPO.txt");
		
		ArrayList<PaymentPO> paymentbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			paymentbillList = (ArrayList<PaymentPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(paymentbillList!=null) return paymentbillList;
		else return null;
		
		
	}
	/*获取收款单*/
	public ArrayList<ReceiptPO> getReceipt() throws RemoteException{
		File filename = Tool.Opendoc("ReceiptPO.txt");
		
		ArrayList<ReceiptPO> receiptbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			receiptbillList = (ArrayList<ReceiptPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(receiptbillList!=null) return receiptbillList;
		else return null;
		
		
	}
	/*获取现金费用单*/
	public ArrayList<CashPaymentPO> getCashPayment()throws RemoteException{
		File filename = Tool.Opendoc("CashPaymentPO.txt");
		
		ArrayList<CashPaymentPO> cashpaymentbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			cashpaymentbillList = (ArrayList<CashPaymentPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(cashpaymentbillList!=null) return cashpaymentbillList;
		else return null;
		
		
	}
	
	
}
