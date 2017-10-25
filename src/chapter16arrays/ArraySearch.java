package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class ArraySearch {
    public static void main(String[] args) {
        RandomGenerator.Integer generator = new RandomGenerator.Integer(1000);
        int[] primitive = ConvertTo.primitive(Generated.array(new Integer[25], generator));
        Arrays.sort(primitive);
        System.out.println("排序之后:"+Arrays.toString(primitive));
//        排序之后:[128, 140, 200, 207, 258, 258, 278, 288, 322, 429, 511, 520, 522, 551, 555, 589, 693, 704, 809, 861, 861, 868, 916, 961, 998]
        while (true){
            Integer integer = generator.next();
            int binarySearch = Arrays.binarySearch(primitive, integer);
            if (binarySearch >= 0) {
                System.out.println(integer+"在数组中的位置是"+binarySearch+" ,primitive{"+binarySearch+"] = "+integer);
//                322在数组中的位置是8 ,primitive{8] = 322
                break;
            }
        }
    }
}
