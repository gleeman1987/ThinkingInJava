package chapter15generics;

public class Holder1 {
    private AutoMobile autoMobile;

    public Holder1(AutoMobile autoMobile) {
        this.autoMobile = autoMobile;
    }

    public AutoMobile getAutoMobile() {
        return autoMobile;
    }
}

class AutoMobile{}
