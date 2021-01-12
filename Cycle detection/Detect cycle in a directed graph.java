class DetectCycle
{
    static boolean isCycle(ArrayList<ArrayList<Integer>>adj,boolean visited[],boolean stack[],int i)
    {
        visited[i]=true;
        stack[i]=true;
        for(int j:adj.get(i))
        {
            if(!visited[j]&&isCycle(adj,visited,stack,j))
            {
                return true;
            }
            else if(stack[j])
            {
                return true;
            }
        }
        stack[i]=false;
        return false;
        
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[]=new boolean[V];
        boolean stack[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
            stack[i]=false;
        }
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
            if(isCycle(adj,visited,stack,i))
            {
                return true;
            }
            }
        }
        return false;
    }
}
