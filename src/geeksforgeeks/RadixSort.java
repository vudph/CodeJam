package geeksforgeeks;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/radix-sort/

 */
public class RadixSort {

	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array

		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];

		// [2, 0, 2, 0, 1, 2, 1, 0, 0, 0]
		// [2, 2, 4, 4, 5, 7, 8, 8, 8, 8]
		// [0, 2, 2, 4, 4, 5, 7, 8, 8, 8]

	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	static void radixsort(int arr[], int n) {
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			bucketSort(arr, exp);
	}

	static void bucketSort(int arr[], int exp) {
		int bucket[] = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			bucket[(arr[i] / exp) % 10]++;
		}
		System.out.println();
		for (int i = 1; i < 10; i++)
			bucket[i] += bucket[i - 1];
		System.out.println();
		
		int output[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			output[bucket[(arr[i] / exp) % 10] - 1] = arr[i];
			bucket[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (int i = 0; i < arr.length; i++)
			arr[i] = output[i];
	}

	// A utility function to print an array
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 10, 21, 17, 34, 44, 11, 654, 123 };
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
		System.out.println();
		System.out.println((66 / 10) % 10);
	}

}

/*
ased on the algorithm, we will sort the input array according to the one's digit (least significant digit).
0: 10
1: 21 11
2:
3: 123
4: 34 44 654
5:
6:
7: 17
8:
9:

So, the array becomes 10,21,11,123,24,44,654,17
Now, we'll sort according to the ten's digit:
0:
1: 10 11 17
2: 21 123
3: 34
4: 44
5: 654
6:
7:
8:
9:

Now, the array becomes : 10,11,17,21,123,34,44,654
Finally , we sort according to the hundred's digit (most significant digit):
0: 010 011 017 021 034 044
1: 123
2:
3:
4:
5:
6: 654
7:
8:
9:

The array becomes : 10,11,17,21,34,44,123,654 which is sorted. This is how our algorithm works.
*/
