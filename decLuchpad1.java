import java.util.*;
class main{
    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            int n = scn.hasNextInt()?scn.nextInt():0;
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.hasNextInt()?scn.nextInt():0;
            }
            int minArr [] = new int[n];
            minArr[0]=arr[0];
            long res=arr[0];
            for(int i=1;i<n;i++){
                minArr[i]=Math.min(arr[i],minArr[i-1]);
                res+=minArr[i];
            }
            sb.append(res+"\n");
        }
        System.out.println(sb);
    }
}