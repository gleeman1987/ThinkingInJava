package chapter19enum;

import java.util.Iterator;

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
                boolean b = mail.readability != Mail.Readability.ILLEGIBLE && mail.address != Mail.Address.INCORRECT;
                if (b) {
                    System.out.println("Delivering "+mail+" normally");
                }
                return b;
            }
        },RETURN_TO_SENDER {
            @Override
            boolean handleMail(Mail mail) {
                boolean b = Mail.ReturnAddress.MISSING != mail.returnAddress;
                if (b) {
                    System.out.println("Return "+mail+" to sender");
                }
                return b;
            }
        };

        abstract boolean handleMail(Mail mail);

    }
    static void handleMail(Mail mail){
        System.out.println("PostOffice.handleMail  " + "mail = [" + mail + "]");
        for (MailHandler mailHandler : MailHandler.values()) {
            if (mailHandler.handleMail(mail)) {
                return;
            }
        }
        System.out.println(mail + " is a dead mail");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handleMail(mail);
            System.out.println("------------------------------");
        }
    }
//    Mail{generalDelivery=NO2, scannablity=YES3, readability=ILLEGIBLE, address=OK5, returnAddress=OK1, id=0}
//    Deliver Mail{id=0} automantically
//------------------------------
//    Mail{generalDelivery=NO5, scannablity=UNSCANNABLE, readability=YES3, address=INCORRECT, returnAddress=OK1, id=1}
//    Return Mail{id=1} to sender
//------------------------------
//    Mail{generalDelivery=YES, scannablity=YES1, readability=YES3, address=OK1, returnAddress=OK5, id=2}
//    GENERAL_DELIVERY for Mail{id=2}
//------------------------------
//    Mail{generalDelivery=NO4, scannablity=YES1, readability=YES3, address=OK2, returnAddress=OK4, id=3}
//    Deliver Mail{id=3} automantically
//------------------------------
//    Mail{generalDelivery=NO4, scannablity=YES1, readability=ILLEGIBLE, address=INCORRECT, returnAddress=OK2, id=4}
//    Return Mail{id=4} to sender
//------------------------------
//    Mail{generalDelivery=NO3, scannablity=UNSCANNABLE, readability=YES1, address=OK4, returnAddress=OK2, id=5}
//    Delivering Mail{id=5} normally
//------------------------------
//    Mail{generalDelivery=YES, scannablity=UNSCANNABLE, readability=YES4, address=INCORRECT, returnAddress=OK4, id=6}
//    GENERAL_DELIVERY for Mail{id=6}
//------------------------------
//    Mail{generalDelivery=YES, scannablity=YES4, readability=YES3, address=OK4, returnAddress=MISSING, id=7}
//    GENERAL_DELIVERY for Mail{id=7}
//------------------------------
//    Mail{generalDelivery=NO3, scannablity=YES3, readability=YES1, address=OK4, returnAddress=MISSING, id=8}
//    Deliver Mail{id=8} automantically
//------------------------------
//    Mail{generalDelivery=NO1, scannablity=YES2, readability=ILLEGIBLE, address=OK4, returnAddress=OK4, id=9}
//    Deliver Mail{id=9} automantically
//------------------------------
}
