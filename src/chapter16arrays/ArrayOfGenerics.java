package chapter16arrays;

import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] lists = new List[20];
        ls = lists;
        ls[0] = new ArrayList<>();

        Object[] objects = ls;
        objects[1] = new ArrayList<>();

        List<BerylliumSphere>[] spheres = new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }
}
