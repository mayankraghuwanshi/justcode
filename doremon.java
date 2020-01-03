import java.util.*;
class main{
    public static void main (String args[]) {
		Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            int n = scn.hasNextInt()?scn.nextInt():0;
            int m = scn.hasNextInt()?scn.nextInt():0;
            int arr[][] = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=scn.hasNextInt()?scn.nextInt():0;
                }
            }
            int res=0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    int l=j;
                    int r=j;
                    int t=i;
                    int b=i;
                    int count=0;
                    while(l>=0 && r<arr[0].length && t>=0 && b<arr.length){
                        if(arr[t][j]==arr[b][j] && arr[i][l]==arr[i][r]) count++;
                        else break;
                        l--;
                        r++;
                        t--;
                        b++;
                    }
                    // System.out.print(count+" ");
                    if(count>0){
                        res+=count;
                    }
                }
                // System.out.println();
            }
            sb.append(res+"\n");
        }
        System.out.println(sb);
    }
}
