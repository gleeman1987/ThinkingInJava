package chapter16arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
class ClassParameter<E> {
    public E[] f(E[] arg){
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg){
        return arg;
    }
}
public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5};
        Integer[] integers1 = new ClassParameter<Integer>().f(integers);
        Double[] doubles1 = new ClassParameter<Double>().f(doubles);
        Integer[] integers2 = MethodParameter.f(integers);
        Double[] doubles2 = MethodParameter.f(doubles);
    }
}
