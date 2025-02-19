// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(1), as for the biggest no it'll have at max 12 steps, 4 octets & mapping them to 3 hasmap sets
    // TC = O(1)
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        String result = "";
        while(num > 0) { 
            int curr = num % 1000; // breaking into octets of three
            if(curr != 0) {
                result = helper(curr) + thousands[i] + " " + result; // appending thousands[] here
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }
    private String helper(int num) {
        // now for the octet starting from the left side, Ones, Tens, Hundreds
        // check in the order of 0, < 20, < 100, >= 100
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num / 10] + " " + helper(num % 10); // 78
        else return below_20[num / 100] + " Hundred " + helper(num % 100); // num > 100 = 578
    }
}