class Node
{
    int v,w;
    Node(int v,int w)
    {
        this.v=v;
        this.w=w;
    }
}
class Solution {
     public int networkDelayTime(int[][] times, int N, int K) {
       ArrayList<ArrayList<ArrayList<Integer>>>graph=buildGraph(times,N);
       boolean visited[]=new boolean[N];
       int distance[]=new int[N];
       Arrays.fill(distance,Integer.MAX_VALUE);
       distance[K-1]=0;
       PriorityQueue<Node>pq=new PriorityQueue<Node>((a,b)->{return a.w-b.w;});
       pq.add(new Node(K-1,0));
       while(!pq.isEmpty())
       {
           Node src=pq.peek();
           pq.poll();
           int srcV=src.v;
           int srcW=src.w;
           visited[srcV]=true;
           for(ArrayList<Integer>adjacent:graph.get(srcV))
           {
               int adjacentV=adjacent.get(0);
               int adjacentW=adjacent.get(1);
               if(visited[adjacentV]==false&&distance[adjacentV]>srcW+adjacentW)
               {
                 distance[adjacentV]=srcW+adjacentW;
                 pq.add(new Node(adjacentV,srcW+adjacentW));
               }
           }
           
       }
         int max=Integer.MIN_VALUE;
         for(int i=0;i<distance.length;i++)
         {
             if(distance[i]==Integer.MAX_VALUE)
             {
                 return -1;
             }
             max=Math.max(max,distance[i]);
         }
         return max;
       
     }
    public ArrayList<ArrayList<ArrayList<Integer>>> buildGraph(int times[][],int N)
    {
        ArrayList<ArrayList<ArrayList<Integer>>>graph=new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<N;i++)
        {
            graph.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int i=0;i<times.length;i++)
        {
            int u=times[i][0]-1;
            int v=times[i][1]-1;
            int w=times[i][2];
            ArrayList<Integer>node=new ArrayList<Integer>();
            node.add(v);
            node.add(w);
            graph.get(u).add(node);
        }
        return graph;
    }
    
}
