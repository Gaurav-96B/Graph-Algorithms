class Solution {
     public int networkDelayTime(int[][] times, int N, int K) {
         int distance[]=new int[N];
         Arrays.fill(distance,Integer.MAX_VALUE);
         distance[K-1]=0;
         for(int i=0;i<N-1;i++)
         {
             for(int j=0;j<times.length;j++)
             {
                 int u=times[j][0]-1;
                 int v=times[j][1]-1;
                 int w=times[j][2];
                 if(distance[u]==Integer.MAX_VALUE)
                 {
                     continue;
                 }
                 if(distance[v]>distance[u]+w)
                 {
                     distance[v]=distance[u]+w;
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
}
