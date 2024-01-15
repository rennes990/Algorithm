/**
 * ClassName: MaxArea
 * Package: PACKAGE_NAME
 * Description:
 *
 */
public class MaxArea {
    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(ma.maxArea(height));
    }

    public int maxArea(int[] height) {
        //TODO 1. 设置left bar, right bar, 左右夹逼
        int max = 0;
        for(int i = 0, j = height.length - 1; j > i; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, minHeight * (j - i + 1));
        }
        return max;
    }
}
