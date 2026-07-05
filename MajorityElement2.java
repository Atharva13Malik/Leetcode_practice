class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> mp= new HashMap<>();
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<>();

        for(int i:nums){
            
            mp.put(i,mp.getOrDefault(i,0)+1);
            
        }

        for(int value:mp.keySet()){
            if(mp.get(value) > n/3){
               list.add(value);
            }
        }
        return list;

    }
}
