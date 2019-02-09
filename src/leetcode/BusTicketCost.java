package leetcode;
/*
https://leetcode.com/discuss/interview-question/124720/tickets-needed-to-get-minimum-cost
The month has 30 days and there are three types of ticket:

1-day ticket, costs 2, valid for one day;
7-day ticket, costs 7, valid for seven consecutive days (e.g. if the first valid day is X, then the last valid day is X+6);
30-day ticket, costs 25, valid for all thirty days of the month.
You want to pay as little as possible.

You are given a sorted (in increasing order) array A of dates when you will be travelling. For example, given:

A[0] = 1
A[1] = 2
A[2] = 4
A[3] = 5
A[4] = 7
A[5] = 29
A[6] = 30

You can buy one 7-day ticket and two 1-day tickets. The two 1-day tickets should be used on days 29 and 30.
The 7-day ticket should be used on the first seven days of the month.
The total cost is 11 and there is no possible way of paying less.
 */
public class BusTicketCost {

	public int findCost(int a[]) {
		if (a == null || a.length == 0)
			return 0;
		
		int cost[] = new int[31];
		for (int i = 0; i < a[0]; i++) {
			cost[i] = 0;
		}
		cost[a[0]] = 2;
		for (int i = 1; i < a.length; i++) {
			for (int j = a[i-1] + 1; j < a[i]; j++) {
				cost[j] = cost[j-1];
			}
//			Raw DP: minCost(cost[i - 1] + 2, cost[a[i] - 7 + 1] + 7, cost[a[i] - 25 + 1] + 25);
			cost[a[i]] = minCost(cost, a[i]);
		}
		for (int i = a[a.length - 1] + 1; i < 31; i++) {
			cost[i] = cost[i - 1];
		}
		return cost[30];
	}
	private int minCost(int cost[], int i) {
		if (i <= 7)
			return Math.min(cost[i-1] + 2, 7);
		if (i <= 25)
			return Math.min(cost[i-1] + 2, cost[i-7+1] + 7);
		return Math.min(Math.min(cost[i-1] + 2, cost[i-7+1] + 7), cost[i-25+1] + 25);
	}

	private int minCost(int cost[], int a, int b, int c) {
		if (b < 0)
			return cost[a] + 2;
		if (c < 0)
			return Math.min(cost[a] + 2, cost[b] + 7);
		return Math.min(Math.min(cost[a] + 2, cost[b] + 7), cost[c] + 25);
	}

	public static void main(String[] args) {
		//1, 2, 4, 5, 7, 29, 30
		//1,2,7,8,9,13,14,15,16,17,19,20,23,27,29,30
		//1,2,7,8,9,13,14,15,16,17,19,20,23,27,29,30
		//5,7,9,15,25
		//5,25,27,28,30
		int a[] = new int[] {1, 7, 8, 9, 10, 15, 16, 17, 18, 21, 25 };
		System.out.println(new BusTicketCost().findCost(a));
	}

}
