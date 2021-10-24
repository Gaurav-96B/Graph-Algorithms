class Node{
    int v,w;
    Node(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> g, int S)
    {
        boolean visited[]=new boolean[V];
        int distance[]=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[S]=0;
        PriorityQueue<Node>pq=new PriorityQueue<Node>((a,b)->{return a.w-b.w;});
        pq.add(new Node(S,0));
        while(!pq.isEmpty())
        {
           Node temp=pq.peek();
           pq.poll();
           int v=temp.v;
           int w=temp.w;
           visited[v]=true;
           for(ArrayList<Integer>adjacent:g.get(v))
           {
               int adjacentV=adjacent.get(0);
               int adjacentW=adjacent.get(1);
               if(visited[adjacentV]==false&&distance[adjacentV]>adjacentW+w)
               {
                 distance[adjacentV]=adjacentW+w;
                 pq.add(new Node(adjacentV,adjacentW+w));
               }
           }
        }
        return distance;
    }
    
}
