class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int y=1000000007;

        

       for(int num:nums){
        pq.add(num);
       }

       while(k>0){
        int x=pq.poll();
        pq.add(x+1);
        k--;
       }

       long  product=1;
       while(!pq.isEmpty()){
        product=(product*pq.poll())%y;
       }

       return (int)product;
    }
}
