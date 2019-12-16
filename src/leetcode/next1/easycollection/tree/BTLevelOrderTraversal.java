package leetcode.next1.easycollection.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*

https://leetcode.com/problems/binary-tree-level-order-traversal/

https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

	     3
	    / \
	   9  20
	  /  /  \
	 1  15   7
	   /    / \
	  10   8   11
[
  [3],
  [9,20],
  [1,15,7],
  [10,8,11]
]

 * 
 */
public class BTLevelOrderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
        	int n = q.size();
        	List<Integer> l = new ArrayList<>();
        	for (int i = 0; i < n; i++) {
				TreeNode p = q.poll();
				l.add(p.val);
				if (p.left != null)
					q.add(p.left);
				if (p.right != null)
					q.add(p.right);
			}
        	result.add(l);
        }
        return result;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(10);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(11);
		new BTLevelOrderTraversal().levelOrder(null);
	}

}
