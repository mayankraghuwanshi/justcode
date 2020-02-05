import java.util.*;
class Edge {
    int v;
    int w;
    Edge(int v,int w){
        this.v=v;
        this.w=w;
    }
}

class main{
    static void print(PriorityQueue<Edge> queue){
        while(queue.size()>0){
            System.out.print(queue.remove().w+",");
        }
        System.out.println();
    }
    public static void main(String args[]){
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1 , Edge e2){
                return e1.w-e2.w;
            }
        });
        queue.add(new Edge(2,5));
        queue.add(new Edge(3,12));
        queue.add(new Edge(5,2));
        print(queue);
        
    }
}