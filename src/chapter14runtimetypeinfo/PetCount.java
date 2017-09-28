package chapter14runtimetypeinfo;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String,Integer> {
        public void count(String type){
            Integer integer = get(type);
            if (integer == null) {
                put(type,1);
            } else {
                put(type,integer+1);
            }
        }
    }

    public static void countPets(PetCreator creator){
        PetCounter petCounter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            String simpleName = pet.getClass().getSimpleName();
            System.out.print(simpleName + "  ");
            petCounter.count(simpleName);
        }
        System.out.println();
        System.out.println(petCounter);
    }

    public static void main(String[] args) {
        countPets(new FornameCreator());
        countPets(new LiteralPetCreator());
    }
}
