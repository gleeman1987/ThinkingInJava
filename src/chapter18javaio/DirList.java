package chapter18javaio;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/12
 * Mail:zhengjun1987@outlook.com
 */
public class DirList {
    public static void main(String[] args) {
        File file = new File(".");
        String[] strings = file.list();
        Arrays.sort(strings,String.CASE_INSENSITIVE_ORDER);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
//        string = .git
//        string = .idea
//        string = out
//        string = src
//        string = ThinkingInJava.iml

        System.out.println("-------------------------");
        try {
            System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            System.out.println("file.getName() = " + file.getName());
            System.out.println("file.getParent() = " + file.getParent());
            System.out.println("file.getPath() = " + file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

