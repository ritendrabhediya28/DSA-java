class Solution {
    public boolean isPalindrome(int x) 
    {
      String s = String.valueOf(x);
      Stack<Character> st = new Stack<>();
      StringBuilder sb = new StringBuilder();
      for(char c : s.toCharArray() )
      {
        st.push(c);
      }
      while(!st.isEmpty())
      {
        sb.append(st.pop());
      }
      if(s.equals(sb.toString()))
      {
        return true;
      }
      return false;
    }
}