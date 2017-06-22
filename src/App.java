import java.io.FileFilter;

public class App {

	public static void main(String[] args) throws InterruptedException {
		OperationClass operationClass=new OperationClass();
        Thread thread1=new Thread(new Runnable() {
			@Override
				public void run() {
				try {
					operationClass.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					}
				 });
 
        Thread thread2=new Thread(new Runnable() {
			@Override
				public void run() {
				try {
					operationClass.secoundThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					}
				 });
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        operationClass.finalOutput();
        
			}
}
