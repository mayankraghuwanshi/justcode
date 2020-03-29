import java.util.*;


class Graph{
    ArrayList<Integer> graph[];
    boolean isSpecial[];
    int ans;
    Graph(int size){
        graph=new ArrayList[size];
        for(int i=0;i<size;i++){
            graph[i]=new
            ArrayList<>();
        }
        isSpecial =new boolean[size];
        ans=0;
    }
    void add(int u , int v){

        if(--u==0 || --v==0){
            int nonZero = (u==0)?v:u;
            graph[0].add(nonZero);
            return ;
        }
        graph[u].add(v);
    }

    int solve(int src ,int color ,int map[]){
        Queue<Integer> queue = new LinkedList<>();
        int localRes = 0;
        queue.add(src);
        while(!queue.isEmpty()){
            int currentNode = queue.remove();
            if(map[currentNode]!=-1 &&  map[currentNode]==color){ 
                map[currentNode]=-1;
                localRes++;
            }
            for(int item : graph[currentNode]){
                queue.add(item);
            }
        }
        
        this.ans+=localRes;
        // System.out.println(localRes);
        return ans;
    }

    @Override
    public String toString(){
        String res = "";
        for(int i=0;i<graph.length;i++){
            res+=(i+1)+"->";
            for(int item : graph[i]){
                res+="("+(item+1)+")";
            }
            res+="\n";
        }
        return res;
    }
}

class main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n =scn.nextInt();
        Graph g = new Graph(n);
        for(int i=0;i<n-1;i++){
            g.add(scn.nextInt() ,scn.nextInt());
        }
        int color[] = new int[n];
        for(int i=0;i<n;i++){
            color[i]=scn.nextInt();
        }
        int noOfSpecialNode = scn.nextInt();
        for(int i=0;i<noOfSpecialNode;i++){
            int inp = scn.nextInt();
            sb.append(g.solve(--inp, color[inp], color)).append("\n");
        }

        System.out.println("\n"+sb);
    }
}