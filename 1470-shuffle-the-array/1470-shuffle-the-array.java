class Solution {
    public int[] shuffle(int[] nums, int n) 
    {
        int[] nums1= new int[n];
        for(int i=0;i<n;i++)
        {
            nums1[i]=nums[i+n];
        }
        int[] ans= new int[2*n];
        int i=0;
        while(i<2*n)
        {
            ans[i]=nums[i/2];
            ans[i+1]=nums1[i/2];
            i++;
            i++;
        }
        return ans;
    }
}