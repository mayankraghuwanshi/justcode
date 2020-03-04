class TriNode{
    TriNode children[];
    boolean endOfWord;
    TriNode(){
        this.children=new TriNode[26];
        endOfWord=false;
    }
}
class main{
    static class Trie{
        TriNode root;
        Trie(){
            this.root=new TriNode();
        }
        void insert(String str){
            TriNode itr = this.root;
            for(char ch : str.toCharArray()){
                TriNode node = itr.children[ch-'a'];
                if(node == null) node = new TriNode();
                itr=itr.children[ch-'a'];
            }
            itr.endOfWord=true;
        }
        void print(){
            TriNode itr = this.root;
            print(itr,"");
        }
        void print(TriNode node , String res){
            if(node.endOfWord){
                System.out.println(res);
            }
            
            if(node == null) return;

            for(int i=0;i<26;i++){
                TriNode currentNode = node.children[i];
                if(currentNode!=null){
                    print(currentNode,res+i);
                }
            }
        }
    }
    public static void main(String args[]){
        String s = "hello";
        Trie t = new Trie();
        t.insert(s);
        t.print();
    }
}