import java.util.*;
class main{
    static boolean isPrime(int n){
        if(n==4) return true;
        int i=2;
        while(i*i<=n){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }

    // for(int i=1;i<=n;i++){
    //     for(int j=1;j<=i;j++){
    //         for(int k=1;k<=j;k++){
    //             for(int x=4;x<=4*n;x++){
    //                 if((i+2*j+k)%x==0){
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
    // }
    public static void main(String[] args) {
        int n=1;
        // int count=0;
        ArrayList<Integer> al = new ArrayList<>();
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         for(int k=1;k<=n;k++){
        //             for(int x=1;x<=n;x++){
        //                 for(int y=1;y<=n;y++){
        //                     for(int z=1;z<=n;z++){
        //                         if((i+2*j+k)%(x+y+2*z)==0){
        //                             // System.out.println((i+2*j+k)+" = "+(x+y+2*z)+"\t"+i+"\t"+j+"\t"+k+"\t"+x+"\t"+y+"\t"+z);
        //                             System.out.println((i+2*j+k)+" = "+(x+y+2*z));
        //                             // System.out.println((i+2*j+k));
        //                             count++;
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        int count=0;
            for(int i=2;i<=2*n;i++){
                for(int j=1;j<=n;j++){
                    int val =(i+2*j);
                    System.out.println(val);
                    for(int x=2;x<=2*n;x++){
                        for(int y=1;y<=n;y++){
                            int val2=x+2*y;
                            System.out.println(val+"\t"+val2);
                            if(val%val2==0) count+=2;
                        }
                    }
                }
            }
            System.out.println();
            System.out.println(count);

        // for(int i=1;i<=n;i++){
        //         for(int j=1;j<=n;j++){
        //             for(int k=1;k<=n;k++){
        //                 int val = (i+2*j+k);
        //                 for(int x=4;x<=val;x++){
        //                     if(val%x==0){
        //                         count++;
        //                     }
        //                 }
        //             }
        //         }
        //     }
        
    }
}