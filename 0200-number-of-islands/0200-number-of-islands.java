class Solution 
{
    public void findisland(int i, int j ,char[][] grid,boolean[][] vis,int n,int m )
    {
       
      if(i<0 || i>=n || j<0 ||j>=m)
      {
        return;
      }
      if(grid[i][j]=='0' || vis[i][j])
      {
        return;
      }
        vis[i][j]=true;      
         findisland(i,j-1,grid,vis,n,m);
         findisland(i,j+1,grid,vis,n,m);
         findisland(i-1,j,grid,vis,n,m);
         findisland(i+1,j,grid,vis,n,m);

    }
    public int numIslands(char[][] grid) 
    {
        int n=grid.length;
        int m= grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==false && grid[i][j]=='1')
                {
                    findisland(i,j,grid,vis,n,m);
                    count++;
                }
            }
        }
        return count;
    }
}