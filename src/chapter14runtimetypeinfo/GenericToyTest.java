package chapter14runtimetypeinfo;

public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        FancyToy fancyToy = fancyToyClass.newInstance();
        System.out.println("fancyToy = " + fancyToy);
        //类加载器中的类型信息并不处理类之间的继承关系,类加载器并不知道某个类型信息的父类的具体类型
        Class<? super FancyToy> superclass = fancyToyClass.getSuperclass();
        System.out.println("superclass = " + superclass);
        Object object = superclass.newInstance();
        System.out.println("object = " + object.getClass().getCanonicalName());

        //只能强转
        Class<Toy> clazz = (Class<Toy>) fancyToyClass.getSuperclass();
        Toy toy = (Toy) superclass.newInstance();
    }
}
