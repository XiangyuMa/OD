package lock;



/**
 * @author :马翔宇
 * @description
 * @date: 2023/10/10 17:05
 */
public class Number {
 public static synchronized void getOne(){
     try {
         Thread.sleep(3000);
     }catch (InterruptedException e){

     }
     System.out.println("one");
 }
    public static synchronized void getTwo(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){

        }
        System.out.println("two");
    }
    public void  getThree(){
        System.out.println("three");
    }
}
