import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++) 
            {
            list.add(i, new ArrayList<Integer>());
            }
            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            ArrayList<Integer>res = new Traversal().bfs(list,nov);
            for (int i =0 ;i < res.size (); i++) 
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
class Traversal 
{
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        int i=0;
        boolean visited[]=new boolean[N];
        for(int i2=0;i2<N;i2++)
        {
            visited[i2]=false;
        }
        ArrayList<Integer>a=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        visited[i]=true;
        while(!q.isEmpty())
        {
            int n=q.poll();
            a.add(n);
            for(int i1:g.get(n))
            {
                if(!visited[i1])
                {
                    q.add(i1);
                    visited[i1]=true;
                }
            }
        }
        return a;
    }
}
