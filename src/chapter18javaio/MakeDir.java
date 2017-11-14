package chapter18javaio;

import java.io.File;
import java.io.IOException;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/14
 * Mail:zhengjun1987@outlook.com
 */
public class MakeDir {
    private static void usage(){
        System.err.println(
                "Usage:MakeDir path1 ...\n" +
                        "Creates each path\n" +
                        "Usage:MakeDir -d path1 ... \n" +
                        "Deletes each path\n" +
                        "Usage:MakeDir -r path1 path2 ...\n" +
                        "Renames path1 to path2"
        );
        System.exit(1);
    }

    public static void fileData(File file){
        System.out.println("getAbsolutePath() : " + file.getAbsolutePath());
        System.out.println("canRead() : " + file.canRead());
        System.out.println("canWrite() : " + file.canWrite());
        System.out.println("canExecute() : " + file.canExecute());
        System.out.println("getName() : " + file.getName());
        System.out.println("getParent() : " + file.getParent());
        System.out.println("getPath() : " + file.getPath());
        System.out.println("length() : " + file.length());
        System.out.println("lastModified() : " + file.lastModified());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.isFile() = " + file.isFile());
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1)
            usage();
        if (args[0].equals("-r")){
            if (args.length != 3)
                usage();
            File old = new File(args[1]),newest = new File(args[2]);
            old.renameTo(newest);
            fileData(old);
            System.out.println("=====================");
            fileData(newest);
            return;
        }

        boolean delete = args[0].equals("-d");
        if (delete && args.length<2) usage();
        File file = new File(args[args.length - 1]);
        if (file.exists()) {
            if (delete) {
                System.out.println("删除文件 = " + file);
                file.delete();
            }
        } else {
            if (!delete) {
                file.createNewFile();
            }
        }
        fileData(file);
    }
}
