import java.util.LinkedList;
class main{
    static public class Map{
        private static final int SIZE = 100;
        private HashEntry table[] = new HashEntry[SIZE];

        public void put(String key , String val){
            int hash = this.generateHash(key);
            HashEntry newHashEntry = new HashEntry(hash,key,val);
            if(this.table[hash]==null){
                this.table[hash] = newHashEntry;
            }else{
                HashEntry temp = table[hash];
                while(temp!=null){
                    if(temp.key == key){
                        temp.val=val;
                        return;
                    }
                    temp = temp.next;
                }
                temp = newHashEntry;
            }
        }
        
        private int generateHash(String key){
            int val = 0;
            for(int i=0;i<key.length();i++){
                val+=(int)key.charAt(i);
                val%=this.SIZE;
            }
            return val;
        }

        public boolean containsKey(String key){
            int hash = this.generateHash(key);
            HashEntry temp = this.table[hash];
            while(temp!=null){
                if(temp.key==key){
                    return true;
                }
            }
            return false;
        }

        public boolean containsValue(String val){
            for(HashEntry entry : this.table){
                while(entry!=null){
                    if(entry.val==val){
                        return true;
                    }
                }
            }
            return false;
        }

        public String get(String key){
            int hash = this.generateHash(key);
            HashEntry temp = this.table[hash];
            while(temp!=null){
                if(temp.key==key){
                    return temp.val;
                }
                temp=temp.next;
            }
            return null;
        }

        @Override
        public String toString(){
            String res="";
            for(HashEntry Entry : this.table){
                if(Entry!=null){
                    while(Entry!=null){
                        res+="("+Entry.key+" : "+Entry.val+"),";
                        Entry = Entry.next;
                    }
                    res+="\n";
                }
            }
            return res;
        }

    }
    static public class HashEntry{
        int hash;
        String key;
        String val;
        HashEntry next;
        
        HashEntry(int hash,String key , String val){
            this.hash=hash;
            this.key=key;
            this.val=val;
            this.next=null;
        }

        @Override
        public String toString(){
            String res = "";
            res+=this.key+" "+this.val;
            return res;
        }

    }

    public static void main(String args[]){
        Map map = new Map();
        map.put("me","mauank");
        System.out.println(map);
        

    }
}