package chapter18javaio;

import java.io.File;
import java.io.IOException;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/14
 * Mail:zhengjun1987@outlook.com
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        File file = new File(".");
//        listFile(file);
        MakeDir.main(new String[]{"zhengjun.txt"});
    }

    static void listFile(File file){
        if (file.isDirectory()) {
            System.out.println("--------------文件夹  " + file.getAbsolutePath());
            String[] list = file.list();
            for (String s : list) {
                File file1 = new File(s);
                listFile(file1);
            }
        } else {
            System.out.println("文件 " + file.getAbsolutePath());
        }
    }
}
