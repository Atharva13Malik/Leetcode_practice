class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        int n=bloomDay.length;

        for(int i=0;i<n;i++){
            end=Math.max(end,bloomDay[i]);
        }

        for(int i=0;i<n;i++){
            start=Math.min(start,bloomDay[i]);
        }
        int result=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(ans(bloomDay,mid,k,m)){
                result=mid;
                end=mid-1;

            }else{
                start=mid+1;
            }
        }
        return result;
        
    }
    public boolean ans(int bloomDay[],int mid,int k,int m){
        int count=0;
        int total=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                count++;
            }else{
                total+= count/k;
                count=0;
            }
        }
        total+=count/k;

        if(total>=m) return true;
        return false;
    }
}
