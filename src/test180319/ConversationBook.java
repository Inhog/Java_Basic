package test180319;

import java.util.Scanner;

public class ConversationBook extends Book{
	private String language = new String();
	public ConversationBook(){
		super();
	}
	public ConversationBook(String iSBNNum, String author, String book_Name,String language) {
		super(iSBNNum, author, book_Name);
		this.language = language;
		}
	public ConversationBook(String language){
		super();
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public void setall(int count,Scanner scanner){
		super.setall(count, scanner);
		System.out.println("언어>>");
		this.language = scanner.nextLine();
	}
	public void showInfo(){
		super.showInfo();
		System.out.println("언어 >> " + language);
	}
	
	
}
