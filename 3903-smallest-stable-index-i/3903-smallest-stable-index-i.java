class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int Ans=0;
        List<Integer> list1=new ArrayList<>();
        int index=0;
        int max=0;
        int min=0;
        int score;
       for(int i=0;i<n;i++)
       {
        List<Integer> list2=new ArrayList<>();
         list1.add(nums[i]);
         for(int j=i;j<n;j++)
         {
            list2.add(nums[j]);
         }
         max=Collections.max(list1);
         min=Collections.min(list2);
         score=max-min;
         if(score<=k)
         {
            return index;
         }
         index++;      
         
       } 
       return -1 ;
    }
}