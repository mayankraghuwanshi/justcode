import java.util.*;
class main{
    static int subSeq(String s , StringBuilder res){
        if(s.length()==0) {
            // return 1;
            System.out.println(res);
            return 1;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            count+=subSeq(s.substring(1), res);
            count+=subSeq(s.substring(1), res.append(ch));
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "anxa";
        subSeq(str, new StringBuilder());
    }
}