import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = scn.nextInt();
        while(tc-->0){
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
            }
            boolean res=false;
            for(int i=0;i<n;i++){
                if(arr[i]%2==0){
                    sb.append(1+"\n");
                    sb.append(i+1).append("\n");
                    res=true;
                    break;
                }
                else if(i+1<n){
                    if(arr[i]%2!=0 && arr[i+1]%2!=0){
                        sb.append(2+"\n");
                        sb.append((i+1)+" "+(i+2)).append("\n");
                        res=true;
                        break;
                    }
                }
            }
            if(!res){
                sb.append(-1+"\n");
            }
        }
        System.out.println(sb);
    }
}