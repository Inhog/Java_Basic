package fsort.basic;

class cInsertionSort{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		System.out.printf("\n삽입정렬 : ");
		for( int i=0; i < a.length; i++)
			System.out.printf("%3d",a[i]);
		insertionSort(a, size);
	}
	
	public static void insertionSort(int a[], int size){
		System.out.println();
		for(int i=0;i<size;i++){
			for(int j=0;j<i;j++){
				if(a[i] < a[j]){
					int temp = a[i];
					while(j<i){
						a[i] = a[--i];
					}
					a[j] = temp;
					print(a);
				}
			}
		}
		for(int i=0;i<size;i++){
			System.out.println(a[i]);
		}
		System.out.println();
	}

	public static void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void print(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");			
		}
		System.out.println();
	}
}