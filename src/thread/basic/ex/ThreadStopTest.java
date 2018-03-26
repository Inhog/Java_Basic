package thread.basic.ex;

public class ThreadStopTest {

	public static void main(String[] args) {
		
		System.out.println("메인쓰레드 : " + Thread.currentThread().getName());
		MyThread mt = new MyThread();
		mt.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("쓰레드 종료!");
		// Deprecated
//		mt.stop();
		mt.flag = true;
	}

}

class MyThread extends Thread{
	boolean flag = false;
	public void run(){
		while(!flag){
		System.out.println(getName() + "작업중");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		} catch (ThreadDeath e){
			System.out.println("Exception by method stop()");
		}
		}
	}
}