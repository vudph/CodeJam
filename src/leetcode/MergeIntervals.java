package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/merge-intervals/

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

[[1,4],[2,3]] => [[1,4]]

Input: [[1,3],[2,8],[8,10],[15,18]]
Output: [[1,10],[15,18]]
 */
public class MergeIntervals {
	static class Interval implements Comparable<Interval> {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Interval o) {
			int diff = start - o.start;
			if (diff == 0) {
				diff = end - o.end;
			}
			return diff;
		}
		
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}

	public int[][] merge(int[][] intervals) {
		List<Interval> inputs = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			Interval interval = new Interval(intervals[i][0], intervals[i][1]);
			inputs.add(interval);
		}
		Collections.sort(inputs);
		LinkedList<Interval> outputs = new LinkedList<>();
//		int i = 0;
//		while (!inputs.isEmpty()) {
//			Interval curr = inputs.get(i);
//			if (i == inputs.size() - 1) {
//				outputs.add(curr);
//				break;
//			}
//			Interval next = inputs.get(i + 1);
//			if (curr.end >= next.start && curr.end <= next.end) {
//				curr.end = next.end;
//				inputs.remove(next);
//			} else if (curr.end >= next.start && curr.end >= next.end) {
//				inputs.remove(next);
//			} else {
//				outputs.add(curr);
//				i++;
//			}
//		}
//		for (int j = 0; j < outputs.size(); j++) {
//			res[j][0] = outputs.get(j).start;
//			res[j][1] = outputs.get(j).end;
//		}
		
		if (!inputs.isEmpty()) {
			Interval last = inputs.get(0);
			outputs.addLast(last);
			for (int i = 1; i < inputs.size(); i++) {
				Interval lastInterval = outputs.getLast();
				Interval next = inputs.get(i);
				if (lastInterval.end < next.start) {
					outputs.addLast(next);
				} else if (lastInterval.end < next.end) {
					lastInterval.end = next.end;
				}
			}
			int res[][] = new int[outputs.size()][2];
			Iterator<Interval> iter = outputs.iterator();
			int i = 0;
			while (iter.hasNext()) {
				Interval interval = iter.next();
				res[i][0] = interval.start;
				res[i][1] = interval.end;
				i++;
			}
			return res;
		}
		return new int[0][0];
	}

	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		m.merge(new int[][]{{1,3},{2,8},{8,10},{15,18}});
	}
}
