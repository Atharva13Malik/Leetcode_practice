class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int ele:graph[i]){
                //In orignal Graph,direction is from i to ele
                // In reverse graph, direction is from ele to i

                list.get(ele).add(i);
                indegree[i]++;
            }
        }

        //Apply Kahn Algorithm
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int front=q.remove();
            ans.add(front);
            for(int ele:list.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        } 
         Collections.sort(ans);
         return ans;


    }
}
