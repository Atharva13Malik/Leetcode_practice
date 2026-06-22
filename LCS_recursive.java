class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m=a.length();
        int n=b.length();
        if(m==0 || n==0)  return 0;
        String str1=a.substring(0,m-1);
        String str2=b.substring(0,n-1);

        


        if(a.charAt(m-1)==b.charAt(n-1)) return 1+longestCommonSubsequence(str1,str2);
        else return Math.max(longestCommonSubsequence(a,str2),longestCommonSubsequence(b,str1));


    }
}
