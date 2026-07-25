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

    private int result = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k == 0){
            return 0;
        }
        levelOrder(root, k);
        return result;
    }

    private void levelOrder(TreeNode root, int k){
        if(root == null){
            return;
        }
        levelOrder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        levelOrder(root.right, k);
    }
}
