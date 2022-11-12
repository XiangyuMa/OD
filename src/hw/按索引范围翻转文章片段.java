package hw;

import java.util.Scanner;

public class 按索引范围翻转文章片段 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num0 = sc.nextInt();;
        int num1 = sc.nextInt();


        System.out.println(reverseWords(input, num0, num1));
    }
    private static String reverseWords(String str,int start,int end){


            String[] content = str.split(" ");
            if(content.length ==1){
                return "EMPTY";
            }
            while (start < end){
                String temp = "";
                temp = content[end];
                content[end] = content[start];
                content[start] = temp;
                start++;
                end--;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < content.length; i++) {
                sb.append(content[i]);
                if (i+1 < content.length){
                    sb.append(" ");
                }
            }
            return sb.toString();
        }


}

