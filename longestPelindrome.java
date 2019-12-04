import java.util.*;

class main{
    static void printBooleanArr(boolean arr[][]){
        for(boolean ar[] : arr){
            System.out.println(Arrays.toString(ar));
        }
    }
    static int solve(String s){
        int count=0;
        int len=s.length();
        boolean mem[][] = new boolean[len][len];
        printBooleanArr(mem);
        for(int dig=0;dig<s.length();dig++){
            int x=0;
            int y=dig;
            while(y<len){
                if(dig==0){
                    mem[y][x]=true;
                }else if(dig==2 && s.charAt(x)==s.charAt(y)){
                    mem[y][x]=true;
                }else if(s.charAt(x)==s.charAt(y) && )
            }
        }
    }
    public static void main(String[] args) {
        
    }
}