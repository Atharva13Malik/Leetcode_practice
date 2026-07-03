class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        for(int key:mp.keySet()){
            if(mp.get(key)==2){
                ans.add(key);
            }
        }
        return ans;
        
        
    }
}
