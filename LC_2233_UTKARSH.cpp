class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        //hmesha min element ko hi uthana hai 
        //priority queue use karo 
        const int MOD=1e9+7;
        priority_queue<int,vector<int>,greater<int>>pq;
        for(auto n:nums){
            pq.push(n);
        }
        long long  prod=1;
        for(int i=0;i<k;i++){
         int p=pq.top();
         pq.pop();
         pq.push(p+1);
        }
        while(!pq.empty()){
            prod=(prod*pq.top())%MOD;
            pq.pop();
        }
        return prod;
       
    }
};
