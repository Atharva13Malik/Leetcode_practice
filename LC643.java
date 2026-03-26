class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double max=0;
        int n=nums.length;

        if(nums.length==1)  return (double)nums[0];

        for(int i=0;i<k;i++){
            sum+=nums[i];

        }
        //sum=sum;
        max=sum/k;

        for(int j=k;j<n;j++){
            sum+=nums[j];
            sum-=nums[j-k];
            //sum=sum/k;

            max=Math.max(sum/k,max);
        }

        return max;
    }
}
