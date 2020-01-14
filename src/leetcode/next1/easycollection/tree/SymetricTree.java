package leetcode.next1.easycollection.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

edge cases:
    1
   / \
  2   2
   \   \
    2   2    
false but 2,2,1,2,2    
     1
    / \
   2   2
  /   /
 2   2
false but 2,2,1,2,2



    1
   / \
  2   2
 / \ / \
3  4 4  3
*/
public class SymetricTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return mirror(root.left, root.right);
	}
	
	private boolean mirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
//		if ((node1 == null && node2 != null) || (node1 != null && node2 == null) || (node1.val != node2.val))
//			return false;
		if (node1 == null || node2 == null)
			return false;
		
		if (node1.val == node2.val && mirror(node1.left, node2.right) && mirror(node1.right, node2.left))
			return true;
		return false;
	}


	public boolean isSymmetric1(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		helper1(root, inorder);
		int l = 0, r = inorder.size() - 1;
		while (l < r && inorder.get(l) == inorder.get(r)) {
			l++;
			r--;
		}
        return l >= r ? true : false;
    }
	
	private void helper1(TreeNode node, List<Integer> l) {
		if (node == null) return;
		helper1(node.left, l);
		l.add(node.val);
		helper1(node.right, l);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(5);
		System.out.println(new SymetricTree().isSymmetric(root));
	}

}
