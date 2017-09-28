package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class Parcel6 {
    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        Destination destination = parcel6.testImplementations();
        String label = destination.readLabel();
        System.out.println(label);
    }

    private Destination testImplementations() {
        class YDestination implements Destination{
            String label;

            public YDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                System.out.println(getClass().getName());
                return label;
            }
        }

        return new YDestination("Shanghai");
    }

    public void track(){
        internalTracking(true);
    }

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip{
                private String id;

                public TrackingSlip(String id) {
                    this.id = id;
                }

                public String getId() {
                    return id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip("slip");
            String id = trackingSlip.getId();
        }
//        TrackingSlip trace = new TrackingSlip("trace");
    }
}
