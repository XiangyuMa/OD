import java.util.ArrayList;

// 演示 ArrayList 扩容
public class ArrayListResizeDemo {
    public static void main(String[] args) {
        // 无参构造，初始容量为 10
        ArrayList<String> list = new ArrayList<>();

        // 查看初始容量（通过反射，仅供学习）
        System.out.println("初始容量: 10（懒加载，添加元素时才创建数组）");

        // 添加第 1-10 个元素，不需要扩容
        for (int i = 1; i <= 10; i++) {
            list.add("element" + i);
            System.out.println("添加第 " + i + " 个元素，当前容量: " + getCapacity(list));
        }

        // 添加第 11 个元素，触发扩容
        list.add("element11");
        System.out.println("添加第 11 个元素后，容量: " + getCapacity(list));
        // 输出: 15（新容量 = 旧容量 + 旧容量 >> 1 = 10 + 5 = 15）

        // 继续添加，容量 15 满后再次扩容
        for (int i = 12; i <= 15; i++) {
            list.add("element" + i);
        }
        System.out.println("添加第 15 个元素后，容量: " + getCapacity(list));

        list.add("element16");
        System.out.println("添加第 16 个元素后，容量: " + getCapacity(list));


        // 输出: 22（15 + 15>>1 = 15 + 7 = 22）


        System.out.println(8>>1);
    }

    // 反射获取容量（仅供学习）
    private static int getCapacity(ArrayList<?> list) {
        try {
            java.lang.reflect.Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(list);
            return elementData.length;
        } catch (Exception e) {
            return -1;
        }
    }
}