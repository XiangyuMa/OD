package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Main10 {
    public static void main(String[] args) {
        int[] target = {1,2};
        int n = 4;
        System.out.println(buildArray(target,n));
    }
    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        for(int i = 1;i<=n;i++){
            if( index < target.length && target[index] == i){
                ans.add("Push");
                index++;
            }else if ( index < target.length && target[index]> i){
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return  ans;
    }
}
