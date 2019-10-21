package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 https://leetcode.com/problems/jump-game-ii/
 Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
 */

public class JumpGameII {
	static class Graph {
		int v;
		Set<Integer> adj[];
		
		public Graph(int v) {
			this.v = v;
			adj = new HashSet[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new HashSet<>();
			}
		}
		
		public void addEdge(int u, int v) {
			adj[u].add(v);
		}
	}
	
	public int jump(int[] nums) {
////		int step = helper(0, nums);
//		Map<Integer, Integer> cache = new HashMap<>();
////		int step = helperMemorize(0, nums, cache);
//		int step = greedy(nums);
//		return step;
		
		if (nums.length == 1) 
            return 0;
            
		int step = 0;
		int i = 0;
		while (i < nums.length) {
			int maxfar = 0;
			int tmpi = i + 1;
			for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
				if (nums[j] + j > maxfar) {
					maxfar = nums[j] + j;
					tmpi = j;
				}
					
			}
			step++;
			if (tmpi == nums.length - 1) break;
			if (maxfar >= nums.length - 1) {
				step++;
				break;
			}
			
			i = tmpi;		
		}
		return step;
    }

	private int helper(int idx, int[] nums) {
		if (idx >= nums.length -1) {
			return 0;
		}
		int min = nums.length;
		for (int i = idx + 1; i <= nums[idx] + idx; i++) {
			int tempMin = helper(i, nums) + 1; 
			min = Math.min(min, tempMin);
		}
		return min;
	}

	private int helperMemorize(int idx, int[] nums, Map<Integer, Integer> cache) {
		if (cache.containsKey(idx)) {
			System.out.println("hit " + idx + ": " + cache.get(idx));
			return cache.get(idx);
		}
		if (idx >= nums.length - 1) {
			return 0;
		}
		int min = nums.length;
		for (int i = idx + 1; i <= nums[idx] + idx; i++) {
			int tempMin = helperMemorize(i, nums, cache) + 1; 
			min = Math.min(min, tempMin);
		}
		cache.put(idx, min);
		return min;
	}
	
	private int bfs(int nums[]) {
		if (nums.length == 1)
			return 0;
		int step = 1;
		Graph g = new Graph(nums.length);
//		int a[][] = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
//				a[i][j] = 1;
				g.adj[i].add(j);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean visited[] = new boolean[nums.length];
		visited[0] = true;
		int trace[] = new int[nums.length];
		while (!q.isEmpty()) {
			int v = q.poll();
			if (v == nums.length - 1) break; //end vertex equals to nums.length - 1
			for(Integer u : g.adj[v]) {
				if (!visited[u]) {
					visited[u] = true;
					q.add(u);
					trace[u] = v;
				}
			}
		}
		int curr = trace[nums.length - 1];
		while (curr != 0) {
			System.out.print(curr + "<-");
			curr = trace[curr];
			step++;
		}
		return step;
	}
	
	private int greedy(int nums[]) {
		int jumps = 0, end = 0, curfar = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curfar = Math.max(curfar, i + nums[i]);// upto max index jumps
			if (i == end)// when equal then we take next jump
			{
				jumps++;
				end = curfar;// set the next index after that it will jump
			}
		}
		return jumps;
	}
	
	private int dynamic(int nums[]) {
		int dp[] = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
					break;
				}
				
			}
		}
		return dp[nums.length - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new JumpGameII().jump(new int[] {3,2,1}));
	}

}
