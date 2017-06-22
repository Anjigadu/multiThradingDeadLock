
public class Account {
	private int balance=10000;
	
	public void withdraw(int amount){
		balance=balance-amount;
	}
	
	public void deposite(int amount){
		balance=balance+amount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void Transfer(Account account1,Account account2,int amount){
		account1.withdraw(amount);
		account2.deposite(amount);
	}

}
