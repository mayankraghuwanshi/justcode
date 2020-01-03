import java.util.*;
class main{
    public static void main (String args[]) {
		Scanner scn = new Scanner(System.in);
		int n,m,k,s;
        n=scn.nextInt();
        m=scn.nextInt();
        char charr[][] = new char[n][m];
        k=scn.nextInt();
        s=scn.nextInt();
        // k=scn.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                charr[i][j]=scn.next().charAt(0);
            }
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(s<1){
                    System.out.println("NO");
                    System.exit(0);
                }
                if(charr[i][j]=='#') break;
                else if(charr[i][j]=='*') s+=5;
                else if(charr[i][j]=='.') s-=2;
                System.out.print(s+" ");
            }
            System.out.println();
        }
        if(s>=k){
            System.out.println("YES");
            System.out.println(s);
        }else{
            System.out.println("NO");
        }
    }
}
