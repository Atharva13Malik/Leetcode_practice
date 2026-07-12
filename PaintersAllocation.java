class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int end=arr[0];
        int start=arr[0];
        for(int i=1;i<arr.length;i++){
            end+=arr[i];
            start=Math.max(start,arr[i]);
        }
        int ans=-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(possible(arr,mid,k)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
        return ans;
        
        
        
    }
    public boolean possible(int arr[], int mid, int painters) {

    int count = 1;
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {

        sum += arr[i];

        if (sum > mid) {
            count++;
            sum = arr[i];
        }
    }

    return count <= painters;
    }
}
