class Islands {
    
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(A.get(i).get(j)==1)
                {
                    dfs(A,i,j,N,M);
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>>A,int i,int j,int N,int M)
    {
        if(i<0||i>=N||j<0||j>=M||A.get(i).get(j)==0)
        {
            return;
        }
        A.get(i).add(j,0);
        dfs(A,i-1,j,N,M);
        dfs(A,i+1,j,N,M);
        dfs(A,i,j-1,N,M);
        dfs(A,i,j+1,N,M);
        dfs(A,i-1,j-1,N,M);
        dfs(A,i-1,j+1,N,M);
        dfs(A,i+1,j-1,N,M);
        dfs(A,i+1,j+1,N,M);
    }
}

