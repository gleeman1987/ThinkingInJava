package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public enum  Course {
    APPETIZER(Food.Appetizer.class),MAINCOURSE(Food.MainCourse.class),COFFE(Food.Coffe.class),DISSERT(Food.Dissert.class);
    private Food[] values;

    Course(Class<? extends Food> tClass) {
        this.values = tClass.getEnumConstants();
    }

    public Food randomSelection(){
        return Enums.random(values);
    }
}
