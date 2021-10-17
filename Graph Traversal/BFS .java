class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int src=0;
        boolean visited[]=new boolean[V];
        ArrayList<Integer>ans=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty())
        {
            int node=q.poll();
            ans.add(node);
            for(int adjacent:adj.get(node))
            {
                if(visited[adjacent]==false)
                {
                    q.add(adjacent);
                    visited[adjacent]=true;
                }
            }
        }
        return ans;
        
    }
    
}
