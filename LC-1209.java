import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Same character as top
            if (!charStack.isEmpty() && charStack.peek() == ch) {

                int count = countStack.pop() + 1;
                countStack.push(count);

                if (count == k) {
                    charStack.pop();
                    countStack.pop();
                }
            }

            // New character
            else {
                charStack.push(ch);
                countStack.push(1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charStack.size(); i++) {

            char ch = charStack.get(i);
            int count = countStack.get(i);

            for (int j = 0; j < count; j++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
