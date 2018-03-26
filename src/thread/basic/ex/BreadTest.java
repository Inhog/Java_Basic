package thread.basic.ex;

class Bread 
{
	String bread;
	boolean isChecked = false;
	public void setBread( String bread )
	{
		isChecked = true;
		// Block 상태에 올라가있는 모든 쓰레드를 불러옴
		synchronized (this){
			notifyAll();
			}
		this.bread = bread;
	}	

	public String getBread()
	{
		if(isChecked == false){
			// 우선 기다려야함. 빵이 생길때까지?
			try {
				synchronized (this){
				wait();
				}
			} catch (InterruptedException e) {	}
		}
		return bread;
	}
}

class Baker extends Thread
{
	Bread bbang;

	Baker( Bread bbang )
	{
		this.bbang = bbang;
	}
	
	public void run()
	{
		bbang.setBread("맛있는 빵");
	}
}

class Customer extends Thread
{
	Bread bbang;

	Customer( Bread bbang )
	{
		this.bbang = bbang;
	}
	
	public void run()
	{
		System.out.println("빵을 사감 : " + bbang.getBread());
	}
}

class BreadTest
{
	public static void main(String[] args) 
	{
		Bread  bread = new Bread();

		Baker  baker = new Baker( bread );
		Customer customer = new Customer( bread );

		
		customer.start();
		baker.start();

		try{
			customer.join();
			baker.join();			
		}catch( Exception ex ){}

	}
}
