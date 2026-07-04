class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minPrice=prices[0];
        int maxprofit=0;

        for(int i=0;i<n;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-minPrice);
        }

        return maxprofit;
    }
}
