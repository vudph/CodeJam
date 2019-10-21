package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/parallel-courses/
 * 
 */
public class ParallelCourse {
	public int minimumSemesters(int N, int[][] relations) {
		Map<Integer, List<Integer>> reverseAdj = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			reverseAdj.put(i, new ArrayList<>());
		}
		int outdegree[] = new int[N + 1];
		for (int[] rel : relations) {
			int src = rel[1];
			int dst = rel[0];
			outdegree[src]++;
			reverseAdj.get(dst).add(src);
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (outdegree[i] == 0) {
				q.add(i);
			}
		}

		int semester = 0;
		Stack<List<Integer>> s = new Stack<>();
		while (!q.isEmpty()) {
			List<Integer> parallelCourse = new ArrayList<>();
			for (int i = q.size(); i > 0; i--) {
				int u = q.poll();
				N--;
				parallelCourse.add(u);
				for (int v : reverseAdj.get(u)) {
					outdegree[v]--;
					if (outdegree[v] == 0) {
						q.add(v);
					}
				}
				System.out.print(u + ", ");
			}
			System.out.println();
			semester++;
			s.push(parallelCourse);
		}
		
        return N == 0 ? semester : -1;
    }
	
	private void printTopoSortOrder(int N, int relations[][]) {
		Map<Integer, List<Integer>> revAdj = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			revAdj.put(i, new ArrayList<>());
		}
		int outdegree[] = new int[N + 1];
		for(int[] rel : relations) {
			int src = rel[1];
			int dst = rel[0];
			revAdj.get(dst).add(src);
			outdegree[src]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (outdegree[i] == 0)
				q.offer(i);
		}
		
		Stack<Integer> s = new Stack<>();
		while (!q.isEmpty()) {
			int u = q.poll();
			s.push(u);
			for (int v : revAdj.get(u)) {
				outdegree[v]--;
				if (outdegree[v] == 0) {
					q.offer(v);
				}
			}
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
	
	public int minimumSemestersIndegree(int N, int[][] relations) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		int indegree[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj.put(i, new ArrayList<>());
		}
		for (int[] rel : relations) {
			int src = rel[1];
			int dst = rel[0];
			adj.get(src).add(dst);
			indegree[dst]++;
		}
		
		Queue<Integer> bfs = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				bfs.offer(i);
		}
		int semester = 0;
		while (!bfs.isEmpty()) {
			for (int i = bfs.size(); i > 0; i--) {
				int u = bfs.poll();
				System.out.print(u + ", ");
				N--;
				for (int v : adj.get(u)) {
					indegree[v]--;
					if (indegree[v] == 0)
						bfs.add(v);
				}
			}
			System.out.println();
			semester++;
		}
		
		return N == 0 ? semester : -1;
	}
	
	public static void main(String[] args) {
//		new ParallelCourse().printTopoSortOrder(3, new int[][]{{2,1},{3,2},{1,3}});
//		new ParallelCourse().printTopoSortOrder(7, new int[][]{{3,1},{3,2},{6,2},{4,3},{5,3},{7,4},{7,5},{7,6}});//6, new int[][] {{2,1},{3,1},{4,2},{5,2},{6,3},{6,4}})); //3, new int[][] {{1,3}, {2,3}}));//4, new int[][]{{2,1},{3,1},{4,2},{4,3}})); //6, new int[][] {{2,1},{3,1},{4,2},{5,2},{6,3},{6,4}}));
		
		System.out.println(new ParallelCourse().minimumSemestersIndegree(6, new int[][]{{2,1},{3,1},{4,2},{5,2},{6,3},{6,4}}));//new int[][]{{3,1},{3,2},{6,2},{4,3},{5,3},{6,4},{6,5}}));//6, new int[][] {{2,1},{3,1},{4,2},{5,2},{6,3},{6,4}})); //3, new int[][] {{1,3}, {2,3}}));//4, new int[][]{{2,1},{3,1},{4,2},{4,3}})); //6, new int[][] {{2,1},{3,1},{4,2},{5,2},{6,3},{6,4}}));
	}
}
