package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
	
	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		
        for (int i = 0; i < nums.length - 1; i++) {
        	int cnt = 0;
        	for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i])
					cnt++;
			}
        	res.add(cnt);
		}
        res.add(0);
        for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + ", ");
		}
        return res;
    }

	public static void main(String[] args) {
		CountSmaller cnt = new CountSmaller();
		cnt.countSmaller(new int[] {5,2,6,1});
	}

}
