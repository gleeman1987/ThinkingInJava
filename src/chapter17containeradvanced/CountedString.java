package chapter17containeradvanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/3
 * Mail:zhengjun1987@outlook.com
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String string;
    private int id = 0;

    public CountedString(String string) {
        this.string = string;
        created.add(string);
        for (String s : created) {
            if (s.equals(string)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String : "+string+" id : "+id+ " hashCode : "+hashCode();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result+string.hashCode();
        result = 37*result+id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString && string.equals(((CountedString) obj).string) && id == ((CountedString)obj).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> hashMap = new HashMap<>();
        CountedString[] countedStrings = new CountedString[5];
        for (int i = 0; i < countedStrings.length; i++) {
            countedStrings[i] = new CountedString("hi");
            hashMap.put(countedStrings[i],i);
        }
        System.out.println("hashMap = " + hashMap);
        for (CountedString countedString : countedStrings) {
            System.out.println("hashMap.get(countedString) = " + hashMap.get(countedString));
        }
//        hashMap = {String : hi id : 4 hashCode : 146450=3, String : hi id : 5 hashCode : 146451=4, String : hi id : 2 hashCode : 146448=1, String : hi id : 3 hashCode : 146449=2, String : hi id : 1 hashCode : 146447=0}
//        hashMap.get(countedString) = 0
//        hashMap.get(countedString) = 1
//        hashMap.get(countedString) = 2
//        hashMap.get(countedString) = 3
//        hashMap.get(countedString) = 4
    }
}
