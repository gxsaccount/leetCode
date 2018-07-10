
import java.util.Arrays;
/*n个骰子的各个点数的次数/概率*/
class DiceProbability {

    public int[] diceProbability(int number) {
        int[] oldRes = new int[number * 6 ];
        int[] newRes = new int[number * 6 ];

        for (int i = 0; i < number * 6 ; i++) {
            oldRes[i] = 0;
            newRes[i] = 0;
        }

        for (int i = 0; i < 6; i++) {
            oldRes[i] = 1;
        }

        for (int i = 1; i < number; i++) {
            for (int j = i; j < (i + 1) * 6; j++) {
                for (int k = 1; k <= j && k <= 6; k++) {
                    newRes[j] += oldRes[j - k];
                }
            }
            int[] temp = oldRes;
            oldRes = newRes;
            newRes = temp;
            for (int j = 0; j < newRes.length; j++) {
                newRes[j] = 0;
            }
        }
        return oldRes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiceProbability().diceProbability(3)));
    }
}
