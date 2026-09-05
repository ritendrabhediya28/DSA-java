class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int index=0;
      int preffmax=Integer.MIN_VALUE;
      int n=nums.length;
       int[] suffmin=new int[n];
      suffmin[n-1]=nums[n-1];
      for(int i=n-2;i>=0;i--)
      {
        suffmin[i]=Math.min(nums[i],suffmin[i+1]);
      }
      for(int j=0;j<n;j++)
      {
        preffmax=Math.max(nums[j],preffmax);
        if((preffmax-suffmin[j])<=k)
        {
            return index;
        }
        index++;
      }
      return -1;
    }
}