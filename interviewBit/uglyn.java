import java.util.*;
class main{
    static void print(PriorityQueue<Integer> pq){
        PriorityQueue<Integer> queue = new PriorityQueue<>(pq);
        while(queue.size()>0){
            System.out.print(queue.remove()+",");
        }
        System.out.println();
    }
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i1-i2;
            }
        });
        pq.add(2);
        pq.add(5);
        pq.add(3);
        Set<Integer> set = new HashSet<>();
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int res[] = new int[k];
        int i=0;
        while(k>0){
             int val = pq.remove();
             if(!set.contains(val)){
                 res[i]=val;
                i++;
                k--;
                pq.add(val*2);
                pq.add(val*3);
                pq.add(val*5);
             }
        }
        System.out.println(Arrays.toString(res));
    }
}