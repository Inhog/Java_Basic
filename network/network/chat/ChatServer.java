package network.chat;


import java.io.*;
import java.util.*;
import java.net.*;

public class ChatServer implements Runnable {
	ArrayList vc = new ArrayList();

	public void run() {
		ServerSocket ss = null;
		try{
			ss = new ServerSocket(1234);
		}catch( Exception e ) {
			System.out.println(e);
		}
		
		while(true) {
			try{
				// accept() 메소드가 클라이언트가 접속한걸 감지하고 소켓을 반환함(return)
				Socket s = ss.accept();
				System.out.println("Client 가 접속시도 :" + s );
//				접속한 해당 소켓을 매개변수로 하는 ChatService 객체를 생성함.
//				이 객체가 소켓의 입,출력 스트림을 생성하고 클라이언트와 통신함.
//				ChatServer 클래스는 vc라는 ArrayList가 참조한 객체의 주소를 통해 어느 소켓에서 메소드들이 발생했는지 알아내고
//				클라이언트와 통신하고있는 소켓(객체)에 각각 write한다. 
				ChatService cs = new ChatService(s);
				cs.start();
				vc.add(cs);
			
			} catch( Exception e ) { }
		}
	}  // run ends
	
	public static void main( String [] arg ) {
		ChatServer cs = new ChatServer();
		new Thread(cs).start();
	}	// main ends



class ChatService extends Thread {
		String myname = "quest";		// 별명은 들어갈때부터 quest라고 정해짐.
		BufferedReader in;
		OutputStream out;
		ChatService( Socket s ) {
			try{
//				생성자를 통해 입,출력스트림을 만듦.
				in = new BufferedReader( new InputStreamReader(s.getInputStream()));
				out = s.getOutputStream();
			}catch( Exception e ) { }
		}// 생성자 종료
		
	

	public void run() {
		while(true) {
			try{
				String msg = in.readLine();
				
				if( msg == null ) return;
				StringTokenizer st = new StringTokenizer(msg);
//				Tokenizer로 밑에 명령어처럼 만들어진 부분을 수행하려함.
				if( st.countTokens() > 1 ) {
					String temp = st.nextToken();
					// 대 소 문자 구문하는 메서드
					if( temp.equalsIgnoreCase("/name" )) {
						temp = st.nextToken();
						putMessageAll(myname + "님의 이름이 " + temp + "으로 바뀌었습니다.");

						myname = temp;
						changeList();
						continue;
					
					}else if(temp.equalsIgnoreCase("/w" )){
						String temp1 = st.nextToken();
						for( int i =0 ; i<vc.size() ; i++ ) {
//							이 부분을 통해 연결하고 있는 소켓을 찾고
							ChatService cs = ( ChatService ) vc.get(i);
							if(temp1.equals(cs.myname)){
							try {
//								메세지를 클라이언트의 입력스트림으로 write 한다.
								cs.putMessage(msg);
							}catch( Exception e ) {
								vc.remove(i--);
							}
							}
						}
						continue;
					}
					// 클라이언트가 처음 들어올때
					else if( temp.equalsIgnoreCase("/enter")){
						myname = st.nextToken();
						putMessageAll(myname + "님이 입장하셨습니다.");
						
						// 멤버리스트 전송
						changeList();
						continue;

						
					}
					// 클라이언트가 종료했을 때
					else if(temp.equals("/exit")){
						putMessageAll(myname+"님이 나갔음");
						// 인덱스는 알 수 없으나 본인이 나갔으니 this를 활용한다.
						vc.remove(this);
						changeList();
						continue;
					}

				}
				// 연결된 클라이언트 전체에 보내줌
				putMessageAll( myname + ">" + msg );
			
			}catch( Exception ex ) { return; }
			
		}
	}// run ends
	
	void changeList(){
		/**	"/member 천재 바보 그냥애 별칭 \n" */
		String msg = "/member	";
		for (int i = 0; i < vc.size(); i++) {
			ChatService cs = (ChatService)vc.get(i);
			msg += cs.myname + " ";
		}	
		putMessageAll(msg);
	}
	

	void putMessageAll( String msg ) {
		for( int i =0 ; i<vc.size() ; i++ ) {
//			이 부분을 통해 연결하고 있는 소켓을 찾고
			ChatService cs = ( ChatService ) vc.get(i);
			
			try {
//				메세지를 클라이언트의 입력스트림으로 write 한다.
				cs.putMessage(msg);
			}catch( Exception e ) {
				vc.remove(i--);
			}
		}
	} // putMessageAll ends
	
	
	void putMessage( String msg )
		throws Exception {
			out.write( (msg+"\r\n").getBytes() );
		}

 } // ChatService class ends
	
	
}// ChatServer class ends
