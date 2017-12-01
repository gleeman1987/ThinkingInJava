package chapter19enum;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
class Mail{
    enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannablity {UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability{ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5}
    enum ReturnAddress{MISSING,OK1,OK2,OK3,OK4,OK5}

    GeneralDelivery generalDelivery;
    Scannablity scannablity;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    final long id = counter++;

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                '}';
    }

    public String details() {
        return "Mail{" +
                "generalDelivery=" + generalDelivery +
                ", scannablity=" + scannablity +
                ", readability=" + readability +
                ", address=" + address +
                ", returnAddress=" + returnAddress +
                ", id=" + id +
                '}';
    }

    public static Mail randomMail(){
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.readability = Enums.random(Readability.class);
        mail.scannablity = Enums.random(Scannablity.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> generator(int count) {
        return new Iterable<Mail>() {
            int n = count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- >0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("不支持此操作");
                    }
                };
            }
        };
    }
}
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handleMail(Mail mail) {
                boolean b = mail.generalDelivery == Mail.GeneralDelivery.YES;
                if (b) {
                    System.out.println("GENERAL_DELIVERY for "+mail);
                }
                return b;
            }
        },MACHINE_SCAN {
            @Override
            boolean handleMail(Mail mail) {
                switch (mail.scannablity) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Deliver "+mail+" automantically");
                                return true;
                        }
                }
            }
        },VISUAL_INSPECTION {
            @Override
            boolean handleMail(Mail mail) {
                return false;
            }
        },RETURN_TO_SENDER {
            @Override
            boolean handleMail(Mail mail) {
                return false;
            }
        };
        abstract boolean handleMail(Mail mail);
    }
}
