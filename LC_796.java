class Solution {
    public boolean rotateString(String s, String goal) {
        return (s.length()==goal.length() && (s+s).contains(goal));

        // (s+s) means wew are concatenating s with s
    }
}
