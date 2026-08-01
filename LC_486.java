class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n-1,nums,dp)>=0;
    }
    public int solve(int i,int j,int nums[],int dp[][]){
        if(i==j) return nums[i];
        if(dp[i][j]!=-1) return dp[i][j];

        // pich left
        int left=nums[i]-solve(i+1,j,nums,dp);

        //pick right
        int right=nums[j]-solve(i,j-1,nums,dp);

        return dp[i][j]=Math.max(left,right);
    }
}
