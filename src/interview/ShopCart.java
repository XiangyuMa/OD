package interview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2023/9/23 11:39
 */
public class ShopCart {
    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        String promotion = scanner.nextLine();
        String[] detail = promotion.split("\\|");
        String date = detail[0];
        String discount = detail[1];
        String product = detail[2];
        String list = scanner.nextLine();
        String[] part1 = list.split(":");
        BigDecimal price = new BigDecimal(part1[1]);
        String[] part2 = part1[0].split("\\*");
        int count = Integer.valueOf(part2[0]);
        String desc = part2[1];
//        List<Product> productList = new ArrayList<>();
        BigDecimal sum = new BigDecimal(0);
        switch (product) {
            case "酒类":
                WineProduct.discount = Float.valueOf(discount);
//                WineProduct wineProduct = new WineProduct(count,price,desc);
                sum = price.multiply(new BigDecimal(count));
                sum = sum.multiply(new BigDecimal(WineProduct.discount));
                break;
            //todo
        }
        sum = sum.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(sum);*/
        System.out.println(StringChallenge2("anna"));

    }
    public static String StringChallenge(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0;i < sb.length();i++){
            if(!Character.isLetter(str.charAt(i))){
               sb.replace(i,i+1," ");
            }
        }
        String[] arr = sb.toString().split(" ");
        for(int i =0;i < arr.length;i++){
//            arr[i] = convert(arr[i]);
        }
        String first = arr[0].charAt(0) + "";
        first = first.toLowerCase();

        String last = arr[0].substring(1);
        String result = first + last;
        for(int i =1;i < arr.length;i++){
            result += arr[i];
        }
        return result;
    }


    /**
     * 实现判断一个字符串能不能构成回文字符串只允许交换一次相邻的字符
     * @param str
     * @return
     */
    public static String StringChallenge2(String str) {
        StringBuilder sb = new StringBuilder(str);
        if(sb.length()<= 1){
            return sb.toString();
        }
        int mid = sb.length() / 2;
        if(sb.length()%2 == 0){
            mid = mid - 1;
        }
        boolean flag = false;
        int i = 0,j = sb.length()-1;
        while (i<= mid && j > mid) {
            if (sb.charAt(i) != sb.charAt(j)) {
                if (flag == true) {
                    return "-1";
                }
                if (sb.charAt(i + 1) == sb.charAt(j)) {
                    flag = true;
                    char c = sb.charAt(i);
                    sb = sb.replace(i, i + 1, sb.charAt(i + 1) + "");
                    sb = sb.replace(i+1, i + 2, c + "");

                } else if (sb.charAt(i) == sb.charAt(j - 1)) {
                    flag = true;
                    char c = sb.charAt(j-1);
                    sb = sb.replace(j - 1, j, sb.charAt(j) + "");
                    sb = sb.replace(j, j+1, c + "");

                }
            }
            i++;
            j--;
        }
        return sb.toString();
    }
}
