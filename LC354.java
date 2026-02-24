class Solution {
    public int maxEnvelopes(int[][] envelopes) {
       Arrays.sort(envelopes,(a,b)->{
        if(a[0]==b[0]){
            return b[1]-a[1];
        }
        return a[0]-b[0];
       });

       int n = envelopes.length;
       int heights[]=new int[n];

       for(int i=0;i<n;i++){
        heights[i]=envelopes[i][1];
       }

       int dp[]=new int[n];
       Arrays.fill(dp,1);

       int ans=0;

       for(int i=0;i<dp.length;i++){
        for(int j=0;j<i;j++){
            if(heights[i]>heights[j]){
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            
        }
        ans=Math.max(ans,dp[i]);
       }
       return ans;
    }
}
