package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/5.
 */
public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int value = 11;

        @Override
        public int value() {
            return value;
        }
    }
    protected static class ParcelDestination implements Destination{
        private String label;

        private ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        private static void f(){
            System.out.println("ParcelDestination.f");
        }

        private static int x = 10;
        static class AnotherLevel{
            public static void f(){
                System.out.println("AnotherLevel.f");
            }
            static int x = 12;
        }
    }

    public Destination destination(String label){
        return new ParcelDestination(label);
    }

    public Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Parcel11 parcel11 = new Parcel11();
        Contents contents = parcel11.contents();
        Destination berlin = parcel11.destination("Berlin");
        System.out.println(berlin.readLabel());

        ParcelDestination.f();

        ParcelDestination.AnotherLevel.f();
        System.out.println(ParcelDestination.x);
        System.out.println(ParcelDestination.AnotherLevel.x);
    }
}
