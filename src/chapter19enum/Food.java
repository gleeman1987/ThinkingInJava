package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public interface Food {
    enum Appetizer implements Food {SALAD,SOUP,SPRING_ROLLS}
    enum MainCourse implements Food {LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO}
    enum Dissert implements Food {TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL}
    enum Coffe implements Food {BLACK_COFFE,DECAF_COFFE,ESPRESSO,LATTE,CAPPUCCINO,TEA,HERB_TEA}
}
