class Solution
{
    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        boolean visited[]=new boolean[V];
        int distance[]=new int[V];
        for(int i=0;i<V;i++)
        {
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        for(int i=0;i<V-1;i++)
        {
            int minVertex=min(distance,visited);
            visited[minVertex]=true;
            for(int j=0;j<V;j++)
            {
                if(g.get(minVertex).get(j)!=0&&!visited[j]&&distance[minVertex]!=Integer.MAX_VALUE)
                {
                 int newDistance=distance[minVertex]+g.get(minVertex).get(j);
                 if(newDistance<distance[j])
                 {
                     distance[j]=newDistance;
                 }
                }
            }
        }
        return distance;
    }
    static int min(int distance[],boolean visited[])
    {
        int minVertex=-1;
        for(int i=0;i<distance.length;i++)
        {
            if(!visited[i]&&(minVertex==-1 || distance[i]<distance[minVertex]))
            {
                minVertex=i;
            }
        }
        return minVertex;
        
    }
    
}

