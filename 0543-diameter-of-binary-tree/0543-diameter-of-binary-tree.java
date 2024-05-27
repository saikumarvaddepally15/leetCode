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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max= new int[1];
        height(root,max);
        return max[0];
        
    }
    private int height(TreeNode node,int[] max){
        if(node==null) return 0;
        int lh=height(node.left,max);
        int rh=height(node.right,max);
        max[0]=Math.max(max[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}