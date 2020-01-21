import java.util.*;
class main{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder();
        Scanner scn = new Scanner(System.in);
        int n = scn.hasNextInt()?scn.nextInt():0;
        int arr[] = new int[n];
        int q = scn.hasNextInt()?scn.nextInt():0;
        int len = arr.length;
        for(int i=0;i<n;i++){
            arr[i]=scn.hasNextInt()?scn.nextInt():0;
        }
        int [] inc=new int[n];
        int count=1;
        for(int i=1;i<n;++i){
            i--;
            if(i+1<len && arr[i]<arr[i+1]){
                while(i+1 < len && arr[i]<arr[i+1]){
                    if(inc[i]==0)
                    inc[i]=count;
                    i++;
                }
                inc[i]=count;
                count++;
            }
            if(i+1<len && arr[i]>arr[i+1]){
                while(i+1<len && arr[i]>arr[i+1]){
                    if(inc[i]==0)
                    inc[i]=count;
                    i++;
                }
                inc[i]=count;
                count++;
            }
        }
        // System.out.println(Arrays.toString(inc));
        for(int i=0;i<q;i++){
            int start=scn.hasNextInt()?scn.nextInt()-1:0;
            int end = scn.hasNextInt()?scn.nextInt()-1:0;
            if(inc[start]==inc[start+1]){
                sb.append((inc[end]-inc[start]+1)%2==0?"YES":"NO").append("\n");
            }else{
                sb.append((inc[end]-inc[start])%2==0?"YES":"NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}