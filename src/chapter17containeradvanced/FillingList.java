package chapter17containeradvanced;


import java.util.ArrayList;
import java.util.Collections;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
class StringAddress {
  private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString()+"  "+s;
    }
}

public class FillingList {
    public static void main(String[] args) {
        ArrayList<StringAddress> stringAddresses = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello!")));
        System.out.println("stringAddresses = " + stringAddresses);
        Collections.fill(stringAddresses,new StringAddress("World!"));
//        stringAddresses = [chapter17containeradvanced.StringAddress@4554617c  Hello!, chapter17containeradvanced.StringAddress@4554617c  Hello!, chapter17containeradvanced.StringAddress@4554617c  Hello!, chapter17containeradvanced.StringAddress@4554617c  Hello!]
        System.out.println("stringAddresses = " + stringAddresses);
//        stringAddresses = [chapter17containeradvanced.StringAddress@74a14482  World!, chapter17containeradvanced.StringAddress@74a14482  World!, chapter17containeradvanced.StringAddress@74a14482  World!, chapter17containeradvanced.StringAddress@74a14482  World!]
    }
}
