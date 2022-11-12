package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :马翔宇
 * @description
 * @date: 2022/11/4 12:03
 */
public class 正方形数量 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = Integer.parseInt(sc.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextLine());
            }
            int count = 0;
            if (num <= 3) {
                System.out.println(count);
                return;
            }
            for (int i = 0; i<list.size(); i++) {
                String str = list.get(i);
                String[] split = str.split(" ");
                int x1 = Integer.parseInt(split[0]);
                int y1 = Integer.parseInt(split[1]);
                for (int j = i + 1; j<list.size(); j++) {
                    String str1 = list.get(j);
                    String[] split1 = str1.split(" ");
                    int x2 = Integer.parseInt(split1[0]);
                    int y2 = Integer.parseInt(split1[1]);

                    /**
                     * 已知：正方形的两个点 (x1,y1)  (x2,y2)
                     *                     则：正方形另外两个点的坐标为
                     *                             x3=x1+(y1-y2)   y3= y1-(x1-x2)
                     *                     x4=x2+(y1-y2)   y4= y2-(x1-x2)
                     *                     或
                     *                             x3=x1-(y1-y2)   y3= y1+(x1-x2)
                     *                     x4=x2-(y1-y2)   y4= y2+(x1-x2)
                     */


                    int x31 = x1 - (y1-y2);
                    int y31 = y1 + (x1-x2);
                    int x41 = x2 - (y1-y2);
                    int y41 = y2 + (x1-x2);

                    int x32 = x1 + (y1-y2);
                    int y32 = y1 - (x1-x2);
                    int x42 = x2 + (y1-y2);
                    int y42 = y2 - (x1-x2);

                    if (list.contains(x31 + " " + y31) && list.contains(x41 + " " + y41)) {
                        count++;
                    }
                    if (list.contains(x32 + " " + y32) && list.contains(x42 + " " + y42)) {
                        count++;
                    }
                }
            }
            System.out.println(count / 4);
        }



}
