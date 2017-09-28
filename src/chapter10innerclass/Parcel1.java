package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/29.
 */
public class Parcel1 {
    class Content {
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

        String readLabel(){
            return label;
        }
    }

    public void ship(String dest){
        Content content = new Content();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("Tasmania");
    }
}
