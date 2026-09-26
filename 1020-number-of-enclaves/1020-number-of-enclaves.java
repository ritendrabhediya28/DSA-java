class Solution 
{
    public void find(int i , int j,boolean[][] vis,int[][] grid,int n,int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
        {
            return;
        }
        if(vis[i][j] || grid[i][j]==0)
        {
            return;
        }
        vis[i][j]=true;
        find(i,j-1,vis,grid,n,m);
        find(i,j+1,vis,grid,n,m);
        find(i-1,j,vis,grid,n,m);
        find(i+1,j,vis,grid,n,m);
    }
    public int numEnclaves(int[][] grid) 
    {
        int n=grid.length;
        int m= grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1 && !vis[i][0])
            {
                find(i,0,vis,grid,n,m);
            }
            if(grid[i][m-1]==1 && !vis[i][m-1])
            {
                 find(i,m-1,vis,grid,n,m);
            }
        }
        for(int j=0;j<m;j++)
        {
            if(grid[0][j]==1 && !vis[0][j])
            {
                 find(0,j,vis,grid,n,m);
            }
            if(grid[n-1][j]==1 && !vis[n-1][j])
            {
               find(n-1,j,vis,grid,n,m); 
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] && grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}