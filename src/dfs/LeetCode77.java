package dfs;

import java.util.*;

/**
 * dfs 经典例题
 * @description LeetCode77
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * @date: 2022/11/15 10:56
 */
public class LeetCode77 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res =  new ArrayList<>();
        if (n < k || k<=0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return  res;
    }
    public void dfs(int n,int k,int begin,Deque<Integer> path,List<List<Integer>> res){
        //递归终止条件
        if(k == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i <= n;i++){
            path.add(i);
            dfs(n,k,i+1,path,res);
            //回溯
            path.removeLast();
        }
    }
}
