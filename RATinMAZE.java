class RIM{
  public int rim(int m ,int n){
    
return paths(0,0,m-1,n-1);
}
public int paths(int r,int c,int er,int ec){
if(r==er && c==ec) return 1;
  if(r>er && c>ec) return 0;
  int rightways=paths(r,c+1,er,ec);
  int leftways=paths(c,r+1,er,ec)

    return rightways+leftways;
}
