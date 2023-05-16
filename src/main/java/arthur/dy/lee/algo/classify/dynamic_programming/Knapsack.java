package arthur.dy.lee.classify.dynamic_programming;

import cn.hutool.json.JSONUtil;

/**
 * 背包问题：
 * <p>
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 * <p>
 * https://time.geekbang.org/column/article/74788?screen=full
 */
public class Knapsack {

    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private int   maxW   = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = { 2, 2, 4, 6, 3 };  // 物品重量
    private int[] value  = { 3, 4, 8, 9, 6 }; // 物品的价值
    private int   n      = 5; // 物品个数
    private int   w      = 9; // 背包承受的最大重量

    /**
     * 背包回溯解法：最大重量
     *
     * @param i
     * @param cw
     */
    public void backtrack_weight(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW)
                maxW = cw;
            return;
        }
        backtrack_weight(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            backtrack_weight(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }

    /**
     * 背包回溯解法：最大价值
     * 在递归树中，有几个节点的i和cw是完全相同的，比如f(2,2,4)和f(2,2,3)。在背包中物品总重量一样的情况下，f(2,2,4)这种状态对应的物品总价值更大，
     * 我们可以舍弃f(2,2,3)这种状态，只需要沿着f(2,2,4)这条决策路线继续往下决策就可以。也就是说，对于(i, cw)相同的不同状态，
     * 那我们只需要保留cv值最大的那个，继续递归处理，其他状态不予考虑。思路说完了，但是代码如何实现呢？如果用回溯算法，这个问题就没法再用“备忘录”解决了。
     * 所以，我们就需要换一种思路，看看动态规划是不是更容易解决这个问题？
     *
     * @param i
     * @param cw
     * @param cv
     */
    public void backtrack_value(int i, int cw, int cv) { // 调用f(0, 0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cv > maxW)
                maxW = cv;
            return;
        }
        backtrack_value(i + 1, cw, cv); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            backtrack_value(i + 1, cw + weight[i], cv + value[i]); // 选择装第i个物品
        }
    }

    /**
     * 动态规划：最大重量（二维数组实现）
     * weight:物品重量，n:物品个数，w:背包可承载重量
     *
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j] == true)
                    states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true)
                    states[i][j + weight[i]] = true;
            }
        }
        System.out.println(JSONUtil.toJsonStr(states));
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i] == true)
                return i;
        }
        return 0;
    }

    /**
     * 动态规划：最大重量（一维数组实现）
     * weight:物品重量，n:物品个数，w:背包可承载重量
     *
     * 实际上，我们只需要一个大小为w+1的一维数组就可以解决这个问题。动态规划状态转移的过程，都可以基于这个一维数组来操作。
     *
     * @param items
     * @param n
     * @param w
     * @return
     */
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j] == true)
                    states[j + items[i]] = true;
                if (states[9] == true) {
                    System.out.println("i=" + i + ",item[i]=" + items[i]);
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true)
                return i;
        }
        return 0;
    }

    /**
     * 动态规划解法：最大价值
     *
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0)
                    states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue)
                maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }

    public static void main(String[] args) {
        int[] weight = new int[] { 2, 2, 4, 6, 3 };
        int n = weight.length;
        int w = 9;
        System.out.println(Knapsack.knapsack2(weight, n, w));
    }
}
