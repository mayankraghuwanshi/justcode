import java.util.*;
class main{
    static long subSequence(String s , StringBuilder sb , int idx , Set<String> set , int size){
        if(idx==s.length()){
            if(sb.length()==size){
                if(set.contains(sb.toString())){
                    return 1;
                }
                set.add(sb.toString());
                return 0;
            }
            return 0;
        }
        if(sb.length()==size){
            if(set.contains(sb.toString())){
                return 1;
            }
            set.add(sb.toString());
            return 0;
        }
        int count=0;
        count+=subSequence(s, sb.append(s.charAt(idx)), idx+1, set,size);
        sb.deleteCharAt(sb.length()-1);
        return count+subSequence(s, sb, idx+1, set,size);

    }
    static long subSequence(String s , StringBuilder sb , int idx , Set<String> set ){
        if(idx==s.length()){
            if(set.contains(sb.toString())){
                return 1;
            }
            set.add(sb.toString());
            return 0;
        }
        int count=0;
        count+=subSequence(s, sb.append(s.charAt(idx)), idx+1, set);
        sb.deleteCharAt(sb.length()-1);
        return count+subSequence(s, sb, idx+1, set);

    }

   
   public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       StringBuilder res  = new StringBuilder();
       for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
           int n = Integer.parseInt(scn.hasNext()?scn.next():"0");
           String s = scn.hasNext()?scn.next():"0";
           Set<String> set = new HashSet<>();
           res.append(subSequence(s, new StringBuilder(), 0, set)+"\n");
           System.out.println(set);
       }
       System.out.println(res); 
   }
}