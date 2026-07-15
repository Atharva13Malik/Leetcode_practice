class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int target=total-x;
        int sum=0;
        int length=-1;
        int left=0;

        // agar target=0 hoga toh pura array ke elements hi remove krne honge
        if(target==0) return nums.length;

        for(int right=0;right<nums.length;right++){
            sum+=nums[right];

            while(left<=right && sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
            length=Math.max(length,right-left+1);
            }
        }
        return length == -1 ? -1 : nums.length - length;

    }
}
