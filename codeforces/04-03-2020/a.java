import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int n =scn.nextInt();
            int m = scn.nextInt();
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=scn.nextInt();
            }
            if(sum>m){
                sb.append(m+"\n");
            }else{
                sb.append(sum+"\n");
            }
        }
        System.out.println(sb);
    }
}