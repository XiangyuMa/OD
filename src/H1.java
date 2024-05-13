import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2024/5/13 14:23
 */
public class H1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < str.length();i++){
            for(int j = i+1;j <= str.length();j++){
                String subStr = str.substring(i,j);
                if(isHuiwen(subStr) && subStr.length()  > 1) {
                    list.add(subStr.length());
                }
            }
        }
        Collections.sort(list);
        if(!list.isEmpty() && list.size() > 0){
            System.out.println(list.get(0));
            return;
        }
        System.out.println(-1);
        scanner.close();
    }
    public static boolean isHuiwen(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString().equals(s);
    }
}
