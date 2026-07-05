class Solution {
    int ans;
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Integer key:mp.keySet()){
            int value=mp.get(key);
            if(value> n/2) ans=key;
        }

        return ans;
    }
}
