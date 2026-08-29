class Solution {

    public boolean canBuyTwoTickets(int[] tickets, int budget) {
        
        HashMap<Integer,Integer> mp=new HashMap<>();

        // Write your code here
        for(int x:tickets){
            int target=budget-x;
            if(mp.containsKey(target)){
                return true;
            }
            mp.put(x,mp.getOrDefault(x,0)+1);
        }

        return false;

    }
}
