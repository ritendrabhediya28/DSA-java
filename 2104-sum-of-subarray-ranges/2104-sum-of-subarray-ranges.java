class Solution {
    public long subArrayRanges(int[] nums) 
    {
        int n=nums.length;
        int min;
        int max;
        long sum=0;
        int[] PGE= new int[n];
        int[] NGE= new int[n];
        int[] PSE= new int[n];
        int[] NSE= new int[n];
        Stack<Integer>st=new Stack<>();
        // previous greater element
         for(int i=0;i<n;i++)
         {
           while(!st.isEmpty() && nums[st.peek()]<=nums[i])
           {
            st.pop();
           }
           if(st.isEmpty())
           {
            PGE[i]=-1;
           }
           else
           {
             PGE[i]=st.peek();
           }
           st.push(i);
         }
         st.clear();
         for(int j=n-1;j>=0;j--)
         {
           while(!st.isEmpty() && nums[st.peek()]<nums[j])
           {
            st.pop();
           }
           if(st.isEmpty())
           {
            NGE[j]=n;
           }
           else
           {
             NGE[j]=st.peek();
           }
           st.push(j);
         }
         st.clear();
         for(int k=0;k<n;k++)
         {
           while(!st.isEmpty() && nums[st.peek()]>=nums[k])
           {
            st.pop();
           }
           if(st.isEmpty())
           {
            PSE[k]=-1;
           }
           else
           {
             PSE[k]=st.peek();
           }
           st.push(k);
         }
         st.clear();
          for(int l=n-1;l>=0;l--)
         {
           while(!st.isEmpty() && nums[st.peek()]>nums[l])
           {
            st.pop();
           }
           if(st.isEmpty())
           {
            NSE[l]=n;
           }
           else
           {
             NSE[l]=st.peek();
           }
           st.push(l);
         }
         st.clear();
         for(int m=0;m<n;m++)
         {
           long Gleft=m-PGE[m];
           long Gright=NGE[m]-m;
           long Maxtotalway=Gleft*Gright;
           long sum1=(Maxtotalway*nums[m]);
           long Sleft=m-PSE[m];
           long Sright=NSE[m]-m;
           long mintotalway=Sleft*Sright;
           long sum2=(mintotalway*nums[m]);
           sum+=(sum1-sum2);
         }
         return sum;
    }
}