class Solution // using BFS
{
    public boolean BFS(int u ,int[][] graph, int[] color , int currcolor)
    {
    
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        color[u]=currcolor;
        while(!q.isEmpty())
        {
            int i= q.poll();
            for(int v : graph[i])
            {
                if(color[v]==color[i])
               {
                return false;
               }
              if(color[v]==-1)
              {
                color[v]=1-color[i];
                q.offer(v);
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
                if(!BFS(i,graph,color,1))
                {
                  return false;
                }
            }
         }
         return true;
    }
}