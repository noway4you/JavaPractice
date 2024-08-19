package tw.test.tutor;

public class thread_practice3 {

	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		t2.join();
		
		System.out.println("Main finished !");
	}
}

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread1 start working ... ");
		try {
			sleep(3000);
		} catch (InterruptedException e) {}
		System.out.println("Thread1 finished !");
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread2 start working ... ");
		try {
			sleep(5000);
		} catch (InterruptedException e) {}
		System.out.println("Thread2 finished !");
	}
}