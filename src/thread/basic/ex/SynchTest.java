package thread.basic.ex;

class Count{
	int i;
	// synchronized를 통해 하나의 쓰레드가 동작할때 다른 쓰레드는 접근하지 못하게 한다.
	synchronized void increment(){
		// 반드시 객체하나를 넣어줘야 한다.
		// 메소드 안에 다른 코딩이 많은경우 필요한 부분에만 블락을 사용하여 지정해 줄 수 있다.
		synchronized(this){
		i++;
		}
	}
}

class ThreadCount extends Thread{
	Count cnt;
	ThreadCount(Count _cnt){	cnt = _cnt;}
	public void run(){
		for(int i=0;i<100000000;i++){
			cnt.increment();
		}
	}
}
public class SynchTest {

	public static void main(String[] args) {
		Count count = new Count();
		ThreadCount tc1 = new ThreadCount( count );
		ThreadCount tc2 = new ThreadCount( count );
		
		tc1.start();
		tc2.start();
		try {
			tc1.join();
//			tc2.join();
			System.out.println("tc1 terminated : " + count.i);
		} catch (InterruptedException e){
		}
		System.out.println("tc1 끝나고 쪼금 시간 지난뒤에 :" + count.i);
		
		try {
//			tc1.join();
			tc2.join();
			System.out.println("tc2 terminated : " + count.i);
		} catch (InterruptedException e){
		}
	}
}
