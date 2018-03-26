package thread.basic.ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CounterTest extends JFrame{
	private JPanel p1,p2;
	private JButton btn1;
	private JTextArea res;
	private JLabel lb,lb1;
	private boolean inputChk,bombChk;
	private ImageIcon[] Icon;
	public CounterTest() {
		ImageIcon[] Icon = new ImageIcon[3];
		for (int i = 0; i < Icon.length; i++) {
			Icon[i] = new ImageIcon("C:\\Users\\student\\Downloads\\bomb"+i+".png");
		}
		setTitle("단일 스레드 테스트!");
		p1 = new JPanel();
		p1.add(btn1 = new JButton("Click"));
		p1.add(lb = new JLabel("Count!"));//추가 
		p1.add(lb1 = new JLabel(""));
		add(p1,"North");
		p2 = new JPanel();
		res = new JTextArea(20,50);
		p2.add(res);
		add(p2);
		setBounds(200, 200, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// (1) (2) (3) 싹다 한번에 한것.
				new Thread(new Runnable(){
					@Override
					// 버튼을 누르면 카운트가 시작되고 폭탄이미지가 생김.
					public void run() {
						lb1.setIcon(Icon[0]);
						bombChk = true;
						for(int i=0;i<10;i++){
							if( inputChk ){
								lb.setText("멈춤");
								inputChk = false;
								return;
							}
							lb.setText(String.valueOf(i));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
							}
						}
						res.append("시간초과, 폭탄이 터졌습니다.\n");
						bombChk = false;
						// 10초 지나면 폭탄터짐.
						lb1.setIcon(Icon[2]);
						}
				}).start();
				new Thread(new Runnable(){
					// 버튼을 또 누르면 폭탄이 멈춤
					public void run(){
						String name = JOptionPane.showInputDialog("비밀번호는?");
						if(bombChk){
							// 공백입력해도 터짐
							if(!name.equals("")){
								lb1.setIcon(Icon[1]);
								res.append("해체완료\n");
								inputChk = true;
							}else{
								res.append("비밀번호가 틀렸습니다.");
								lb1.setIcon(Icon[2]);
								res.append("폭탄이 터졌습니다.\n");
								inputChk = true;
							}
						}
					}
				}).start();
			}
		});
	}
	public static void main(String[] args) {
		new CounterTest();
	}
}
