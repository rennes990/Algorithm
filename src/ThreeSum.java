import java.util.*;

/**
 * ClassName: ThreeSum
 * Package: PACKAGE_NAME
 * Description:
 *
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> result = ts.threeSum2(nums);
        System.out.println(result.toString());
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        //TODO 1. 三重循环暴力求解
        if(nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums); //需要排序，这样HashSet才能够识别相同的元素并去重
        //TODO 1. 把问题看成有条件的查找，则可以考虑采用HashMap，类比两数之和，key为数据，value为数组下标
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j]) && map.get(target - nums[j]) != j) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[map.get(target - nums[j])])));
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        //TODO 1. 排序后双指针左右夹逼
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if(sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
