package hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TLV解码 {

/**
 * hw.TLV解码
 * tag 一个字节 //第一行
 * length占2个字节
 * 字节为小端序
 * 1各字节占8位 length 16位
 * 1个16进制数 占2进制多少位？ 4位 所以length 占4个数
 *  * //32 00 01 AE
 * //90 00 02 01 02
 * //30 00 03 AB 32 31
 * //31 00 02 32 33
 * //33 0 01 CC
 *  */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tag = sc.nextLine();//需要解析的tag
        String stream = sc.nextLine();//所有的tag内容
        Map<String,Inner> map = new HashMap<>();
        //分割所有码流数据，塞到map中
        String[] input = stream.split(" ");
        int idx = 0;
        while (idx < input.length){
            String tagTemp = input[idx];
            String lengthStr = input[idx+2] + input[idx+1];
            idx += 3;
            //计算内容的长度
            int length = Integer.parseInt(lengthStr,16);
            StringBuilder content = new StringBuilder();
            for (int i = idx; i < idx + length; i++) {
                if (i == idx+length -1){
                    content.append(input[i]);
                }else {
                    content.append(input[i]).append(" ");
                }
            }
            map.put(tagTemp,new Inner(length,content.toString()));
            idx += length;
        }

        Inner inner = map.get(tag);
        System.out.println(inner.content);
    }

    static class Inner{
        private int length;
        private String content;

        public Inner(int length, String content) {
            this.length = length;
            this.content = content;
        }
    }
}

