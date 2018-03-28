package network.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClient implements ActionListener,Runnable{
	JFrame f;

	JTextField connTF, sendTF;
	JButton connB, sendB;
	JTextArea ta;
	
	Socket s;
	BufferedReader in;
	OutputStream out;

	// 추가0 : 대화명을 바꾸기
	JTextField changeNameTF;
	JButton    changeNameB;

	// 추가2 : 방인원의 대명 보여주기
	// 변수 선언
	JList  memberList;
	Vector list;
	
	public ChatClient() {
		f = new JFrame("Chat Client");
		

		connTF = new JTextField();
		sendTF = new JTextField();
		connB = new JButton("접 속");
		sendB = new JButton("확 인");
		ta = new JTextArea(15,40);
		
		// 추가0: 대화명 바꾸기
		changeNameTF	= new JTextField("guest", 10);
		changeNameB		= new JButton("바꾸기");
		JPanel p_changeName = new JPanel();
		p_changeName.add( new JLabel("대화명 : "),"West" );
		p_changeName.add(changeNameTF, "Center");
		p_changeName.add(changeNameB, "East");
		
		JPanel p_serverName = new JPanel();
		p_serverName.setLayout( new BorderLayout() );
		p_serverName.add( new JLabel("서버입력 : "),"West" );
		p_serverName.add(connTF, "Center");
		p_serverName.add(connB, "East");

		JPanel p_north = new JPanel();
		p_north.setLayout( new GridLayout(1, 2));
		p_north.add( p_changeName );
		p_north.add( p_serverName );

		JPanel p2 = new JPanel();
		p2.setLayout( new BorderLayout() );
		p2.add( new JLabel("메세지입력 : "),"West" );
		p2.add(sendTF,"Center");
		p2.add(sendB, "East");
		
		// 추가2 : 방인원의 대명 보여주기
		memberList = new JList();
		list		= new Vector();
		JPanel  p_east = new JPanel();
		p_east.setLayout( new BorderLayout());
		p_east.add("North", new JLabel("   우 리 방 멤 버   "));
		p_east.add("Center", memberList );
		


		f.getContentPane().add("North", p_north);
		f.getContentPane().add("Center", new JScrollPane(ta));
		f.getContentPane().add("South", p2);
		f.getContentPane().add("East", p_east);
		
		//f.setSize(500, 300);
		f.pack();
		f.setVisible(true);
		


		connTF.addActionListener(this);
		connB.addActionListener(this);
		sendTF.addActionListener(this);
		sendB.addActionListener(this);

		//  추가0: 대화명 바꾸기
		changeNameTF.addActionListener(this);
		changeNameB.addActionListener(this);
		
		// X버튼이 눌렸을 때 이벤트 
		// WindowListener하면 추상메소드 다 적어둬야 하니, WindowApdapter 사용
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				if(s.isConnected()){
					try {
						out.write("/exit bye\n".getBytes());
						in.close();
						out.close();
						s.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.exit(0);
				}
			}
		});
	}// 생성자 종료
	
	public void actionPerformed( ActionEvent e ) {
		Object o = e.getSource();

		if( o == connTF || o == connB ) {
			connProc();
		}
		
		else if( o == sendTF || o == sendB ) {
			sendProc();
		}

		//  추가0: 대화명 바꾸기
		else if( o == changeNameTF || o == changeNameB ) {
			changeNameProc();
		}
	} // actionPerformed ends
	

	void changeNameProc(){
		// "/name 변경할이름+\n" 이 커멘드를 보낼 수 있게 만들어줌.
		String name1 ="/name "+ changeNameTF.getText()+ "\n";
		try {
			out.write(name1.getBytes());
		} catch (IOException e) {
			ta.setText("변경실패 :" + e.getMessage());
		}
	}

	void connProc() {
		try {
			// 1. 소켓생성 ( 서버아이피, 서버포트)

			s = new Socket(connTF.getText(),1234);
			
			// 2. 입출력 스트림을 얻어오기

			out = s.getOutputStream();
			
//			Byte형 통로를 (getInputStream) char형 통로(BufferedReader)로 못바꿔줌
//			그래서 InputStreamReader 사용함.
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			연결이 되자마자 쓰레드를 돌리면 됨.
//			Thread th = new Thread(this);
			new Thread(this).start();	// run() 호출
			
			enterRoom();
			
			ta.setText("접속성공\n");
		} catch (Exception e) {
			ta.setText("접속실패 :" + e.getMessage());
		}
	} // connProc ends
	
	void enterRoom(){
		String name1 ="/enter "+ changeNameTF.getText()+ "\n";
		// 이 문장을 서버에게 날려주면된다.
		try {
			out.write(name1.getBytes());
		} catch (IOException e) {
			ta.setText("접속 후 별명전송시 오류:" + e.getMessage());
		}
		
	}
	
// 	사용하기 위해서 클래스에 Runnable을 상속받는다.
	@Override
	public void run() {
		while(s.isConnected()){		// 가급적 무한루프는 만들지 말어라라
//			서버로부터 데이터 읽어서 화면 출력
			try {
				String msg = in.readLine();
				StringTokenizer st = new StringTokenizer(msg);
				if(st.countTokens() >1){
					String temp = st.nextToken();
					
					// 멤버들을 리스트 화면에 출력
					if(temp.equals("/member")){
						list.removeAllElements();
						while(st.hasMoreTokens()){
							list.add(st.nextToken());
							memberList.setListData(list);
							
						}
						continue;
					}
				}
				
				ta.append(msg + "\r\n");
				
            	ta.setCaretPosition(ta.getText().length());	
			} catch (IOException e) {
				ta.append("읽기실패 :" + e.getMessage());
			}
		}
	}
	


	void sendProc() {
		String msg = sendTF.getText() + "\n";
		
		try {
//			String 을 Byte[]로 바꾸어 주는 메서드
			out.write(msg.getBytes());
//			서버로 보내면 비워주기
			sendTF.setText(null);
		} catch (IOException e) {
			ta.setText("전송실패 :" + e.getMessage());
		}
	}// sendProc ends
	

	public static void main(String [] args ) {
		new ChatClient_nb();
	}
	

}// ChatClient ends
			
			

	
		
