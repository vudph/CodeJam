package leetcode;

/*
https://leetcode.com/problems/sort-colors/

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
		
*/
public class SortColors {
	
	public void sortColors(int[] nums) {
		int buckets[] = new int[3];
		for (int i = 0; i < nums.length; i++) {
			buckets[nums[i]]++;
		}
		int k = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i]; j++) {
				nums[k++] = i;
			}
		}
		System.out.println();
    }

	public static void main(String[] args) {
		new SortColors().sortColors(new int[] {2,0,2,1,1,0});
	}

}
