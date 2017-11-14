package chapter18javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/13
 * Mail:zhengjun1987@outlook.com
 */
public class DirList2 {
    public static FilenameFilter filter(String regex){
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.compile(regex).matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/chapter18javaio/");
        String[] list = file.list();
        for (String s : list) {
            System.out.println("new File(s).getAbsolutePath() = " + new File(s).getAbsolutePath());
        }
//        new File(s).getAbsolutePath() = /Users/zhengjun/IdeaProjects/ThinkingInJava/DirFilter.java
//        new File(s).getAbsolutePath() = /Users/zhengjun/IdeaProjects/ThinkingInJava/DirList.java
//        new File(s).getAbsolutePath() = /Users/zhengjun/IdeaProjects/ThinkingInJava/DirList2.java

        File file1 = new File("/chapter18javaio/DirFilter.java");
        System.out.println("file1.getCanonicalFile() = " + file1.getCanonicalFile());
//        file1.getCanonicalFile() = /chapter18javaio/DirFilter.java

    }
}
