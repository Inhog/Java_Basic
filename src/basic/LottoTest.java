package basic;

import java.util.Arrays;

public class LottoTest {

	public static void main(String[] args) {
		// 출력
		// 0. (*) 5줄
		// 1. 총 6개의 수를 합산 했을 때 106~170 사이일 때 "좋은 번호" 라고 출력
		// 2. 정렬
		// 3. 중복 숫자 배제
		int value=0;
		int sum =0;
		int[][] lotto = new int[500000][45];
		boolean[][] isExist = new boolean[5][45+1];			
		// 이 배열을 선언하여 로또번호가 중복인지아니지 확인.
		// 공간복잡도는 모르겠지만 확실히 시간복잡도는 엄청 빠름.
//		for(int j=0;j<lotto.length;j++){
//			for(int i=0;i<lotto[j].length;i++){
//				value = (int)(Math.random()*45)+1;
//				if(isExist[j][value] == false){
//					isExist[j][value] = true;
//					lotto[j][i] = value;
//				}else{
//					i--;
//				}
//			}
//		}
		  for(int j=0;j<lotto.length;j++){		
		//  이거는 3중반복문으로 중복유무 확인 및 정렬
			for(int i=0;i<lotto[j].length;i++){
				lotto[j][i] = (int)(Math.random()*45)+1;
				for(int k = 0;k<i;k++){
					if(lotto[j][i] == lotto[j][k]){
						i--;
						continue;
					}
					if(lotto[j][k] > lotto[j][i]){
						int temp = lotto[j][k];
						lotto[j][k] = lotto[j][i];
						lotto[j][i] = temp;
					}
				}
			}
		}
		
		
		for(int a=0;a<lotto.length;a++){
			for(int b=0;b<lotto[a].length;b++){
				for(int c =0; c<b;c++){
					if(lotto[a][c] > lotto[a][b]){
						int temp = lotto[a][c];
						lotto[a][c] = lotto[a][b];
						lotto[a][b] = temp;
					}
				}
			}
		}
		
//		for(int j=0;j<lotto.length;j++){		// 여기는 아마 퀵정렬이지않을까.
//		Arrays.sort(lotto[j]);
//		}
		
		for(int j=0;j<lotto.length;j++){			// 내가 전에 활용한 출력단. 시간이 오래 걸린다.
			System.out.printf("\n[%d]",j);
			for(int i=0;i<lotto[j].length;i++){
				System.out.printf("%3d / ",lotto[j][i]);
				sum +=lotto[j][i];
				if(106 <= sum && 170 >= sum)
					System.out.print("좋은 번호");
				sum =0;
			}
		}
		
//		for(int j=0;j<lotto.length;j++){			// 출력 Arrays.toString메소드를 활용 배열을 통째로 출력한다.
//			System.out.printf("[%d]%s\n",j,Arrays.toString(lotto[j]));
//		}
//
//		for(int j=0;j<lotto.length;j++){
//			for(int i=0;i<lotto[j].length;i++){
//				sum +=lotto[j][i];
//			}
//		if(106 <= sum && 170 >= sum)
//			System.out.printf("[%d]좋은 번호\n",j);
//		sum =0;
//		}
		//System.out.println("\n--------------------------");
	}
}

