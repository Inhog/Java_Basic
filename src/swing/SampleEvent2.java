package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleEvent2 {

	JFrame f = new JFrame();
	JButton b1 = new JButton("눌러");
	JButton b2 = new JButton("눌러2");
	

	void addLatout() {
		f.setLayout(new FlowLayout());
		f.add(b1);
		f.add(b2);
		
		f.setSize(500, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc() {
		// 2. 이벤트핸들러 객체 생성
		//MyBtn BtnHdlr = new MyBtn();
		
		// 3. 이벤트 대상과 2번의 객체와 연결
		b1.addActionListener(
				new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ddd");
			}
		}
				);
		
		// ActionListener()를 구현한 이름없는 클래스를 선언한것이다.
		b2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// showMessageDialog
				// showComfirmDialog 둘다 가능함
				JOptionPane.showMessageDialog(null, "OKAY");
			}
		});
		// 요렇게 해도 된단다.
	}

	// 1. 이벤트 핸들러 만들기
	// 		(1) Listener 구현
	//		(2) override
	/*class MyBtn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// showMessageDialog
			// showComfirmDialog 둘다 가능함
			JOptionPane.showMessageDialog(null, "ddd");
		}
		
	}*/
	
	public static void main(String[] args) {
		
		SampleEvent se = new SampleEvent();
		se.addLatout();
		se.eventProc();
	}

	
}
