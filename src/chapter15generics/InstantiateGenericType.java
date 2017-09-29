package chapter15generics;

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassFactory<Employee> employeeClassFactory = new ClassFactory<>(Employee.class);
        System.out.println("employeeClassFactory.get().getClass().getCanonicalName() = " + employeeClassFactory.get().getClass().getCanonicalName());
        //employeeClassFactory.get().getClass().getCanonicalName() = chapter15generics.Employee
        ClassFactory<Integer> integerClassFactory = new ClassFactory<>(Integer.class);
        System.out.println("integerClassFactory.get().getClass().getCanonicalName() = " + integerClassFactory.get().getClass().getCanonicalName());
        //此处出错.因为Integer类没有默认构造器
    }
}

class ClassFactory<T> {
    T x;

    public ClassFactory(Class<T> tClass) {
        try {
            this.x = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public T get(){
        return x;
    }
}

class Employee {}
