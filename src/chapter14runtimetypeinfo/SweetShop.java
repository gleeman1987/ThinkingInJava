package chapter14runtimetypeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/21.
 */
class Candy{
    static {
        System.out.println("Loading Candy");
    }
}

class Gum{
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("-----------inside main()-----------");
        new Candy();
        System.out.println("---------After creating candy-----------");
        try {
            Class<?> aClass = null;//Loading Gum
            if (args.length == 0) {
//            Class.forName("Gum");//fail to find Class 'Gum'
//此处必须将类型的引用名完整写全,ClassLoader才能找到该类
//                aClass = Class.forName("chapter14runtimetypeinfo.Gum");
                aClass = Gum.class;
            } else {
                aClass = Class.forName("chapter14runtimetypeinfo.Cookie");
            }
            System.out.println(aClass.getCanonicalName());
            List<Class<?>> classes = Arrays.asList(aClass.getClasses());
            System.out.println(classes);
            System.out.println(aClass.getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            System.out.println("fail to find Class 'Gum'");
        }
        System.out.println("---------After  Class.forName(\"Gum\")-----------");
        new Cookie();
        System.out.println("---------After creating cookie-----------");
//        -----------inside main()-----------
//                Loading Candy
//        fail to find Class 'Gum'
//                ---------After  Class.forName("Gum")-----------
//                Loading Cookie
//                ---------After creating cookie-----------
    }
}


