class Solution {
     public int getMaxArea(int[] heights) {
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
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=1;i<=m;i++){
           for(int j=0;j<=n;j++){
            if(matrix[i][j]==1) matrix[i-1][j]+=matrix[i-1][j];
           }
        }
        int max=0;
        for(int row[]:matrix){
            int area=getMaxArea(row);
            max=Math.max(area,max);
        }

        return max;
    }
}
