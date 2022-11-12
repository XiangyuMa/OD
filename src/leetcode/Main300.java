package leetcode;

/**
 * leetcode 686. 重复叠加字符串匹配
 */
public class Main300 {
    public static void main(String[] args) {

    }
    public int repeatedStringMatch(String a, String b) {
        int m = a.length(), n = b.length();
        //利用StringBuilder操作字符串效率最高
        StringBuilder s = new StringBuilder();
        int result = 0;
        //进行遍历
        for(int i = m;i <= 2*m+n;i += m){
            //每次重复叠加
            s.append(a);
            //结果+1
            result++;
            //如果当前存在子字符串其下表位置
            if(s.indexOf(b) != -1){
                //就返回值
                return result;
            }
        }
        //反之没有找到
        return -1;
    }

}
