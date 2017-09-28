package chapter14runtimetypeinfo;

public class TreePrint {
    public static void printTree(Object o) {
        if (o != null) {
            Class<?> aClass = o.getClass();
            System.out.println(aClass);
            Class<?> superclass = aClass.getSuperclass();
            if (superclass != null) {
                try {
                    printTree(superclass.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        printTree(System.out);
//        printTree(12);
    }
}
