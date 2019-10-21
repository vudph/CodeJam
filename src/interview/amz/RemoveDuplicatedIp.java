package interview.amz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://aonecode.com/amazon-onsite-remove-duplicated-ipv4-addresses

input: ["205.251.242.103","205.251.242.100","104.36.196.223","151.101.40.116","205.251.242.103","104.196.174.50","52.205.157.89","205.251.242.103","151.101.40.116"]
output: ["205.251.242.103","205.251.242.100","104.36.196.223","151.101.40.116","104.196.174.50","52.205.157.89"]
 */
public class RemoveDuplicatedIp {
	static class TrieNode {
		Map<String, TrieNode> next = new HashMap<>();
		boolean end;
		String ip;
	}
	
	private List<String> res = new ArrayList<>();
	
	private void buildTrie(String ips[], TrieNode root) {
		List<String> res = new ArrayList<String>();
		for (String ip : ips) {
			TrieNode node = root;
			String segments[] = ip.split("\\.");
			for (String seg : segments) {
				if(!node.next.containsKey(seg)) {
					node.next.put(seg, new TrieNode());
				}
				node = node.next.get(seg);
			}
			node.end = true;
			node.ip = ip;
		}
		System.out.println(res.size());
	}
	
	public String[] removeDuplicates(String ips[]) {
		TrieNode root = new TrieNode();
		buildTrie(ips, root);
		dfs(root);
		String[] r = new String[res.size()];
		return res.toArray(r);
	}
	
	private void dfs(TrieNode node) {
		if (node.ip != null) {
			res.add(node.ip);
		}
		for (TrieNode n : node.next.values()) {
			dfs(n);
		}
	}
	

	public static void main(String[] args) {
		String t[] = new RemoveDuplicatedIp().removeDuplicates(new String[] {"205.251.242.103","205.251.242.100","104.36.196.223","151.101.40.116","205.251.242.103",
																"104.196.174.50","52.205.157.89","205.251.242.103","151.101.40.116"});
		
		System.out.println();
	}

}
