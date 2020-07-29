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
    
    /**
	 * pda 货位排序
	 * @param pcdvList List<PdaChangePickingDetailsDTO>
	 * @return List<PdaChangePickingDetailsDTO>
	 */
	private List<PdaChangePickingDetailsDTO> sort(List<PdaChangePickingDetailsDTO> pcdvList){
		//获取货位编码规则
		//库区编码(楼层)【正序】/货列【正序】/货架根据货列奇【正序】偶【逆序】/货位(层 逆序) (格 正序)
		List<PdaChangePickingDetailsDTO> collect = pcdvList.stream().sorted(
				Comparator.comparing(PdaChangePickingDetailsDTO::getAreaFloor)
				.thenComparing(new Comparator<PdaChangePickingDetailsDTO>() {
					@Override
					public int compare(PdaChangePickingDetailsDTO o1, PdaChangePickingDetailsDTO o2) {
                        Integer o1Int = Integer.valueOf(o1.getRowCode().substring(o1.getAreaCode().length()));
						Integer O2Int = Integer.valueOf(o2.getRowCode().substring(o2.getAreaCode().length()));
						return o1Int.compareTo(O2Int);
					}
				})
				.thenComparing(new Comparator<PdaChangePickingDetailsDTO>() {
					@Override
					public int compare(PdaChangePickingDetailsDTO o1, PdaChangePickingDetailsDTO o2) {
						Integer o1Int = Integer.valueOf(o1.getRowCode().substring(o1.getAreaCode().length()));
						Integer s1 = Integer.valueOf(o1.getShelvesCode().split("-")[1]);
						Integer s2 = Integer.valueOf(o2.getShelvesCode().split("-")[1]);
						return o1Int % 2 == 0 ? s2.compareTo(s1) : s1.compareTo(s2);
					}
				})
				.thenComparing(Comparator.comparing(PdaChangePickingDetailsDTO::getShelvesLayer).reversed())
				.thenComparing(PdaChangePickingDetailsDTO::getShelvesGrid)
		).collect(Collectors.toList());
		return collect;
	}
}
