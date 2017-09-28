package chapter15generics;

public class ClassTypeCapture<T> {
    private Class<T> tClass;

    public ClassTypeCapture(Class<T> tClass) {
        this.tClass = tClass;
    }

    public boolean f(Object arg){
        return tClass.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> buildingClassTypeCapture = new ClassTypeCapture<>(Building.class);
        System.out.println(buildingClassTypeCapture.f(new Building()));
//        true
        System.out.println(buildingClassTypeCapture.f(new House()));
//        true

        ClassTypeCapture<House> houseClassTypeCapture = new ClassTypeCapture<>(House.class);
        System.out.println(houseClassTypeCapture.f(new Building()));
//        false
        System.out.println(houseClassTypeCapture.f(new House()));
//        true
    }
}

class Building {}

class House extends Building {}
