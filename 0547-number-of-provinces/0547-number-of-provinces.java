class Solution 
{
    public void dfs(int u,boolean[] visited,int[][] isConnected,int count,int n)
    {
        visited[u]=true;
        for(int v=0;v<n;v++)
        {
            if(!visited[v] && isConnected[u][v]==1)
            {
                dfs(v,visited,isConnected,count,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) 
    {
       int count=0;
       int n=isConnected.length;
       boolean[] visited = new boolean[n];
       Arrays.fill(visited,false);
       for(int i=0;i<n;i++)
       {
         if(!visited[i])
         {
            dfs(i,visited,isConnected,count,n);
            count++;
         }
       } 
       return count;
    }
}