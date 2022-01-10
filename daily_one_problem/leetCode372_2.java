package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/13-21:03 三叶快速幂
 */
public class leetCode372_2 {
    int MOD = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
    }

    // 下面的解法参考快速幂计算，这是迭代写法，递归写法可能更好理解，区别就是在快速幂的基础上，每一步都加了一个取模操作。
    int qpow(int a, int b) { //计算a的b次幂  %  1337
        int ans = 1;
        a %= MOD;  // 先取模对结果没影响，而且可以防止a*a溢出
        while (b != 0) {
            if ((b & 1) != 0) ans = ans * a % MOD;   //看b是不是奇数
            a = a * a % MOD;
            b >>= 1; //  b/2
        }
        return ans;
    }

}
