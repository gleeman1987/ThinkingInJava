package chapter15generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles,int nShelves,int nProducts) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves,nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Aisle aisle : this) {
            for (Shelf products : aisle) {
                for (Product product : products) {
                    stringBuilder.append(product);
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14,5,10));
    }
}

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println("Product = " + this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change){
        price +=  change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random random = new Random(47);
        @Override
        public Product next() {
            return new Product(random.nextInt(1000),"Test",Math.round(random.nextDouble())*1000+0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int initialCapacity) {
        Generators.fill(this, Product.generator,initialCapacity);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves,int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand {}

class Office {}