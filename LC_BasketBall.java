class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<operations.length;i++){
            String ch=operations[i];
            if(ch.equals("+")){
              int size=stk.size();
              stk.push(stk.get(size-1)+stk.get(size-2));

            }
            else if(ch.equals("D")){
                stk.push(2 * stk.peek());
            }
            else if(ch.equals("C")){
                stk.pop();
            }
            else{
                stk.push(Integer.parseInt(ch));
            }
        }
        for(int val:stk){
            sum+=val;
        }
        return sum;
    }
}
