package chapter14runtimetypeinfo;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/22.
 */
public class FamilyVsExactType {
    static void test(Object o){
        System.out.println("o = [" + o.getClass() + "]");
        //instanceof关键字仅检查实例是否是目标类型的实例或子类实例,模糊匹配
        System.out.println("o instanceof Base = " + (o instanceof Base));
        System.out.println("o instanceof Derived = " + (o instanceof Derived));
        System.out.println("Base.class.isInstance(o) = " + Base.class.isInstance(o));
        System.out.println("Derived.class.isInstance(o) = " + Derived.class.isInstance(o));

        //获取Class对象并检查是否与目标类型相等 检查该实例类型是否严格匹配
        System.out.println("o.getClass() == Base.class :"+(o.getClass() == Base.class));
        System.out.println("o.getClass() == Derived.class :"+(o.getClass() == Derived.class));
        System.out.println("o.getClass().equals(Base.class)) :"+(o.getClass().equals(Base.class)));
        System.out.println("o.getClass().equals(Derived.class)) :"+(o.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Derived());
        System.out.println("--------------------------------");
        test(new Base());
//        o = [class chapter14runtimetypeinfo.Derived]
//        o instanceof Base = true
//        o instanceof Derived = true
//        Base.class.isInstance(o) = true
//        Derived.class.isInstance(o) = true
//        o.getClass() == Base.class :false
//        o.getClass() == Derived.class :true
//        o.getClass().equals(Base.class)) :false
//        o.getClass().equals(Derived.class)) :true
//         --------------------------------
//        o = [class chapter14runtimetypeinfo.Base]
//        o instanceof Base = true
//        o instanceof Derived = false
//        Base.class.isInstance(o) = true
//        Derived.class.isInstance(o) = false
//        o.getClass() == Base.class :true
//        o.getClass() == Derived.class :false
//        o.getClass().equals(Base.class)) :true
//        o.getClass().equals(Derived.class)) :false
    }
}

class Base{}

class Derived extends Base {}
