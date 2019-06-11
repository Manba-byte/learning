import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/6/10
 */
public class Demo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("c","b","a","f","e");
        //list.forEach(x -> System.out.println(x));
        //list.forEach(System.out::println);
        //list.forEach(Demo::print);

        //list.stream().sorted()将自然元素正序排序.collect(Collectors.toList());返回list
       /* List<String> collect = list.stream().sorted().collect(Collectors.toList());
        collect.forEach(System.out::println);*/

       /* list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());将自然元素逆序排序
        List<String> collect = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        collect.forEach(System.out::println);*/
       List<Student> students = Arrays.asList(
               new Student("2","B"),
               new Student("3","A"),
               new Student("1","A"),
               new Student("1","C"));
        /*List<Student> collect = students.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName)).collect(Collectors.toList());
        collect.forEach(System.out::println);*/
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                System.out.println("o1:"+o1.getAge());
                System.out.println("o2:"+o2.getAge());
                return o2.getAge().compareTo(o1.getAge());

            }
        });
        students.forEach(System.out::println);
    }

    public static void print(String a){
        System.out.println(a);
    }
}
