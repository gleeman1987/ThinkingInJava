package chapter18javaio;

import java.io.File;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/14
 * Mail:zhengjun1987@outlook.com
 */
public class DirectoryDemo {

    public static final String PATH = "src/chapter18javaio/";

    public static void main(String[] args) {
        PPrint.pprint(Directory.walk("src/chapter18javaio/").files);
//        [
//        src/chapter18javaio/Directory.java
//        src/chapter18javaio/DirectoryDemo.java
//        src/chapter18javaio/DirFilter.java
//        src/chapter18javaio/DirList.java
//        src/chapter18javaio/DirList2.java
//        src/chapter18javaio/PPrint.java
//        src/chapter18javaio/Test.java
//        ]

        for (File file : Directory.local(PATH, "T.*")) {
            System.out.println(file.getPath());
        }
//        src/chapter18javaio/Test.java
        System.out.println("------------------------");
        for (File file : Directory.walk(PATH, "D.*.java")) {
            System.out.println(file);
        }
//        src/chapter18javaio/Directory.java
//        src/chapter18javaio/DirectoryDemo.java
//        src/chapter18javaio/DirFilter.java
//        src/chapter18javaio/DirList.java
//        src/chapter18javaio/DirList2.java
        System.out.println("=================");
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            System.out.println(file);
        }
//        ./out/production/ThinkingInJava/chapter05initialization/OrderOfInitialization.class
//                ./out/production/ThinkingInJava/chapter05initialization/StaticInitialization.class
//                ./out/production/ThinkingInJava/chapter10innerclass/Z$1.class
//                ./out/production/ThinkingInJava/chapter10innerclass/Z.class
//                ./out/production/ThinkingInJava/chapter13charsequence/FornatizedOutput.class
//                ./out/production/ThinkingInJava/chapter14runtimetypeinfo/ClassInitialization.class
//                ./out/production/ThinkingInJava/chapter15generics/FixedSizeStack.class
//                ./out/production/ThinkingInJava/chapter16arrays/ParameterizedArrayType.class
//                ./out/production/ThinkingInJava/chapter17containeradvanced/Synchronization.class
    }
}
