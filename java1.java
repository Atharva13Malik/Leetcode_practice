class Solution {

    public char mostFrequentChar(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();

        // Step 1: Frequency store
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Maximum frequency character
        int maxFreq = 0;
        char ans = s.charAt(0);

        for (char ch : s.toCharArray()) {
            if (mp.get(ch) > maxFreq) {
                maxFreq = mp.get(ch);
                ans = ch;
            }
        }

        return ans;
    }
}
