class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
     Stack<Integer>st=new Stack<>();
     for(int i: asteroids)
     {
        //  asteroids collision condition
        while(!st.isEmpty() && i<0 && st.peek()>0)
        {
            int sum=i+st.peek();
            if(sum<0)
            {
                st.pop();
            }
            else if(sum==0)
            {
               st.pop();
               i=0;
               break;
            }
            else
            {
                i=0;
                break;
            }
        }
        if(i!=0)
        {
            st.push(i);
        }
    }
    int[] result=new int[st.size()];
    for(int k=result.length-1;k>=0;k--)
        {
          result[k]=st.pop();
        }
    return result;
    }
}