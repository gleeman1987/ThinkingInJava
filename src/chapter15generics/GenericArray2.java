package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/9
 * Mail:zhengjun1987@outlook.com
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int size) {
        this.array = new Object[size];
    }

    public void put(int index,T t){
        array[index] = t;
    }

    public T get(int index){
        return (T)array[index];
    }

    public T[] rep(){
        return (T[])array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> integerGenericArray2 = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            integerGenericArray2.put(i,i*9);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(integerGenericArray2.get(i)+"  ");
        }

        try {
            Integer[] integers = integerGenericArray2.rep();//此步骤出错
            System.out.println("integers = " + integers);
        } catch (Exception e) {
            System.out.println("e = " + e);//e = java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        }

        int i = Integer.MAX_VALUE + 1;
        System.out.println("Integer.MAX_VALUE+1 = " + i);
        String binaryString = Integer.toBinaryString(i);
        System.out.println("Integer.toBinaryString(i) = " + binaryString);
        String binaryString1 = Integer.toBinaryString(Integer.MAX_VALUE);
        System.out.println("10000000000000000000000000000000 = " + binaryString.length());
        System.out.println("Integer.toBinaryString(Integer.MAX_VALUE) = " + binaryString1);
        System.out.println("1111111111111111111111111111111.length() = " + binaryString1.length());

    }
}
