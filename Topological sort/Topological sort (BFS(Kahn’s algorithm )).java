class Solution
{
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) 
    {
        int topo[] = new int[N]; 
        int indegree[] = new int[N]; 
        for(int i = 0;i<N;i++) {
            for(int adjacent: adj.get(i)) {
                indegree[adjacent]++; 
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i); 
            }
        }
        int index = 0;
        while(!q.isEmpty()) {
            int node=q.poll(); 
            topo[index++]=node;
            for(int adjacent:adj.get(node)) {
                indegree[adjacent]--; 
                if(indegree[adjacent] == 0) {
                    q.add(adjacent); 
                }
            }
        }
        return topo; 
    }
    
}
