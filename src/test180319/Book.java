package test180319;

public class Book extends Product{
	private String ISBNNum = new String();
	private String author = new String();
	private String book_Name = new String();
	public Book(){
		super();
	}
	/*public Book(String identity, String explanaion, String productor, int price,String iSBNNum, String author, String book_Name) {
		super(identity,explanaion,productor,price);
		this.ISBNNum = iSBNNum;
		this.author = author;
		this.book_Name = book_Name;
	}*/
	public Book(String iSBNNum2, String author2, String book_Name2) {
		super();
		this.ISBNNum = iSBNNum2;
		this.author = author2;
		this.book_Name = book_Name2;
	}
	public String getISBNNum() {
		return ISBNNum;
	}
	public void setISBNNum(String iSBNNum) {
		this.ISBNNum = iSBNNum;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	@Override
	public void showInfo(){
		System.out.println("상품 ID >> " + super.getIdentity());
		System.out.println("상품 설명 >> " + super.getExplanaion());
		System.out.println("생산자 >> " + super.getProductor());
		System.out.println("가격 >> " + super.getPrice());
		System.out.println("ISBN >> " + ISBNNum);
		System.out.println("책 제목 >> " + book_Name);
		System.out.println("저자 >> " + author);
	}
}
