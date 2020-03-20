import java.util.*;
class Heap{
    ArrayList<Integer> heap = new ArrayList<>();
    public void push(int val){
        this.heap.add(val);
        upheapify();
    }

    private void upheapify(){
        int idx = this.heap.size()-1;
        while(isValid(idx)){
            int parentIdx = (idx-1)/2;
            if(this.heap.get(parentIdx)<this.heap.get(idx)){
                int temp = this.heap.get(idx);
                this.heap.set(idx , this.heap.get(parentIdx));
                this.heap.set(parentIdx , temp);
                idx = parentIdx;
            }else break;
        }
    }
    private boolean isValid(int idx){
        return (idx>=0 && idx<this.heap.size())?true:false;
    }
    public int pop(){
        if(this.heap.size()==0) throw new IndexOutOfBoundsException();
        int res = this.heap.get(0);
        this.heap.set(0,this.heap.get(this.heap.size()-1));
        this.heap.remove(this.heap.size()-1);
        heapifydown(0);
        return res;
    }

    private void heapifydown(int idx){
        int leftChild = 2*idx+1;
        int rightChild = 2*idx+2;
        int indexWithHighestValue=idx;
        if(!isValid(leftChild) && !isValid(rightChild)) return ;
        else if(isValid(leftChild) && isValid(rightChild)){
            int leftChildVal = this.heap.get(leftChild);
            int rightChildVal = this.heap.get(rightChild);
            int parentVal = this.heap.get(idx);
            if(leftChildVal>=rightChildVal && parentVal<leftChildVal){
                indexWithHighestValue = leftChild;
            }else if(rightChildVal>leftChildVal && parentVal<rightChildVal){
                indexWithHighestValue = rightChild;
            }
        }
        else if(isValid(rightChild)){
            int rightChildVal = this.heap.get(rightChild);
            int parentVal = this.heap.get(idx);
            if(parentVal<rightChild){
                indexWithHighestValue = rightChild;
            }
        }else if(isValid(leftChild)){
            int leftChildVal = this.heap.get(leftChild);
            int parentVal = this.heap.get(idx);
            if(parentVal<leftChildVal){
                indexWithHighestValue = leftChildVal;
            }
        }

        if(indexWithHighestValue==idx) return ;
        int temp = this.heap.get(idx);
        this.heap.set(idx,this.heap.get(indexWithHighestValue));
        this.heap.set(indexWithHighestValue,temp);
        heapifydown(indexWithHighestValue);           
    }

    public int peek(){
        return this.heap.get(0);
    }
    public int size(){
        return this.heap.size();
    }

    public void clear(){
        this.heap.clear();
    } 

    @Override
    public String toString(){
        if(this.size()==0){
            return "EMPTY!!!";
        }
        StringBuilder sb = new StringBuilder();
        for(int item : this.heap){
            sb.append(item+", ");
        }
        return sb.append("\n").toString();
    }
}

class main{

    static boolean test(Heap heap){
        heap.clear();
        int size =  (int) 1e5;
        Random random = new Random();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1 , Integer i2){
                return i2-i1;
            }
        });

        for(int i=0;i<size;i++){
            int randomNumber = random.nextInt(size);
            pq.add(randomNumber);
            heap.push(randomNumber);
        }
        System.out.println(heap);
        while(size-->0){
            if(pq.remove()!=heap.pop()) return false;
            size--;
        }
        return true;
    }
    public static void main(String args[]){
        Heap heap = new Heap();
        System.out.println(test(heap));
    }
}

