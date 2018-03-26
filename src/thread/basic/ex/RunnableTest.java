package thread.basic.ex;

public class RunnableTest {

	public static void main(String[] args) {
		MakeTaxi m1 = new MakeTaxi("택시틀 만들기");
		Thread t1 = new Thread(m1);
		t1.start();
		
		new Thread(new MakeTaxi("엔진부착")).start();
		
		/*
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}*/
		
		System.out.println("Process Terminated");
	}

}


//1. Runnable 구현
class MakeTaxi extends Object implements Runnable{
	String work;
	MakeTaxi(String work){
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