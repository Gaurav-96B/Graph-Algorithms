class Solution {
    public int[] findRedundantConnection(int[][] edges) {
         if (edges.length == 0)
         {
            return null;
         }
        int parent[] = new int[edges.length+1];
        for (int i=1; i<=edges.length; i++)
        {
            parent[i] = i;
        }
        for (int edge[]:edges) {
            int x=find(parent, edge[0]);
            int y=find(parent, edge[1]);
            if (x==y)
                return new int[]{edge[0], edge[1]};
            else
                union(parent,x,y);
        }
        return null;
    }
    public int find(int [] parent, int v) {
        if (parent[v] == v)
        {
            return v;
        }
        return find(parent,parent[v]);
    }
    public void union(int [] parent, int x, int y) {
        int xSet = find(parent,x);
        int ySet = find(parent,y);
        parent[xSet] = ySet;
    } 
}
