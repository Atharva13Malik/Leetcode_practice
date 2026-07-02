public class Main{
public static void main(String args[]){

  int arr={4,5,6,7,10,10};
  int max=Integer.MIN_VALUE;
  for(int i=0;i<arr.length;i++){
    if(arr[i}>max) max=arr[i];
    
  }
  return max;
}
