/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int minDepth(TreeNode root) {
        
    	if(root == null) {
    		return 0;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return 1;
    	}
    	
    	if(root.left == null) {
    		return 1+ minDepth(root.right);
    	}
    	
    	if(root.right ==  null) {
    		return 1 + minDepth(root.left);
    	}
    	
    	int leftDep = minDepth(root.left);
    	int rightDep =  minDepth(root.right);
    	
    	return 1 + Math.min(leftDep, rightDep);
    	
    }
}