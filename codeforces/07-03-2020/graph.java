import java.util.*;
class Edge{
    public int vertex;
    public int weight;
    Edge(int v , int w){
        this.vertex=v;
        this.weight=w;
    }
}
class Graph{
    public ArrayList<Edge> graph[];
    public Graph(int size){
        this.graph = new ArrayList[size];
        for(int i=0;i<size;i++){
            this.graph[i]=new ArrayList<>();
        }
    }
    public void addEdge(int u , int v  , int weight  , boolean bidir){
        if(u>=0 && u<this.graph.length && v>=0 && v<this.graph.length){
            this.graph[u].add(new Edge(v,weight));
            if(bidir){
                this.graph[v].add(new Edge(u,weight));
            }
        }
    }
    public void removeEdge(int u , int v){
        for(int i=0;i<this.graph[u].size();i++){
            if(this.graph[u].get(i).vertex==v) {
                this.graph[u].remove(i);
                break;
            }
        }
        for(int i=0;i<this.graph[v].size();i++){
            if(this.graph[v].get(i).vertex==u){
                this.graph[v].remove(i);
                break;
            }
        }
    }
    public boolean isBipartitBFS(){
        int WHITE = -1;
        int RED = 0;
        int GREEN = 1;
        int src=0;
        int noOfvertex = this.graph.length;
        int set[] = new int[noOfvertex];
        Arrays.fill(set,WHITE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        set[src]=GREEN;
        int level=0;
        while(queue.size()>0){
            int size =  queue.size();
            int color = level%2;
            while(size-->0){
                int currentVertex = queue.remove();
                for(Edge e : this.graph[currentVertex]){
                    int neighbour = e.vertex;
                    if(set[neighbour]==WHITE){
                        queue.add(neighbour);
                        set[neighbour]=color;
                    }else if(set[neighbour]!=WHITE && set[neighbour]!=color){
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
    public void display(){
        for(int i=0;i<this.graph.length;i++){
            System.out.print(i+"->");
            for(Edge e  : this.graph[i]){
                System.out.print("("+e.vertex+"|"+e.weight+"),");
            }
            System.out.println();
        }
    }
}


class main{
    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.hasNextInt()?scn.nextInt():0;
        int q = scn.hasNextInt()?scn.nextInt():0;
        Graph g =  new Graph(n);
        boolean isDone[][] = new boolean[n+1][n+1];
        ArrayList<Edge> graph[] = g.graph;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            int inp =scn.hasNextInt()?scn.nextInt():0;
            // g.display();
            if(inp==1){
                int u = scn.hasNextInt()?scn.nextInt()-1:0;
                int v = scn.hasNextInt()?scn.nextInt()-1:0;
                if(!isDone[u][v]){
                    g.addEdge(u,v,0,true);
                    isDone[u][v]=true;
                } 
            }else if(inp==2){
                int u = scn.hasNextInt()?scn.nextInt()-1:0;
                int v = scn.hasNextInt()?scn.nextInt()-1:0;
                if(!isDone[u][v]){
                    g.addEdge(u,v,0,true);
                    sb.append(g.isBipartitBFS()?"Yes":"No").append("\n");
                    g.removeEdge(u,v);
                }else{
                    sb.append(g.isBipartitBFS()?"Yes":"No").append("\n");
                }

            }
        }
        // g.display();
        System.out.println(sb);
    }    
}
