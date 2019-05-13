package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/accounts-merge/

 */

public class AccountsMerge {
	static class Graph {
		Map<String, Set<String>> adj = new HashMap<>();
		
		public Graph(Set<String> vertices) {
			Iterator<String> iter = vertices.iterator();
			while (iter.hasNext()) {
				Set<String> s = new HashSet<>();
				String v = iter.next();
				s.add(v);
				adj.put(v, s);
			}
		}
		
		public Set<String> getAdj(String v) {
			return adj.get(v);
		}
		public void addEdge(String v, String u) {
			adj.get(v).add(u);
		}
	}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Set<String> emails = accounts.stream().flatMap(Collection::stream).collect(Collectors.toSet());
		Graph g = new Graph(emails);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
			for (int j = 1; j < accounts.get(i).size() - 1; j++) {
				for (int k = j + 1; k < accounts.get(i).size(); k++) {
					g.addEdge(accounts.get(i).get(j), accounts.get(i).get(k));
				}
			}
		}
        
        return res;
    }

	public static void main(String[] args) {
//		[
//			["John", "johnsmith@mail.com", "john00@mail.com"], 
//			["John", "johnnybravo@mail.com"], 
//			["John", "john_newyork@mail.com", "johnsmith@mail.com"], 
//			["Mary", "mary@mail.com"]
//		]
		List<String> account0 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
		List<String> account1 = Arrays.asList("John", "johnnybravo@mail.com");
		List<String> account2 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
		List<String> account3 = Arrays.asList("Mary", "mary@mail.com");
		
		AccountsMerge acc = new AccountsMerge();
		acc.accountsMerge(Arrays.asList(account0, account1, account2, account3));
	}

}
