class Solution 
{
    public boolean DFS(int u ,int[][] graph, int[] color , int currcolor)
    {
        int colorofv;
        color[u]=currcolor;
        for(int v : graph[u])
        {
            if(color[v]==color[u])
            {
                return false;
            }
            if(color[v]==-1)
            {
            if(DFS(v,graph,color,1-color[u])==false)
            {
                return false;
            }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) 
    {
        int n= graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
         for(int i=0 ; i<n;i++)
         {
            if(color[i]==-1)
            {
                if(!DFS(i,graph,color,1))
                {
                  return false;
                }
            }
         }
         return true;
    }
}