package chapter19enum;

import java.util.EnumMap;

import static chapter19enum.Input.*;


/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/2
 * Mail:zhengjun1987@outlook.com
 */
enum Category {
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SOAP,SODA),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] inputs;

    Category(Input... inputs) {
        this.inputs = inputs;
    }

    private static EnumMap<Input, Category> categoryEnumMap = new EnumMap<>(Input.class);

    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input input : category.inputs) {
                categoryEnumMap.put(input, category);
            }
        }
    }

    public static Category categorize(Input input){
        return categoryEnumMap.get(input);
    }
}

public class VendingMachine {
    enum StateDuration{TRANSIENT}
    enum State{}

}
