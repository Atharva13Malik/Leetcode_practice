class Solution {
    private String traversal(TreeNode node){
        if(node==null) return null;
        return node.val+traversal(node.left)+traversal(node.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null) return true; 
        if(p!=null && q!=null){
        if(traversal(p).equals(traversal(q))){
            return true;

        }
        }
        return false;
    }
}
