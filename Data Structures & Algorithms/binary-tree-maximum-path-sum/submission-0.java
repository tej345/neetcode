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
    private int globalSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateSum(root);
        return globalSum;
    }

    private int calculateSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftGain = Math.max(calculateSum(root.left), 0);
        int rightGain = Math.max(calculateSum(root.right), 0);

        int sum = root.val + leftGain + rightGain;

        globalSum = Math.max(globalSum, sum);

        return root.val +  Math.max(leftGain, rightGain);
    }
}
