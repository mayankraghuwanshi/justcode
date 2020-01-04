import java.util.*;
class main{
    public static void main (String args[]) {
		Scanner scn = new Scanner(System.in);
        int n = scn.hasNextInt()?scn.nextInt():0;
        int t = scn.hasNextInt()?scn.nextInt():0;
        int arr[] = new int[n];
        int tc[][] = new int[t][2];
        for(int i=0;i<n;i++){
            arr[i]=scn.hasNextInt()?scn.nextInt():0;
        }
        for(int i=0;i<t;i++){
            arr[i][0]=scn.hasNextInt()?scn.nextInt():0;
            arr[i][1]=scn.hasNextInt()?scn.nextInt():0;
        }
        int res=0;
        for(i=0;i<t;i++){
            int l=tc[i][0];
            int r=tc[i][1];
            for(int p=l;p<r-1;p++){
                for(int q=p+1;q<r;q++){
                    if(p==l && q<r-1){
                        
                    }
                    else if(p>l && q<r-1){

                    }
                    else if(p>l && q==r-1){

                    }
                    else if(p==l && q==r-1){

                    }
                }
            }
        }
    }
}
