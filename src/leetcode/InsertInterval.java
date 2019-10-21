package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval/
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]
[1,3], [2,4]
 */
public class InsertInterval {
	static class Interval implements Comparable<Interval> {
		int lower, upper;
		public Interval(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}

		@Override
		public int compareTo(Interval o) {
			int diff = lower - o.lower;
			if (diff == 0) {
				diff = upper - o.upper;
			}
			return diff;
		}
		
		@Override
		public String toString() {
			return "[" + lower + "," + upper + "]";
		}
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<Interval> inputs = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			inputs.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		inputs.add(new Interval(newInterval[0], newInterval[1]));
		Collections.sort(inputs);
		if (inputs.isEmpty()) {
			return new int[0][0];
		}
		LinkedList<Interval> outputs = new LinkedList<>();
		outputs.addLast(inputs.get(0));
		for (int i = 1; i < inputs.size(); i++) {
			Interval last = outputs.getLast();
			if (last.upper < inputs.get(i).lower) {
				outputs.addLast(inputs.get(i));
			} else if (last.upper < inputs.get(i).upper) {
				last.upper = inputs.get(i).upper;
			}
		}
		int res[][] = new int[outputs.size()][2];
		Iterator<Interval> iter = outputs.iterator();
		int i = 0;
		while (iter.hasNext()) {
			Interval interval = iter.next();
			res[i][0] = interval.lower;
			res[i][1] = interval.upper;
			i++;
		}
        return res;
    }

	public static void main(String[] args) {
		InsertInterval i = new InsertInterval();
		i.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8});
	}

}
