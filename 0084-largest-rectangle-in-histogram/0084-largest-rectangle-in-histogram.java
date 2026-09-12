class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        int[] PSE=new int[n];
        int[] NSE = new int[n];
        int maxarea=Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
       for(int i=0;i<n;i++)
       {
        while(!st.isEmpty() && heights[i]<heights[st.peek()])
        {
            st.pop();
        }
        if(st.isEmpty())
        {
          PSE[i]=-1;
        }
        else
        {
            PSE[i]=st.peek();
        }
        st.push(i);
       } 
       st.clear();
       for(int j=n-1;j>=0;j--)
       {
        while(!st.isEmpty() && heights[j]<= heights[st.peek()])
        {
            st.pop();
        }
        if(st.isEmpty())
        {
          NSE[j]=n;
        }
        else
        {
            NSE[j]=st.peek();
        }
        st.push(j);
       } 
       for(int k=0;k<n;k++)
       {
        int left= k-PSE[k];
        int right=NSE[k]-k;
        int width=left+right-1;
        maxarea=Math.max(maxarea,heights[k]*width);
       }
       return maxarea;
    }
}