package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/5 13:21
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        String word = scanner.nextLine();
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < word.length();i++){
            list.add(word.charAt(i));
        }
        int count = 0;
        for(int i = 0;i< content.length()-word.length();){
            for(int j =  i+list.size();j < content.length();j++){
                String temp = content.substring(i,j);
                if(exists(temp,list)){
                    i ++;
                    count++;
                }else {
                    i++;
                }

            }

        }
        System.out.println(count);
        scanner.close();
    }
    public static boolean exists(String s, List<Character> list){
         List<Character> temp = new ArrayList<>();
         for(int i = 0;i < s.length();i++){
             temp.add(s.charAt(i));
         }
        Collections.sort(temp);
        Collections.sort(list);
        for(int i = 0;i < s.length();i++){
           if(temp.get(i) != list.get(i)){
               return false;
           }
        }
        return true;
    }
}
