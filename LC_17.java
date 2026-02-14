class Solution{
public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
        return ans;       // just return empty list if no input
    }

    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    backtrack(digits, 0, map, "", ans);
    return ans;
}

private void backtrack(String digits,int index,Map<Character, String> map,String curr, List<String> ans) {
    // Base case: we've processed all digits
    if (index == digits.length()) {
        ans.add(curr);
        return;
    }

    // Get the letters for the current digit
    String letters = map.get(digits.charAt(index));
    for (int i = 0; i < letters.length(); i++) {
        // Append one letter and move on to the next digit
        backtrack(digits,index + 1,map,curr + letters.charAt(i), ans);
     }
}
}
