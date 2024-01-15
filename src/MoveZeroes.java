import java.util.Arrays;

/**
 * ClassName: MoveZeroes
 * Package: PACKAGE_NAME
 * Description:
 *
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        //TODO 1. 记录非0元素下标，遍历数组，移动非0元素到对应下标，并将非0元素置0
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}


