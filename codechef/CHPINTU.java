import java.util.*;
class main{
    static int input(Scanner scn){
        if(scn.hasNextInt()){
            return scn.nextInt();
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int tc = input(scn);
        while(tc-->0){
            int m = input(scn);
            int n = input(scn);
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            int min = Integer.MAX_VALUE;

            for(int i=0;i<m;i++){
                arr1[i]=input(scn);
            }
            for(int i=0;i<m;i++){
                int index = arr1[i]-1;
                int temp = input(scn);
                arr2[index]+=temp;
            }
            for(int item : arr2){
                if(item==0) continue;
                min=Math.min(min,item);
            }

            System.out.println(min==Integer.MAX_VALUE?0:min);
        }

    }
}