class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set=new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('O');
        set.add('I');
        set.add('U');
        
        
        int left=0;
        int right=s.length()-1;

        char arr[]=s.toCharArray();

        while(left<right){
           
           while(left<right && !set.contains(arr[left])){
            left++;
           }
           while(left<right && !set.contains(arr[right])){
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
