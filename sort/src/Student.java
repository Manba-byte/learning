/**
 * @author wh
 * @description
 * @date 2019/6/10
 */
public class Student {
    private String age;
    private String name;

    public Student(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
