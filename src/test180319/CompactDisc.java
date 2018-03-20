package test180319;

import java.util.Scanner;

public class CompactDisc extends Product{
	private String albumName = new String();
	private String singerName = new String();
	public CompactDisc(){
		super();
	}
	public CompactDisc(String albumName, String singerName) {
		super();
		this.albumName = albumName;
		this.singerName = singerName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	@Override
	public void setall(int count,Scanner scanner){
		super.setall(count, scanner);
		System.out.println("앨범 제목>>");
		this.albumName = scanner.nextLine();
		System.out.println("가수>>");
		this.singerName = scanner.nextLine();
	}
	
	public void showInfo(){
		System.out.println("상품 ID >> " + super.getIdentity());
		System.out.println("상품 설명 >> " + super.getExplanaion());
		System.out.println("생산자 >> " + super.getProductor());
		System.out.println("가격 >> " + super.getPrice());
		System.out.println("앨범 제목 >> " + albumName);
		System.out.println("가수 >> " + singerName);
	}
	
}
