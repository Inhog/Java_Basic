package swing;

import javax.swing.*;
import java.awt.*;

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
		tfAge = new JTextField(10);		
		tfHome = new JTextField(10);		
		bInsert = new JButton("추가",normalIcon);
		bInsert.setRolloverIcon(new ImageIcon("C:\\Users\\student\\Desktop\\angryPug.jpg"));
		bInsert.setPressedIcon(new ImageIcon("C:\\Users\\student\\Desktop\\angryPug.jpg"));
		bInsert.setToolTipText("입력하는거야 임마");
		// 커서를 올려두었을때 옆에 뜨는 창 -> ToolTip
		bInsert.setMnemonic('i');
		// Alt + i 누르면 단축키처럼 사용가능하다.
		bModify = new JButton("수정");
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
	}
	
}
public class InfoTest {

	public static void main(String[] args) {
		Info info = new Info();
		info.addLayout();
	}

}
