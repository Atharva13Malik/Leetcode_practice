class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        //  Build suffix max array
        char[] suffixMax = new char[n];
        suffixMax[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--){
            suffixMax[i] = (char)Math.max(arr[i], suffixMax[i+1]);
        }

        //  Find first place to swap
        for(int i = 0; i < n; i++){
            if(arr[i] < suffixMax[i]){
                // find  index of suffixMax[i]
                for(int j = n-1; j > i; j--){
                    if(arr[j] == suffixMax[i]){
                        // swap
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
                break; // only one swap allowed
            }
        }

        //  Convert back to number
        return Integer.parseInt(new String(arr));
    }
}
