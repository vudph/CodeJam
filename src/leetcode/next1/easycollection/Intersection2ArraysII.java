package leetcode.next1.easycollection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
 */
public class Intersection2ArraysII {
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			m1.put(nums1[i], m1.getOrDefault(nums1[i], 0) + 1);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for (int i : nums2) {
			if (m1.containsKey(i)) {
				res.add(i);
				if (m1.get(i) == 1)
					m1.remove(i);
				else
					m1.put(i, m1.get(i) - 1);
			}
		}
		
		int r[] = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			r[i] = res.get(i);
		}
		
        return r;
    }

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime d = LocalDateTime.now();
		System.out.println(d.toString());
	}

}
