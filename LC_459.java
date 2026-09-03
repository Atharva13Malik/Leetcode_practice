class Solution {
    public boolean repeatedSubstringPattern(String s) {

        String doubled = s + s;

        String temp = doubled.substring(1, doubled.length() - 1);

        return temp.contains(s);
    }
}
