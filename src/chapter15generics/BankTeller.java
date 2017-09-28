package chapter15generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class BankTeller {
    static void serve(Teller teller, Customer customer){
        System.out.println("teller = [" + teller + "], customer = [" + customer + "]");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> customers = new LinkedList<>();
        Generators.fill(customers, Customer.generator(),15);
        ArrayList<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator(),4);
        for (Customer customer : customers) {
            serve(tellers.get(random.nextInt(tellers.size())),customer);
        }
//        teller = [Teller{id=3}], customer = [Customer 1]
//        teller = [Teller{id=2}], customer = [Customer 2]
//        teller = [Teller{id=3}], customer = [Customer 3]
//        teller = [Teller{id=1}], customer = [Customer 4]
//        teller = [Teller{id=1}], customer = [Customer 5]
//        teller = [Teller{id=3}], customer = [Customer 6]
//        teller = [Teller{id=1}], customer = [Customer 7]
//        teller = [Teller{id=2}], customer = [Customer 8]
//        teller = [Teller{id=3}], customer = [Customer 9]
//        teller = [Teller{id=3}], customer = [Customer 10]
//        teller = [Teller{id=2}], customer = [Customer 11]
//        teller = [Teller{id=4}], customer = [Customer 12]
//        teller = [Teller{id=2}], customer = [Customer 13]
//        teller = [Teller{id=1}], customer = [Customer 14]
//        teller = [Teller{id=1}], customer = [Customer 15]
    }
}

class Customer {
    private static long count = 1;
    private final long id = count++;

    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer "+id;
    }

    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long count = 1;
    private final long id = count++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public static Generator<Teller> generator(){
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}
