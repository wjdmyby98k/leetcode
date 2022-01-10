package daily_one_problem;

import java.util.HashMap;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/11/23-21:20
 */
public class leetCode1436 {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        String start = paths.get(0).get(0);
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        while (map.containsKey(start)) {
            start = map.get(start);
        }
        return start;
    }
}
