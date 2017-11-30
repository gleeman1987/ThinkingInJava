package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SPRING_ROLLS;
        food = Food.Coffe.BLACK_COFFE;
        food = Food.Dissert.GELATO;
        food = Food.MainCourse.LASAGNE;
    }
}
