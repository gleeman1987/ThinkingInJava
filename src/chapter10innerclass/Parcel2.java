package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/29.
 */
public class Parcel2 {
    class Contents {
        private int i = 11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String readLabel(){
            return label;
        }
    }

    public Destination to(String dest){
        return new Destination(dest);
    }

    public Contents contents(){
        return new Contents();
    }

    public void ship(String dest){
        Destination destination = to(dest);
        Contents contents = contents();
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tasmania");
        Parcel2 parcel21 = new Parcel2();
        Contents contents = parcel21.new Contents();
        Destination borneo = parcel21.new Destination("Borneo");
    }
}
