class Solution {
static class Edge{
int start;
int end;
int weight;
public Edge(int start,int end,int weight){
this.start=start;
this.end=end;
this.weight=weight;
}
}
static class SortByWeight implements Comparator{
@Override
public int compare(Edge e1,Edge e2){
return e1.weight-e2.weight;
}
}

public int topParent(int[] parent,int x){
    if(parent[x]!=x){
        parent[x]=topParent(parent,parent[x]);
    }
    return parent[x];
}
public void union(int[] parent,int[] rank,int a,int b){
int topA=topParent(parent,a);
int topB=topParent(parent,b);
if(topA==topB){
return;
}
if(rank[topA]>rank[topB]){
parent[topB]=topA;
}
else{
parent[topA]=topB;
if(rank[topA]==rank[topB]){
rank[topB]+=1;
}
}
return;
}

public int minCostConnectPoints(int[][] points) {
    int n=points.length;
    ArrayList<Edge> arr=new ArrayList<Edge>();
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            arr.add(new Edge(i,j,dist));
        }
    }
    int[] parent=new int[n];
    int[] rank=new int[n];
    Arrays.fill(rank,0);
    for(int i=0;i<n;i++){
        parent[i]=i;
    }
    Collections.sort(arr,new SortByWeight());
    int count=0;
    int i=0;
    int ans=0;
    while(count<n-1){
        int a=arr.get(i).start;
        int b=arr.get(i).end;
        if(topParent(parent,a)!=topParent(parent,b)){
            union(parent,rank,a,b);
            count+=1;
            ans+=arr.get(i).weight;
        }
        i=i+1;
    }
    return ans;
}
}
