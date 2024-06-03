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
    public int kthSmallest(TreeNode root, int k) {
        int[] kSmallest = new int[]{Integer.MIN_VALUE};
        int[] counter = new int[]{0};
        inorder(root,k,kSmallest,counter);
        return kSmallest[0];
    }
    void inorder(TreeNode root,int k, int[] smallest,int[] counter){
        if(root==null || smallest[0]>=k) return ;
        inorder(root.left,k,smallest,counter);
        counter[0]++;
        if(counter[0]==k){
            smallest[0]=root.val;
            return;
        } 
        inorder(root.right,k,smallest,counter);
    }
}