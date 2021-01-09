import java.lang.*;
import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    int t;
	    Scanner sc=new Scanner(System.in);
	    t=sc.nextInt();
	    sc.nextLine();
	    while(t-->0)
	    {
	        int z=0;
	        int v=sc.nextInt();
	        int e=sc.nextInt();
	        int n=0;
	        int m=0;
	        List<Integer>l[]=new LinkedList[v];
	        for(int i=0;i<v;i++)
	        {
	           l[i]=new LinkedList<>();
	        }
	        for(int i=0;i<e;i++)
	        {
	            n=sc.nextInt();
	            m=sc.nextInt();
	            l[n].add(m);
	        }
	        for(int i=0;i<v;i++)
	        {
	  
	            z=z+l[i].size();
	       
	        }
	        System.out.println(z);
	    }
	}
}
