class Solution {
    public void find(int i,int j,boolean[][] vis,char[][] board,int n ,int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
        {
            return;
        }
        if(board[i][j]=='X' || vis[i][j])
        {
          return;
        }
        vis[i][j]=true;
        find(i,j-1,vis,board,n,m);
        find(i,j+1,vis,board,n,m);
        find(i-1,j,vis,board,n,m);
        find(i+1,j,vis,board,n,m);
    }
    public void solve(char[][] board) 
    {
        int n= board.length;
        int m=board[0].length; 
        boolean[][] vis = new boolean[n][m]; 
        if(n==0)
        {
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O')
            {
                find(i,0,vis,board,n,m);
            }
        }
        for(int j=0;j<n;j++)
        {
            if(board[j][m-1]=='O')
            {
                find(j,m-1,vis,board,n,m);
            }
        }
          for(int k=0;k<m;k++)
        {
            if(board[0][k]=='O' )
            {
                find(0,k,vis,board,n,m);
            }
        }
         for(int l=0;l<m;l++)
        {
            if(board[n-1][l]=='O')
            {
                find(n-1,l,vis,board,n,m);
            }
        }
        for(int u=0;u<n;u++)
        {
            for(int v=0;v<m;v++)
            {
                if(board[u][v]=='O' && !vis[u][v])
                {
                    board[u][v]='X';
                }
            }
        }
      return;
    }
}