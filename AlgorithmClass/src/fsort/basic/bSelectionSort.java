package fsort.basic;

class bSelectionSort{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		
		System.out.printf("\n선택정렬 : ");
		for( int i=0; i < a.length; i++)
			System.out.printf("%3d",a[i]);
		selectionSort(a);
	}
	
	public static void selectionSort(int a[]){
		for(int i=0;i<a.length;i++){
			int minidx= i;
			for(int j=i;j<a.length;j++){
				if(a[minidx] > a[j]){
					minidx = j;
				}
			}
			swap(a,i,minidx);
		}
		
		System.out.println();
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	
	 public static void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	 

}	