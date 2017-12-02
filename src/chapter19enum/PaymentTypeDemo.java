package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
public class PaymentTypeDemo {
    public static void main(String... args) {
        for (PaymentType paymentType : PaymentType.values()) {
            System.out.println(paymentType.name()+" = " + paymentType.getServerToken());
        }
        PaymentType.ALIPAY.start();
//        UNION = 100200
//        ALIPAY = 100300
//        WECHAT = 100400
//        serverToken = 100300
    }
}
