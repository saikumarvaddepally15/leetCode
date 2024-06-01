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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          Map<Integer,Integer> pomap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            pomap.put(inorder[i],i);
        }
        TreeNode root= buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,pomap);
        return root;
    }
    public TreeNode buildTree(int[] postorder,int poStart,int poEnd,int[] inorder,int inStart,int inEnd,  Map<Integer,Integer> pomap){
        if(poStart>poEnd || inStart>inEnd)return null;
        TreeNode root=new TreeNode(postorder[poEnd]);
        //for the sake of tracking the elements and to avoid duplicates.
        int inRootIndex=pomap.get(root.val);
        int numsLeft = inRootIndex-inStart;
        //left part recusrsion
        root.left=buildTree(postorder,poStart,poStart+numsLeft-1,
                           inorder,inStart,inRootIndex-1,pomap);
        //right part recursion
        root.right=buildTree(postorder,poStart+numsLeft,poEnd-1,
                            inorder,inRootIndex+1,inEnd,pomap);
        return root;
    }
}