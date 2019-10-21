package leetcode;

import java.util.Arrays;

/*
 https://leetcode.com/problems/boats-to-save-people/
 Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 */
public class RescueBoats {
	
	public int numRescueBoats(int[] people, int limit) {
		int boats = bucket(people, limit);
		return boats;
	}
	
	private int sort(int[] people, int limit) {
		int boats = 0;
		Arrays.sort(people);
		int i = 0, j = people.length - 1;
		while (i <= j) {
			if (people[i] + people[j] <= limit) {
				i++;
				j--;
			} else if (people[i] + people[j] > limit) {
				j--;
			}
			boats++;
		}
		return boats;
	}
	
	private int bucket(int[] people, int limit) {
		int buckets[] = new int[limit + 1];
		for (int p : people) {
			buckets[p]++;
		}
		int boats = buckets[limit];
		int i = 1;
		int j = limit - 1;		
		while (i <= j) {
			while (buckets[i] <= 0 && i <= j) i++;
			while (buckets[j] <= 0 && i <= j) j--;
			if (i > j) 
				break;
			if (i + j <= limit) {
			}
			buckets[i]--;
			buckets[j]--;
			boats++;
		}
		return boats;
	}

	public static void main(String[] args) {
		System.out.println(new RescueBoats().numRescueBoats(new int[] {3,2,2,1,3,4,1}, 8));
	}

}
