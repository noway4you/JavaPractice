package tw.test.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class timer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(),0,1000);
		timer.schedule(new StopTask(timer),5000);
		System.out.println("main");
	}
}

class MyTask extends TimerTask {
	private int i=1;
	@Override
	public void run(){
		System.out.println(i++);
	}
}

class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		System.out.println("stop");
		timer.purge();
		timer.cancel();
		timer = null;
	}
}