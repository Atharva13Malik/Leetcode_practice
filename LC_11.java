class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int width=0;
        int length=0;
        int area=1;
        int max=0;

        while(left<right){
            width=right-left;
            length=Math.min(height[left],height[right]);

            area=width*length;
            max=Math.max(max,area);

            if (height[left] < height[right]) {
               left++;
            } else {
               right--;
            }


        }
        return max;
    }
}
