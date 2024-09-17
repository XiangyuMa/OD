package test;

/**
 * @author :马翔宇
 * 招商银行机考编程题一
 * @description:通过反射实现给定参数的加减乘除
 * 只需熟悉反射的固定写法就行
 * @date: 2024/9/17 18:13
 */

import java.lang.reflect.Method;

class Solution {
    public static void main(String[] args) {
        Solution s  = new Solution();
        try {
            System.out.println(s.solution("add",10,20));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 实现此方法核心逻辑
     * @param methodName
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    public int solution(String methodName, int a, int b) throws Exception {
        try{
            Class<?> targetClass = Calculator.class;
            Method[] methods = targetClass.getDeclaredMethods();
            for(Method method:methods){
                if(method.getName().equals(methodName)){
                    return (Integer) method.invoke(null,a,b);
                }
            }
        }catch(Exception exception){
            throw new NoSuchMethodException();
        }
        return 0;
    }
}

/**
 * 题目中提供的
 */
class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }
}
