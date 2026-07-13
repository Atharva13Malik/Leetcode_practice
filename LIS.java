class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int n=nums.length;
        int dp[]=new int[n];
        //Arrays.fill(dp,-1);
        Arrays.fill(dp,1);
        dp[0]=1;

        for(int i=1;i<n;i++){
           for(int j=0;j<i;j++){
            if(nums[j] < nums[i]){
               dp[i]=Math.max(dp[i],dp[j]+1);
            }
            
            
           }
           //dp[i]+=1;
        }
        
        int ans=0;
        for(int x : dp){
            ans=Math.max(x,ans);
        }
        return ans;

    }
}
