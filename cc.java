import java.util.*;

class main{
    static class Edge{
        int vertex;
        int weight;
        Edge(int v , int w){
            this.vertex=v;
            this.weight=w;
        }
    }
    static void addEdge(int u , int u , int weight){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    static ArrayList<Edge> graph[] = new ArrayList[7];
    public static void main(String args[]){
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        

    }
}