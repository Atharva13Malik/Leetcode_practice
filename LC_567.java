class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need[ch - 'a']++;
        }

        int left = 0;
        int k = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);
            window[ch - 'a']++;

            if (right - left + 1 > k) {

                char leftChar = s2.charAt(left);
                window[leftChar - 'a']--;

                left++;
            }

            if (right - left + 1 == k &&
                Arrays.equals(need, window)) {
                return true;
            }
        }

        return false;
    }
}
