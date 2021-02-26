/**
 * 1。 两数之和
 * <p>
 * 2020年02月26日
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Algorithm000001 {
    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了15.03% 的Java用户
     */
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        {
            int[] nums = new int[]{2, 7, 11, 15};
            int target = 9;
            System.out.println("====================NEW ONE====================");
            printlnArray("输入：", nums);
            System.out.println("target: " + target);
            printlnArray("输出：", twoSum(nums, target));
        }

        {
            int[] nums = new int[]{3, 2, 4};
            int target = 6;
            System.out.println("====================NEW ONE====================");
            printlnArray("输入：", nums);
            System.out.println("target: " + target);
            printlnArray("输出：", twoSum(nums, target));
        }

        {
            int[] nums = new int[]{3, 3};
            int target = 6;
            System.out.println("====================NEW ONE====================");
            printlnArray("输入：", nums);
            System.out.println("target: " + target);
            printlnArray("输出：", twoSum(nums, target));
        }
        {
            int[] nums = new int[]{-3, 4, 3, 90};
            int target = 0;
            System.out.println("====================NEW ONE====================");
            printlnArray("输入：", nums);
            System.out.println("target: " + target);
            printlnArray("输出：", twoSum(nums, target));
        }

    }

    private static void printlnArray(String logHead, int[] array) {
        if (array == null) {
            System.out.println(logHead + "array is null");
            return;
        }
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
