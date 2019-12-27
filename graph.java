import java.util.ArrayList;
import java.util.Stack;
class main{
    static class Edge{
        int val;
        int weight;

        Edge(int val , int weight){
            this.val=val;
            this.weight=weight;
        }
    }
    static ArrayList<Edge> graph [] = new ArrayList[7];
    static void initGraph(){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
    }
    static void add(int src , int des , int weight){
        if(isValid(src , des)){
            graph[src].add(new Edge(des , weight));
            graph[des].add(new Edge(src , weight));
        }
    }
    static boolean isValid(int src , int des){
        if(src>=0 && src<graph.length && des>=0 && des<graph.length) return true;
        return false;
    }
    static void display(){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+" -> ");
            for(Edge ver : graph[i]){
                System.out.print("("+ver.val+" | "+ver.weight+")"+", ");
            }
            System.out.println();
        }
    }

    static void removeEdge(int src , int des){
        for(int i=0;i<graph[src].size();i++){
            if(graph[src].get(i).val==des){
                graph[src].remove(i);
            }
        }
        for(int i=0;i<graph[des].size();i++){
            if(graph[des].get(i).val==src){
                graph[des].remove(i);
            }
        }
    }
    static int printPath(int src , int des , boolean isDone[],String path){
        if(src==des){
            System.out.println(path+"->"+des);
            return 1;
        }
        isDone[src]=true;
        int count=0;
        for(int i=0;i<graph[src].size();i++){
            if(!isDone[graph[src].get(i).val]){
                count+=printPath(graph[src].get(i).val,des,isDone,path+"->"+src);
            }
        }
        return count;
    }

    static int sortedPath(int src  , int des , boolean isDone[], int currentCost){
        if(src==des){
            return currentCost;
        }
        isDone[src]=true;
        int minCost=Integer.MAX_VALUE;
        for(int i=0;i<graph[src].size();i++){
            if(!isDone[graph[src].get(i).val]){
                int cost = sortedPath(graph[src].get(i).val,des,isDone,currentCost+graph[src].get(i).weight);
                minCost=Math.min(minCost,cost);
            }
        }
        isDone[src]=false;
        return minCost;
    }
    static void removeVertex(int ver){
        Stack<Edge> stack = new Stack<>();
        System.out.println(graph[ver]);
        for(int i=0;i<graph[ver].size();i++){
            stack.push(graph[ver].get(i));
        }
        System.out.println(stack);
        while(stack.size()>0){
            Edge temp = stack.pop();
            for(int i=0;i<graph[temp.val].size();i++){
                if(graph[temp.val].get(i).val==ver){
                    graph[temp.val].remove(i);
                }
            }
        }
        graph[ver].clear();
    }
    public static void main(String args[]){
        initGraph();
        add(0,1,2);
        add(0,2,3);
        add(2,3,4);
        add(3,1,2);
        add(1,4,5);
        add(4,6,4);
        add(4,5,2);
        add(5,6,3);
        boolean isDone[] = new boolean[7];
        // removeEdge(1,4);
        // removeVertex(4);
        // display();
        // printPath(0,6,isDone,"");
        System.out.println(sortedPath(0,6,isDone,0));
    }

}