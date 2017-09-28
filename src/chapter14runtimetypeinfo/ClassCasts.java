package chapter14runtimetypeinfo;

public class ClassCasts {
    public static void main(String[] args) {
        Building building = new House();

        //新的强转方法(没多大用处,反而会产生冗余工作量)
        Class<House> houseClass = House.class;
        House house = houseClass.cast(building);

        //旧的强转方法
        house = (House)building;
    }
}

class Building {}

class House extends Building {}
