package leetcode.recap;

public class FlattenBT {
	
	public void flatten(TreeNode root) {
        flattenHelper(root);
    }
	
	private TreeNode flattenHelper(TreeNode node) {
		if (node == null) return null;
		TreeNode left = flattenHelper(node.left);
		if (left != null) {
			TreeNode r = node.right;
			TreeNode walk = left;
			while (walk.right != null) {
				walk = walk.right;
			}
			node.right = left;
			node.left = null;
			walk.right = r;
		}
		flattenHelper(node.right);
		return node;
	}

	public static void main(String[] args) {
/*
	 		1
	 	  /   \
	 	 2     6
	 	/ \   / \
	   3   4 5   7
	  /
	 0
      \
       8
      /
     9
 */
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
		FlattenBT f = new FlattenBT();
		f.flatten(root);
		System.out.println();

	}

}
