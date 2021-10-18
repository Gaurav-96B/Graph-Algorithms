class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                boolean ans=dfs(adj,visited,i,-1);
                if(ans==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int src,int parent)
    {
        visited[src]=true;
        for(int adjacent:adj.get(src))
        {
            if(visited[adjacent]==false)
            {
                boolean ans=dfs(adj,visited,adjacent,src);
                if(ans==true)
                {
                    return true;
                }
            }
            else if(adjacent!=parent)
            {
              return true;  
            }
        }
        return false;
    }
}
