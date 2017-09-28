package chapter14runtimetypeinfo;

public class BoundClassReference {
    public static void main(String[] args) {
        Class<? extends Number> integerClass = int.class;//向Class引用添加泛型语法的原因仅仅是提供编译期类型检查,避免把类型错误带到运行时
        integerClass = double.class;
        integerClass = float.class;
    }
}
