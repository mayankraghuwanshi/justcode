import java.util.*;
class main{
    public static class Graph{
        ArrayList<Integer> graph[];
        Graph(int n){
            this.graph = new ArrayList[n];
            for(int i=0;i<n;i++){
                this.graph[i]=new ArrayList<Integer>();
            }
        }
        void addEdge(int u , int v){
            this.graph[u].add(v);
            this.graph[v].add(u);
        }
        void display(){
            for(int i=0;i<this.graph.length;i++){
                System.out.print(i+"->");
                for(int item : this.graph[i]){
                    System.out.print(item+",");
                }
                System.out.println();
            }
        }
        public int[] shortestReach(int src){
            int noOfVertex = this.graph.length;
            int distance[] = new int[noOfVertex];
            Arrays.fill(distance,-1);
            boolean visited[] = new boolean[noOfVertex];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            visited[src]=true;
            int level=0;
            distance[src]=level;
            while(queue.size()>0){
                int size = queue.size();
                // System.out.println(currentVertex+"\t"+level);
                while(size-->0){
                    int currentVertex  = queue.remove();
                    for(int neighbour : this.graph[currentVertex]){
                        if(!visited[neighbour]){
                            queue.add(neighbour);
                            visited[neighbour]=true;
                            distance[neighbour]=(level+1)*6;
                        }
                    }
                }
                level++;
            }
        return distance; 
        }       
    }
    public static void main(String args[]){
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(0,4);
        // g.display();
        System.out.println(Arrays.toString(g.shortestReach(0)));
    }
}