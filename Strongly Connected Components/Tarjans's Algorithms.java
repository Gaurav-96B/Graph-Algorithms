import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
static boolean visited[];
static boolean inStack[];
static int ID[];
static int low[];
static int disc[];
static int time;		
static Stack<Integer> untilHead;
static int idCount;
static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int v=sc.nextInt();
			int e=sc.nextInt();
			adj = new ArrayList<>();
			for(int i=0;i<v;++i)
			{
			adj.add(new ArrayList<Integer>());
			}
			for(int i=0;i<e;++i)
			{
				int fr=sc.nextInt();
				int to=sc.nextInt();
				adj.get(fr).add(to);
			}
			visited=new boolean[v];
			inStack=new boolean[v];
			ID=new int[v];
			low=new int[v];
			disc=new int[v];
			time=0;
			untilHead=new Stack<Integer>();
			for(int i=0;i<v;++i)
			{
				if(!visited[i])
				{
					scc(i);
				}
			}
			System.out.println();
		}
	}
	static void scc(int v)
	{
		visited[v]=true;
		inStack[v]=true;
		low[v]=disc[v]=time++;
		untilHead.push(v);
		for(int next:adj.get(v))
		{
			if(!visited[next])
			{
				scc(next);
				low[v]=Math.min(low[v], low[next]);
				
			}
			else
			{
				if(inStack[next])
				low[v]=Math.min(disc[next], low[v]);
				
			}
		}
		if(disc[v]==low[v])
		{
			int cur=0;
			while(untilHead.peek()!=v)
			{
				cur=untilHead.pop();
				ID[cur]=idCount;
				System.out.print(cur+" ");
				inStack[cur]=false;
				
			}
			cur=untilHead.pop();
			ID[cur]=idCount;
			System.out.print(cur+",");
			inStack[cur]=false;
			idCount++;
		}
		
	}
    
}
