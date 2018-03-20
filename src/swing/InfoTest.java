package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // 다른거래 포함 안된대
import java.util.Calendar;

class Info{
	// 1. 멤버변수 선언
	JFrame f;
	JLabel lname,lTel, lJumin, lJender, lAge, lHome;
	JTextField tfName;
	JTextField tfTel;
	JTextField tfJumin;
	JTextField tfGender;
	JTextField tfAge;
	JTextField tfHome;
	JButton bInsert;
	JButton bModify;
	JButton bDelete;
	JButton bShow;
	JButton bExit;
	JTextArea ta;
	ImageIcon normalIcon = new ImageIcon("C:\\Users\\student\\Desktop\\Smile_pug.jpg");
	ImageIcon normalIcon2 = new ImageIcon("C:\\Users\\student\\Desktop\\짱이1.jpg");
	// 상대경로-> 지금 실행되고있는 프로젝트 파일부터.
	// 나는 귀찮아서 그냥 바탕화면에 jpg파일 불러옴.
	// 역슬래쉬는 \\ 두번 쳐야 하나로 출력 \\ -> \
	

	// 2. 객체 생성
	Info(){
		f = new JFrame("나의 프로그램");
		tfName = new JTextField(10);		
		tfTel = new JTextField(10);		
		tfJumin = new JTextField(10);		
		tfGender = new JTextField(10);
		tfGender.setEditable(false);
		tfAge = new JTextField(10);
		tfAge.setEditable(false);
		tfHome = new JTextField(10);
		tfHome.setEditable(false);
		bInsert = new JButton("추가",normalIcon);
		bInsert.setRolloverIcon(new ImageIcon("C:\\Users\\student\\Desktop\\angryPug.jpg"));
		bInsert.setPressedIcon(new ImageIcon("C:\\Users\\student\\Desktop\\angryPug.jpg"));
		bInsert.setToolTipText("입력하는거야 임마");
		// 커서를 올려두었을때 옆에 뜨는 창 -> ToolTip
		bInsert.setMnemonic('i');
		// Alt + i 누르면 단축키처럼 사용가능하다.
		bModify = new JButton("수정",normalIcon2);
		bModify.setRolloverIcon(new ImageIcon("C:\\Users\\student\\Desktop\\짱이1.jpg"));
		bModify.setPressedIcon(new ImageIcon("C:\\Users\\student\\Desktop\\짱이2.jpg"));
		bDelete = new JButton("삭제");
		bShow = new JButton("전체보기");
		bExit = new JButton("종료");
		ta = new JTextArea(10,10);

	}

	// 3. 화면 구성
	void addLayout(){
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(6,2));
		pWest.add(new JLabel("이름"));
		pWest.add(tfName);
		pWest.add(new JLabel("전화"));
		pWest.add(tfTel);
		pWest.add(new JLabel("주민"));
		pWest.add(tfJumin);
		pWest.add(new JLabel("성별"));
		pWest.add(tfGender);
		pWest.add(new JLabel("나이"));
		pWest.add(tfAge);
		pWest.add(new JLabel("출신도"));
		pWest.add(tfHome);
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1,5));
		pSouth.add(bInsert);
		pSouth.add(bModify);
		pSouth.add(bDelete);
		pSouth.add(bShow);
		pSouth.add(bExit);


		// 전체 영역 붙이기
		f.setLayout(new BorderLayout());
		f.add(pWest,BorderLayout.WEST);
		f.add(ta,BorderLayout.CENTER);
		// TextArea는 그냥 바로 프레임에 띄워도 된다.
		f.add(pSouth,BorderLayout.SOUTH);

		// 화면 출력
		f.setSize(800, 600);
		f.setVisible(true);
	}	// end of addLayout 나중에 괄호땜시 고생한다.
	
	// 이벤트 등록하는 메소드
	void eventProc(){
		// 핸들러 객체 생성 
		MyBtn bHdlr = new MyBtn();
		// 이벤트 등록
		bInsert.addActionListener(bHdlr);
		bModify.addActionListener(bHdlr);
		bDelete.addActionListener(bHdlr);
		bShow.addActionListener(bHdlr);
		bExit.addActionListener(bHdlr);
		
		// 핸들러 객체 생성
		MyTxt txtHdlr = new MyTxt();
		// 이벤트 등록
		tfTel.addActionListener(txtHdlr);
		
		// 핸들러 객체 생성
		MyWin winHdlr = new MyWin();
		// 이벤트 등록
		f.addWindowListener(winHdlr);
		
		MyFocus FocusHdlr = new MyFocus();
		//
		tfJumin.addFocusListener(FocusHdlr);
		}// end of eventProc()
	
	//class MyWin implements WindowListener{
	class MyWin extends WindowAdapter{
		// 이건 싹다 implements해서 추상메서드를 싹다 구현해주어야 하는데
		// 모든 추상메서드를 다 구현하지않고 이와 같은 방법으로 할 수있다.
		// Adapter를 상속받았을 때는 해당 메서드를 올바르게 오버라이딩 해야한다.
		// @Override 가 없으면 메서드 명에 오타가 나면, 그냥 새로 추가한 메서드로 인식할 수도 있다.
		@Override
		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(null,"진짜로???????????????????");	
			// 위에 메서드의 반환값이 int 형이라서 그런데 그게 OK_OPTION이면 
			if( result == JOptionPane.OK_OPTION){
				// 시스템 종료
				System.exit(0);
			}else{
				// 아니면 아무것도 하지 않는다.
				f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
	} // end of class MyWin extends WindowAdapter{
	
	//class MyFocus implements FocusListener{
	class MyFocus extends FocusAdapter{
		@Override
		public void focusLost(FocusEvent e) {
			String Jumin = tfJumin.getText();
			Status s1 = new Status(Jumin);
			//int result = JOptionPane.showConfirmDialog(null, Jumin);
			// 주민번호에서 7번째 문자로 성별을 구해서 tfGender창에 출력.
			// 밑 코딩은 basic\\StatusTest.java 에 있음.
			
			tfGender.setText(s1.getGender());
			tfHome.setText(s1.getHome());
			tfAge.setText(""+s1.getAge());
		}
	}
	
	class MyTxt implements ActionListener{
		// TextField 이벤트 핸들러 생성 
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,tfTel.getText()+"검색");
		}
	}// end of class MyTxt implements ActionListener
	
	class MyBtn implements ActionListener{ 
		// 이벤트는 대체로 inner 클래스로 만든다.
		// 이벤트 관련 클래스 - EventHandler
		// Listener를 구현하고
		@Override
		public void actionPerformed(ActionEvent ev){
			//Object evt = ev.getSource();
			JButton evt = (JButton)ev.getSource();
			if(evt == bInsert){
			JOptionPane.showMessageDialog(null,"저장합니다.");
			}else if(evt == bModify){
				JOptionPane.showMessageDialog(null,"수정합니다.");
			}else if(evt == bDelete){
			JOptionPane.showMessageDialog(null,"삭제합니다.");
			}else if(evt == bShow){
				JOptionPane.showMessageDialog(null,"합.");
			}else if(evt == bExit){
			System.exit(0); 	// 여기 들어가는 숫자는의미가 음슴.
			}
		}// end of actionPerformed()

	}// end of ActionListener{}
}

public class InfoTest {

	public static void main(String[] args) {
		Info info = new Info();
		info.addLayout();
		info.eventProc();
	}

}
