class DSU{
    int parent[];
    int rank[];

    DSU(int n){
        parent=new int[n+1];
        rank=new int[n+1];

        for(int i=1;i<=n;i++){
          parent[i]=i;
          rank[i]=0;
        }
    }

    int find(int x){
        if(parent[x]==x) return x;
        parent[x]=find(parent[x]);

        return parent[x];
    }

    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb) return;
        if(rank[pa]<rank[pb]) parent[pa]=pb;
        else if(rank[pb]<rank[pa]) parent[pb]=pa;
        else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];

            if(dsu.find(u)==dsu.find(v)){
                return edge;
            }
            dsu.union(u,v);
        }
        return new int[]{-1,-1};
    }
}
