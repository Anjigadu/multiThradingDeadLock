import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OperationClass {
	
	Account account1=new Account();
	Account account2=new Account();
	int totalAmount=0;
	
	ReentrantLock lock1=new ReentrantLock();
	ReentrantLock lock2=new ReentrantLock();
	
	
	private void aquireLock(ReentrantLock flock,ReentrantLock slock) throws InterruptedException{
		while(true){
			boolean	firstLocak =flock.tryLock();
			boolean secondlock =slock.tryLock();
			
			if(firstLocak && firstLocak){
				return;
			}
				if(firstLocak){
					flock.unlock();
				}
					if(secondlock){
					slock.unlock();
				     }
					Thread.sleep(1);
					
			 }
	}
	public void firstThread() throws InterruptedException{
		
			for(int i=0;i<10000;i++){
				aquireLock(lock1,lock2);
				try{
				Random random=new Random();
				account1.Transfer(account1, account2, random.nextInt(100));
				
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
	    }
		
	}
	public void secoundThread() throws InterruptedException{
		
		for(int i=0;i<10000;i++){
			aquireLock(lock2,lock1);
			try{
			Random random=new Random();
			account1.Transfer(account2, account1, random.nextInt(100));
			
		  }finally{
					lock2.unlock();
					lock1.unlock();
			}
		}
		
			
	   }
	public void finalOutput(){
		System.out.println("Account 1 balance is "+(account1.getBalance()));
		System.out.println("Account 2  balance is "+(account2.getBalance()));
		System.out.println("Total Amount is "+(account1.getBalance()+account2.getBalance()));
	}

}
