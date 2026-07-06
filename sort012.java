class Solution {
    public void sort012(int[] arr) {
        // code here
        int countzero=0;
        int countone=0;
        int counttwo=0;
        int k=0;
        //int temp[]=new int[temp.length];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) countzero++;
            if(arr[i]==1) countone++;
            if(arr[i]==2) counttwo++;
            
            
            
        }
        for(int i=0;i<countzero;i++){
            arr[k++]=0;
        }
        for(int i=0;i<countone;i++){
            arr[k++]=1;
        }
        for(int i=0;i<counttwo;i++){
            arr[k++]=2;
        }
    }
}
