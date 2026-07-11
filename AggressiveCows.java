class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int start=1;
        int end=arr[arr.length-1]-arr[0];
        
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(possible(arr,mid,k)){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    public boolean possible(int arr[],int mid,int k){
        int lastposition=arr[0];
        int cows=1;
        
        for(int i=1;i<arr.length;i++){
            int distance=arr[i]-lastposition;
            if(distance>=mid){
                cows++;
                lastposition=arr[i];
                
                if(cows==k) return true;
            }
            
        }
        return false;
    }
    
}
