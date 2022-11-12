package hw;

/**
 * //在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * //
 * // 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * //
 * // 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * //
 * // 注意:
 * //
 * //
 * // 给定 0 和 1 的数量都不会超过 100。
 * // 给定字符串数组的长度不会超过 600。
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * //输出: 4
 * //
 * //解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * //输出: 2
 * //
 * //解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 * //
 * // Related Topics 动态规划
 */
public class OneAndZero {
    public static void main(String[] args) {

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(String s:strs){
            int zeros = 0,ones= 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '1'){
                    ones++;
                }else{
                    zeros++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    int zeroLeft = i - zeros;
                    int oneLeft = j - ones;
                    /**
                     * /**
                     *       设dp[i][j]表示i个0和j个1可以最多构造多少个字符串，
                     *       则对于数组中每个字符串（含zeros个0,ones个1），当我们选择构造它时，剩下的0,1还能构造多少个字符串？
                     *       dp[i][j] = max(dp[i][j], 1 + dp[i-zeros][j-ones])
                     *
                     */
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[zeroLeft][oneLeft]);
                }
            }

        }
        return dp[m][n];

    }
}
