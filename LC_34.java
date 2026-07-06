class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=binaryfirst(nums,target);
         if(first==-1){
          return new int[]{-1,-1};
        }

        int last=binarylast(nums,target);

       
        return new int[]{first,last};
    }
    public int binaryfirst(int nums[],int target){
        int start=0;
        int high=nums.length-1;
        int ans=-1;

        while(start<=high){
            int mid=start+(high-start)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;

            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                high=mid-1;
            }

        }
        return ans;

    }
    public int binarylast(int nums[],int target){
        int start=0;
        int high=nums.length-1;
        int ans=-1;

        while(start<=high){
            int mid=start+(high-start)/2;
            if(nums[mid]==target){
                ans=mid;
                start=mid+1;

            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                start=mid+1;
            }

        }
        return ans;
    }

}
