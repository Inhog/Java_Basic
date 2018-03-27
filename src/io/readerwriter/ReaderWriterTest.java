package io.readerwriter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReaderWriterTest
{
	public static void main( String args[])
	{
		UIForm3 ui = new UIForm3();
		ui.addLayout();
		ui.eventProc();	
	}	
}

//========================================
//	화면을 관리하는 클래스 
//----------------------------------------
class UIForm3 extends JFrame
{
	JTextArea	ta;
	JButton 	bSave, bLoad, bClear;
	JScrollPane sp;
	
	UIForm3()
	{
		ta		= new JTextArea();		
		sp		= new JScrollPane(ta);
		bSave 	= new JButton("파일저장");
		bLoad	= new JButton("파일읽기");
		bClear	= new JButton("화면지우기");
	}
	
	void addLayout()
	{
		JPanel pCenter 	= new JPanel();
		pCenter.setLayout( new BorderLayout() );
		pCenter.add("Center", sp );
		
	
		JPanel pSouth	= new JPanel();
		pSouth.add( bSave );
		pSouth.add( bLoad );
		pSouth.add( bClear );
		
		getContentPane().add("Center", pCenter );
		getContentPane().add("South",  pSouth );
		
		setSize( 400, 350 );
		setVisible( true );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	void eventProc()
	{
		EventHandler hdlr = new EventHandler();
		
		bSave.addActionListener(hdlr);
		bLoad.addActionListener(hdlr);
		
	}
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object evt = ev.getSource();
			
			// "화일저장" 버튼이 눌렸을 때 
			if( evt == bSave){
				
				JFileChooser fc = new JFileChooser();
				int result = fc.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(file);
						fw.write( ta.getText() );
						fw.close();
					} catch (Exception e) {
						System.out.println("저장실패 : "+ e.getMessage());
					}					
				}
			}else if( evt == bLoad){
				
				JFileChooser fc = new JFileChooser();
				int result = fc.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					try {
						FileReader fr = new FileReader(file);
						
						while(true){
							int chr = fr.read();
							if( chr == -1 ) break;
							ta.append(String.valueOf((char)chr));
						}
						fr.close();
					} catch (Exception e) {
						System.out.println("읽기실패 : "+ e.getMessage());
					}					
				}
			}
		}
	}
}