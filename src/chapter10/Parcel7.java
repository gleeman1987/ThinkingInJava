package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class Parcel7 {
    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
        System.out.println(contents.value());
    }

    private Contents contents() {
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                System.out.println(getClass().getName());
                return i;
            }
        };
    }
}
