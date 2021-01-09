import java.util.*;
import java.lang.*;
import java.io.*;
class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            ArrayList<Integer> res = new Traversal().dfs(list, nov);
            for (int i = 0; i < res.size (); i++) 
                System.out.print (res.get(i) + " ");
            System.out.println();
        }
    }
}
class Solution
{
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int i=0;
        boolean visited[]=new boolean[V];
        for(int i2=0;i2<V;i2++)
        {
            visited[i2]=false;
        }
        ArrayList<Integer>a=new ArrayList<>();
        Stack<Integer>s=new Stack<>();
        s.push(i);
        visited[i]=true;
        while(!s.isEmpty())
        {
            int n=s.pop();
            a.add(n);
            for(int i1:adj.get(n))
            {
                if(!visited[i1])
                {
                    s.push(i1);
                    visited[i1]=true;
                }
            }
        }
        return a;
    }
}
