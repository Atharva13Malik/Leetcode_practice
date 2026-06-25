class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();

        return helper(result,root);
    }

    public List<Integer> helper(List<Integer> result,TreeNode root){
        if(root==null) return result;
        result.add(root.val);
        helper(result,root.left);
        helper(result,root.right);

        return result;

    }
}
