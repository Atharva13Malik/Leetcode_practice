class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int length=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='R') count+=1;
            else if(ch=='L') count-=1;

            if(count==0) length++;
        }

        return length;
    }
}
