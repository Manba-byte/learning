import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wh
 * @description
 * @date 2019/6/6
 */
public class Sort {
    public static void main(String[] args) {
        /*String s = "1A01-1-11";
        String[] split = s.split("-");
        for (int i = 0 ; i<split.length; i++){
            String s1 = split[i];
            System.out.println(s1);
        }*/
        List<String> list = new ArrayList<>();
        list.add("99");
        list.add("101");
        list.add("3");
        list.add("1");
        for (String s1 : list){
            System.out.println(s1);
        }
        Collections.swap(list,0,3);
        for (String s1 : list){
            System.out.println(s1);
        }
       /* String st = "2017-03-28 23:42:06";
        String sd = "2017-03-29 00:42:06";

        int i = st.compareTo(sd);
        System.out.println(i);

        System.out.println(i1);*/
       /*int[] aa = {10,20,15,0,6,7,2,1,-5,55};
       int middle = getMiddle(aa, 0, aa.length-1);
       for (int i = 0 ; i < aa.length ; i++){
           System.out.println(aa[i]);
       }*/

        //System.out.println(group);
        //int i = s.indexOf("^[A-Za-z]");

        //System.out.println(i);
        Sort sort = new Sort();
        List<String> sort1 = sort.sort();
        for (String str : sort1){
            System.out.println(str);
        }

        String s1 = "3";
        String s2 = "1";
        int i1 = s1.compareTo(s2);
        System.out.println(i1);
    }
    public static String queryLetter(String str){
        String z  = "[A-Za-z]";
        Pattern pattern = Pattern.compile(z);
        Matcher matcher = pattern.matcher(str);
        String letterValue = "";
        while (matcher.find()){
            letterValue =  matcher.group();
        }
        return letterValue;
    }

    public List<String> sort(){
        List<String> list = new ArrayList<>();
        list.add("2A01-1-11");
        list.add("1A02-8-12");
        list.add("1A01-4-33");
        list.add("1A03-5-23");
        list.add("1A01-5-34");
        list.add("2A04-4-25");
        list.add("1B05-1-13");
        list.add("4A05-3-51");
        list.add("1A07-3-32");
        list.add("5A07-2-55");
        list.add("1B06-9-51");
        list.add("1A03-11-45");
        list.add("1A04-7-35");
        list.add("1A01-3-12");
        int l = (int) System.currentTimeMillis();
        for (int i = 0 ; i < list.size() -1 ; i++){
            for (int j = 0 ; j < list.size()-1-i; j++){

                //String[] stri = list.get(i).split("-");
                //String[] strj = list.get(j).split("-");
                String strI = list.get(j);
                String qli = queryLetter(strI);

                String[] arrayi = strI.split(qli);
                String strJ = list.get(j+1);
                String qlj = queryLetter(strJ);
                System.out.println(qli);
                String[] arrayj = strJ.split(qlj);
                String arrayStri = arrayi[0];
                String arrayStrj = arrayj[0];
                System.out.println("arrayi---------"+arrayStri);
                System.out.println("arrayj---------"+arrayStrj);
                if(0 < arrayStri.compareTo(arrayStrj)){
                    System.out.println("********************");
                    Collections.swap(list,j,j+1);
                    if(0 == arrayStri.compareTo(arrayStrj)){
                        char c = (list.get(j).toCharArray())[1];
                        char b = (list.get(j+1).toCharArray())[1];
                        String s = String.valueOf(c);
                        String s1 = String.valueOf(b);
                        String strJ2 = list.get(j+1);
                        if(0 > (s.compareTo(s1))){
                            Collections.swap(list,j,j+1);
                        }
                    }
                }
            }
            int l1 = (int)System.currentTimeMillis() - l;
            System.out.println(l1);
        }
        return list;
    }

    public static int getMiddle(int[] numbers, int low,int high,List<String> list) {
        int temp = numbers[low]; //数组的第一个作为中轴

        while(low < high)
        {
            while(low < high && numbers[high] > temp)
            {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while(low < high && numbers[low] < temp)
            {
                low++;
            }
            numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }


}
