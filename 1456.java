class Solution {
    public boolean isvowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
    public int maxVowels(String s, int k) {
        int count=0;
        int maxcount=0;

        for(int i=0;i<k;i++){
            if(isvowel(s.charAt(i)))  count++;
        }

        maxcount=count;
        for(int j=k;j<s.length();j++){
            char addchar=s.charAt(j);
            char removechar=s.charAt(j-k);

            if(isvowel(addchar)) count++;

            if(isvowel(removechar)) count--;

            maxcount = Math.max(maxcount, count);
        }

        return maxcount;



    }
}
