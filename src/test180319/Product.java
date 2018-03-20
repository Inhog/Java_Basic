package test180319;

import java.util.Scanner;

public abstract class Product {
	private int identity = 0;
	private String explanaion = new String();
	private String productor = new String();
	private int price = 0;
	
	public Product(){}
	public Product(int identity, String explanaion, String productor, int price) {
		super();
		this.identity = identity;
		this.explanaion = explanaion;
		this.productor = productor;
		this.price = price;
	}

	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getExplanaion() {
		return explanaion;
	}
	public void setExplanaion(String explanaion) {
		this.explanaion = explanaion;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setall(int count,Scanner scanner){
		boolean roof_check = true;
		this.identity = count;
		System.out.println("상품설명 >>");
		this.explanaion = scanner.nextLine();
		System.out.println("생산자 >>");
		this.productor = scanner.nextLine();
		while(roof_check)
		try{
		System.out.println("가격>>");
		this.price = scanner.nextInt();
		scanner.nextLine();
		roof_check = false;
		}catch(Exception e){
			System.out.println("정확한 값을 입력하시오.");
		}
		
	}
	public abstract void showInfo();
//	System.out.println("상품 ID >> " + identity);
//	System.out.println("상품 설명 >> " + explanaion);
//	System.out.println("생산자 >> " + productor);
//	System.out.println("가격 >> " + price);
}
