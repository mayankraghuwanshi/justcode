import java.util.*;
class main{
    static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    static int noOfDub(int arr[]){
        int res=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==arr[i]*arr[j]){
                    System.out.println(i+"\t"+j);
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        for(int tc=scn.hasNextInt() ? scn.nextInt():0;tc>0;tc--){
            int n = scn.hasNextInt() ? scn.nextInt():0;
            long t=0;
            long z=0;
            for(int i=0;i<n;i++){
                int inp = scn.hasNextInt() ? scn.nextInt():0;
                if(inp==2) t++;
                else if(inp==0) z++;
            }
            res.append((((t*(t-1))/2)+((z*(z-1))/2))+"\n");
        }
        System.out.println(res);
    }
}