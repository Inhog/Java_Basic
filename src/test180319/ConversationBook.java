package test180319;

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
	public void showInfo(){
		super.showInfo();
		System.out.println("언어 >> " + language);
	}
	
	
}
