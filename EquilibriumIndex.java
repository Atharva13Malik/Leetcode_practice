class Solution {
    static long rightsum;
    public static int findEquilibrium(int arr[]) {
        // code here
        long totalsum=0;
        
        for(int x:arr){
            totalsum+=x;
        }
        long leftsum=0;
        for(int i=0;i<arr.length;i++){
             rightsum=totalsum-leftsum-arr[i];
            
            if(leftsum==rightsum) return i;
            
            leftsum+=arr[i];
        }
        
        return -1;
        
        
    }
}
