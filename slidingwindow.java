class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum=0;
        int max=0;
        int n=arr.length;
        
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max=sum;
        for(int i=k;i<arr.length;i++){
            sum=sum+arr[i]-arr[i-k];
           // sum=sum-arr[i-k];
            
            max=Math.max(sum,max);
        }
        
        return max;
    }
}
