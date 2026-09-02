class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp=new HashMap<>();

        for(String word:strs){
            char arr[]=word.toCharArray();
            Arrays.sort(arr);

            String key=new String(arr);
            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }
            mp.get(key).add(word);
        }

        return new ArrayList<>(mp.values());
    }
}
