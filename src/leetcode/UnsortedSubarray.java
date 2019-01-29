package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// 2, 6, 4, 8, 5 => 6, 4, 8, 5
// 2, 6, 4, 8, 1 => 2, 6, 4, 8, 1
// 2, 6, 4, 8, 9 => 6, 4
// 2, 1, 6, 4, 8 => 2, 1, 6, 4

public class UnsortedSubarray {
	
	public int findUnsortedSubarray(int[] nums) {
		int tmp[] = nums.clone();
		Arrays.sort(tmp);
		int il = 0;
		int i = 0;
		for (i = 0; i < tmp.length; i++) {
			if (tmp[i] != nums[i]) { 
				il = i;
				break;
			}
		}
		if (i == tmp.length) return 0;
		
		int ir = tmp.length - 1;
		for (i = tmp.length - 1; i >= 0; i--) {
			if (tmp[i] != nums[i]) { 
				ir = i;
				break;
			}
		}
		return ir - il + 1;
	}

	public static void main(String[] args) {
		UnsortedSubarray s = new UnsortedSubarray();
		System.out.println(s.findUnsortedSubarray(new int[] {2, 3, 1, 5}));
	}

}
