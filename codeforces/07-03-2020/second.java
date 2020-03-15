import java.util.*;
class main{
    static boolean isPrime(int n){
        if(n<=1) return false;
        int i=2;
        while(i*i<=n){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = scn.hasNext()?scn.next():"";
        while(tc-->0){
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.hasNextInt()?scn.nextInt():0;
            }
            int res=0;
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(isPrime(arr[i]+arr[j])) res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}