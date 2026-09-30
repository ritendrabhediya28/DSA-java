class Solution 
{

    public int orangesRotting(int[][] grid) 
    {
        int n= grid.length;
        int m=grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int freshcount=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                  q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1)
                {
                    freshcount++;
                }
            }
        } 
        int[][] direction={{0,-1},{0,1},{-1,0},{1,0}};
        int time=0;
        while(!q.isEmpty() && freshcount>0)
        {
            int N = q.size();
            while(N-- > 0)
            {
               int[] curr=q.poll();
               int u=curr[0];
               int v= curr[1];
               for(int[] dir : direction)
               {
                int new_u = u+dir[0];
                int new_v= v+dir[1];
                if(new_u >= 0 && new_u < n && new_v >= 0 && new_v < m && grid[new_u][new_v]==1)
                {
                    grid[new_u][new_v]=2;
                    freshcount--;
                    q.offer(new int[]{new_u,new_v});
                }
               }
            }
            time++;
        }
        if(freshcount==0)
        {
            return time;
        }
        return -1;
         
    }
}