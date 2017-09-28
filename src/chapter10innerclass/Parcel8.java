package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class Parcel8 {
    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(10);
        System.out.println(wrapping.value());
    }

    private Wrapping wrapping(int i) {
        return new Wrapping(i){
            @Override
            public int value() {
                System.out.println(getClass().getName()+".value");
                return super.value()*47;
            }
        };
    }


}

class Wrapping{
    private int i;

    public Wrapping(int i) {
        this.i = i;
    }

    public int value(){
        System.out.println("Wrapping.value");
        return i;
    }
}
