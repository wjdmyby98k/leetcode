package backtracking;

import org.junit.Test;

import java.util.*;

/**
 * @author：THIEM
 * @create:2021/10/4-14:44
 * [["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],
 * ["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
 * carl回溯思路，太难了。。。
 */
public class leetCode332 {
    @Test
    public void Test1(){
        List<List<String>> tickets = new ArrayList<>();
        String[][] s000=new String[][]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},
                {"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        String[][] s001=new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"ATL","JFK"},{"ATL","SFO"},{"SFO","ATL"}};
        for (int i = 0; i < s001.length; i++) {
            List<String> tmp = new ArrayList<>();
            tmp.add(s001[i][0]);
            tmp.add(s001[i][1]);
            tickets.add(tmp);
        }
        findItinerary(tickets);
    }




    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();//刚开始res就只有一个起点，每次都要取res最后一个元素，当做下轮机票的起点
        if(map.containsKey(last)){//防止出现null
            //把当前取的起点机场对应的终点map取出来，实际上就是一个entrySet,然后遍历每个entry
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        // 构建映射关系，如果存在多个终点，对终点的map的键要排序！
        //map格式<起点，map<终点，次数>>
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();
                //升序Map,这里之所以要用升序，是为了后序存在多个起始位置的时候，
                // 对终点进行排序！！！因为上面又取出来了
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
//        System.out.println(map);
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
}











