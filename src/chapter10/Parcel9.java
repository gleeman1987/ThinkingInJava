package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class Parcel9 {
    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination washingtonDC = parcel9.destination("WashingtonDC");
        System.out.println(washingtonDC.readLabel());
    }

    private Destination destination(final String s) {
        return new Destination() {
            private String label = s;

            @Override
            public String readLabel() {
                System.out.println(getClass().getName());
                return label;
            }
        };
    }
}
