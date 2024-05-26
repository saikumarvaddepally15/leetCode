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
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root!=null){
            preOrder(root,ls);
        } 
        return ls;
    }
    private void preOrder(Node root, List<Integer> list){
        list.add(root.val);
        for(Node child: root.children){
            preOrder(child,list);
        }

    }
}