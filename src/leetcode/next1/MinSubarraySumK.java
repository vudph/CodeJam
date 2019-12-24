package leetcode.next1;

import java.util.TreeMap;
import java.util.TreeSet;

public class MinSubarraySumK {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) return 0;
//		TreeMap<Integer, Integer> seen = new TreeMap<>();
//		seen.put(0, -1);
//		int sum = 0;
//		int smallest = Integer.MAX_VALUE;
//		for (int i = 0; i < nums.length; i++) {
//			sum += nums[i];
//			seen.put(sum, i);
//			if (sum < s) {
//				continue;
//			}
//			int target = sum - s;
//			smallest = Math.min(smallest, i - seen.get(seen.floorKey(target)));
//		}
//		return smallest == Integer.MAX_VALUE ? 0 : smallest;
		int l = 0;
		int r = 0;
		int sum = nums[0];
		int min = Integer.MAX_VALUE;
		while (r < nums.length && l < nums.length) {
			if (sum < s) {
				r++;
				if (r < nums.length)
					sum += nums[r];
			} else {
				min = Math.min(min, r - l + 1);
				sum -= nums[l++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		System.out.println(new MinSubarraySumK().minSubArrayLen(7, new int[] {2,3,1,2,4,3,7}));
		
		TreeSet<Integer> tree = new TreeSet<Integer>(); 
		  
        // Add elements to this TreeSet 
        tree.add(10); 
        tree.add(5); 
        tree.add(8); 
        tree.add(1); 
        tree.add(11); 
        tree.add(3); 
  
        System.out.println(tree.floor(6)); 
        String strPwd = "password"; 
        char[] charPwd = new char[] {'p','a','s','s','w','o','r','d'}; 
          
        System.out.println("String password: " + strPwd ); 
        System.out.println("Character password: " + charPwd ); 
	}

}
