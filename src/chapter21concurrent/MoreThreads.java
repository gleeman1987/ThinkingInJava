package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/6
 * Mail:zhengjun1987@outlook.com
 */
public class MoreThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff(),"Thread"+i).start();
        }
        System.out.println("等待发射");
//        等待发射
//        #0(9) #0(8) #0(7) #1(9) #1(8) #2(9) #3(9) #4(9) #1(7) #3(8) #1(6) #4(8)
//        #2(8) #0(6) #1(5) #3(7) #4(7) #2(7) #0(5) #3(6) #2(6) #3(5) #1(4) #3(4)
//        #2(5) #3(3) #0(4) #3(2) #4(6) #3(1) #0(3) #2(4) #1(3) #0(2) #1(2) #3(LiftOff!)
//        #4(5) #1(1) #0(1) #2(3) #4(4) #1(LiftOff!) #0(LiftOff!) #2(2) #4(3) #4(2)
//        #2(1) #4(1) #2(LiftOff!) #4(LiftOff!)

    }
}
