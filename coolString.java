import java.util.*;
class main{
    static String solve(){
        
    }
    static ArrayList<String> arr = new ArrayList<>();
    public static void main(String args[]){
        for(char ch='a';ch<='c';ch++){
            arr.add(ch+"");
        }
        int p=0;
        while(arr.size()<1e5){
            for(char ch = 'a';ch<='c';ch++){
                arr.add(arr.get(p)+ch);
                // System.out.println(arr);
            }
            p++;
            // if(arr.size()<=1e5) break;
        }
        for(String s : arr){
            System.out.println(s);
        }
    }
}