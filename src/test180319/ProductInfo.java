package test180319;

import java.util.Scanner;

public class ProductInfo {
	static Product[] product = new Product[5];
	static int count =0;
	public static void main(String[] args) {
		int check=0;
		boolean roofCheck =true;
		Scanner scanner = new Scanner(System.in);
		while(roofCheck){
			System.out.println("상품 추가 (1), 모든 상품 조회(2), 끝내기(3)");
			check = scanner.nextInt();
			scanner.nextLine(); 
			switch(check){
			case 1:
				if(count == 5){
					System.out.println("더 이상 추가할 수 없습니다.");
					break;
				}
				else{
					addProduct();
					break;
				}
			case 2:
				for(int i=0;i<count;i++){
					if(count == 0){
						System.out.println("등록된 정보가 없습니다.");
					}
					else{
					product[i].showInfo();
					}
				}
				break;
			case 3:
				roofCheck = false;
				break;
			default:
				System.out.println("입력오류 : 프로그램 종료");
				roofCheck = false;
				break;
			}
		}
	}
	static void addProduct(){
		int check =0;
		String text = new String();
		Scanner scanner = new Scanner(System.in);
		System.out.println("상품 종류 책(1), 음악CD(2), 회화책(3)");
		check = scanner.nextInt();
		scanner.nextLine(); 
		switch(check){
		case 1:
			product[count] = new Book();
			product[count].setIdentity(count);
			System.out.println("상품설명 >>");
			product[count].setExplanaion(scanner.nextLine());
			System.out.println("생산자 >>");
			product[count].setProductor(scanner.nextLine());
			System.out.println("가격>>");
			product[count].setPrice(scanner.nextInt());
			scanner.nextLine();
			System.out.println("ISBN>>");
			((Book) product[count]).setISBNNum(scanner.nextLine());
			System.out.println("책 제목>>");
			((Book)product[count]).setBook_Name(scanner.nextLine());
			System.out.println("저자>>");
			((Book)product[count]).setAuthor(scanner.nextLine());
			count++;
			break;
		case 2:
			product[count] = new CompactDisc();
			product[count].setIdentity(count);
			System.out.println("상품설명 >>");
			product[count].setExplanaion(scanner.nextLine());
			System.out.println("생산자 >>");
			product[count].setProductor(scanner.nextLine());
			System.out.println("가격>>");
			product[count].setPrice(scanner.nextInt());
			scanner.nextLine();
			System.out.println("앨범 제목>>");
			((CompactDisc) product[count]).setAlbumName(scanner.nextLine());
			System.out.println("가수>>");
			((CompactDisc)product[count]).setSingerName(scanner.nextLine());
			count++;
			break;
		case 3:
			product[count] = new ConversationBook();
			product[count].setIdentity(count);
			System.out.println("상품설명 >>");
			product[count].setExplanaion(scanner.nextLine());
			System.out.println("생산자 >>");
			product[count].setProductor(scanner.nextLine());
			System.out.println("가격>>");
			product[count].setPrice(scanner.nextInt());
			scanner.nextLine();
			System.out.println("책 제목>>");
			((ConversationBook) product[count]).setBook_Name(scanner.nextLine());
			System.out.println("저자>>");
			((ConversationBook)product[count]).setAuthor(scanner.nextLine());
			System.out.println("언어>>");
			((ConversationBook)product[count]).setLanguage(scanner.nextLine());
			System.out.println("ISBN>>");
			((ConversationBook)product[count]).setISBNNum(scanner.nextLine());
			
			count++;
			break;
		default:
			System.out.println("알맞은 값을 입력하시오.");
			break;
		}
	}
}
