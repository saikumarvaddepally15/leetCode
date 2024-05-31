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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inmap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        TreeNode root= buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);
        return root;
    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,  Map<Integer,Integer> inmap){
        if(preStart>preEnd || inStart>inEnd)return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRootIndex=inmap.get(root.val);
        int numsLeft = inRootIndex-inStart;
        root.left=buildTree(preorder,preStart+1,preStart+numsLeft,inorder,
                            inStart,inRootIndex-1,inmap);
        root.right=buildTree(preorder,preStart+numsLeft+1,preEnd,
                            inorder,inRootIndex+1,inEnd,inmap);
        return root;
    }
}