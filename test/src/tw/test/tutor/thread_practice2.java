package tw.test.tutor;

public class thread_practice2 {

	public static void main(String[] args) {
		Store store = new Store();
		Producer producer = new Producer(store);
		Consumer consumer1 = new Consumer(store,"A");
		Consumer consumer2 = new Consumer(store,"B");
		Consumer consumer3 = new Consumer(store,"C");
		producer.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}
}

class Store {
	private int qty;
	private int max;
	Store(){
		max = 10;
	}
	
	synchronized void add(int add) throws InterruptedException {
		System.out.printf("準備進貨: %d\n", add);
		while (qty + add > max) {
			wait();
		}
		qty += add;
		System.out.printf("完成進貨: %d, 目前庫存: %d\n", add, qty);
		notify();
	}
	
	synchronized void buy(int buy, String name) throws InterruptedException{
		System.out.printf("%s想買: %d\n", name, buy);
		while (qty < buy) {
			wait();
		}
		qty -= buy;
		System.out.printf("完成賣出: %d, 目前庫存: %d\n", buy, qty);
		notify();
	}
}

class Producer extends Thread {
	private Store store;
	public Producer(Store store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.add(5);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

class Consumer extends Thread {
	private Store store;
	private String name;
	public Consumer(Store store, String name) {
		this.store = store;
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.buy((int)(Math.random()*3)+1, name);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}