class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();

        int last[]=new int[26];
        Arrays.fill(last,-1);
        for(int i=s.length()-1;i>=0;i--){
            int idx=s.charAt(i)-'a';
            if(last[idx]==-1){
                last[idx]=i;
            }
        }

        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,last[s.charAt(i)-'a']);

            if(i==end){
                list.add(end-start+1);
                start=end+1;
            }
        }
        return list;
    }
}
