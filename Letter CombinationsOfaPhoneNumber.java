//https://leetcode.com/submissions/detail/151420239/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String,String> map=new HashMap<>();
    {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }
    List<String> list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()<=0){
            return list;
        }
        letterCombinations(digits,"",0);
        return list ;
    }
    public void letterCombinations(String digits,String cur,int index) {
        if(index==digits.length()){
            list.add(cur);
            return;
        }
        String val=map.get(digits.charAt(index)+"");
        for(char c:val.toCharArray()){
            letterCombinations(digits,cur+c,index+1);
        }
        
    }
}
