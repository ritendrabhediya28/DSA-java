class Solution {
    public String removeKdigits(String num, int k) 
    {
       Stack<Character> st = new Stack<>();
       StringBuilder ans= new StringBuilder();
       for(char ch:num.toCharArray())
       {
        while(!st.isEmpty() && ch<st.peek() && k>0)
        {
            st.pop();
            k--;
        }
        st.push(ch);
       } 
        // If k is still remaining, remove from the end
        while (k > 0) {
            st.pop();
            k--;
        }
       for(char c:st)
       {
        ans.append(c);
       } 
        int i = 0;
        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }

        ans = new StringBuilder(ans.substring(i));

        return ans.length() == 0 ? "0" : ans.toString();
    }
}