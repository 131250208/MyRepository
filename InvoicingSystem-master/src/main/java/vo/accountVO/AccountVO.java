package vo.accountVO;

public class AccountVO {
	String name;
	double balance;
	
	public AccountVO(){}
	public AccountVO(String n, double bal) {
		this.name = n;
		this.balance = bal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
