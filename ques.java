class Solution {

    public int longestUniqueTransactions(int[] transactions) {

        // Write your code here
        int n=transactions.length;
        
        HashMap<Integer,Integer> mp=new HashMap<>();
        int left=0;
        for(int right=0;right<n;right++){
            mp.put(transactions[right],mp.getOrDefault(transactions[right],0)+1);
            
            while(mp.get(transactions[right])>1){
                mp.put(transactions[left],mp.get(transactions[left])-1);
                left++;
            }
            
            max=Math.max(max,right-left+1);
        }
 
    }
}
