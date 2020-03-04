import java.util.*;
public class Main{
    // static getVal(String str , int i)
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int len = scn.nextInt();
            String str = scn.next();
            int start = 0;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                int val = (int) ch-'a';
                if(val<min){
                    min=val;
                    start=i;
                }
                else if(val==min){
                    int c1 = (start+1<str.length()) ? (int) str.charAt(start+1)-'a' : (int) str.charAt(0)-'a';
                    int c2 = (i+1<str.length()) ? (int) str.charAt(i+1)-'a' :  (int) str.charAt(0)-'a';
                    if(c2<c1){
                        start=i;

                    int c1 = (start-1>=0) ? ((int) str.charAt(i-1)-'a') : ((int) str.charAt(start+1)-'a');
                    int c2 = (int) str.charAt(i-1)-'a';
                    if(c2<c1){
                        start=i;
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for(int i=start;i>=0;i--){
                res.append(str.charAt(i));
            }
            for(int  i=start+1;i<str.length();i++){
                res.append(str.charAt(i));
            }
            sb.append(res+"\n"+(start+1)+"\n");
            
        }
        System.out.println("  ..............................");
        System.out.println(sb);
    }

}