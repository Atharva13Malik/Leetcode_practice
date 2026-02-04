class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, s, set, dp);
    }

    public boolean helper(int i, String s, Set<String> set, Boolean[] dp) {
        if (i == s.length()) return true;

        if (dp[i] != null) return dp[i];

        for (int end = i + 1; end <= s.length(); end++) {
            String curr = s.substring(i, end);
            if (set.contains(curr)) {
                if (helper(end, s, set, dp)) {
                    return dp[i] = true;
                }
            }
        }

        return dp[i] = false;
    }
}
