class Node{
    int v,w;
    Node(int v,int w){
       this.v=v;
       this.w=w;
    }
}
class NodeComparator implements Comparator<Node>{
    public int compare(Node a,Node b){
        return a.w-b.w;
    }
}
class Solution
{
    static int[] dijkstra(int V1, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean visited[]=new boolean[V1];
        int distance[]=new int[V1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[S]=0;
       // PriorityQueue<Node>pq=new PriorityQueue<Node>(new NodeComparator());
        PriorityQueue<Node>pq=new PriorityQueue<Node>((a,b)->{
            return a.w-b.w;
        });
        pq.add(new Node(S,0));
        while(!pq.isEmpty())
        {
            Node temp=pq.poll();
            int V=temp.v;
            int W=temp.w;
            visited[V]=true;
            for(ArrayList<Integer>adjacent:adj.get(V))
            {
                int adjacentV=adjacent.get(0);
                int adjacentW=adjacent.get(1);
                if(visited[adjacentV]==false&&distance[adjacentV]>W+adjacentW)
                {
                    distance[adjacentV]=W+adjacentW;
                    pq.add(new Node(adjacentV,W+adjacentW));
                }
            }
        }
        
        return distance;
        
    }
}
