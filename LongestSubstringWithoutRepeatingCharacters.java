//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> sub=new HashMap<>();
        int max=0,start=0,end=0;
        for(end=0;end<s.length();end++){
            char c=s.charAt(end);
            if(sub.containsKey(c)){
                start=Math.max(start,sub.get(c)+1);
            }
            sub.put(c,end);
            max=Math.max(end-start+1,max);
        }
        return max;
    }
    //将hashmap成数组，更快
    public int lengthOfLongestSubstring1(String s) {
        int[] sub=new int[256];
        int max=0,start=0,end=0;
        for(end=0;end<s.length();end++){
            int c=s.charAt(end);
            if(sub[c]!=0){
                start=Math.max(start,sub[c]);
            }
            sub[c]=end+1;
            max=Math.max(end-start+1,max);
        }
        return max;
    }
    
}
