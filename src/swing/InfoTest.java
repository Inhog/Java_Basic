package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
// 다른거래 포함 안된대
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Info{
	// 1. 멤버변수 선언
	JFrame f;
	JLabel lname,lTel, lJumin, lJender, lAge, lHome;
	JTextField tfName, tfTel,tfJumin, tfGender, tfAge,tfHome;
	JButton bInsert, bModify,bDelete,bShow, bExit;
	JTextArea ta;
	ImageIcon normalIcon = new ImageIcon("C:\\Users\\student\\Desktop\\Smile_pug.jpg");
	ImageIcon normalIcon2 = new ImageIcon("C:\\Users\\student\\Desktop\\짱이1.jpg");
	// 상대경로-> 지금 실행되고있는 프로젝트 파일부터.
	// 나는 귀찮아서 그냥 바탕화면에 jpg파일 불러옴.
	// 역슬래쉬는 \\ 두번 쳐야 하나로 출력 \\ -> \
	
	//JDBC 객체 선언 
	Database db;
	
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
		bModify.setRolloverIcon(new ImageIcon("C:\\Users\\student\\Desktop\\짱이4.jpg"));
		bModify.setPressedIcon(new ImageIcon("C:\\Users\\student\\Desktop\\짱이2.jpg"));
		bDelete = new JButton("삭제");
		bShow = new JButton("전체보기");
		bExit = new JButton("종료");
		ta = new JTextArea(10,10);
		
		// JDBC 객체 생성
		try {
			db = new Database();
			ta.setText("본사에 연결되었습니다. ");
		} catch (Exception e) {
			ta.setText("연결실패:"+e.getMessage());
		}
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
		
		// 이벤트 등록
		tfTel.addActionListener(bHdlr);
		
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
	
	
	class MyBtn implements ActionListener{ 
		// 이벤트는 대체로 inner 클래스로 만든다.
		// 이벤트 관련 클래스 - EventHandler
		// Listener를 구현하고
		@Override
		public void actionPerformed(ActionEvent ev){
			//Object evt = ev.getSource();
			Object evt = ev.getSource();
			if(evt == bInsert){
			JOptionPane.showMessageDialog(null,"저장합니다.");
			insert();
			}else if(evt == bModify){
				JOptionPane.showMessageDialog(null,"수정합니다.");
				updateByTel();
			}else if(evt == bDelete){
			JOptionPane.showMessageDialog(null,"삭제합니다.");
			deleteByTel();
			}else if(evt == bShow){
				JOptionPane.showMessageDialog(null,"합.");
				selectByTel();
			}else if(evt == bExit){
			System.exit(0); 	// 여기 들어가는 숫자는의미가 음슴.
			}else if(evt== tfTel){
				selectByTel();
			}
		}// end of actionPerformed()
		
		void deleteByTel(){
			String tel = tfTel.getText();
			try{
				db.deleteData(tel);
				ta.setText("삭제 되었습니다.");
				tfName.setText(null);
				tfJumin.setText(null);
				tfGender.setText(null);
				tfAge.setText(null);
				tfHome.setText(null);
				tfTel.setText(null);
			}catch(Exception e){
				System.out.println("삭제실패:"+e.getMessage());
			}
		}
		
		void updateByTel(){
			String name = tfName.getText();
			String id = tfJumin.getText();
			String tel = tfTel.getText();
			String gender = tfGender.getText();
			String age = tfAge.getText();
			String home = tfHome.getText();
			InfoVO info = new InfoVO(tel,name,id,gender, Integer.parseInt(age), home);
			try{
			db.updateData(info);
			ta.setText("수정되었습니다.");
			}catch(Exception e){
				System.out.println("연결실패 : "+ e.getMessage());
			}
		}
		void selectByTel(){
			// 1.입력한 전화번호를 얻어오기
			// 2. 1번값을 Database에 selectBtPk()에 전송
			// 3. 2번의 결과를 화면에 뿌려줌
			String tel = tfTel.getText();
			try{
				InfoVO vo = db.selectByPk(tel);
				tfName.setText(vo.getName());
				tfJumin.setText(vo.getId());
				tfGender.setText(vo.getGender());
				tfAge.setText(String.valueOf(vo.getAge()));
				tfHome.setText(vo.getHome());
			}catch(Exception e ){
				System.out.println("전화번호 검색 실패"+e.getMessage());
			}
		}
		void insert(){
			// 1. 화면에서 각각의 입력값을 얻어오기
			// 2. 1번의 값들을 InfoVO객체로 저장
			// 3. Database 클래스의 insertData() 호출
			String name = tfName.getText();
			String id = tfJumin.getText();
			String tel = tfTel.getText();
			String gender = tfGender.getText();
			String age = tfAge.getText();
			String home = tfHome.getText();
			InfoVO info = new InfoVO(tel,name,id,gender, Integer.parseInt(age), home);
			
			try{
			db.insertData(info);
			ta.setText("입력되었습니다.");
			}catch(Exception e){
				System.out.println("연결실패 : "+ e.getMessage());
			}
			
		}
	}// end of ActionListener{}
}


public class InfoTest {

	public static void main(String[] args) {
		Info info = new Info();
		info.addLayout();
		info.eventProc();
	}

}
