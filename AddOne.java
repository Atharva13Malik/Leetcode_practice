class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        int carry=1;
        int n=arr.length;
        Vector<Integer> ans=new Vector<>();
        
        for(int i=n-1;i>=0;i-- ){
            if(arr[i]+carry <=9){
                ans.add(arr[i]+carry);
                carry=0;
                
            }else{ // 9 ya usse kmm nhi toh 10
                ans.add(0);
                carry=1;
            }
        }
        if(carry==1) ans.add(carry);
        Collections.reverse(ans);
        return ans;
    }
}
