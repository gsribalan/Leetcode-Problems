import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                String temp = currentString;
                currentString = stringStack.pop();
                int count = countStack.pop();
                for (int j = 0; j < count; j++) {
                    currentString += temp;
                }
            } else {
                currentString += ch;
            }
        }
        return currentString;
    }
}