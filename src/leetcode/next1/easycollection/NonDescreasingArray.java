package leetcode.next1.easycollection;

public class NonDescreasingArray {
	
	public boolean checkPossibility(int[] nums) {
        if (nums.length < 2)
            return true;
        int cnt = 1;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
        	if (nums[i] <= nums[i + 1]) {
        		prev = nums[i];
        		continue;
        	}
        	if (cnt == 0) return false;
        	if (nums[i + 1] >= prev) {
        		nums[i] = nums[i + 1];
        		prev = nums[i];
        		cnt--;
        	} else {
        		if (i < nums.length - 2 && nums[i] < nums[i + 2]) {
        			nums[i + 1] = nums[i];
        			cnt--;
        		} else if (i == nums.length - 2){
        			return true;
        		} else {
        			return false;
        		}
        	}
        }
        return true;
	}

	public static void main(String[] args) {
		System.out.println(new NonDescreasingArray().checkPossibility(new int[] {2,3,3,2,4}));
	}

}
