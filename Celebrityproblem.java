class Solution {
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer> stk=new Stack<>();
        int n=mat.length;
        for(int i=0;i<n;i++){
            stk.push(i);
        }
        
        while(stk.size()>1){
            int a=stk.pop();
            int b=stk.pop();
            
            boolean aflag=true;
            boolean bflag=true;
            
            if(mat[a][b]==1){
                aflag=false;
            }else{
                bflag=false;
            }
            if(mat[b][a]==1){
                bflag=false;
            }else{
                aflag=false;
            }
            if(aflag==true) stk.push(a);
            if(bflag==true) stk.push(b);
        }
        
        if(stk.size()==0) return -1;
        // checking last element of the stack
        int celeb=stk.pop();
        for(int i=0;i<n;i++){
            if(i==celeb) continue;
            if(mat[celeb][i]==1){
                return -1;
            }
        }
        for(int j=0;j<n;j++){
            if(j==celeb) continue;
            if(mat[j][celeb]==0){
                return -1;
            }
        }
        
        return celeb;
        
    }
}
