package chapter14runtimetypeinfo;

import java.lang.reflect.Field;

public class ModifyingPrivateFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalFields withPrivateFinalFields = new WithPrivateFinalFields();
        System.out.println("withPrivateFinalFields = " + withPrivateFinalFields);//withPrivateFinalFields = WithPrivateFinalFields{i=1, s='I'm totally safe', s2='Am I safe?'}
        Field declaredField = withPrivateFinalFields.getClass().getDeclaredField("i");
        declaredField.setAccessible(true);
        int anInt = declaredField.getInt(withPrivateFinalFields);
        System.out.println("anInt = " + anInt);

        declaredField.setInt(withPrivateFinalFields,22);
        System.out.println("withPrivateFinalFields = " + withPrivateFinalFields);

        Field s = withPrivateFinalFields.getClass().getDeclaredField("s");
        s.setAccessible(true);
        System.out.println("s.get(withPrivateFinalFields) = " + s.get(withPrivateFinalFields));
        try {
            s.set(withPrivateFinalFields,"No,you're not!");
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        }
        System.out.println("withPrivateFinalFields = " + withPrivateFinalFields);

        Field s2 = withPrivateFinalFields.getClass().getDeclaredField("s2");
        s2.setAccessible(true);
        System.out.println("s2.get(withPrivateFinalFields) = " + s2.get(withPrivateFinalFields));
        s2.set(withPrivateFinalFields,"No,you're not!");
        System.out.println("withPrivateFinalFields = " + withPrivateFinalFields);//withPrivateFinalFields = WithPrivateFinalFields{i=22, s='I'm totally safe', s2='No,you're not!'}
    }
}

class WithPrivateFinalFields {
    private int i = 1;
    private static final String s = "I'm totally safe";
    private String s2 = "Am I safe?";

    @Override
    public String toString() {
        return "WithPrivateFinalFields{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }
}
