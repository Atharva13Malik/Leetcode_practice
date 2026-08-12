class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left=0;
        //int right=0;
        int n=nums.length;

        PriorityQueue<int[]> maxheap=new PriorityQueue<>((a,b)->b[0]-a[0]);

        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->a[0]-b[0]);

        int ans=0;

        for(int right=0;right<n;right++){
            maxheap.offer(new int[]{nums[right],right});
            minheap.offer(new int[]{nums[right],right});

            while(!maxheap.isEmpty()  && maxheap.peek()[1]<left){
                maxheap.poll();
            }

            while(!minheap.isEmpty() && minheap.peek()[1]<left){
                minheap.poll();
            }

            while(maxheap.peek()[0]-minheap.peek()[0] > limit){
                left++;


                while(!maxheap.isEmpty()  && maxheap.peek()[1]<left){
                  maxheap.poll();
                }

                while(!minheap.isEmpty() && minheap.peek()[1]<left){
                  minheap.poll();
                }


            }

            ans=Math.max(ans,right-left+1);
        }

        return ans;

        

    }
}
