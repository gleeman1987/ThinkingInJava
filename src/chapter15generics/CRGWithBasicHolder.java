package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
class SubType extends BasicHolder<SubType>{

}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        SubType subType1 = new SubType(),subType2 = new SubType();
        subType1.set(subType2);
        SubType subType = subType1.get();
        subType1.f();
    }
}
