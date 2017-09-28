package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        Destination paris = parcel4.destination("Paris");
//        Parcel4.PContents pContents = parcel4.new PContents();
    }
}

interface Contents{
    int value();
}

interface Destination{
    String readLabel();
}

class Parcel4{
    private class PContents implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }
}
