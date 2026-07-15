import java.util.*;
public class Main{
  public static void main(String args[]){

    Scanner sc=new Scanner(System.in);
    int V=sc.nextInt();
    int E=sc.nextInt();
    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    
    for(int i=0;i<V;i++){
      list.add(new ArrayList<>());
    }

     for(int i=0;i<E;i++){
      int u=sc.nextInt();
       int v=sc.nextInt();

       adj.get(u).add(v);
    }

    int indegree[]=new int[V];

    for(int i=0;i<V;i++){
       for(int neighbour:adj.get(i)){
         indegree[neighbour]++;
       }
    }

    ArrayList<Integer> result=new ArrayList<>();
    Queue<Integer> q=new LinkedList<>();

     for(int i=0;i<v;i++){
       if(indegree[i]==0){
         q.add(i);
      } 
    }

    while(!q.isEmpty()){
      int node=q.poll();
      result.add(node);

      for(int neighbour:adj.get(node)){
        indegree[neighbour]--;
        if(indegree[neighbour]==0){
          q.offer(neighbour);
        }
      }
    }

    System.out.print(result);

    
  }
}
