class MinStack 
{
    Stack<Integer> st;
    Stack<Integer>minstack;
    public MinStack() 
    {
       st=new Stack<>();
       minstack=new Stack<>();
    }
    
    public void push(int value) 
    {
         st.push(value); 
        if(minstack.isEmpty()||value<=minstack.peek())
        {
            minstack.push(value);
        }
                  
    }
    public void pop() 
    {
     int y=st.pop();
     if(y== minstack.peek())
     {
        minstack.pop();
     }       
    }
    public int top() 
    {
      int x=st.peek();
      return x; 
    }
    public int getMin() 
    {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */