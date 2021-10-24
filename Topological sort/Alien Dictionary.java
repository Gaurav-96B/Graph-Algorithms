class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        int n=dict.length;
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for(int i=0;i<K;i++)
            graph.add(new ArrayList<Integer>());
        
        for(int i=0;i<n-1;i++){
            String word1= dict[i];
            String word2= dict[i+1];
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    graph.get(word1.charAt(j)-'a').add(word2.charAt(j)-'a');
                    break;
                }
            }
        }
        String s= new String("");
        boolean visited[]=new boolean[K];
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<K;i++)
        {
            if(visited[i]==false)
            {
            DFS(graph,visited,stack,i);
            }
        
        }
        while(!stack.isEmpty())
        {
            s=s+(char)('a'+stack.pop());
        }
        return s;
        
    }
    public void DFS(ArrayList<ArrayList<Integer>> graph,boolean[] visited,Stack<Integer> stack,int src)
    {
        visited[src]=true;
        for(int v:graph.get(src))
        {
            if(visited[v]==false)
            {
                visited[src]=true;
                DFS(graph,visited,stack,v);
            }
        }
        stack.push(src);
    }
}
