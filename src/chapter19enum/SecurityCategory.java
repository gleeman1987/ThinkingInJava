package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),BOND(Security.Bond.class);
    interface Security {
        enum Stock implements Security {SHORT,LONG,MARGIN}
        enum Bond implements Security {MUNICIPAL,JUNK}
    }
    Security[] values;

    SecurityCategory(Class<? extends Security> tClass) {
        this.values = tClass.getEnumConstants();
    }
    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category+":"+Enums.random(category.values));
        }
//        BOND:MUNICIPAL
//        BOND:MUNICIPAL
//        STOCK:MARGIN
//        STOCK:MARGIN
//        BOND:JUNK
//        STOCK:SHORT
//        STOCK:LONG
//        STOCK:LONG
//        BOND:MUNICIPAL
//        BOND:JUNK
    }
}
