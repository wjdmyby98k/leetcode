package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/5-14:11
 * 自己第一次写的思路，当时没写出来
 */
public class leetCode1576_3 {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                if (i == 0) {
                    // 0的时候要考虑后面那个字符是不是?
                    if ((i + 1) < n && arr[i + 1] != '?') {
                        // 以26位周期，取后一个字符的下一位
                        arr[i] = (char) ((arr[i + 1] - 'a' + 1) % 26 + 'a');
                    } else {
                        arr[i] = 'a';
                    }
                } else if (i == n - 1) {
                    // 进入这个if 默认i已经是大于0了，且前面已全部替换完毕
//                    if (arr[i - 1] != '?') {
//                        arr[i] = (char) ((arr[i - 1] - 'a' + 1) % 26 + 'a');
//                    } else {
//                        arr[i] = 'a';
//                    }
                    arr[i] = (char) ((arr[i - 1] - 'a' + 1) % 26 + 'a');
                } else {
                    arr[i] = 'a';
                    while (arr[i] == arr[i - 1] || arr[i] == arr[i + 1]) {
                        arr[i]++;
                    }
                }
            }
        }
        return String.valueOf(arr);
    }
}
