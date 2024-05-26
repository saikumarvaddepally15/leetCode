/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ls= new ArrayList<>();
        if(root!=null){
            postOrder(root,ls);
        }
        return ls;
    }
    private void postOrder(Node root,List<Integer> ls){
        if(root.children == null){
            ls.add(root.val);
            return;
        }
        for(Node child:root.children){
            postOrder(child,ls);
        }
        ls.add(root.val);
    }
}