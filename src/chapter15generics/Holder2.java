package chapter15generics;

public class Holder2 {
    private Object object;

    public Holder2(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Holder2 hold2 = new Holder2(new AutoMobile());
        AutoMobile autoMobile = (AutoMobile) hold2.getObject();
        System.out.println("hold2.getObject() = " + hold2.getObject());
        hold2.setObject("Not an automobile");
        String string = (String) hold2.getObject();
        System.out.println("hold2.getObject() = " + hold2.getObject());
        hold2.setObject(1);
        System.out.println("hold2.getObject() = " + hold2.getObject());
//        hold2.getObject() = chapter15generics.AutoMobile@4554617c
//        hold2.getObject() = Not an automobile
//        hold2.getObject() = 1
    }
}
