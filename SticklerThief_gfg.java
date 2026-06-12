class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return loot(0,arr,dp);
    }
    
    public int loot(int i,int arr[],int dp[]){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=arr[i]+loot(i+2,arr,dp);
        int skip=loot(i+1,arr,dp);
        
        
        dp[i]=Math.max(pick,skip);
        return dp[i];
    }
}
