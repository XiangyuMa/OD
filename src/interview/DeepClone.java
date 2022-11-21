package interview;
/**
 * 深拷贝： 拷贝所有的属性，将对象引用的所有对象全部拷贝一次
 * 相比于浅拷贝速度较慢且花销较大
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher2 teacher = new Teacher2();
        teacher.setName("lisi");
        teacher.setAge(21);

        Student3 student1 = new Student3();
        student1.setName("zhangsan");
        student1.setAge(16);
        student1.setTeacher(teacher);

        Student3 student2 = (Student3) student1.clone();
        System.out.println("拷贝后");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());

        System.out.println("修改老师信息-------------");
        // 修改老师的信息
        teacher.setName("wangmazi");
        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());
    }
}

class Teacher2 implements Cloneable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student3 implements Cloneable {
    private String name;
    private int age;
    private Teacher2 teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher2 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher2 teacher) {
        this.teacher = teacher;
    }

    public Object clone() throws CloneNotSupportedException {
        // 浅拷贝时：
        // Object object = super.clone();
        // return object;

        // 改为深拷贝：
        Student3 student = (Student3) super.clone();
        // 本来是浅拷贝，现在将Teacher对象复制一份并重新set进来
        student.setTeacher((Teacher2) student.getTeacher().clone());
        return student;
    }
}
