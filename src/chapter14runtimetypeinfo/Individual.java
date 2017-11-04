package chapter14runtimetypeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual implements Comparable<Individual> {
    private static long count ;
    private long id = count++;
    private String name;

    public Individual() {
    }

    public Individual(String name) {
        this.name = name;
    }

    public long id(){
        return id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+(name==null || "".equals(name)?"":"{" +
                "name='" + name + '\'' +
                '}');
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual && ((Individual)obj).name.equals(name) && ((Individual)obj).id == id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = result*37 + name.hashCode();
        }
        result = (int) (result*37 + id);
        return result;
    }

    @Override
    public int compareTo(Individual o) {
        int firstCompare = this.getClass().getSimpleName().compareTo(o.getClass().getSimpleName());
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && o.name!=null) {
            int compare = name.compareTo(o.name);
            if (compare != 0) {
                return compare;
            }
        }
        return Long.compare(id,o.id);
    }
}

class Person extends Individual {
    public Person(String name) {
        super(name);
    }
}

class Mut extends Dog {
    public Mut() {
    }

    public Mut(String name) {
        super(name);
    }
}

class Pug extends Dog {
    public Pug() {
    }

    public Pug(String name) {
        super(name);
    }
}

class EgyptianMau extends Cat {
    public EgyptianMau() {
    }

    public EgyptianMau(String name) {
        super(name);
    }
}

class Manx extends Cat {
    public Manx() {
    }

    public Manx(String name) {
        super(name);
    }
}

class Cymric extends Manx {
    public Cymric() {
    }

    public Cymric(String name) {
        super(name);
    }
}

class Rodent extends Pet {
    public Rodent() {
    }

    public Rodent(String name) {
        super(name);
    }
}

class Mouse extends Rodent {
    public Mouse() {
    }

    public Mouse(String name) {
        super(name);
    }
}

class Hamster extends Rodent {
    public Hamster() {
    }

    public Hamster(String name) {
        super(name);
    }
}

abstract class PetCreator {
    private Random random = new Random(47);
    public abstract  List<Class<? extends Pet>> types();

    public Pet randomPet(){
        int nextInt = random.nextInt(types().size());
        try {
            return types().get(nextInt).newInstance();
        } catch (InstantiationException e) {
            //目标Class没有默认构造器
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //违背了Java安全机制,此处特指默认构造器被设置成private的情形
            e.printStackTrace();
        }
        return null;
    }

    public Pet[] createArray(int size){
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public List<Pet> arrayList(int size){
        ArrayList<Pet> pets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            pets.add(randomPet());
        }
        return pets;
    }
}