class Solution {
    public int minInsertions(String s) {
       String rev="";
       for(int i=s.length()-1;i>=0;i--){
        char ch=s.charAt(i);
        rev+=ch;
       }
       int store= helper(s,rev);
       return s.length()-store;
    }
    public int helper(String s,String rev){
        int n=s.length();
        int m=rev.length();

        int dp[][]=new int[n][m];

        dp[0][0]=(s.charAt(0)==rev.charAt(0))? 1:0 ;

        for(int i=1;i<n;i++){
          dp[i][0]=(s.charAt(i)==rev.charAt(0)) ?1:dp[i-1][0];
        }

        for(int j=1;j<n;j++){
          dp[0][j]=(s.charAt(0)==rev.charAt(j)) ?1:dp[0][j-1];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s.charAt(i)==rev.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n-1][m-1];

       

    }
}
