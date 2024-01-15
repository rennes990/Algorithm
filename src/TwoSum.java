import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName: TwoSum
 * Package: PACKAGE_NAME
 * Description: 力扣两数之和
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        //TODO 1. 将数组数据存入哈希表，key为数据，value为数组下标
        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
        //TODO 2. 遍历数组，获取target对应差值，并在哈希表中查找key，若存在，输出索引数组
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

