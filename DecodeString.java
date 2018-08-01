//https://leetcode.com/problems/decode-string/description/
import java.util.*;
class Solution {
    public String decodeString(String s){
        int substart=0;
        if(s.length()==0) return "";
        if(s.charAt(substart)<'0'||s.charAt(substart)>'9'){
            return s.charAt(substart)+decodeString(s.substring(substart+1,s.length()));
        }
        while(substart<s.length()&&s.charAt(substart)>='0'&&s.charAt(substart)<='9'){
            ++substart;
        }
        int times = Integer.parseInt(s.substring(0,substart));
        int num=0;
        int i=substart;
        for(;i<s.length();i++){
            if(s.charAt(i)=='[') {
                ++num;
            }
            else if(s.charAt(i)==']'){
                --num;
            }
            if(num==0){
                break;
            }
        }
        String substring = decodeString(s.substring(substart+1, i));
        String reslut="";
        for(int j=0;j<times;j++){
            reslut+=substring;
        }
        return reslut+decodeString(s.substring(i+1));
    }
    public static void main(String[] args) {
        System.out.print(new Solution().decodeString("3[a]2[bc]"));
    }
}
