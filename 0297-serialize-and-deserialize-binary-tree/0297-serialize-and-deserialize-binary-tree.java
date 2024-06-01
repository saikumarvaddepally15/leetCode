/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        StringBuilder res= new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                res.append("k ");
                continue;
            }
            res.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q= new LinkedList<>();
        String[] values= data.split(" ");
        TreeNode root = values[0].equals("k")?null:new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<values.length){
            TreeNode node=q.poll();
            if(node!=null){
            if(!values[i].equals("k")){
                TreeNode left= new TreeNode(Integer.parseInt(values[i]));
                node.left=left;
                q.offer(left);
            }i++;
             if(i<values.length && !values[i].equals("k")){
                TreeNode right= new TreeNode(Integer.parseInt(values[i]));
                node.right=right;
                q.offer(right);
            }
            i++;
        }
        }
          return root;
      
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));