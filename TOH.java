class Recusrsion{
  public static void main(String args[]){
    hanoi(n,A,B,C);
  }
  public void hanoi(int n,char a,char b,char c){
    if(n==0) return;
    hanoi(n-1,a,c,b);
    System.out.print(a+"->"+c);
    hanoi(n-1,b,a,c);
    
}
