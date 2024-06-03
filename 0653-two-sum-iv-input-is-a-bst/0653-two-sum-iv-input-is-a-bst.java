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
      public boolean findTarget(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);
        return findtwosum(ls, k);
    }

    private void inorder(TreeNode root, List<Integer> ls) {
        if (root == null) return;
        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }

    private boolean findtwosum(List<Integer> ls, int k) {
        int i = 0;
        int j = ls.size() - 1;
        while (i < j) {
            if (ls.get(i) + ls.get(j) == k) {
                return true;
            } else if (ls.get(i) + ls.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}