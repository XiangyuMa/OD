package leetcode;

import java.util.*;

/**
 * leetcode 347. 前 K 个高频元素
 */

//Java 中优先队列（堆） PriorityQueue 的默认情况下是一个最小堆，如果要使用最大堆，那么在调用构造函数时就需要传入 Comparator 的实现类自定义比较排序的规则。 PriorityQueue 实现了接口 Queue，常用函数有：
//offer(e)：将元素 e 放入堆中
//poll()：删除堆顶元素
//peek()：返回位于堆顶的元素，但该元素并不出堆，还在堆中

class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
