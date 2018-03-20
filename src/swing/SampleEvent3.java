package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* 내부에서 계속 반복되는게 싫음.
 * b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// showMessageDialog
				// showComfirmDialog 둘다 가능함
				JOptionPane.showMessageDialog(null, "ddd");
			}
		});
		
*/
public class SampleEvent3 implements ActionListener{

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
		b1.addActionListener(this);
		b2.addActionListener(this);
		// 클래스 자체가 이벤트핸들러임. 그래서 this
	}
	// 클래스 내에서 자체적으로 ActionListener 상속받음
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "OKAY");
	}
	public static void main(String[] args) {
		
		SampleEvent3 se = new SampleEvent3();
		se.addLatout();
		se.eventProc();
	}
	
	
	

	
}
