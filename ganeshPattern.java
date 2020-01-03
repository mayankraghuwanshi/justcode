import java.util.*;
class main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //first half
                if(i<n/2){
                    if(j==0 || j==n/2){
                        System.out.print("*");
                    }
                    else if(i==0 && j>n/2){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                //second half
                else if(i>n/2){
                    if(j==n-1 || j==n/2){
                        System.out.print("*");
                    }
                    else if(i==n-1 && j<n/2){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}