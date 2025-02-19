// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(n) stack space
    // public int calculate(String s) {
    //     if(s == null || s.length() == 0) return 0;
    //     int num = 0, calc = 0;
    //     char lastSign = '+'; // start with + as we are adding (+)num to the stack
    //     Stack<Integer> st = new Stack<>();
    //     for(int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if(Character.isDigit(c)) {
    //             num = num * 10 + c - '0';
    //         }
    //         if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) { // or condition -> if we are at the end, then we must evaluate & not add it to the num
    //         // taking care of precedence as + & - are pushed but * & / are popped, calculated & then pushed
    //             if(lastSign == '+') st.push(num);
    //             if(lastSign == '-') st.push(-num);
    //             if(lastSign == '*') st.push(st.pop() * num); // taking care of precedence
    //             if(lastSign == '/') st.push(st.pop() / num); // taking care of precedence
    //             lastSign = c; // update lastSign
    //             num = 0; // reset num as the operation is complete
    //         }
    //     }
    //     while(!st.isEmpty()) {
    //         calc += st.pop(); // at the end add all the nums in the stack for the answer
    //     }
    //     return calc;
    // }

    // TC = O(n), SC = O(1) - w/o stack
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int num = 0, calc = 0, tail = 0;
        char lastSign = '+'; // start with + as we are adding (+)num to the stack
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) { // or condition -> if we are at the end, then we must evaluate & not add it to the num
            // taking care of precedence as + & - are pushed but * & / are popped, calculated & then pushed
                if(lastSign == '+') {
                    calc = calc + num;
                    tail = +num;
                }
                if(lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                }
                if(lastSign == '*') { // taking care of precedence
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                } 
                if(lastSign == '/') { // taking care of precedence
                    calc = calc - tail + (tail / num);
                    tail = tail / num;
                }
                lastSign = c; // update lastSign
                num = 0; // reset num as the operation is complete
            }
        }
        return calc;
    }
}