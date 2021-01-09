//Initial Template for Java


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
class Traversal
{
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        boolean vis[]=new boolean[N];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<N;i++)
        if(!vis[i])
        util(g,vis,i,res);
        return res;
    }
    static void util(ArrayList<ArrayList<Integer>> g,boolean vis[],int src,ArrayList<Integer> res){
        vis[src]=true;
        res.add(src);
        for(int v:g.get(src))
        if(!vis[v])
        util(g,vis,v,res);
    }
}

