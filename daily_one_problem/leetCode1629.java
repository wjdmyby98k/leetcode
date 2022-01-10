package daily_one_problem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2022/1/8-15:53
 * 自己写的笨比方法，其实用不到list
 * list排序貌似用collections还是蛮方便的
 */
public class leetCode1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        List<Character> list = new LinkedList<>();
        int max = 0;
        int cur;
        for (int i = 0; i < keysPressed.length(); i++) {  //第一遍找出最大值
            if (i == 0) {
                cur = releaseTimes[0];
            } else {
                cur = releaseTimes[i] - releaseTimes[i - 1];
            }
            max = Math.max(cur, max);
        }
        for (int i = 0; i < keysPressed.length(); i++) {  // 第二遍找出最大值对应的字符，并存入list
            if (i == 0) {
                cur = releaseTimes[0];
            } else {
                cur = releaseTimes[i] - releaseTimes[i - 1];
            }
            if (cur == max) {
                list.add(keysPressed.charAt(i));
            }
        }
        Collections.sort(list);  // list自然排序，返回最后一个
        return list.get(list.size() - 1);
    }
}
