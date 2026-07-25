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

    private int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int currentMax = root.val;
        goodCount(root, currentMax);
        return goodNodes;
    }

    private void goodCount(TreeNode root, int currentMax){
        if(root == null){
            return;
        }
        if(root.val >= currentMax){
            currentMax = root.val;
            goodNodes++;
        }

        goodCount(root.left, currentMax);
        goodCount(root.right, currentMax);
    }
}
