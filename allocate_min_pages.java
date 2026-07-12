class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        long start=arr[0];
        long end=0;
        for(int i=0;i<arr.length;i++){
            start=Math.max(start,arr[i]);
            end+=arr[i];
        }
        if(arr.length < k) return -1;
        
        long ans=-1;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(possible(arr,mid,k)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return (int)ans;
    }
    public boolean possible(int arr[],long mid,int k){
        int student=1;
        long pages=0;
        for(int i=0;i<arr.length;i++){
            pages+=arr[i];
            if(pages>mid){
                student++;
                pages=arr[i];
            }
            
        }
        if(student<=k) return true;
        return false;
    }
}
