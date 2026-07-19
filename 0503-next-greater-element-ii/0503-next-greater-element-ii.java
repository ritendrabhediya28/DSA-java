class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

      for(int i=0;i<nums.length;i++)
      {
        int currel=nums[i];
        for(int j=1;j<nums.length;j++)
        {
           int ind = (i + j) % n;
            if(nums[ind]>currel)
            {
                ans[i]=nums[ind];
                break;
            }
        }
       
      }
       return ans;
    }
}