package leetcode.next1;
/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 */
public class FlattenBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		flattenHelper(root);
		System.out.println(root);
		
//		if (root != null) {
//            TreeNode left = root.left;
//            TreeNode right = root.right;
//            if (left != null) {
//                root.left = null;
//                root.right = left;
//                while (left.right != null) {
//                    left = left.right;
//                }
//                left.right = right;
//            }
//            flatten(root.right);
//        }
	}
	
	private void flattenHelper(TreeNode node) {
		if (node != null) {			
			flattenHelper(node.left);
			flattenHelper(node.right);
			if (node.left != null) {
				TreeNode walk = node.left; 
				while(walk.right != null) {
					walk = walk.right;
				}
				walk.right = node.right;	
				node.right = node.left;
				node.left = null;
			}
		}
	}

	public static void main(String[] args) {
		FlattenBinaryTree f = new FlattenBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(0);
		root.left.left.left.right = new TreeNode(8);
		root.left.left.left.right.left = new TreeNode(9);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		f.flatten(root);
		System.out.println();
	}

}
