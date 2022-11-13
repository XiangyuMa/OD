package leetcode;

/**
 * leetcode 468. 验证IP地址
 */
public class LeetCode468 {
    public static void main(String[] args) {
        String str = "1.1.1.1.";
        String[] s  = str.split("\\.");

    }

    public static String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            //先验证是否是ipv4地址
            int count = 0;
            for(int i = 0;i<queryIP.length();i++){
                if(queryIP.charAt(i) =='.'){
                    count++;
                }
            }
            if(count!=3){
                return "Neither";
            }
            String[] v4 = queryIP.split("\\.");
            if (v4.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < v4.length; i++) {
                String str = v4[i];
                if (str.length() > 3 || str.length() < 1) {
                    return "Neither";
                }
                if (str.length() > 1 && str.startsWith("0")) {
                    return "Neither";
                }
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                        return "Neither";
                    }
                }
                int num = Integer.parseInt(str);
                if (num < 0 || num > 255) {
                    return "Neither";
                }

            }
            return "IPv4";
        } else {
            //验证是否是ipv6地址
            int count = 0;
            for(int i = 0;i<queryIP.length();i++){
                if(queryIP.charAt(i) ==':'){
                    count++;
                }
            }
            if(count != 7){
                return "Neither";
            }
            String regex = "^[A-Fa-f0-9]+$";
            String[] v6 = queryIP.split(":");
            if (v6.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < v6.length; i++) {

                if (v6[i].length() < 1 || v6[i].length() > 4) {
                    return "Neither";
                }
                if (!v6[i].matches(regex)) {
                    return "Neither";
                }
            }
            return "IPv6";
        }

    }

}