package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/9.
 */
public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House();
        house.function();
    }
}

class Window{
    public Window(int marker) {
        System.out.println("Window构造方法:marker = [" + marker + "]" + this);
    }
}

class House{
    Window window3 = new Window(3);
    Window window1 = new Window(1);

    public House() {
        System.out.println("House.House构造方法");
        window3 = new Window(33);
    }

    void function(){
        System.out.println("House.bowlfunction");
    }

    Window window2 = new Window(2);

}
