package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
enum Search {HITHER,YON}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum enum1 = Search.HITHER;
        Enum[] enumConstants = enum1.getClass().getEnumConstants();
        for (Enum enumConstant : enumConstants) {
            System.out.println("enumConstant = " + enumConstant);
        }
//        enumConstant = HITHER
//        enumConstant = YON
    }
}
