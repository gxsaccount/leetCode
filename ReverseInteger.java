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
    //正解
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
