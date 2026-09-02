class Solution {
    public int minDeletions(String s) {
       char arr[]=s.toCharArray();
       HashMap<Character,Integer> mp=new HashMap<>();
       Arrays.sort(arr);
       int count=0;

       for(int i=0;i<arr.length;i++){
          mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
       }
       HashSet<Integer> set=new HashSet<>();

       for(int x:mp.values()){
        
        while(x>0 && set.contains(x)){
            x--;
            count++;
        }
        if(x>0) set.add(x);
        
       }

       return count;
    }
}
