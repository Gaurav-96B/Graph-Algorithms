
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
