package ardendertat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.TreeNode;

/*
      1
     / \
    2   3
   /   / \
  4   5   6
 / \   \   \
7   8   9   10
=>
1
2 3
4 5 6

*/
public class TreeLevelOrderPrint {
	
	public String levelOrderPrint(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 1;
		int nextLevel = 0;
		StringBuilder sb = new StringBuilder();
		Stack<String> reverse = new Stack<>();
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			if (node.left != null) {
				q.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				q.add(node.right);
				nextLevel++;
			}
			sb.append(node.val);
			level--;
			if (level == 0) {
				sb.append("\n");
				level = nextLevel;
				nextLevel = 0;
			} else {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	public String levelReverseOrderPrint(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 1;
		int nextLevel = 0;
		String line = "";
		Stack<String> reverse = new Stack<>();
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			if (node.left != null) {
				q.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				q.add(node.right);
				nextLevel++;
			}
			line += node.val;
			level--;
			if (level == 0) {
				level = nextLevel;
				nextLevel = 0;
				reverse.push(line);
				line = "";
			} else {
				line += " ";
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!reverse.isEmpty()) {
			sb.append(reverse.pop() + '\n');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.right.left = new TreeNode(5);
//		root.right.right = new TreeNode(6);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(8);
//		root.right.left.right = new TreeNode(9);
//		root.right.right.right = new TreeNode(10);
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		TreeNode n = new TreeNode(5);
		root.left.right.right = n;
		root.right.left = n;
		
		
		TreeLevelOrderPrint t = new TreeLevelOrderPrint();
		System.out.println(t.levelOrderPrint(root));
	}

}
