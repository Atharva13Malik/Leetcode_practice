class Solution {
    //public int sum;
    public int mean(int nums[],int i){
         int n=nums.length;
         int sum=0;
        for(int j=i+1;j<n;j++){
            sum+=nums[j];
        }
        return sum/(n-i-1);
    }
    
    public int dominantIndices(int[] nums) {
         int n=nums.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            int average=mean(nums,i);
            if(average<nums[i]){
                count++;
            }
             
        }
        return count;
    }
}
