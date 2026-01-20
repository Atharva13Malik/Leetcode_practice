import java.util.*;
public class LC1552 {
    // leetcode 1552
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int positions[] = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }

    }
    public int maxDistance(int position[],int m){
        Arrays.sort(position);

        int start=1;
        int n=position.length;
        int end=position[n]-position[0];

        int result=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(position,m,mid)){
                result=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return result;
    }
    public boolean isPossible(int position[],int m,int mid){
        int count=1;
        int lastPlace=position[0];

        for(int i=0;i<position.length;i++){
            if(position[i]-lastPlace>=mid){
                count++;
                lastPlace=position[i];
                if(count==m){
                    return true;
                }

            }
        }
        return false;
    }


