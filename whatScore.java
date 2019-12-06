import java.util.*;
class main{


    public static void main(String args[]){
        Scanner scn =new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            int arr[] = new int[9];
            Arrays.fill(arr , 0);
            for(int n=scn.hasNextInt()?scn.nextInt():0;n>0;n--){
                int key = scn.hasNextInt()?scn.nextInt():0;
                int val = scn.hasNextInt()?scn.nextInt():0;
                if(key>=0 && key<=8){
                    arr[key] = Math.max(arr[key], val);
                }
            }
            int res = 0;
            for(int item : arr){
                res+=item;
            }
            sb.append(res+"\n");
        }
        // System.out.println(".............................");
        System.out.println(sb);
    }
}