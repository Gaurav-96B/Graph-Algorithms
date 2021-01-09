import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t =sc.nextInt();
	 while(t-->0)
	 {
	     int v = sc.nextInt();
	     int e = sc.nextInt();
	     
	     ArrayList<Edge> list = new ArrayList<Edge>();
	     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	     for(int i=0;i<v;i++)
	     adj.add(new ArrayList<Integer>());
	     
	     for(int i=0;i<e;i++){
	         int src = sc.nextInt();
	         int dest =sc.nextInt() ;
	         int weight =sc.nextInt() ;
	      list.add(new Edge(src,dest,weight));
	      adj.get(src).add(dest);
	      adj.get(dest).add(src);
	     }
	      
	      System.out.println(fun(adj,list,v,e));
	 }
	 }
	 static int fun(ArrayList<ArrayList<Integer>> adj,ArrayList<Edge> list,int v,int e)
	 {
	     Collections.sort(list,new SortByWeight());
	     int sum=0;
	     for(int i=e-1;i>=0;i--)
	     {
	         Edge edge = list.remove(i);
	         Integer src = edge.src;
	         Integer dest = edge.dest;
	         int weight = edge.weight;
	         
	         adj.get(src).remove(dest);
	         adj.get(dest).remove(src);
	         
	         if(!isConnected(adj,v))
	         {
	             sum += weight;
	             adj.get(src).add(dest);
	             adj.get(dest).add(src);
	         }
	         
	     }
	     return sum;
	     
	 }
	 static boolean isConnected(ArrayList<ArrayList<Integer>> list,int v)
	 {
	     boolean[] vis = new boolean[v];
	     
	     DFS(0,vis,list);
	     for(int i=0;i<v;i++)
	     if(vis[i]==false)
	     return false;
	     
	     
	     return true;
	 }
	 static void DFS(int src,boolean[] vis,ArrayList<ArrayList<Integer>> list)
	 {
	     vis[src] =true;
	     ArrayList<Integer> list1 = list.get(src);
	     for(Integer k:list1)
	     {
	         if(!vis[k])
	         DFS(k,vis,list);
	     }
	 }
}
class Edge
{
    int src;
    int dest;
    int weight;
    Edge(int src,int dest,int weight)
    {
        this.src =src;
        this.dest =dest;
        this.weight =weight;
    }
}
class SortByWeight implements Comparator<Edge>
{
    public int compare(Edge a,Edge b)
    {
        return a.weight-b.weight;
    }
}
