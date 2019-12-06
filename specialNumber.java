import java.util.*;
class main{
   
    static int num=0;
    static void fillArr(SortedSet<Integer> arr , int n1,int p1,int res1 , int n2,int p2,int res2){
        // System.out.println(n1+"^"+p1+"\t"+n2+"^"+p2+"\t"+(res1+res2));
        num++;
        arr.add(res1+res2);
        if(p1+p2>=12){
            return ;
        }
        fillArr(arr, n1, p1+1, res1*n1, n2, p2, res2);
        fillArr(arr, n1, p1, res1, n2, p2+1, res2*n2);
    }
    static void getCount(){
        System.out.println(num);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        SortedSet<Integer> set  = new TreeSet<>();
        fillArr(set,3,1,3,5,1,5);
        fillArr(set,5,1,5,7,1,7);
        fillArr(set,3,1,3,7,1,7);
        for(int item : set){
            System.out.println(item);
        } 
        getCount();
    }
}