class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int left=0;
        int maxfreq=0;
        int length=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            mp.put(ch,mp.getOrDefault(ch,0)+1);

            // hmm maxfreq jo bhi add hota jayega uski nikalenge aur previous wale se compare krneg
            maxfreq=Math.max(maxfreq,mp.get(ch));

            length=right-left+1;

            while(length-maxfreq >k){
                char chl=s.charAt(left);

                mp.put(chl,mp.get(chl)-1);
                left++;
            }
            ans=Math.max(ans,right-left+1);
            
        }
        return ans;
    }
}
