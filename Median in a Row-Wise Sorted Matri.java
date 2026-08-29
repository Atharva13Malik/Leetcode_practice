class Solution {
    public int median(int[][] mat) {
        // code here
        int m=mat.length;
        int n=mat[0].length;
        int arr[]=new int[m*n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k++]=mat[i][j];
            }
        }
        
        Arrays.sort(arr);
        
        return  arr[(m*n)/2];
    }
}
