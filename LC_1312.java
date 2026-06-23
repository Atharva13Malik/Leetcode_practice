class Solution {
    public int minInsertions(String s) {
       String rev="";
       for(int i=s.length()-1;i>=0;i--){
        rev+=s.charAt(i);
       }

       return s.length()-LPS(s,rev);
    }
    public int LPS(String a,String b){
        int m=a.length();
        int n=b.length();

        int dp[][]=new int[m][n];

        dp[0][0]=(a.charAt(0)==b.charAt(0))?1:0;
        for(int i=1;i<m;i++){
            dp[i][0]=(a.charAt(i)==b.charAt(0))?1:dp[i-1][0];
        }

         for(int j=1;j<m;j++){
            dp[0][j]=(a.charAt(0)==b.charAt(j))?1:dp[0][j-1];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a.charAt(i)==b.charAt(j)){
                    dp[i][j]+=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
