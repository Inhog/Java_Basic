package awt;

// 정신없는 awt, swing
import java.awt.*;
import javax.swing.*;
//is - a
public class MyPro2 extends JFrame {
	// 1. 멤버변수 선언
	JButton b;
	JButton cancel;
	JTextField tf;
	JTextArea ta;
	JRadioButton cb1,cb2;
	JList lst;
	JComboBox ColorChooser;
	public MyPro2(){
		super("ㄹㄹㄹ");
		// 2. 멤버변수 객체 생성
		b = new JButton("OK");
		cancel = new JButton("cancel");
		tf = new JTextField("one line");
		ta = new JTextArea("more lines",10,20);
		
		ColorChooser  = new JComboBox();
		ButtonGroup group = new ButtonGroup();
		cb1 = new JRadioButton("man",false);
		cb2 = new JRadioButton("woman",false);
		String[] a ={"1","2","3","4","5"};
		lst = new JList(a);		
		// JList는 배열을 선언해서 배열을 매개변수로 
		// 생성해야 한다.
		group.add(cb1);
		group.add(cb2);
		// 3. 화면 구성
		//FlowLayout f1 = new FlowLayout();
		//setLayout(new FlowLayout());
		// 윗줄 상단에 배치( 컴포넌트 크기가 중심)
//		setLayout(new GridLayout(2,4));
		// 행렬에 맞춰서 배치( 컨테이너 크기가 중심)
		setLayout(new BorderLayout());
		// 복,남,중앙,서,동 배치
		add(b,BorderLayout.WEST);
		add(cancel, BorderLayout.EAST);
		add(tf, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		Panel p = new Panel();
		p.add(cb1);
		p.add(cb2);
		add(p, BorderLayout.SOUTH);
//		add(cb1, BorderLayout.SOUTH);
//		add(cb2, BorderLayout.SOUTH);
//		add(lst,BorderLayout.SOUTH);
//		lst.add("Mercury");
//		lst.add("Venus");
//		lst.add("Earth");
//		lst.add("JavaSoft");
//		lst.add("Mars");
//		lst.add("Jupiter");
//		lst.add("Saturn");
//		lst.add("Uranus");
//		lst.add("Neptune");
//		lst.add("Pluto");
		// 이거는 그냥 awt -> List
		add(ColorChooser);
		ColorChooser.addItem("Green");
		ColorChooser.addItem("Red");
		ColorChooser.addItem("Blue");
		
		
		
		
		setSize(600,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		MyPro2 f = new MyPro2();
	}

}
