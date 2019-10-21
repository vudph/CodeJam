package leetcode;

public class SortAWithB {
	
	public void sortAWithB(int A[], int B[]){
//		int C[] = new int[A.length];
//		for (int i = 0; i < B.length; i++) {
//			C[B[i] - 1] = A[i];
//			System.out.println();
//		}
//		return C;
//		int i = 0;
//		int k = 0;
//		while (i < B.length) {
//			System.out.println(k++);
//			if (i != B[i] - 1) {
//				swap(B[i] - 1, i, A);
//				swap(B[i] - 1, i, B);
//			} else {
//				i++;
//			}
////			System.out.println();
//		}
		
		for (int i = 0; i < A.length; i++) {
			B[i] = A[B[i] - 1];
		}
		System.out.println();
	}
	
	private void swap(int i, int j, int A[]) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	void sortAWithB1(int[] A, int[] B) {
		int k = 0;
		for (int i = 0; i < A.length; i++) {
			System.out.println(k++);
			while (i != B[i] - 1) {
				System.out.println(k++);
				swap(A, B, i, B[i] - 1);
			}
		}
	}

	void swap(int[] A, int[] B, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
		tmp = B[i];
		B[i] = B[j];
		B[j] = tmp;
	}

	public static void main(String[] args) {
		int A[] = {24,56,74,-23,87,91};
		int B[] = { 2, 3, 4,  1, 5, 6};
		
//		int A[] = {56,24,74,-23,87,91};	
//		int B[] = { 3, 2, 4,  1, 5, 6};
		
//		int A[] = {56,24,-23,74,87,91};	
//		int B[] = { 3, 2, 1,  4, 5, 6};
		
		
		//        -23,24,56,74,87,91
		
		new SortAWithB().sortAWithB(A, B);
	}

}
