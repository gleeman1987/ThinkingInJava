package chapter15generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/18
 * Mail:zhengjun1987@outlook.com
 */
public class Fill {
    public static <T> void fill(Collection<T> collection,Class<? extends T> tClass,int size){
        for (int i = 0; i < size; i++) {
            try {
                collection.add(tClass.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}

class Contract {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+ id;
    }
}

class TitleTransfer extends Contract {}

class FillTest {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts,Contract.class,3);
        Fill.fill(contracts,TitleTransfer.class,3);
        System.out.println(contracts);
//        [Contract 0, Contract 1, Contract 2, TitleTransfer 3, TitleTransfer 4, TitleTransfer 5]
    }
}