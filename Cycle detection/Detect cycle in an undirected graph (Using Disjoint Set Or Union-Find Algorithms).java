class Solution
{
   static int find(int[] p,int i)
    {
        if(p[i]==-1)
            return i;
        return find(p,p[i]);
    }
    static void union(int[] p,int x,int y)
    {
        
        int xt = find(p,x);
        int yt = find(p,y);
        p[xt] = yt;
    } 
    

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
       
       int[] p = new int[V];
       for(int i=0;i<V;i++)
            p[i] = -1;
       ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        for(int i=0;i<V;i++)
            list1.add(new ArrayList<Integer>());
       
        for(int i=0;i<V;i++)
        {
            for(int j:adj.get(i))
            {
                if(!list1.get(i).contains(j)) {
                    list1.get(j).add((Integer)i);
                }
                
            }
        }
        adj = list1;     
       for(int i=0;i<V;i++)
       {
           for(int j:adj.get(i))
           {
                int x = find(p,i);
                int y = find(p,j);
                if(x==y)
                    return true;
                    
                union(p,x,y);    
           }
       }
       return false;
    }
    
}
