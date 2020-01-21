import java.util.*;
class main{
    static class Graph{
        public static class Edge{
            int vertex;
            Edge(int v ){
                this.vertex=v;
            }
        }
        ArrayList<Edge> graph[];
        public Graph(int size){
            this.graph=new ArrayList[size];
            for(int i=0;i<size;i++){
                this.graph[i]=new ArrayList<>();
            }
        
        }
        void addEdge(int u , int v){
            this.graph[u].add(new Edge(v));
            // this.graph[v].add(new Edge(u));
        }
        void DFS(int src , int isVisited[] , int weight){
            isVisited[src]=weight;
            // System.out.println(Arrays.toString(isVisited));
            for(Edge e : this.graph[src]){
                if(isVisited[e.vertex]==-1){
                    DFS(e.vertex,isVisited,weight+6);
                }
            }
        }
        void display(){
            for(int i=0;i<this.graph.length;i++){
                System.out.print(i+"->");
                for(Edge e : this.graph[i]){
                    System.out.print(e.vertex+",");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        for(int tc=scn.nextInt();tc>0;tc--){
            int n=scn.nextInt();
            int m=scn.nextInt();
            Graph g = new Graph(n+1);
            for(int i=1;i<m;i++){
                g.addEdge(scn.nextInt(),scn.nextInt());
            }
            int src = scn.nextInt();
            int isVisited[] = new int[n+1];
            Arrays.fill(isVisited,-1);
            for(int i=1;i<n;i++){
                if(isVisited[i]==-1)g.DFS(src,isVisited,0);
            }
            for(int i=1;i<n;i++){
                if(i!=src) System.out.print(isVisited[i]==0?-1:isVisited);
            }
        }
    }
}