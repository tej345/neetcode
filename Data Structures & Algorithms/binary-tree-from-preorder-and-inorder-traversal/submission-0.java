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

    private int preorderIndex = 0;
    private Map<Integer, Integer>inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int []preorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inorderRootIndex = inorderMap.get(rootValue);

        root.left = arrayToTree(preorder, left, inorderRootIndex - 1);
        root.right = arrayToTree(preorder, inorderRootIndex + 1, right);

        return root;
    }
}
