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
    public int maxPathSum(TreeNode root) {
        int[] maxsum = new int[1];
        maxsum[0]=Integer.MIN_VALUE;
        height(root,maxsum);
        return maxsum[0];
    }
    private int height(TreeNode node, int[] maxsum){
        if(node==null) return 0;
        int lh=Math.max(0,height(node.left,maxsum));
        int rh=Math.max(0,height(node.right,maxsum));
        maxsum[0]=Math.max(maxsum[0],lh+rh+node.val);
        return Math.max(lh,rh)+node.val;
    }
}