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

    PriorityQueue <TreeNode> pq = new PriorityQueue <>((a,b) -> a.val - b.val);

    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k == 0){
            return 0;
        }
        encodeNode(root);
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            TreeNode node = pq.poll();
            result = node.val;
        }
        return result;
    }

    private void encodeNode(TreeNode root){
        if(root == null){
            return;
        }
        pq.add(root);
        encodeNode(root.left);
        encodeNode(root.right);
    }
}
