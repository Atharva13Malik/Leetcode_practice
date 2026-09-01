class Solution {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;

        int req = need.size();
        int formed = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) &&
                window.get(ch).equals(need.get(ch))) {
                formed++;
            }

            while (formed == req) {

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                char chleft = s.charAt(left);

                window.put(chleft, window.get(chleft) - 1);

                if (need.containsKey(chleft) &&
                    window.get(chleft) < need.get(chleft)) {
                    formed--;
                }

                left++;
            }
        }

        return min == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + min);
    }
}
