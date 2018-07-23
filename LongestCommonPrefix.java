//https://leetcode.com/submissions/detail/165354728/
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            len=Math.min(len,strs[i].length());
        }
        if(len==Integer.MAX_VALUE) return "";
        for(int i=0;i<len;i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,len);
    }
}
