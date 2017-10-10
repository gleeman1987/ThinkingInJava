package chapter15generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class ByteSet {
    Byte[] possibles = {1,2,3,4,5,6,7,8,9};
    Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));

    public static void main(String[] args) {
        System.out.println(new ByteSet().mySet);
    }
}
