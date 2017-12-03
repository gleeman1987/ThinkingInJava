package chapter19enum;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/2
 * Mail:zhengjun1987@outlook.com
 */
public enum Input {

    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        @Override
        public int getValue() {
            throw new RuntimeException("UnSupportedOperation!");
        }
    },
    STOP{
        @Override
        public int getValue() {
            throw new RuntimeException("UnSupportedOperation!");
        }
    };

    private int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    static Random random = new Random(50);

    public int getValue() {
        return value;
    }

    public static Input randomSelection(){
        return values()[random.nextInt(values().length)];
    };
}
