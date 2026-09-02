class Solution {
    public boolean uniformArray(int[] nums1) 
    {
        int count=0;
        int n=nums1.length;
        int[] nums2 = new int[n];
        int evencount=0;
        int oddcount=0;
       for(int i:nums1)
       {
        if(i%2==0)
        {
           evencount++;
        }
        else 
        {
           oddcount++; 
        }
       } 
       if(evencount==n)
       {
        return true;
       }
       else if(oddcount==n)
       {
        return true;
       }
       else
       {
        for(int j=0;j<n-1;j++)
        {
            nums2[j]=nums1[j]-nums1[j+1];
        }
        nums2[n-1]=nums1[n-1];
       }
       for(int k:nums2)
       {
        if(k%2==0)
        {
            count++;
        }
       }
       if(count==0 || count==n)
       {
        return true;
       }
       return true;
    }
}