class Solution {
    public int search(int[] nums, int target) {
        int ans=-1;
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;

            //Left half is sorted
            else if(nums[start]<=nums[mid]){
                if(target >= nums[start] && target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            // Right half is sorted
            else {
                if(target<=nums[end] && target>nums[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return ans;
    }
}
