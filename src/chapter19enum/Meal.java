package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("--------------------------");
        }
//        SPRING_ROLLS
//                VINDALOO
//        HERB_TEA
//                GELATO
//        --------------------------
//                SOUP
//        VINDALOO
//                BLACK_COFFE
//        TIRAMISU
//        --------------------------
//        SALAD
//                BURRITO
//        ESPRESSO
//                FRUIT
//        --------------------------
//                SALAD
//        BURRITO
//                LATTE
//        FRUIT
//        --------------------------
//        SOUP
//                BURRITO
//        BLACK_COFFE
//                FRUIT
//        --------------------------
    }
}
