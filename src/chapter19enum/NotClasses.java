package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
enum LikeClasses {
    WINKEN {
        @Override
        void behaviour() {
            System.out.println("WINKEN.behaviour");
        }
    },BLINKEN {
        @Override
        void behaviour() {
            System.out.println("BLINKEN.behaviour");
        }
    },NOD {
        @Override
        void behaviour() {
            System.out.println("NOD.behaviour");
        }
    };
    abstract void behaviour();
}

public class NotClasses {
    static void function(LikeClasses likeClasses){
        likeClasses.behaviour();
    }

    public static void main(String[] args) {
        for (LikeClasses likeClasses : LikeClasses.values()) {
            function(likeClasses);
        }
    }
}
