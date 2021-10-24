class Node
{
    int u,w;
    Node(int u,int w)
    {
        this.u=u;
        this.w=w;
    }
}
class Solution {
     public int networkDelayTime(int[][] times, int N, int K) {
         ArrayList<ArrayList<ArrayList<Integer>>>graph=buildGraph(N,times);
         boolean visited[]=new boolean [N];
         int distance[]=new int[N];
         Arrays.fill(distance,Integer.MAX_VALUE);
         distance[K-1]=0;
         PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->{return a.w-b.w;});
         pq.add(new Node(K-1,0));
         while(!pq.isEmpty())
         {
             Node temp=pq.peek();
             pq.poll();
             int u=temp.u;
             int w=temp.w;
             visited[u]=true;
             for(ArrayList<Integer>adjacent:graph.get(u))
             {
                 int adjacentU=adjacent.get(0);
                 int adjacentW=adjacent.get(1);
                 if(visited[adjacentU]==false&&distance[adjacentU]>adjacentW+temp.w)
                 {
                    distance[adjacentU]=adjacentW+temp.w;
                    pq.add(new Node(adjacentU,adjacentW+temp.w));
                 }
             }
         }
         int max=Integer.MIN_VALUE;
         for(int i=0;i<N;i++)
         {
             if(distance[i]==Integer.MAX_VALUE)
             {
                 return -1;
             }
             max=Math.max(max,distance[i]);
         }
         return max;
    }
public ArrayList<ArrayList<ArrayList<Integer>>> buildGraph(int V,int[][] times)
{
    ArrayList<ArrayList<ArrayList<Integer>>>graph =new ArrayList<ArrayList<ArrayList<Integer>>>();
    for(int i=0;i<V;i++)
    {
       graph.add(new ArrayList<ArrayList<Integer>>());
    }
    for(int edges[]:times)
    {
       int u=edges[0]-1;
       int v=edges[1]-1;
       int w=edges[2];
       ArrayList<Integer>vNode=new ArrayList<>();
       vNode.add(v);
       vNode.add(w);
       
       graph.get(u).add(vNode);
    }
    return graph;
}
}
