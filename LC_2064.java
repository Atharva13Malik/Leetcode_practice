class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start=1;
        int end=quantities[0];
        for(int i=1;i<quantities.length;i++){
            end=Math.max(end,quantities[i]);
        }
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(possible(quantities,mid,n)){
                ans=mid;
                end=mid-1;

            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int quantities[],int mid,int n){
        int count=0;
        for(int i=0;i<quantities.length;i++){
            count+= quantities[i]/mid;
            if(quantities[i]%mid !=0) count++;
        }
        if(count<=n) return true;
        return false;
    }
}
