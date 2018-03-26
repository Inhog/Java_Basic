package thread.basic.ex;

import java.awt.*;
import javax.swing.*;


public class DalTest extends Frame {
	
	Dal a, b, c;
	
	public DalTest()
	{
		setSize( 500, 400 );
		setVisible( true );

		a = new Dal(this, 0, 50);
		// implements Runnable 하면 
		// Thread t1 = new Thread(a) ; t1.start();
		//a.start()로 해라!!!
		//바로 run() 하는게 아님.
		a.start();
		b = new Dal(this, 0, 100);
		b.start();
		c = new Dal(this, 0, 150);
		c.start();
		
		// # 
		// (3)각 객체의 쓰레드 메소드(run) 호출한다 
		
	}	
	


	public void paint( Graphics g )
	{
		g.setColor(Color.red);
		g.drawString("__@", a.x, a.y );

		g.setColor(Color.blue);
		g.drawString("__@", b.x, b.y );

		g.setColor(Color.green);
		g.drawString("__@", c.x, c.y );
			
	}

	public static void main(String args[] )
	{
		DalTest dal = new DalTest();
	}

}

/*
# Thread 처리
(1) Thread 클래스나 Runnable 인터페이스 상속
(2) run() 오버라이딩

	- 임의의 수를 speed 값으로 지정		
	- x 값을 위의 임의의 수를 더하기
	- 화면을 다시 그린다 (*) app.repaint() 이용
	- 임의의 수만큼 잠시 쓰레드를 블럭한다
	# 위의 작업을 반복한다
*/
class Dal extends Thread
{
	int x, y;
	int speed;
	Frame app;
	
	public Dal( Frame _app, int _x, int _y )
	{
		app = _app;
		x = _x;
		y = _y;	
	}
	
	public void run(){
		while(app != null){
			speed = (int)(Math.random()*100);
			x += speed;
			app.repaint();
			try {
				// Thread가 부모 클래스이기 때문에 그냥 sleep()이라고 적어도 된다.
				Thread.sleep(speed * 100);
			} catch (InterruptedException e) {
			}
		}
	}
}