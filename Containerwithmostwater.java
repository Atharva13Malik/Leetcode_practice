class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int n=arr.length;
        int left=0;
        int right=n-1;
        int area=0;
        
        while(left<right){
           int width=right-left;
           int height=Math.min(arr[left],arr[right]);
            int currarea=height*width;
            area=Math.max(currarea,area);
            
            if(Math.min(arr[left],arr[right])==arr[left]) left++;
            else right--;
        }
        return area;
    }
}
