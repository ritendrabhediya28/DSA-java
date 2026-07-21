class Solution {
    public int trap(int[] height) 
    {
      // left max array 
      int n=height.length;
      int leftmax[] = new int [n];
      leftmax[0]=height[0];
      for(int i=1;i<n;i++)
      {
        leftmax[i]=Math.max(height[i],leftmax[i-1]);
      }
      // Right max array 
       int Rightmax[] = new int [n];
       Rightmax[n-1]=height[n-1];
       for(int j=n-2;j>=0;j--)
       {
        Rightmax[j]=Math.max(height[j],Rightmax[j+1]);
       }

       int Trappedwater=0;
       for(int k=0;k<n;k++)
       {
        int waterlevel=Math.min(leftmax[k],Rightmax[k]);
        Trappedwater+=waterlevel-height[k];
       }
       return Trappedwater;


    }
}