package ArithmeticQuest;

/**
 * Created by cxx on 2017/6/13.
 */
public class Lintcode0613 {
    public static void main(String[] args) {
        int nums[] = new int[]{0, 1, 2, 0, 123, 0, 4, 6, 0, 0, 9, 1231, 345, 987, 8, 0, 6234, 0, 87, 2, 4, 0, 234};
//        nums = new int[]{-1, 2, -3, 4, 0, 1, 0, -2, 0, 0, 1};
//        nums = new int[]{-1, 2, -3, 4, 1, -2, 0, 1, 0, 0, 0,};
        nums = new int[]{0, 1};
        moveZeroes(nums);
    }

    //给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
    public static void moveZeroes(int[] nums) {
        int index0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i < nums.length - index0) {
                int temp = i;   //记录0的位置
                System.out.printf("0出现位置：" + i + " ----- ");
                for (int j = temp; j < nums.length - 1 - index0; j++) {
                    nums[j] = nums[j + 1];   //逐一交换
                    System.out.printf("交换位置：" + j + " 和 " + (j + 1));
                }
                index0++;       //记录0的个数
                System.out.printf("    当前0的个数：" + index0);
                nums[nums.length - index0] = 0;
                System.out.printf("   后驱置0位置:" + (nums.length - index0));
                System.out.println("\r\n排序后：");
                for (int x : nums)
                    System.out.print(x + "\t");
                System.out.println("  ");
                if (nums[i] == 0 && i != 0)  //如果后续把当前0位置又移成了0则重新排一次
                    i--;
            }
        }
    }

    //

}
