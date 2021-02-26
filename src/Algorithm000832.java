import java.util.Random;

/**
 * 832. 翻转图像
 * <p>
 * 2020年02月24日
 * <p>
 * https://leetcode-cn.com/problems/flipping-an-image/
 * <p>
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1：
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * 示例 2：
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
class Algorithm000832 {
    /**
     * 解法
     */
    private static int[][] flipAndInvertImage(int[][] A) {
        //数组为空
        if (A == null || A.length == 0) {
            return A;
        }
        //遍历每一行
        for (int[] row : A) {
            //得到单个行
            //每行最后一位的index
            int lastRowIndex = row.length - 1;
            //i 每行交换的前位index
            for (int i = 0; ; i++) {
                //每行交换的后位index
                int switchIndex = lastRowIndex - i;
                //如果前位等于后卫，那么交换结束，且值反转
                if (i == switchIndex) {
                    row[i] = row[i] ^ 1;
                    break;
                }
                //如果前位大于后卫，那么交换结束
                if (i > switchIndex) {
                    break;
                }
                //将前位和后位交换
                int holder = row[i];
                row[i] = row[switchIndex];
                row[switchIndex] = holder;
                //反转
                row[i] = row[i] ^ 1;
                row[switchIndex] = row[switchIndex] ^ 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        {
            int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
            System.out.println("\n======================NEW ONE======================");
            printlnArray("输入：", A);
            printlnArray("输出：", flipAndInvertImage(A));
        }

        final int testTimes = 10;
        for (int i = 0; i < testTimes; i++) {
            System.out.println("\n======================NEW ONE======================");
            int[][] A = randomTwoDimensionalArrayCreator();
            printlnArray("输入：", A);
            printlnArray("输出：", flipAndInvertImage(A));
        }
    }

    /**
     * 生成随机二位数组
     */
    private static int[][] randomTwoDimensionalArrayCreator() {
        Random r = new Random();
        int column = r.nextInt(20);
        int row = r.nextInt(20);
        int[][] A = new int[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                A[i][j] = r.nextInt(2);
            }
        }
        return A;
    }

    /**
     * 打印数组
     */
    private static void printlnArray(String logHead, int[][] output) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < output.length; i++) {
            if (i == 0) {
                stringBuilder.append("[");
            } else {
                stringBuilder.append(",");
            }
            for (int j = 0; j < output[i].length; j++) {
                if (j == 0) {
                    stringBuilder.append("[");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append(output[i][j]);
                if (j == output[i].length - 1) {
                    stringBuilder.append("]");
                }
            }
            if (i == output.length - 1) {
                stringBuilder.append("]");
            }
        }
        System.out.println(logHead + stringBuilder.toString());
    }
}