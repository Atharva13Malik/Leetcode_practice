class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int n=temperatures.length;
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            while(!stk.isEmpty()  && temperatures[stk.peek()]<temperatures[i]){
                int idx=stk.pop();
                ans[idx]=i-idx;

            }
            stk.push(i);
        }

        return ans;

    }
}
