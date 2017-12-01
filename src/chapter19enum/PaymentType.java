package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
public enum PaymentType {
    UNION("100200") {
        @Override
        void start() {
            System.out.println("serverToken = " + getServerToken());
        }
    },ALIPAY("100300") {
        @Override
        void start() {
            System.out.println("serverToken = " + getServerToken());
        }
    },WECHAT("100400") {
        @Override
        void start() {
            System.out.println("serverToken = " + getServerToken());
        }
    };

    private String serverToken;

    PaymentType(String serverToken) {
        this.serverToken = serverToken;
    }

    public String getServerToken() {
        return serverToken;
    }

    abstract void start();
}
