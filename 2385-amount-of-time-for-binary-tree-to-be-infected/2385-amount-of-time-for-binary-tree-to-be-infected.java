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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> mpp= new HashMap<>();
        TreeNode target= bfsForParentTracking(root,mpp,start);
        int maxi=bfsToFindTimeToBurn(mpp,target);
        return maxi;
    }
    private TreeNode bfsForParentTracking(TreeNode root,HashMap<TreeNode,TreeNode> mpp,int start){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode res= new TreeNode(-1);
        while(!q.isEmpty()){
            TreeNode node= q.poll();
            if(node.val==start) res=node;
            if(node.left!=null){
                mpp.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                mpp.put(node.right,node);
                q.offer(node.right);
            }

        }
        return res;
    }
    private int bfsToFindTimeToBurn(HashMap<TreeNode,TreeNode> mpp,TreeNode target){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode,Integer> vis= new HashMap<>();
        vis.put(target,1);
        int maxi=0;
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
            if(node.left!=null && !vis.containsKey(node.left)){
                flag=1;
                vis.put(node.left,1);
                q.offer(node.left);
            }
            if(node.right!=null && !vis.containsKey(node.right)){
                flag=1;
                vis.put(node.right,1);
                q.offer(node.right);
            }
            if(mpp.get(node)!=null && !vis.containsKey(mpp.get(node))){
                flag=1;
                vis.put(mpp.get(node),1);
                q.offer(mpp.get(node));
            }
         }
            if(flag==1) maxi++;

        }
        return maxi;
    }
}