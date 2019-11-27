import java.util.*;
class test{
    static int solve(int arr[] , int t){
        int min=Integer.MAX_VALUE;
        int res=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                int dif = Math.abs(t-sum);
                if(dif<min){
                    res=sum;
                    min=dif;
                }
                if(sum<t){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {-1,2,1,-4};
        System.out.println(solve(arr, 1));
    }
}