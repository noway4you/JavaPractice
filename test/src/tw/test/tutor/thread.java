package tw.test.tutor;

public class thread {

	public static void main(String[] args) {
		MyThread mt = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyRunnable mr = new MyRunnable("C");
		Thread t = new Thread(mr);
		
		mt.start();
		mt2.start();
		t.start();
		System.out.println("ok");
	}

}

class MyThread extends Thread{
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				sleep(5000);
				System.out.println(name + " => " + i + " ");
			} catch (Exception e) {
				System.out.println("error => " + e);
			}
		}
		
	}
}

class MyRunnable implements Runnable{
	private String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(5000);
				System.out.println(name + " => " + i + " ");
			} catch (Exception e) {
				System.out.println("error => " + e);
			}
		}
		
	}
}