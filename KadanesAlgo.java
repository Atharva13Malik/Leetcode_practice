class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(maxsum<sum){
                maxsum=sum;
            }
            if(sum<0) sum=0;
        }
        return maxsum;
    }
}
