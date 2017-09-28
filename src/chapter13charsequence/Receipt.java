package chapter13charsequence;

import java.util.Formatter;

public class Receipt {
    private double total = 0;
    private Formatter formatter = new Formatter(System.out);
    public void printTitle(){
        formatter.format("%-15s %5s %10s\n","Item","Qty","Price");
        formatter.format("%-15s %5s %10s\n","----","---","-----");
    }

    public void print(String name,int qty,double price){
        formatter.format("%-15.15s %5d %10.2f\n",name,qty,price);
        total += price;
    }

    public void printTotal(){
        formatter.format("%-15s %5s %10.2f\n","Tax","",total*0.17);
        formatter.format("%-15s %5s %10s\n","","","-----");
        formatter.format("%-15s %5s %10.2f\n","Total","",total*1.17);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans",1,20.2);
        receipt.print("Princess Peas",11,231);
        receipt.print("Three Peer Porridge",1,22.2);
        receipt.print("Rice",11,22);
        receipt.print("Noodles",1,20);
        receipt.print("Humbergers",1,20.2);
        receipt.printTotal();

        //需要设置等宽字体才能显示正常
//        Item              Qty      Price
//        ----              ---      -----
//        Jack's Magic Be     1      20.20
//        Princess Peas      11     231.00
//        Three Peer Porr     1      22.20
//        Rice               11      22.00
//        Noodles             1      20.00
//        Humbergers          1      20.20
//        Tax                        57.05
//        -----
//        Total                     392.65
    }
}
