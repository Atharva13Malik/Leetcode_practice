class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int n=nums.length;
        int count=0;
        int length=0;
        while(right<n){
            if(nums[right]==0) count++;
            while(count>k){
                if(nums[left]==0) count--;
                left++;
            }
            length=Math.max(right-left+1,length);
            right++;


        }
        return length;

    }
}
