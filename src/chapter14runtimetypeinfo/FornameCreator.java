package chapter14runtimetypeinfo;

import java.util.ArrayList;
import java.util.List;

public class FornameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "chapter14runtimetypeinfo.Mut",
            "chapter14runtimetypeinfo.Pug",
            "chapter14runtimetypeinfo.EgyptianMau",
            "chapter14runtimetypeinfo.Manx",
            "chapter14runtimetypeinfo.Cymric",
            "chapter14runtimetypeinfo.Rat",
            "chapter14runtimetypeinfo.Mouse",
            "chapter14runtimetypeinfo.Hamster"
    };

    private static void loader(){
        for (String typeName : typeNames) {
            try {
                types.add((Class<? extends Pet>) Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
