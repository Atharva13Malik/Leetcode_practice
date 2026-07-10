class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        //int n=edges.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean visited[]=new boolean[n];
        return bfs(source,list,visited,destination);
    }
    public boolean bfs(int start,ArrayList<ArrayList<Integer>> list,boolean visited[],int destination){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int node=q.remove();

            for(int neighbour:list.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
        }
        return visited[destination]==true;
    }
}
