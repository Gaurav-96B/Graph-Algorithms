class Solution
{
    void dfs1(ArrayList<ArrayList<Integer>> adj,int N,Stack<Integer>s)
    {
        boolean visited[]=new boolean[N];
        for(int j=0;j<N;j++)
        {
            if(visited[j]==false)
            {
                visited[j]=true;
            dfs0(adj,j,N,s,visited);
            }
        }
        
    }
    void dfs0(ArrayList<ArrayList<Integer>> adj,int i,int N,Stack<Integer>s,boolean visited[])
    {
        for(int j:adj.get(i))
        {
            if(visited[j]==false)
            {
                visited[j]=true;
                dfs0(adj,j,N,s,visited);
            }
        }
        s.push(i);
    }
    
    void reversedfs(int i,ArrayList<ArrayList<Integer>> adj1,boolean visited[])
    {
       for(int j:adj1.get(i))
       {
           if(visited[j]==false)
           {
              visited[j]=true;
               reversedfs(j,adj1,visited);
           }
       }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        Stack<Integer>s=new Stack<>();
        dfs1(adj,N,s);
        
        ArrayList<ArrayList<Integer>>adj1 = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj1.add(new ArrayList<>());
        
        for(int i=0;i<N;i++) 
       {
          for(int j:adj.get(i))
          {
            adj1.get(j).add(i);
          }
       }
       int count=0;
       boolean visited1[]=new boolean[N];
       for(int i=0;i<N;i++)
       {
           visited1[i]=false;
       }
       while(!s.isEmpty())
       {
           int z=s.pop();
           if(visited1[z]==false)
           {
               visited1[z]=true;
               reversedfs(z,adj1,visited1);
               count++;
           }
       }
       
       return count;
        
    }
}

