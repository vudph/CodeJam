package leetcode;

public class DuplicateZeros {
	public void duplicateZeros(int[] arr) {
//		int tmp[] = new int[arr.length];
//		int j = 0;
//		for (int i = 0; i < arr.length && j < tmp.length; i++) {
//			if (arr[i] != 0) {
//				tmp[j++] = arr[i]; 
//			} else {
//				tmp[j++] = 0;
//                if (j < tmp.length)
//				    tmp[j++] = 0;
//			}
//		}
//		for (int i = 0; i < tmp.length; i++) {
//			arr[i] = tmp[i];
//		}
		int z = 0;
		for (int e : arr)
			if (e == 0)
				z++;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 0)
				z--;
			int j = i + z;
			if (j < arr.length) {
				arr[j] = arr[i];
				if (j + 1 < arr.length && arr[i] == 0)
					arr[j + 1] = 0;
			}
		}
	}

	public static void main(String[] args) {
		new DuplicateZeros().duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
		// 1,0,2,3,0,4,5,0
		// 1,0,0,2,3,0,0,4
	}

}
