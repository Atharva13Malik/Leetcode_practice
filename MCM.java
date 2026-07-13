import java.util.*;
public class Main{
  public static void main(String args[]){
    int arr={1,2,3,4,2};  // Represent 4 matrices
    int n=arr.length;
    System.out.print.ln(mcm(0,n-2,arr);
  }

  public int  mcm(int i,int j,int arr[]){
  if(i==j) return 0;
    int min=Integer.MAX_VALUE;
    int cost=0;

    for(int k=i;k<j;k++){
      int x=arr[i]*arr[k+1]*arr[j+1];
      cost=mcm(i,k,arr)+mcm(k+!,j,arr)+x;
      min=Math.min(cost,min)
        
    }
    return min;
    
  }
}
