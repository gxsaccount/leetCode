/*
二进制的1个数
*/
class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberOf1(9));
    }
   public int numberOf1(int n){
       int num=n;
       int count=0;
       while(num!=0){
           ++count;
           num=num&(num-1);
       }
       return count;
   }
}
