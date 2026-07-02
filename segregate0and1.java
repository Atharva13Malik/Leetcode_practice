class Solution {
    void segregate0and1(int[] arr) {

       int i=0;
       int j=arr.length-1;
       while(i<j){
           if(arr[i]==0) i++;
           if(arr[j]==1) j--;
           else if(arr[i]==1 && arr[j]==0){
             arr[i]=0;
             arr[j]=1;
           }
       }
    }
}
