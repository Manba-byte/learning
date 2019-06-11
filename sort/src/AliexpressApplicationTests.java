
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class AliexpressApplicationTests {
    public static void main(String[] args) {
        new AliexpressApplicationTests().contextLoads();
    }


    public void contextLoads() {
        List<String> list = new ArrayList<>();
        list.add("1A01-1-11");
        list.add("1A01-1-92");
        list.add("1A01-1-91");
        list.add("1A02-4-33");
        list.add("1A02-8-12");

        list.add("1A03-5-23");
        list.add("1A01-5-34");
        list.add("2A04-4-25");
        list.add("1B05-1-13");
        list.add("4A05-3-51");
        list.add("1A07-3-32");
        list.add("5A07-2-55");
        list.add("1A06-9-51");
        list.add("1A03-11-45");
        list.add("1A04-7-35");
        list.add("1A01-3-22");
        Long aaaaaa=System.currentTimeMillis();
        List<IndexDTO> indexDTOS=new ArrayList<>(list.size());
        list.forEach(s ->{
              String[] aa= s.split("-");
              indexDTOS.add(new IndexDTO(aa[0],Integer.valueOf(aa[1]),aa[2].substring(0,1),aa[2].substring(1),Integer.valueOf(aa[0].substring(2,4))));
        });
        indexDTOS.forEach(System.out::println);
        List<IndexDTO> aaa=indexDTOS.stream().sorted(
                Comparator.comparing((IndexDTO::getNum1))
                .thenComparing(new Comparator<IndexDTO>() {
                    @Override
                    public int compare(IndexDTO o1, IndexDTO o2) {
                        return o1.getNum5()%2==0 ? o2.getNum2().compareTo(o1.getNum2()): o1.getNum2().compareTo(o2.getNum2());
                    }
                })
                .thenComparing(Comparator.comparing(IndexDTO::getNum3).reversed())
                .thenComparing(IndexDTO::getNum4)
        ).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis()-aaaaaa);

        aaa.forEach(System.out::println);
    }

}
