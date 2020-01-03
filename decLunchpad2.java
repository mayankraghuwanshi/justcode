import java.util.*;
class main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            String str = scn.hasNext()?scn.next():"";
            StringBuilder sb = new StringBuilder();
            int count=1;
            for(int i=1;i<str.length();i++){
                if(str.charAt(i-1)==str.charAt(i)) count++;
                else{
                    sb.append(str.charAt(i-1)).append(count);
                    count=1;
                }
            }
            sb.append(str.charAt(str.length()-1)).append(count);
            System.out.println(sb);
            if(str.length()==sb.length()) res.append("No\n");
            else if(str.length()<sb.length()) res.append("No\n");
            else res.append("Yes\n");
        } 
        System.out.println(res);           
    }
}