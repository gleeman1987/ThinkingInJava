package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.addAll(Countries.names(6));
        collection.add("Ten");
        collection.add("Eleven");
        System.out.println("collection = " + collection);
//        collection = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, Ten, Eleven]

        Object[] objects = collection.toArray();
        System.out.println("Arrays.toString(objects) = " + Arrays.toString(objects));
//        Arrays.toString(objects) = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, Ten, Eleven]
        String[] strings = collection.toArray(new String[10]);
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));
//        Arrays.toString(strings) = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, Ten, Eleven, null, null]

        System.out.println("Collections.max(collection) = " + Collections.max(collection));
//        Collections.max(collection) = Ten
        System.out.println("Collections.min(collection) = " + Collections.min(collection));
//        Collections.min(collection) = ALGERIA

        Collections.sort((List<String>) collection,Collections.reverseOrder());//Collections的排序静态方法仅针对List及其子类
        System.out.println("collection = " + collection);
//        collection = [Ten, Eleven, BURUNDI, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA]


        Collection<String> collections = new ArrayList<>(Countries.names(6));
        ((List<String>) collection).addAll(collections);
        System.out.println("collection = " + collection);
//        collection = [Ten, Eleven, BURUNDI, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]

        String s = Countries.DATA[3][0];
        System.out.println("collection.contains(s) = " + collection.contains(s));
//        collection.contains(s) = true
        System.out.println("collection.containsAll(collections) = " + collection.containsAll(collections));
//        collection.containsAll(collections) = true
        List<String> subList = ((List<String>) collection).subList(3, 5);
        System.out.println("collections = " + collections);
//        collections = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
        collections.retainAll(subList);
        subList.add("HANGZHOU");
        System.out.println("subList = " + subList);
        System.out.println("collections = " + collections);
//        subList = [BURKINA FASO, BOTSWANA, HANGZHOU]
//        collections = [BOTSWANA, BURKINA FASO]

        collections.removeAll(subList);
        System.out.println("collections.isEmpty() = " + collections.isEmpty());
//        collections.isEmpty() = true

        ArrayList<String> stringArrayList = new ArrayList<>(Countries.names(6));
        System.out.println("stringArrayList = " + stringArrayList);
        stringArrayList.clear();
        System.out.println("stringArrayList = " + stringArrayList);
//        stringArrayList = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
//        stringArrayList = []
    }
}
