class Solution {
    public List<String> generateParenthesis(int n) {
        String current="";
        int open=0;
        int close=0;
        List<String> result=new ArrayList<>();
        recursive(result,"",0,0,n);
        return result;

    }
    public void recursive( List<String> result, String current,int open ,int close,int n){

        //Base Case(where we need to stop)
        if(open==n && close==n){
            result.add(current);
        }
        if(open<=n){
            recursive(result,current+"(",open+1,close,n);

        }
        if(close<open){
            recursive(result,current+")",open,close+1,n);
        }
    }
}
