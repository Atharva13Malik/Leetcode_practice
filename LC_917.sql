class Solution {
    public String reverseOnlyLetters(String s) {
          int left=0;
        int right=s.length()-1;

        char arr[]=s.toCharArray();

        while(left<right){
           
           while(left<right && !Character.isLetter(arr[left])){
            left++;
           }
           while(left<right && !Character.isLetter(arr[right])){
            right--;
           }

           char temp=arr[left];
           arr[left]=arr[right];
           arr[right]=temp;

           left++;
           right--;
        }

        return new String(arr);
    }
}
