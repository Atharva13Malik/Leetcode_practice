class Solution {
    int size=0;
    public int getSize(Node root) {
        // code here
        if(root==null) return size;
        size++;
        getSize(root.left);
        getSize(root.right);
        
        return size;
    }
}
