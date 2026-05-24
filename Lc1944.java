class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        Stack<Integer> stk=new Stack<>();
        int res[]=new int[n];
        stk.push(heights[n-1]);
        res[n-1]=0;

        for(int i=n-2;i>=0;i--){
            int count=0;
            while(!stk.isEmpty()  && stk.peek()<heights[i]){
                count++;
                stk.pop();
                

                
            }
            if(stk.size()>0) count++;  // stk ka size >0 ka mtlb hme next greater element mila 
            res[i]=count;
            stk.push(heights[i]);
        }
        return res;
    }
}
