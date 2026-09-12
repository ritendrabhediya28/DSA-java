class Solution 
{
    public int FindmaxArea(int[] height,int n,int m)
    {
        
        int[] PSE=new int[n];
        int[] NSE=new int[n];
        int N=height.length;
        int Area;
        int MaxArea=0;
        Stack<Integer>st= new Stack<>();

        for(int i=0;i<N;i++)
        {
            while(!st.isEmpty() && height[i]<=height[st.peek()])
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
        for(int j=N-1;j>=0;j--)
        {
            while(!st.isEmpty() && height[j]<=height[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSE[j]=N;
            }
            else
            {
                NSE[j]=st.peek();
            }
            st.push(j);
        }
        for(int k=0;k<N;k++)
        {
            int width=NSE[k]-PSE[k]-1;
            Area=(height[k]*width);
            MaxArea=Math.max(MaxArea,Area);
        }
        return MaxArea;
    }
    public int maximalRectangle(char[][] matrix) 
    {
        int m=matrix.length;
        int n=matrix[0].length;
       int[] height = new int[n];
       int maxArea=0;

       for(int i=0;i<n;i++)
       {
        height[i]=matrix[0][i]-'0';
       } 
       maxArea=Math.max(maxArea,FindmaxArea(height,n,m));

       for(int row=1;row<m;row++)
       {
        for(int col=0;col<n;col++)
        {
            if(matrix[row][col]=='0')
            {
                height[col]=0;
            }
            else
            {
                height[col]+=1;
            }
        }
        maxArea=Math.max(maxArea,FindmaxArea(height,n,m));
       }   
        return maxArea;
    }
}