class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        int ans[]=new int[N];
        boolean visited[]=new boolean[N];
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<N;i++)
        {
            if(visited[i]==false)
            {
                visited[i]=true;
                topo(i,s,visited,adj);
            }
        }
        int k=0;
        while(!s.isEmpty())
        {
            ans[k++]=s.pop();
        }
        return ans;
    }
    static void topo(int i,Stack<Integer>s,boolean visited[],ArrayList<ArrayList<Integer>>adj)
    {
        for(int x:adj.get(i))
        {
            if(visited[x]==false)
            {
                visited[x]=true;
                topo(x,s,visited,adj);
            }
        }
        s.push(i);
    }
}

