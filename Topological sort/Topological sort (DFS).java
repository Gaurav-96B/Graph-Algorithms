class Solution
{
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) 
    {
      boolean visited[]=new boolean [N];
      Stack<Integer>topologicalSort=new Stack<>();
      for(int i=0;i<N;i++)
      {
          if(visited[i]==false)
          {
              dfs(adj,visited,i,topologicalSort);
          }
      }
      int ans[]=new int[N];
      int k=0;
      while(!topologicalSort.isEmpty())
      {
         ans[k++]=topologicalSort.pop();
      }
      return ans;
        
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int src,Stack<Integer>topologicalSort)
    {
        visited[src]=true;
        for(int adjacent:adj.get(src))
        {
            if(visited[adjacent]==false)
            {
               dfs(adj,visited,adjacent,topologicalSort);
            }
        }
        topologicalSort.push(src);
    }
    
}
