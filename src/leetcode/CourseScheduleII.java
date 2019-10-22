package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CourseScheduleII {
	boolean isCyclePresent = false;
	
	public int[] findOrderDfs(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		
		for (int i = 0; i < prerequisites.length; i++) {
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];
			List<Integer> lst = adj.getOrDefault(src, new ArrayList<Integer>());
			lst.add(dest);
			adj.put(src, lst);
		}

		Stack<Integer> stack = new Stack<>(); 
		  
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
  
        for (int i = 0; i < numCourses; i++) 
            if (visited[i] == false) 
                dfs(adj, i, visited, stack, recStack); 
  
        if(isCyclePresent) 
        	return new int[0];
        
        int[] order = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
//        	System.out.print(stack.pop() + " ");
        	order[i++] = stack.pop();
        }
		return order;
	}

	private void dfs(Map<Integer, List<Integer>> adj, int v, boolean visited[], Stack<Integer> stack, boolean[] recStack) {
		if (isCyclePresent) return;
		
		visited[v] = true;
		recStack[v] = true;
		for (Integer u : adj.getOrDefault(v, new ArrayList<>())) {
			if (!visited[u]) {
				dfs(adj, u, visited, stack, recStack);
			} else {
                if(recStack[u]){ 
                    isCyclePresent = true;
                }
            }
		}
		stack.push(v);
		recStack[v] = false;
	}
	
	public int[] findOrderBfs(int numCourses, int[][] prerequisites) {
		List<Integer> reverseAdj[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			reverseAdj[i] = new ArrayList<>();
		}
		
		int outdegree[] = new int[numCourses];
		
		for (int[] pr : prerequisites) {
			int src = pr[1];
			int dst = pr[0];
			outdegree[src]++;
			reverseAdj[dst].add(src);
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < outdegree.length; i++) {
			if (outdegree[i] == 0) {
				q.add(i);
			}
		}
		Stack<Integer> s = new Stack<>();
		while (!q.isEmpty()) {
			int u = q.poll();
			s.push(u);
			for (Integer v : reverseAdj[u]) {
				outdegree[v]--;
				if (outdegree[v] == 0) {
					q.add(v);
				}
			}
		}
		if (s.isEmpty()) return new int[0];
		
		int[] order = new int[s.size()];
        int i = 0;
        while (!s.empty()) {
//        	System.out.print(s.pop() + " ");
        	order[i++] = s.pop();
        }
		return order;
	}
	
	public static void main(String[] args) {
		new CourseScheduleII().findOrderBfs(6, new int[][] {{0,2},{1,2},{2,0}});//{{0,2},{1,2},{2,0}});//{{1,0},{2,0},{3,1},{4,1},{5,2},{5,3}}); //{{0,1}, {1,0}}; //{1,0},{2,0},{3,1},{3,2}
	}
}
