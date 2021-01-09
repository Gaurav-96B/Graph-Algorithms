class MST {
    static int min(int weight[],boolean visited[])
    {
        int minvertex=-1;
        for(int i=0;i<weight.length;i++)
        {
            if(!visited[i]&&(minvertex==-1||weight[i]<weight[minvertex]))
            {
                minvertex=i;
            }
        }
        return minvertex;
    }
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) 
    {
        int parent[]=new int[V];
        int weight[]=new int[V];
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            weight[i]=Integer.MAX_VALUE;
        }
        weight[0]=0;
        parent[0]=-1;
        for(int i=0;i<V;i++)
        {
            int minVertex=min(weight,visited);
            visited[minVertex]=true;
            for(int j=0;j<V;j++)
            {
                if(!visited[j]&&graph.get(minVertex).get(j)!=0)
                {
                    if(graph.get(minVertex).get(j)<weight[j])
                    {
                       weight[j]=graph.get(minVertex).get(j);
                       parent[j]=minVertex;
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<V;i++)
        {
           sum=sum+weight[i]; 
        }
        return sum;
    }
}
