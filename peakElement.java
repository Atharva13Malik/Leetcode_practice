class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        if(nums.length==1) return 0;
        int ans=-1;

        if(nums[0]>nums[1]) return 0;
        if(nums[end]>nums[end-1]) return end;

        start=1;
        end=nums.length-2;
        while(start<=end){

            int mid=start+(end-start)/2;
            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]){
                ans=mid;
                break;
            }else if(nums[mid-1]<nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }
        return ans;
    }
}
