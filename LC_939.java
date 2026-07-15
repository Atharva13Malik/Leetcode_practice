class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int n=nums.length;
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
           sum+=nums[i];
           int k=sum-goal;
           if(mp.containsKey(k)){
           // mp.put(sum,mp.get(k)+1);
            count+= mp.get(k);
           }
           mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
