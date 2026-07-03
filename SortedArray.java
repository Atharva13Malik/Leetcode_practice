class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        boolean ans=true;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                ans=false;
            }
        }
        return ans;
    }
}
