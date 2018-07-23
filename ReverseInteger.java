//https://leetcode.com/submissions/detail/165347213/
class ReverseInteger {
    public int reverse(int x) {
        int isNeg=1;
        long n=x;
        if(x<0){
            isNeg=-1;
            n*=-1;
        }
        char[] num =(n+"").toCharArray();
        char[] res=new char[num.length];
        for(int i=0;i<res.length;i++){
            res[i] =num[res.length-1-i];
        }
        long re = Long.parseLong(new String(res))*isNeg;
        if(re >Integer.MAX_VALUE||re<Integer.MIN_VALUE){
            return 0;
        }
        return (int) re;
    }
}
