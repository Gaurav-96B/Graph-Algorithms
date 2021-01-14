import java.lang.*;
import java.io.*;
import java.util.*;

class Edge
{
    int source, dest;
 
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

class Graph
{
    List<List<Integer>> adjList = null;
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }   
}

class GFG {
	public static void main (String[] args) {
	   int t;
	   Scanner sc=new Scanner(System.in);
	   t=sc.nextInt();
	   sc.nextLine();
	   while(t-->0)
	   {
	       int v=sc.nextInt();
	       int e=sc.nextInt();
	       List<Edge>l=new ArrayList<>();
	       for(int i=0;i<e;i++)
	       {
	       int src=sc.nextInt();
	       int dest=sc.nextInt();
	       l.add(new Edge(src,dest));
	       }
	       Graph graph = new Graph(l, v);
	       System.out.println(graph.adjList);
	       int sum=0;
	       for(int i=0;i<v;i++)
	       {
	         sum=sum+graph.adjList.get(i).size(); 
	       }
	       System.out.println(sum);
	       
	   }
	}
}
