package ardendertat;

/*
http://www.ardendertat.com/2011/09/24/programming-interview-questions-3-largest-continuous-sum/
{1, 2, 3, 4, -6, 7, 7, 7} => 25
{-2, -3, 4, -1, -2, 1, 5, -3} => 7
{4, -8, 9, -4, 1, -8, -1, 6} => 9
 */
public class LargestContinuousSum {
	
	public int calculate(int nums[]) {
		int largest = nums[0];
		int tempLargest = largest;
		for (int i = 1; i < nums.length; i++) {
			tempLargest = Math.max(tempLargest + nums[i], nums[i]);
			largest = Math.max(largest, tempLargest);
		}
		return largest;
	}

	public static void main(String[] args) {
		System.out.println(new LargestContinuousSum().calculate(new int[] {1, 2, 3, 4, -6, 7, 7, 7}));
	}

}
