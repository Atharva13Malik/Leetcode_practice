class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start=weights[0];
        for(int i=1;i<weights.length;i++){
            start=Math.max(start,weights[i]);
        }
        int end=0;
        for(int i:weights){
            end+=i;
        }
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(ans(weights,mid,days)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean ans(int weights[],int mid,int days){
        int reqdays=1;
        int capacity=0;
        for(int i=0;i<weights.length;i++){
            capacity+=weights[i];
            if(capacity>mid){
                reqdays+=1;
                capacity=weights[i];
            }
            if(reqdays>days) return false;


        }
        if(reqdays>days) return false;
        return true;
    }
}
