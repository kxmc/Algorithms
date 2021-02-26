/**
 * 1052. 爱生气的书店老板
 * <p>
 * 2020年02月23日
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 */
class Algorithm001052 {

    /**
     * 解法1
     *
     * @param customers 每分钟的顾客数
     * @param grumpy    生气记录(1表示生气，0表示不生气)
     * @param X         连续不生气次数
     */
    private static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int maxSatisfied = 0;
        if (customers.length == 0) {
            return maxSatisfied;
        }
        if (X == 0) {
            for (int i = 0; i < customers.length; i++) {
                maxSatisfied += customers[i] * (grumpy[i] == 1 ? 0 : 1);
            }
            return maxSatisfied;
        }
        if (customers.length <= X) {
            for (int customer : customers) {
                maxSatisfied += customer;
            }
            return maxSatisfied;
        }
        //计算出所有可能性下的值
        int moveTime = customers.length - X + 1;
        int[] maxValues = new int[moveTime];
        for (int times = 0; times < moveTime; times++) {
            //每一种新的可能性之前都清空上次值
            maxSatisfied = 0;
            for (int i = 0; i < customers.length; i++) {
                //当前分钟是否 没有生气
                boolean notAngry = (i >= times && i < times + X) || grumpy[i] == 0;
                //求和
                maxSatisfied += customers[i] * (notAngry ? 1 : 0);
            }
            maxValues[times] = maxSatisfied;
        }
        //比较出所有可能性下的最大值
        maxSatisfied = 0;
        for (int item : maxValues) {
            if (item > maxSatisfied) {
                maxSatisfied = item;
            }
        }
        return maxSatisfied;
    }

    /**
     * 解法2
     *
     * @param customers 每分钟的顾客数
     * @param grumpy    生气记录(1表示生气，0表示不生气)
     * @param X         连续不生气次数
     */
    private static int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int maxSatisfied = 0;
        //先把所有不生气的加起来
        for (int i = 0; i < customers.length; i++) {
            maxSatisfied += customers[i] * (grumpy[i] == 1 ? 0 : 1);
        }
        //所有小段中连续不生气，多出来的客户数的最大值
        int moreMax = 0;
        //当前一小段的起始位置
        int singleStart = 0;
        while (singleStart + X <= customers.length) {
            //此段连续不生气，多出来的客户数的值
            int singleMore = 0;
            for (int i = 0; i < X; i++) {
                //当前分钟是否 没有生气
                singleMore += customers[singleStart + i] * (grumpy[singleStart + i] == 1 ? 1 : 0);
            }
            System.out.println("singleMore ：" + singleMore);
            if (moreMax < singleMore) {
                moreMax = singleMore;
            }
            singleStart++;
        }
        return maxSatisfied + moreMax;
    }

    public static void main(String[] args) {
        int[] customerArray = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpyArray = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        //
        Algorithm001052.printlnArray(customerArray, "customers ：");
        Algorithm001052.printlnArray(grumpyArray, "grumpy    ：");
        System.out.println("x ：" + x);
        System.out.println("最大值（保证正确）：" + Algorithm001052.maxSatisfied(customerArray, grumpyArray, x));
        System.out.println("最大值（当前测试）：" + Algorithm001052.maxSatisfied2(customerArray, grumpyArray, x));
        System.out.println("----------");
    }

    private static void printlnArray(int[] array, String logHead) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                stringBuilder.append("[");
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(array[i]);
            if (i == array.length - 1) {
                stringBuilder.append("]");
            }
        }
        System.out.println(logHead + stringBuilder.toString());
    }
}