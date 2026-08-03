import java.util.*;
public class Main{
  public static void main(String args[]){
    DSU dsu=new DSU(5);
    dsu.union(1,2);
    dsu.union(2,3);

    dsu.find(2);
    dsu.find(3);

    
  }
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

      return parent;
  }

    void union(int a,int b){
      int pa=find(a);
      int pb=find(b);

      if(pa==pb) return ;

      if(rank[a]<rank[b]) parent[pa]=pb;
      else if(rank[a]>rank[b]) parent[pb]=pa;
      else{
        parent[pb]=pa;
        rank[pa]++;
}
