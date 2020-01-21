import java.util.*;
class main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int tc = scn.hasNextInt()?scn.nextInt():0;
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int a = scn.hasNextInt()?scn.nextInt()-1:0;
            int b = scn.hasNextInt()?scn.nextInt()-1:0;
            int res=(a>b)?a-b:b-a;
            int i=1;
            int count=0;
            while(i*i<=res){
                if(res%i==0){
                    if(res/i==i){
                        count++;
                    }else{
                        count+=2;
                    }
                }
                i++;
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
//         Scanner scn = new Scanner(System.in);
//         int tc = scn.hasNextInt()?scn.nextInt():0;
//         while(tc-->0){
//             long l = scn.hasNextLong()?scn.nextLong():0;
//             long r = scn.hasNextLong()?scn.nextLong():0;
            // long res=l;
            // long cum=l;
            // long i=l+1;
            // while(cum>0 && i<=r){
            //     cum=(cum&i);
            //     res+=cum;
            //     i++;
            // }
            // System.out.println(res);
//         }
//     }
// }