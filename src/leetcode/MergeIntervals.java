package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/merge-intervals/

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
			if (start > o.start)
				return 1;
			else if (start == o.start) {
				if (end > o.end)
					return 1;
				else if (end == o.end)
					return 0;
				return -1;
			}
			return -1;
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
		List<Interval> outputs = new ArrayList<>();
		int i = 0;
		while (!inputs.isEmpty()) {
			Interval curr = inputs.get(i);
			if (i == inputs.size() - 1) {
				outputs.add(curr);
				break;
			}
			Interval next = inputs.get(i + 1);
			if (curr.end >= next.start && curr.end <= next.end) {
				curr.end = next.end;
				inputs.remove(next);
			} else if (curr.end >= next.start && curr.end >= next.end) {
				inputs.remove(next);
			} else {
				outputs.add(curr);
				i++;
			}
		}
		int res[][] = new int[outputs.size()][2];
		for (int j = 0; j < outputs.size(); j++) {
			res[j][0] = outputs.get(j).start;
			res[j][1] = outputs.get(j).end;
		}
		return res;
	}

	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		m.merge(new int[][]{{1,4},{2,3}});
	}
}
