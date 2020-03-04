import java.util.*;
class Node{
    int val;
    Node left;
    Node right;
    Node(int data){
        this.val=data;
        this.left=null;
        this.right=null;
    }
}
class tree{
    Node root = null;
    tree(int val){
        Node temp = new Node(val);
        this.root = temp;
    }
    tree(){
        this.root = null;
    }
    void add(int val){
        Node temp = new Node(val);
        if(this.root==null){
            this.root=temp;
        }else{
            if(this.root.val>val){
                this.root.left = add(this.root.left,val);
            }else{
                this.root.right = add(this.root.right,val);
            }
        }
    }

    Node add(Node node, int val){
        if(node==null){
            Node temp = new Node(val);
            return temp;
        }
        if(node.val>val){
            node.left = add(node.left,val);
            return node;
        }else{
            node.right = add(node.right,val);
            return node;
        }
    }
    void display(){
        Queue<Node> queue = new LinkedList<>();
        
        if(this.root!=null) queue.add(this.root);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print(current.val+"->");
            if(current.left!=null) queue.add(current.left);
            if(current.right!=null) queue.add(current.right);
        }
        System.out.println();
    }
    
    void inOrder(){
        Node root = this.root;
        Stack<Node> stack = new Stack<>();
        Node previous = root;
        while(!stack.isEmpty() || previous!=null){
            if(previous!=null){
                while(previous!=null){
                    stack.add(previous);
                    previous=previous.left;
                }
            }else{
                Node current = stack.pop();
                System.out.print(current.val+",");
                previous = current.right;
            }
        }
        System.out.println();
    }
    void preOrder(){
        Node root = this.root;
        Stack<Node> stack = new Stack<>();
        if(root!=null) stack.add(root);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.val+",");
            if(current.right!=null) stack.add(current.right);
            if(current.left!=null) stack.add(current.left);
        }
        System.out.println();
    }
    void seed(int arr[]){
        for(int item : arr){
            add(item);
        }
    }
}


class main{
    static void display(Node root){
        Queue<Node> queue = new LinkedList<>();
        
        if(root!=null) queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print(current.val+"->");
            if(current.left!=null) queue.add(current.left);
            if(current.right!=null) queue.add(current.right);
        }
        System.out.println();
    }

    static Node solve(int ino[] , int pre[]){
        return solveHelper(ino,0,ino.length-1,pre,0,pre.length-1);
    }
    static Node solveHelper(int ino[] , int inoS,int inoE , int pre[] , int preS,int preE){
        if(inoS>inoE || preS>preE || preS<0 || inoS<0 || preE>=pre.length || inoE>=ino.length) return null;
        Node root = new Node(pre[preS]);
        int rootIdx = Arrays.binarySearch(ino , root.val);
        int inoLS = inoS;
        int inoLE = rootIdx-1;
        int inoRS = rootIdx+1;
        int inoRE = inoE;
        int preLS = preS+1;
        int preLE = preLS + (inoLE-inoLS);
        int preRS = preLE+1;
        int preRE = preE;
        root.left = solveHelper(ino,inoLS,inoLE,pre,preLS,preLE);
        root.right = solveHelper(ino,inoRS,inoRE,pre,preRS,preRE);
        return root;
    }

    public static void main(String args[]){
        tree t = new tree();
        int arr[] = {4,8,2,5,1,6,3,7};
        int pre[] = { 1, 2, 3, 4, 5 };
        int ino[] = {3, 2, 4, 1, 5};
        display(solve(ino,pre));
        // t.display();

    }
}