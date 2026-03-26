class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
      int sum=0;
      int count=0;
      int max=0;
      int n=arr.length;

      for(int i=0;i<k;i++){
        sum+=arr[i];
      }
      if(sum>=k*threshold)  count++;

      for(int j=k;j<n;j++){
        sum+=arr[j];
        sum-=arr[j-k];

        if(sum>=k*threshold)  count++;
      }

      return count;
    }
}
