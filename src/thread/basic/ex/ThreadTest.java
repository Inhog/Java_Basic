package thread.basic.ex;

public class ThreadTest {

	public static void main(String[] args) {
		MakeBus mb1 = new MakeBus("버스틀 만들기");
		//mb1.run();
		mb1.start();		// 3. start() 호출
		/*MakeBus mb2 = new MakeBus("엔진부착");
		//mb2.run();
		mb2.start();*/
		new MakeBus("엔진부착").start();
		MakeBus mb3 = new MakeBus("출고");
		//mb2.run();
		mb3.start();
		
		
	}

}

// 1. Thread 클래스 상속
class MakeBus extends Thread{
	String work;
	MakeBus(String work){
		 this.work = work;
	}
	// 2. run() overriding
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(this.work+"작업중");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}