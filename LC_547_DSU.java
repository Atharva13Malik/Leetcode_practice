class DSU{
    int parent[];
    int rank[];

    DSU(int n){
     parent=new int[n];
     rank=new int[n];

     for(int i=0;i<n;i++){
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

        if(pa == pb) return;

        if(rank[pa]>rank[pb]) parent[pb]=pa;
        else if(rank[pa]<rank[pb]) parent[pa]=pb;
        else {
            parent[pb]=pa;
            rank[pa]++;
        }
    }


}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU dsu=new DSU(n);


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                   dsu.union(i,j);
                }
                
            }
        }

        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(dsu.find(i));
        }
        return set.size();
    }
}
