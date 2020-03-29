import java.util.*;

class Edge{
    String v;
    int w;
    Edge(String vertex , int weight){
        this.v=vertex;
        this.w=weight;
    }
}

class Tri{
    String v;
    int w;
    int n;
    Tri(String v , int w , int n){
        this.v=v;
        this.w=w;
        this.n=n;
    }
}

class Graph{
    Map<String , ArrayList<Edge>> graph = new HashMap<>();
    public void add(String u , String v , int weight){
       if(!graph.containsKey(v)){
            graph.put(v,new ArrayList<>());
       }
       if(!graph.containsKey(u)){
           graph.put(u , new ArrayList<>());
           graph.get(u).add(new Edge(v ,weight));
           return;
       }

       graph.get(u).add(new Edge(v , weight));
    }
    @Override
    public String toString(){
        String res="";
        for(String u : graph.keySet()){
            res+=u+"->";
            for(Edge neighbour : graph.get(u)){
                res+="("+neighbour.v+" | "+neighbour.w+")";
            }
            res+="\n";
        }
        return res;
    }

    void DFS(String src , String des , String path ,int cost, int interconnected , Set<String> visited ,ArrayList<Tri> res ){
        if(src.equals(des)){
            res.add(new Tri(path+" "+cost , cost , interconnected));
            return ;
        }
        visited.add(src);
        for(Edge neighbour : graph.get(src)){
            if(!visited.contains(neighbour.v)){
                visited.add(neighbour.v);
                DFS(neighbour.v , des , path+" "+neighbour.v , cost+neighbour.w ,interconnected+1 , visited ,res );
                visited.remove(neighbour.v);
            }
        }
    }
}
class Triple{
    String s1;
    String s2;
    int w;
    Triple(String s1 , String s2 , int w){
        this.s1=s1;
        this.s2=s2;
        this.w=w;
    }
}

class main{
    public static void main(String args[]){       
        Scanner scn = new Scanner(System.in);
        String src =scn.next();
        String des =scn.next();
        Graph g = new Graph();
        ArrayList<Triple> inp =new ArrayList<>();
        while(scn.hasNext()){
            inp.add(new Triple(scn.next() ,scn.next() ,scn.nextInt()));
        }
        for(Triple triple : inp){
            g.add(triple.s1 , triple.s2 , triple.w);
        }
        ArrayList<Tri> res = new ArrayList<>();
        g.DFS(src, des, src, 0, 1, new HashSet<String>(), res);
        Collections.sort(res,new Comparator<Tri>(){
            @Override
            public int compare(Tri e1 , Tri e2){
                if(e1.w==e2.w){
                    return e1.n-e2.n;
                }
                return e1.w-e2.w;
            }
        });
        for(Tri t : res){
            System.out.println(t.v);
        }
    }
}


/*


bengaluru coimbatore
bangaluru coimbatore 10000
bangaluru chennai 4000
chennai coimbatore 4000


*/