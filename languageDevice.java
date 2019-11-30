import java.util.*;
import java.io.*;
class main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] LanguageDevice = new String[26];
         for(int i_LanguageDevice=0; i_LanguageDevice<26; i_LanguageDevice++)
         {
         	LanguageDevice[i_LanguageDevice] = br.readLine();
         }

         int out_ = CountPossibleStrings(LanguageDevice, N);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int subSet(String s,String res , int idx , String [] arr){
        if(idx==s.length()){
            if(res.length()>0 &&  isValid(res , arr)) return 1;
            return 0;
        }
        int count=0;
        char ch = s.charAt(idx);
        count+=subSet(s, res+ch, idx+1,arr);
        return count + subSet(s, res, idx+1,arr);
    }
    static Set<String> set = new HashSet<>();
    static boolean isValid(String s , String [] arr){
        if(set.contains(s)){
            return false;
        }
        if(s.length()==1) return true;
        for(int i=1;i<s.length();i++){
            char ch1=s.charAt(i-1);
            char ch2=s.charAt(i);
            if(arr[ch1-65].charAt(ch2-65)!='1'){
                return false;
            }
        }
        set.add(s);
        System.out.println(s);
        return true;
    }

    static int CountPossibleStrings(String[] str, int N){
        int count=0;
        for(int i=0;i<str.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<str[i].length();j++){
                if(str[i].charAt(j)-'0'==1){
                   char ch = (char)(j+65);
                   sb.append(ch);
                }
            }
            if(sb.length()>0){
                int temp=subSet(sb.toString(), "", 0, str);
                // System.out.println(sb+"\t"+temp);
                count=(count+temp)%1000000007;
            }
        }
        return count;

    }
}
