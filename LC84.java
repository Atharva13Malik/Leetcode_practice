class Solution {
    public int largestRectangleArea(int[] heights) {
       int n=heights.length;
       int right[]=new int[n];
       int left[]=new int [n];
       Stack<Integer>stk=new Stack<>();

       //Right smaller element
       for(int i=n-1;i>=0;i--){
        while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
            stk.pop();
        }
        right[i]=stk.isEmpty()?n:stk.peek();
        stk.push(i);
       }

       while(!stk.isEmpty()){
        stk.pop();
       }

       //left smaller
       for(int i=0;i<n;i++){
        while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
            stk.pop();
        }
        left[i]=stk.isEmpty()?-1:stk.peek();
        stk.push(i);
       }
       int ans=0;
       for(int i=0;i<n;i++){
        int width=right[i]-left[i]-1;
        int currarea=heights[i]*width;
        ans=Math.max(ans,currarea);
       }
       return ans;


    }
}
