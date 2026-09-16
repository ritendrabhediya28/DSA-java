class Solution 
{
    public boolean DFS(int u,ArrayList<ArrayList<Integer>> graph,boolean[] vis,boolean[] rec)
    {
        vis[u]=true;
        rec[u]=true;
        for(int v : graph.get(u))
        {
            if(rec[v])
            {
                return true;
            }
            if(!vis[v])
            {
                if(DFS(v,graph,vis,rec))
                {
                    return true;
                }
            }
        }
        rec[u]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        int V=numCourses;
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        Arrays.fill(vis,false);
        Arrays.fill(rec,false);
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       for(int i=0;i<numCourses;i++)
       {
        graph.add(new ArrayList<>());
       } 
       for(int[] edge : prerequisites)
       {
        int u=edge[1];
        int v=edge[0];
        graph.get(u).add(v); // directed graph
       }
       if(prerequisites.length==0) return true;
       for(int U=0;U<V;U++)
       {
        if(!vis[U])
        {
            if(DFS(U,graph,vis,rec))
            {
                return false;
            }
        }
       }
       return true;
    }
}