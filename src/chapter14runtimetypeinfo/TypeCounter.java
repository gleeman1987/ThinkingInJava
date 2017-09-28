package chapter14runtimetypeinfo;

import java.util.HashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/21.
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object){
        Class<?> objectClass = object.getClass();
        if (!baseType.isAssignableFrom(objectClass)) {
            throw new RuntimeException("类型错误");
        }
        countClass(objectClass);
    }

    private void countClass(Class<?> objectClass) {
        Integer integer = get(objectClass);
        put(objectClass,integer == null?1:integer+1);
        Class<?> superclass = objectClass.getSuperclass();
        if (superclass != null && baseType.isAssignableFrom(superclass)) {
            countClass(superclass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Entry<Class<?>, Integer> classIntegerEntry : entrySet()) {
            result.append(classIntegerEntry.getKey().getSimpleName());
            result.append("=");
            result.append(classIntegerEntry.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("}");
        return result.toString();
    }

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        PetCreator literalPetCreator = new FornameCreator();
        for (Pet pet : literalPetCreator.arrayList(20)) {
            typeCounter.count(pet);
        }
        System.out.println(typeCounter);
        //{Cymric=5, Hamster=1, Mouse=2, Rodent=5, Mut=3, Pug=3, Rat=2, Manx=7, EgyptianMau=2, Cat=9, Pet=20, Dog=6}
    }
}
