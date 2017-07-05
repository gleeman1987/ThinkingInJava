package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class Parcel10 {
    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination tasmania = parcel10.destination("Tasmania", 101.395F);
        System.out.println(tasmania.readLabel());
    }

    private Destination destination(final String s, final float v) {
        return new Destination() {
            private int cost;
            {
                cost = Math.round(v);
                if (cost > 100) {
                    System.out.println("Over Budget!");
                }
            }
            private String label = s;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
