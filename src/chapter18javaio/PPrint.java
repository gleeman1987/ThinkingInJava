package chapter18javaio;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/14
 * Mail:zhengjun1987@outlook.com
 */
public class PPrint {
    public static String pformat(Collection<?> collection){
        if (collection.size() == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        for (Object o : collection) {
            if (collection.size() != 1) {
                stringBuffer.append("\n");
            }
            stringBuffer.append(o.toString());
        }
        if (collection.size() != 1) {
            stringBuffer.append("\n");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /**
     * @see MakeDir#fileData(File)  使用该类的范例
     *
     * */
    public static void pprint(Collection<?> collection){
        System.out.println(pformat(collection));
    }

    public static void pprint(Object[] args) {
        System.out.println(pformat(Arrays.asList(args)));
    }
}
