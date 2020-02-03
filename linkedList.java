// package dataStructure;
import java.util.*;

class Node{
    int val;
    Node next;
    Node(int val , Node link){
        this.val=val;
        this.next=link;
    }
    Node(int val){
        this.val=val;
    }
}
class LinkedList{
    Node head;
    Node tail;
    int size;
    LinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    void addFirst(int val){
        Node temp = new Node(val);
        if(this.head==null){
            this.head=temp;
            this.size++;
            this.tail=temp;
        }
        else{
            temp.next=head;
            this.head=temp;
            this.size++;
        }
    }
    void addLast(int val){
        Node temp = new Node(val);
        if(this.head==null){
            this.head=temp;
            this.tail=temp;
            this.size++;
        }else{
            this.tail.next=temp;
            this.tail=temp;
            this.size++;
        }
    }
    int size(){
        return this.size;
    }
    void addAtIndex(int val , int index){
        if(index>this.size+1 || index<0){
            throw new IndexOutOfBoundsException("Index should range between 0 and "+(this.size+1));
        }
        else if(index==0){
            addFirst(val);
        }else if(index==this.size){
            addLast(val);
        }else{
            int i=0;
            Node nodeIterater = this.head;
            while(i<index-1){
                nodeIterater = nodeIterater.next;
                i++;
            }
            Node ref = nodeIterater.next;
            Node temp = new Node(val,ref);
            nodeIterater.next=temp;
            this.size++;
        }
    }
    void deleteFirst(){
        if(this.size==0) return;
        this.head=this.head.next;
        this.size--;
    }
    void deleteLast(){
        if(this.size==0) return;
        Node temp = this.head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        this.tail=temp;
        temp.next=null;
        this.size--;
    }
    void deleteAtIndex(int index){
        if(index>=0 && index<=this.size-1){
            if(index==0){
                deleteFirst();
            }else{
                int i=0;
                Node nodeIterater = this.head;
                while(i<index-1){
                    nodeIterater=nodeIterater.next;
                    i++;
                }
                nodeIterater.next=nodeIterater.next.next;
            }
        }
    }
    void display(){
        StringBuilder sb = new StringBuilder();
        Node i = this.head;
        while(i!=null){
            sb.append(i.val+"->");
            i=i.next;
        }
        System.out.println(sb.substring(0,sb.length()-2));
    }
    
}
class main{
    static void bubbleSort(LinkedList list){
        Node head = list.head;
        int size = list.size;
        for(Node i=head;i.next!=null;i=i.next){
            for(Node j=i.next;j!=null;j=j.next){
                if(j.val<i.val){
                    int temp = j.val;
                    j.val=i.val;
                    i.val=temp;
                }
            }
        }
    }
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.addAtIndex(3,0);
        list.addAtIndex(2,0);
        list.addAtIndex(1,0);
        list.addLast(12);
        list.addAtIndex(13,0);
        list.display();
        // list.deleteAtIndex(0);
        bubbleSort(list);
        list.display();
    }
}