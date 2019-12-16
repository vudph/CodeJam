package leetcode.next1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii/

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

 */

public class MeetingRoomII {
	
	static class Interval implements Comparable<Interval> {
		int begin;
		int end;
		
		public Interval(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
		
		@Override
		public int compareTo(Interval o) {
			return begin - o.begin;
		}
		
		@Override
		public String toString() {
			return "(" + begin + "," + end + ")";
		}
	}
	
	public int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		List<Interval> meetings = new ArrayList<Interval>();
		
		for (int[] in : intervals) {
			meetings.add(new Interval(in[0], in[1]));
		}
		
		Collections.sort(meetings);
		
		PriorityQueue<Integer> allocator = new PriorityQueue<>();
		
		allocator.add(meetings.get(0).end);
		for (int i = 1; i < meetings.size(); i++) {
			if (meetings.get(i).begin >= allocator.peek()) {
				allocator.poll();
			}
			allocator.add(meetings.get(i).end);
		}
		
        return allocator.size();
    }

	public static void main(String[] args) {
		System.out.println(new MeetingRoomII().minMeetingRooms(new int[][] {{2,15},{36,45},{9,29},{16,23},{4,9}}));
	}

}
