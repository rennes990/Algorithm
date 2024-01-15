/**
 * ClassName: ClimbStairs
 * Description:
 *
 * @author sjystart
 * @create 2024/1/15 11:45
 */
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        int n = 3;
        System.out.println(cs.climbStairs(n));
    }

    public int climbStairs(int n) {
        //TODO 1. 找最近重复子问题，f(n) = f(n - 1) + f(n - 2)
        int i = 1, j = 2;
        int res = 0;
        if(n == 1)
            res = 1;
        if(n == 2)
            res = 2;
        for (int k = 2; k < n; k++) {
            res = i + j;
            i = j;
            j = res;
        }
        return res;
    }
}
