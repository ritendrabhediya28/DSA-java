class Solution   // Using DFS + Stack ==> Topological sort
{
    public boolean DFS(int u,ArrayList<ArrayList<Integer>> graph,boolean[] vis,Stack<Integer> st,boolean[] rec)
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
               if( DFS(v,graph,vis,st,rec))
               {
                return true;
               }
            }
        }
        rec[u]=false;
        st.push(u);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int V=numCourses;
        boolean[] vis=new boolean[V];
        Stack<Integer> st = new Stack<>();
        boolean[] rec  = new boolean[V];
        Arrays.fill(rec,false);
        Arrays.fill(vis,false);
        int[] result  = new int[V];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge :prerequisites)
        {
            int u=edge[1];
            int v=edge[0];
            graph.get(u).add(v); // for directed graph
        }
        for(int j=0;j<V;j++)
        {
            if(!vis[j])
            {
             if(DFS(j,graph,vis,st,rec))
             {
                return new int[0];
             }
            }
        }
        int j=0;
        while(!st.isEmpty())
        {
            result[j]=st.pop();
            j++;
        }
        return result;
    }
}