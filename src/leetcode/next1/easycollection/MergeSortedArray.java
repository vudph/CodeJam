package leetcode.next1.easycollection;

import java.util.Arrays;

/*
 https://leetcode.com/problems/merge-sorted-array/solution/
Assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Input:
nums1 = [1,2,3], m = 3
nums2 = [2,5,6], n = 3

Output: nums1 = [1,2,2,3,5,6]

 */
public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
        	if (nums1[p1] > nums2[p2]) {
        		nums1[p--] = nums1[p1--];
        	} else if (nums1[p1] < nums2[p2]) {
        		nums1[p--] = nums2[p2--];
        	} else {
        		nums1[p--] = nums1[p1--];
        		nums1[p--] = nums2[p2--];
        	}
        }
  
        if (p2 >= 0) {
        	System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
        System.out.println();
    }

	public static void main(String[] args) {
		new MergeSortedArray().merge(new int[] {1,2,3,0,0,0}, 3, new int[] {4,5,6}, 3);
	}
}
