package nothing;

/**
 * 题目4:数字判断
 * description:判断一个字符串是否是合法的十进制或者十六进制数
 * date:2022/7/31
 * time:12:31
 * author:马翔宇
 */
public class GrapeCity {
    public static void main(String[] args) {

        GrapeCity demo = new GrapeCity();
        String s = "1.23E+10";
        System.out.println(demo.isDecimalOrHexadecimal(s));
    }

    /**
     * 判断一个字符串是否是合法的10进制或者16进制数
     * @param input 给定字符串
     * @return 返回结果true或者false
     */
    public boolean isDecimalOrHexadecimal(String input){
        return isDecimal(input) || isHex(input);
    }

    /**
     * 判断给定字符串是否是合法的10进制数
     * @param input 给定字符串
     * @return 返回结果true或者false
     */
    public boolean isDecimal(String input){
        String s = input.trim();
        if(".".equals(s) || "".equals(s)){
            return false;
        }
        boolean finish = false;
        boolean existNum = false;
        int step = 0;
        for(int i = 0;i < s.length();i++){
            finish = false;

            //判断符号位是否合法
            if(step == 0){
                if(i == 0 && (s.charAt(i) == '+'|| s.charAt(i) =='-')){
                    step = 1;
                    continue;
                }else if(i == 0 && (s.charAt(i) >='0' && s.charAt(i)<='9')){
                    existNum = true;
                    finish = true;
                    step = 1;
                    continue;
                }else if(s.charAt(i)=='.'){
                    finish = true;
                    step = 2;
                    continue;
                }else {
                    return false;
                }
            }

            //判断整数位是否合法
            if(step == 1){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    existNum = true;
                    finish = true;
                    continue;
                }else if(s.charAt(i)=='.'){
                    finish = true;
                    step = 2;
                    continue;
                }else if(s.charAt(i) =='e' || s.charAt(i)=='E'){
                    step =3;
                    continue;
                }else {
                    return false;
                }
            }

            //判断小数位是否合法
            if(step == 2){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    existNum = true;
                    finish = true;
                    continue;
                } else if (s.charAt(i) == 'e' || s.charAt(i)=='E') {
                    step = 3;
                    continue;
                }else {
                    return false;
                }
            }

            //判断指数符号位是否合法
            if(step == 3){
                if(s.charAt(i)=='+' || s.charAt(i)=='-'){
                    step = 4;
                    continue;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    finish = true;
                    step = 4;
                    continue;
                }else {
                    return false;
                }
            }

            //判断指数位是否合法
            if(step == 4){
                 if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                     finish = true;
                     continue;
                 }else {
                     return false;
                 }
            }
        }
        if(finish && existNum){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断字符串是否是合法的16进制数
     * @param input 给定字符串
     * @return 返回结果true或者false
     */
    public boolean isHex(String input) {
        String s = input.trim();
        if (".".equals(s) || "".equals(s)) {
            return false;
        }
        boolean finish = false;
        boolean existNum = false;
        int step = 0;
        for (int i = 0; i < s.length(); i++) {
            finish = false;
            //判断符号位是否合法
            if (step == 0) {
                if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                    step = 1;
                    continue;
                } else if (i == 0 && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'F'))) {
                    existNum = true;
                    finish = true;
                    step = 1;
                    continue;
                } else if (s.charAt(i) == '.') {
                    finish = true;
                    step = 2;
                    continue;
                } else {
                    return false;
                }
            }

            //判断整数位是否合法
            if (step == 1) {
                if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'F')) {
                    existNum = true;
                    finish = true;
                    continue;
                } else if (s.charAt(i) == '.') {
                    finish = true;
                    step = 2;
                    continue;
                } else {
                    return false;
                }
            }

            //判断小数位是否合法
            if (step == 2) {
                if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'F')) {
                    existNum = true;
                    finish = true;
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (finish && existNum) {
            return true;
        } else {
            return false;
        }
    }
}
