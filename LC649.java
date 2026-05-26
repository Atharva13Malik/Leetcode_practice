class Solution {
    public String predictPartyVictory(String s) {
        Queue<Integer> rad=new LinkedList<>();
        Queue<Integer> dir=new LinkedList<>();

        int n= s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='R'){
                rad.add(i);
            }
            if(ch=='D'){
                dir.add(i);
            }
        }

        while(!rad.isEmpty()  && !dir.isEmpty()){
            if(rad.peek()<dir.peek()){
                dir.remove();
                rad.add(rad.remove()+n);
            }
            else if(rad.peek()>dir.peek()){
                rad.remove();
                dir.add(dir.remove()+n);
            }
        }

        if(rad.size()==0) return "Dire";
        return "Radiant";
    }
}
