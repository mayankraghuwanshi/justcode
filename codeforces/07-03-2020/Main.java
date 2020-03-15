import java.util.*;
public class Main{
    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = scn.hasNextInt()?scn.nextInt():0;
        while(tc-->0){
           int n = scn.hasNextInt()?scn.nextInt():0;
           int l = scn.hasNextInt()?scn.nextInt():0;
           int a=2;
           if(n%2!=0){
               sb.append(0).append("\n");
               continue;
           }
           long arr[] = new long[n+1];
           Arrays.fill(arr,0);
           arr[0]=1;
           for(int i=2;i<=n;i+=2){
               a=2;
               while(a<=l && a<=i){
                   arr[i]+=(long)arr[i-a];
                   arr[i]%=1e9+7;
                   a+=2;
               }
           }
           sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}