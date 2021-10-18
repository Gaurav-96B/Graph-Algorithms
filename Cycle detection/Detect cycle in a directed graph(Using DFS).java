class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        boolean helper[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                boolean ans=dfs(adj,visited,helper,i);
                if(ans==true)
                {
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean helper[],int src)
    {
        visited[src]=true;
        helper[src]=true;
        for(int adjacent:adj.get(src))
        {
            if(helper[adjacent]==true)
            {
                return true;
            }
            if(visited[adjacent]==false)
            {
               boolean ans=dfs(adj,visited,helper,adjacent);
               if(ans==true)
               {
                 return true;  
               }
            }
        }
        helper[src]=false;
        return false;
    }
}
