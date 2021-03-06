package practiceofswordtooffer.question60;

import org.junit.Test;

import java.text.DecimalFormat;

public class Solution {
    /*
     * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能出现的概率
     */
    public void printProbability(int number) {
        if (number < 1) {
            return;
        }

        //骰子能够产生的最大数字
        int maxValue = 6;
        int[][] probabilities = new int[2][];
        // 数组长度为maxValue * number + 1是为了放下maxValue * number这个数字
        probabilities[0] = new int[maxValue * number + 1];
        probabilities[1] = new int[maxValue * number + 1];

        int  flag = 0;

        for (int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }

        // 为什么初始化k为2呢，因为上面的只有一个骰子的情况已经说明了
        for (int k = 2; k <= number; k++) {
            // 数值范围内的求值
            for (int i = number; i <= maxValue * k; ++i) {
                // 获取每个数值的可能性
                for (int j = 1; j <= i && j <= maxValue; ++j) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            // 切换数组
            flag = 1 - flag;

        }

        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i);
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.println(df.format(ratio));
        }

    }

    @Test
    public void test() {
        printProbability(2);
    }

}
