class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            }

            else if (ch == ')') {
                low--;
                high--;
            }

            else { // '*'
                low--;    // '*' acts as ')'
                high++;   // '*' acts as '('
            }

            // Too many ')' even in the best case
            if (high < 0) {
                return false;
            }

            // Minimum cannot be negative
            low = Math.max(low, 0);
        }

        return low == 0;
    }
}