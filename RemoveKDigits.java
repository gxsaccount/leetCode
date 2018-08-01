//https://leetcode.com/problems/remove-k-digits/description/
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<0) return "0";
        if(k==num.length()) return "0";
        if(k==0) return num;
        StringBuilder sb =new StringBuilder(num);
        while(k!=0){
            for(int i=1;i<sb.length();i++){
                if(sb.charAt(i)<sb.charAt(i-1)){
                    sb.replace(i-1,i,"");
                    break;
                }
                else if(i==sb.length()-1){
                    sb.replace(sb.length()-1,sb.length(),"");
                }
            }
            --k;
        }
        int i=0;
        while(i<sb.length()&&sb.charAt(i)=='0'){
            ++i;
        }
        String re =sb.substring(i);
        return re.length()==0?"0":re;
    }
}
// class Solution {
//     public String removeKdigits(String num, int k){
//         if(num.length()<0) return "0";
//         if(k==num.length()) return "0";
//         if(k==0) return num;
//         String re =removeKdigits_(num,k);
//         int i=0;
//         while(i<re.length()&&re.charAt(i)=='0'){
//             ++i;
//         }
//         re=re.substring(i);
//         return re.length()==0?"0":re;
//     }
//     public String removeKdigits_(String num, int k) {
//         if(num.length()<0) return "";
//         if(k==num.length()) return "";
//         if(k==0) return num;
//         char max=num.charAt(0);
//         String re="";
//         if(max>num.charAt(1)){
//             re= removeKdigits_(num.substring(1),k-1);
//         } 
//         else{
//             re= num.charAt(0)+removeKdigits_(num.substring(1),k);
//         }   
//         return re;
//     }
// }
