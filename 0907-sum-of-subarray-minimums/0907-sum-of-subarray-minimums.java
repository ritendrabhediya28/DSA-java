class Solution {
    public int sumSubarrayMins(int[] arr) 
    {
        int n=arr.length;
      int[] LSE = new int[n]; // Left smallest element
      int[] RSE = new int[n];
      long sum=0;
      Stack<Integer> st = new Stack<>();
      for(int i=0;i<n;i++)
      {
        while(!st.isEmpty() && arr[st.peek()] >= arr[i])
        {
            st.pop();
        }
        if(st.isEmpty())
        {
            LSE[i]=-1;
        }
        else
        {
            LSE[i]=st.peek();
        }
        st.push(i);
      }
      st.clear();
       for(int j=n-1;j>=0;j--)
      {
        while(!st.isEmpty() && arr[st.peek()] > arr[j])
        {
            st.pop();
        }
        if(st.isEmpty())
        {
            RSE[j]=n;
        }
        else
        {
            RSE[j]=st.peek();
        }
        st.push(j);
      }
      for(int k=0;k<n;k++)
      {
        long ls=k-LSE[k];
        long rs=RSE[k]-k;
        long result=(long)arr[k]*ls*rs;
        sum += result;
      }
      return (int)(sum%(1000000007));
    }
}